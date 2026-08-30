package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pablo03
 */
//This class is the bottom bar with de buttons tu manage the stack
public class StackControlsPanel extends JPanel {

    private final JButton btnReset;
    private final JButton btnBack;
    private final JButton btnNext;
    private final JButton btnFinish;

    public StackControlsPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        setBackground(Theme.BACKGROUND_DARK.getColorSet());

        btnReset = createStyledButton("Reiniciar", 2);
        btnBack = createStyledButton("Atrás", 1);
        btnNext = createStyledButton("Siguiente", 1);
        btnFinish = createStyledButton("Terminar", 2);

        add(btnReset);
        add(btnBack);
        add(btnNext);
        add(btnFinish);
    }

    private JButton createStyledButton(String text, int value) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Liberation Mono", Font.BOLD, 12));

        Theme themeBase = (value == 1) ? Theme.SIDEBAR_LIGHT : Theme.STATUS_BAR_LIGHT;

        btn.setBackground(themeBase.getColorSet());
        btn.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return btn;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public JButton getBtnFinish() {
        return btnFinish;
    }
}
