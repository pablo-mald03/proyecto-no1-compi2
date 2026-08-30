package com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme;

import java.awt.Color;

/**
 *
 * @author pablo03
 */
/*Class used to declarate the principal colors*/
public enum Theme {

    /*Light Theme related to the code editor */
    BACKGROUND_LIGHT(new Color(245, 247, 240)),
    SURFACE_LIGHT(new Color(230, 210, 215)),
    SIDEBAR_LIGHT(new Color(238, 235, 205)),
    STATUS_BAR_LIGHT(new Color(205, 170, 160)),
    FOREGROUND_LIGHT(new Color(30, 30, 30)),
    BORDER_LIGHT(new Color(190, 160, 130)),
    
    /*Dark Theme related to the code editor */
    BACKGROUND_DARK(new Color(10, 22, 38)),
    SURFACE_DARK(new Color(18, 14, 60)),
    SIDEBAR_DARKT(new Color(8, 20, 22)),
    STATUS_BAR_DARK(new Color(50, 25, 65)),
    FOREGROUND_DARK(new Color(230, 235, 245)),
    BORDER_DARK(new Color(85, 30, 75));

    private final Color colorSet;

    Theme(Color setColor) {
        this.colorSet = setColor;
    }

    public Color getColorSet() {
        return colorSet;
    }

}
