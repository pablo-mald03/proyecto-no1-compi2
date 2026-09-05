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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * This class is the Text Pane editor
 * @author pablo03
 */
public class CodeTextPane extends JTextPane {

    private boolean isApplyingHighlight = false;
    private static final int SYNTAX_DELAY = 250;
    private static final int TAB_SIZE = 4;

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
        setupCustomTabHandling();

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

    /**
     * Setup custom tab key handling (4 spaces instead of tab character)
     */
    private void setupCustomTabHandling() {

        //Ident
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "insert-tab");
        getActionMap().put("insert-tab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertTabSpaces();
            }
        });

        //indent
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.SHIFT_DOWN_MASK), "unindent");
        getActionMap().put("unindent", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unindentSelection();
            }
        });
    }

    /**
     * Insert 4 spaces at the current caret position
     */
    private void insertTabSpaces() {
        int caretPosition = getCaretPosition();
        String spaces = " ".repeat(TAB_SIZE);

        try {
            getDocument().insertString(caretPosition, spaces, null);
        } catch (BadLocationException ex) {
            replaceSelection(spaces);
        }
    }

    /**
     * Unindent selected lines (remove 4 spaces from start of each selected line)
     */
    private void unindentSelection() {
        try {
            int start = getSelectionStart();
            int end = getSelectionEnd();

            if (start == end) {
                int lineStart = getLineStartOffset(start);
                removeIndentFromLine(lineStart);
            } else {
                String text = getText(start, end - start);
                String[] lines = text.split("\n", -1);

                int currentPos = start;
                for (String line : lines) {
                    int lineStart = currentPos;
                    String lineContent = line;

                    if (lineContent.startsWith(" ".repeat(TAB_SIZE))) {
                        getDocument().remove(lineStart, TAB_SIZE);
                        currentPos += lineContent.length() - TAB_SIZE + 1;
                    } else {
                        currentPos += lineContent.length() + 1;
                    }
                }
            }
        } catch (BadLocationException ex) {
            // Ignore
        }
    }

    /**
     * Remove indent from a single line
     */
    private void removeIndentFromLine(int lineStart) throws BadLocationException {
        String line = getText(lineStart, getLineLength(lineStart));
        if (line.startsWith(" ".repeat(TAB_SIZE))) {
            getDocument().remove(lineStart, TAB_SIZE);
        }
    }

    /**
     * Get the start offset of a line
     */
    private int getLineStartOffset(int offset) throws BadLocationException {
        return getDocument().getDefaultRootElement().getElement(
                getDocument().getDefaultRootElement().getElementIndex(offset)
        ).getStartOffset();
    }

    /**
     * Get the length of a line
     */
    private int getLineLength(int lineStart) throws BadLocationException {
        int lineEnd = getDocument().getDefaultRootElement().getElement(
                getDocument().getDefaultRootElement().getElementIndex(lineStart) + 1
        ).getStartOffset();
        return lineEnd - lineStart - 1;
    }

    // ==========================================
    // TEXT PROCESSING
    // ==========================================

    /**
     * Convert tabs to spaces in a text string
     */
    private String convertTabsToSpaces(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        // Replace each tab character with 4 spaces
        return text.replace("\t", " ".repeat(TAB_SIZE));
    }

    /**
     * Override setText to convert tabs to spaces when loading content
     */
    @Override
    public void setText(String text) {
        String processedText = convertTabsToSpaces(text);
        super.setText(processedText != null ? processedText : "");

        if (context != null && processedText != null) {
            context.setSourceCode(processedText);
        }
        if (syntaxListener != null && processedText != null && !processedText.isEmpty()) {
            scheduleHighlight();
        }
    }

    /**
     * Get text with tabs preserved (for saving)
     * Note: We keep spaces, no conversion back to tabs
     */
    @Override
    public String getText() {
        return super.getText();
    }

    /**
     * Get text with tabs converted (for display consistency)
     */
    public String getTextWithSpaces() {
        return convertTabsToSpaces(super.getText());
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
     */
    private AttributeSet createColorAttribute(Color color) {
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, color);
        return attr;
    }
}