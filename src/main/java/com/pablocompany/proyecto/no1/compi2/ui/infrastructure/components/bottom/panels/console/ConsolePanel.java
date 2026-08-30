package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.console;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author pablo03
 */
//This class implement the console logs
public class ConsolePanel extends JPanel {

    // ==========================================
    // COLORS PALETTE
    // ==========================================
    private static final Color COLOR_INFO = new Color(125, 207, 255);
    private static final Color COLOR_SUCCESS = new Color(130, 226, 120);
    private static final Color COLOR_WARN = new Color(255, 200, 85);
    private static final Color COLOR_ERROR = new Color(255, 83, 112);
    private static final Color COLOR_DEFAULT = new Color(230, 235, 245);

    private final JTextPane console;
    private final StyledDocument doc;

    public ConsolePanel() {
        setLayout(new BorderLayout());

        console = new JTextPane();
        console.setEditable(false);
        console.setFont(new Font("Liberation Mono", Font.PLAIN, 13));

        Color bgDark = Theme.BACKGROUND_DARK.getColorSet();
        console.setBackground(bgDark);
        console.setCaretColor(COLOR_DEFAULT);

        doc = console.getStyledDocument();

        JScrollPane scrollPane = new JScrollPane(console);
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);
    }

    // ==========================================
    // WRITE METHODS
    // ==========================================
    public void appendInfo(String text) {
        appendFormatted("[INFO] " + text + "\n", COLOR_INFO, false);
    }

    public void appendSuccess(String text) {
        appendFormatted("[SUCCESS] " + text + "\n", COLOR_SUCCESS, false);
    }

    public void appendWarn(String text) {
        appendFormatted("[WARN] " + text + "\n", COLOR_WARN, false);
    }

    public void appendError(String text) {
        appendFormatted("[ERROR] " + text + "\n", COLOR_ERROR, true);
    }

    public void append(String text) {
        appendFormatted(text + "\n", COLOR_DEFAULT, false);
    }

    /**
     * This method append the text to the console
     */
    private void appendFormatted(String text, Color color, boolean bold) {
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setForeground(attrs, color);
        StyleConstants.setBold(attrs, bold);

        try {
            doc.insertString(doc.getLength(), text, attrs);
            console.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            System.out.println("Console error");
        }
    }

    public void clear() {
        try {
            doc.remove(0, doc.getLength());
        } catch (BadLocationException e) {
            System.out.println("clear error");
        }
    }

    // ==========================================
    // SPECIAL LOG METHODS TO THE STACKGRAPH
    // ==========================================
    public void appendReduce(String text) {
        appendFormatted(text + "\n", COLOR_INFO, false);
    }

    public void appendShift(String text) {
        appendFormatted(text + "\n", COLOR_SUCCESS, false);
    }

    public void appendNormal(String text) {
        appendFormatted(text + "\n", COLOR_WARN, false);
    }

}
