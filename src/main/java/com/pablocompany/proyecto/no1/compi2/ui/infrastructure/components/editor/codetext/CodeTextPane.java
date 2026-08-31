package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.codetext;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.lexical.TokenStyleResolver;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
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

    private final TokenStyleResolver resolver;

    //Defult text style
    private final SimpleAttributeSet style;

    /*Reference to the parent*/
    private WorkspaceNotifier notifierReference;

    public CodeTextPane(WorkspaceNotifier notifierReference) {
        super(new DefaultStyledDocument());

        resolver = new TokenStyleResolver();

        setBackground(Theme.AUXILIARY_BACKGROUND_DARK.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());

        syntaxTimer = new Timer(SYNTAX_DELAY, e -> {

            syntaxTimer.stop();

            onSyntaxHighlight();

        });

        syntaxTimer.setRepeats(false);

        context = new EditorContext();

        style = new SimpleAttributeSet();

        StyleConstants.setForeground(
                style,
                Theme.FOREGROUND_DARK.getColorSet());

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

    //This method reestart the debounce
    private void scheduleHighlight() {

        syntaxTimer.restart();

    }

    //This method hihghlight the code when the key is pressed
    protected void onSyntaxHighlight() {

        /*context.setSourceCode(getText());

        if (syntaxListener != null) {
            syntaxListener.highlight(context);
        }

        applyHighlight();

        if (notifierReference != null) {
            notifierReference.notifyErrorsUpdated(context.getCompilerErrors());
        }*/

    }

    //This method implements the highlight to the component
    private void applyHighlight() {
      /*  isApplyingHighlight = true;
        try {
            StyledDocument document = getStyledDocument();
            int docLength = document.getLength();

            document.setCharacterAttributes(0, docLength, this.style, true);

            if (context.getTokens() == null) {
                return;
            }

            for (Token token : context.getTokens()) {
                if (token.getType() == Token.EOF) {
                    continue;
                }

                int start = token.getStartIndex();
                int stop = token.getStopIndex();

                if (start < 0 || stop < start || stop >= docLength) {
                    continue;
                }

                TokenStyle tokenStyle = resolver.style(token);
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
        }*/
    }

    public void setSyntaxHighlightListener(SyntaxHighlightListener listener) {

        this.syntaxListener = listener;

    }
    
    //This method returns the reference to codetext
    public EditorContext getEditorContext(){
        return this.context;
    }

    // Auxiliar methog to convert the color to attributeSet
    private AttributeSet createColorAttribute(Color color) {
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, color);
        return attr;
    }
    
    /*
    //This method clean the editor context
    public void clearCompiledCode(){
        this.context.clearCompilatedCode();
    }
    
    //This method clear stack view 
    public void clearStackView() {
        this.context.clearStacklists();
    }

    //This method clear all required clearable data
    public void clearAll(){
        this.context.clearAll();
    }
    
    //This method clear AST view 
    public List<Symbol> getAstView() {
        return this.context.getGlobalEnvironment().getAllSymbolsForUI();
    }*/
}
