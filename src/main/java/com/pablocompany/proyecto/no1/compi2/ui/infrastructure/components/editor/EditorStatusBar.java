package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pablo03
 */
public class EditorStatusBar extends JPanel {

    private final JLabel line;

    private final JLabel column;

    private final JLabel encoding;

    private final JLabel language;

    public EditorStatusBar() {

        setLayout(new BorderLayout());

        setBackground(new Color(52, 58, 64));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 3));

        left.setOpaque(false);
        right.setOpaque(false);

        line = new JLabel("Ln 1");

        column = new JLabel("Col 1");

        encoding = new JLabel("UTF-8");

        language = new JLabel("ANTLR4");

        Color color = Color.WHITE;

        line.setForeground(color);
        column.setForeground(color);
        encoding.setForeground(color);
        language.setForeground(color);

        left.add(line);
        left.add(column);

        right.add(language);
        right.add(encoding);

        add(left, BorderLayout.WEST);

        add(right, BorderLayout.EAST);

        setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

    }

    public void updateCursor(int ln, int col) {

        line.setText("Ln: " + ln);

        column.setText("Col: " + col);

    }

}
