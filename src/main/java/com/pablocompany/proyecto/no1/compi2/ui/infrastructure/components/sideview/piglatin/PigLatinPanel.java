package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.piglatin;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.LineNumberView;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author pablo03
 */
//This clas represents the panel where is alojated the compiled text
public class PigLatinPanel extends JPanel {

    private final JTextPane codeView;
    private final LineNumberView lineNumbers;
    private final JScrollPane scroll;

    public PigLatinPanel() {
        setLayout(new BorderLayout());

        codeView = new JTextPane();
        codeView.setEditable(false);
        codeView.setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        
        codeView.setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        codeView.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        codeView.setCaretColor(Theme.FOREGROUND_DARK.getColorSet());
        codeView.setMargin(new Insets(5, 8, 5, 8));

        scroll = new JScrollPane(codeView);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        lineNumbers = new LineNumberView(codeView);
        scroll.setRowHeaderView(lineNumbers);

        add(scroll, BorderLayout.CENTER);
    }

    /*
     * This method set the code to the editor or textPane
     */
    public void setCode(String code) {
        codeView.setText(code != null ? code : "");
        codeView.setCaretPosition(0);
    }

    public String getCode() {
        return codeView.getText();
    }

    /*
     * this method clear the content
     */
    public void clear() {
        codeView.setText("");
    }
}