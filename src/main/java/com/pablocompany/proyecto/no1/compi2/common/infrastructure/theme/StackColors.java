package com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme;

import java.awt.*;

/**
 *
 * @author pablo03
 */
//This enum represents the base color to the stack
public enum StackColors {

    COLOR_CONTAINER(new Color(50, 48, 41)),
    COLOR_TERMINAL(new Color(180, 80, 90)), 
    COLOR_NON_TERM(new Color(70, 130, 180)), 
    COLOR_ACTION_SHIFT(new Color(76, 153, 100)), 
    COLOR_ACTION_REDUCE(new Color(120, 80, 160)); 

    private final Color colorSet;

    StackColors(Color setColor) {
        this.colorSet = setColor;
    }

    public Color getColorSet() {
        return colorSet;
    }
}
