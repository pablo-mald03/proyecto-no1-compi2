package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.codetext;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers.SyntaxHighlightListenerFactory;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers.TokenStyleResolverFactory;
import lombok.Getter;

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
    private final EditorContext context;
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

        context = new EditorContext();

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

        this.notifierReference = notifierReference;
    }

    // ==========================================
    // EXTENSION MANAGEMENT
    // ==========================================

    /**
     * Set the file extension and update the syntax listener
     */
    public void setCurrentExtension(String extension) {
        this.currentExtension = extension;
        updateSyntaxListener();
    }

    /**
     * Update the syntax listener based on current extension
     */
    private void updateSyntaxListener() {
        // Clear old listener
        this.syntaxListener = null;

        // Create new listener based on extension
        if (currentExtension != null && !currentExtension.isEmpty()) {
            this.syntaxListener = SyntaxHighlightListenerFactory.createListener(
                    currentExtension,
                    notifierReference
            );
        }

        // Trigger re-highlight if there's content
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
        if (text == null || text.isEmpty()) {
            return;
        }

        // Set source code in context
        // context.setSourceCode(text);

        // Use the appropriate listener
        if (syntaxListener != null) {
            syntaxListener.highlight(context);
        }

        applyHighlight();

      /*  if (notifierReference != null) {
            notifierReference.notifyErrorsUpdated(context.getCompilerErrors());
        }*/
    }

    private void applyHighlight() {
        isApplyingHighlight = true;
        try {
            StyledDocument document = getStyledDocument();
            int docLength = document.getLength();

            document.setCharacterAttributes(0, docLength, this.style, true);

           /* if (context.getTokens() == null) {
                return;
            }*/

            TokenStyleProvider tokenResolver = TokenStyleResolverFactory.createProvider(currentExtension);

           /* for (Token token : context.getTokens()) {
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
            }*/
        } finally {
            isApplyingHighlight = false;
        }
    }

    // ==========================================
    // SETTERS & GETTERS
    // ==========================================

    public void setSyntaxHighlightListener(SyntaxHighlightListener listener) {
        this.syntaxListener = listener;
    }

    public EditorContext getEditorContext() {
        return this.context;
    }

    private AttributeSet createColorAttribute(Color color) {
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, color);
        return attr;
    }

    @Override
    public void setText(String text) {
        super.setText(text != null ? text : "");
        if (syntaxListener != null && text != null && !text.isEmpty()) {
            scheduleHighlight();
        }
    }

  /*  public void clearCompiledCode() {
        this.context.clearCompilatedCode();
    }

    public void clearStackView() {
        this.context.clearStacklists();
    }

    public void clearAll() {
        this.context.clearAll();
    }

    public List<Symbol> getAstView() {
        return this.context.getGlobalEnvironment().getAllSymbolsForUI();
    }*/
}