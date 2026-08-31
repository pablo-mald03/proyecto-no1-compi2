package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.utils;


import com.pablocompany.proyecto.no1.compi2.ui.domain.TextConstants;
import com.pablocompany.proyecto.no1.compi2.ui.domain.UIColors;

import java.awt.*;
import javax.swing.JButton;

/**
 *
 * @author pablo03
 */
//This is the principal form button class to confirm any submit
public class FormButton extends JButton {

    private static final int ARC = 12;

    private Color normalColor;
    private Color hoverColor;
    private Color pressedColor;
    private Color borderColor;

    //Default initialization
    public FormButton(String text) {

        super(text);

        initialize(UIColors.ACCENT, UIColors.ACCENT_HOVER, UIColors.MODULE_SELECTED, UIColors.BORDER, UIColors.TEXT_PRIMARY_BUTTON_DARK);
    }

    //Custom initialization
    public FormButton(String text, UIColors normalColor, UIColors hoverColor, UIColors pressedColor, UIColors borderColor, UIColors foreColor) {

        super(text);

        initialize(normalColor, hoverColor, pressedColor, borderColor,foreColor);
    }

    //Normal initialize
    private void initialize( UIColors normalColor, UIColors hoverColor, UIColors pressedColor, UIColors borderColor, UIColors foreColor) {

        this.normalColor = normalColor.getColorSet();

        this.hoverColor = hoverColor.getColorSet();

        this.pressedColor = pressedColor.getColorSet();

        this.borderColor = borderColor.getColorSet();

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setForeground(foreColor.getColorSet());

        setFont(new Font("Liberation Mono", Font.BOLD, TextConstants.SMALL_EMPHASIS_TEXT.getSize()));

        setPreferredSize(new Dimension(140, 38));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics graphics) {

        Graphics2D g2 = (Graphics2D) graphics.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color background;

        if (getModel().isPressed()) {

            background = pressedColor;

        } else if (getModel().isRollover()) {

            background = hoverColor;

        } else {

            background = normalColor;
        }

        int width = getWidth();
        int height = getHeight();

        // Background
        g2.setColor(background);

        g2.fillRoundRect(0, 0, width - 1, height - 1, ARC, ARC);

        g2.setColor(borderColor);

        g2.drawRoundRect(0, 0, width - 1, height - 1, ARC, ARC);

        g2.dispose();

        super.paintComponent(graphics);
    }
}
