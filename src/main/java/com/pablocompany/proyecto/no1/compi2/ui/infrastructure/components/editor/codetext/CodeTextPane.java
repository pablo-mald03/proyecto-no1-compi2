package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.codetext;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyle;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers.SyntaxHighlightListenerFactory;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers.TokenStyleResolverFactory;
import lombok.Getter;
import org.antlr.v4.runtime.Token;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;

/**
 *
 * @author pablo03
 */
/*This class is the Text Pane editor*/
public class CodeTextPane extends JTextPane {

    private boolean isApplyingHighlight = false;
    private static final int SYNTAX_DELAY = 250;
    private Timer syntaxTimer;
    private SyntaxHighlightListener syntaxListener;
    private EditorContext context;
    private final SimpleAttributeSet style;
    private WorkspaceNotifier notifierReference;
    @Getter
    private String currentExtension = "";

    public CodeTextPane(WorkspaceNotifier notifierReference) {
        super(new DefaultStyledDocument());

        setBackground(Theme.AUXILIARY_BACKGROUND_DARK.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());

        syntaxTimer = new Timer(SYNTAX_DELAY, e -> {
            syntaxTimer.stop();
            onSyntaxHighlight();
        });
        syntaxTimer.setRepeats(false);

        this.context = new EditorContext();
        this.notifierReference = notifierReference;

        style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, Theme.FOREGROUND_DARK.getColorSet());

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!isApplyingHighlight) {
                    scheduleHighlight();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!isApplyingHighlight) {
                    scheduleHighlight();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!isApplyingHighlight) {
                    scheduleHighlight();
                }
            }
        });
    }


    // ==========================================
    // CONTEXT MANAGEMENT (EXTERNAL)
    // ==========================================

    /**
     * Set the EditorContext from outside (WorkspacePanel)
     */
    public void setEditorContext(EditorContext context) {
        this.context = context != null ? context : new EditorContext();

        String text = getText();
        if (text != null && !text.isEmpty()) {
            this.context.setSourceCode(text);
        }

        if (syntaxListener != null) {
            scheduleHighlight();
        }
    }

    /**
     * Get the current EditorContext
     */
    public EditorContext getEditorContext() {
        return this.context;
    }


    // ==========================================
    // EXTENSION AND LISTENER MANAGEMENT
    // ==========================================

    public void setCurrentExtension(String extension, String filePath, String fileName) {
        this.currentExtension = extension;
        updateSyntaxListener(filePath, fileName);
    }

    /**
     * Update the syntax listener based on current extension
     */
    private void updateSyntaxListener(String filePath, String fileName) {
        this.syntaxListener = null;
        if (currentExtension != null && !currentExtension.isEmpty()) {
            this.syntaxListener = SyntaxHighlightListenerFactory.createListener(
                    currentExtension,
                    filePath,
                    fileName
            );
        }
        if (getText() != null && !getText().isEmpty()) {
            scheduleHighlight();
        }
    }

    public void setSyntaxHighlightListener(SyntaxHighlightListener listener) {
        this.syntaxListener = listener;
        if (getText() != null && !getText().isEmpty()) {
            scheduleHighlight();
        }
    }


    // ==========================================
    // HIGHLIGHT METHODS
    // ==========================================

    private void scheduleHighlight() {
        syntaxTimer.restart();
    }

    protected void onSyntaxHighlight() {
        String text = getText();
        if (text == null || text.isEmpty() || context == null) {
            return;
        }

        context.setSourceCode(text);

        if (syntaxListener != null) {
            syntaxListener.highlight(context);
        }

        applyHighlight();

        if (notifierReference != null && context.getAllCompilerErrors() != null) {
            notifierReference.notifyErrorsUpdated(context.getAllCompilerErrors());
        }
    }


    /**
     * Principal method to apply the highlighting code
     */
    private void applyHighlight() {
        isApplyingHighlight = true;
        try {
            StyledDocument document = getStyledDocument();
            int docLength = document.getLength();

            document.setCharacterAttributes(0, docLength, this.style, true);

            if (context.getTokens() == null || context.getTokens().isEmpty()) {
                return;
            }

            TokenStyleProvider tokenResolver = TokenStyleResolverFactory.createProvider(currentExtension);

            for (Token token : context.getTokens()) {
                if (token.getType() == Token.EOF) {
                    continue;
                }

                int start = token.getStartIndex();
                int stop = token.getStopIndex();

                if (start < 0 || stop < start || stop >= docLength) {
                    continue;
                }

                TokenStyle tokenStyle = tokenResolver.style(token);
                if (tokenStyle == null) {
                    continue;
                }

                Color rawColor = tokenStyle.getStyle();
                AttributeSet attributeSet = createColorAttribute(rawColor);

                int length = stop - start + 1;

                document.setCharacterAttributes(
                        start,
                        length,
                        attributeSet,
                        true);
            }
        } finally {
            isApplyingHighlight = false;
        }
    }

    /**
     * Principal method to create the color attribute set
     *
     */
    private AttributeSet createColorAttribute(Color color) {
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, color);
        return attr;
    }

    /**
     * This method is the principal to set the code text
     * */
    @Override
    public void setText(String text) {
        super.setText(text != null ? text : "");
        if (context != null && text != null) {
            context.setSourceCode(text);
        }
        if (syntaxListener != null && text != null && !text.isEmpty()) {
            scheduleHighlight();
        }
    }
}