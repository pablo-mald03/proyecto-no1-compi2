package com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme;

import java.awt.*;

//This enum is the principal collor palette for the AST representation
public enum AstColors {

    // Light theme
    PARSE_NODE_LIGHT(new Color(91, 67, 130)),
    PARSE_TERMINAL_LIGHT(new Color(150, 61, 91)),
    PARSE_NODE_BORDER_LIGHT(new Color(119, 89, 165)),
    PARSE_TERMINAL_BORDER_LIGHT(new Color(190, 82, 119)),
    PARSE_EDGE_LIGHT(new Color(102, 135, 170)),
    PARSE_ERROR_LIGHT(new Color(190, 55, 55)),
    PARSE_ERROR_BORDER_LIGHT(new Color(235, 85, 85)),

    // Dark theme
    PARSE_NODE_DARK(new Color(42, 105, 81)),
    PARSE_TERMINAL_DARK(new Color(118, 103, 42)),
    PARSE_NODE_BORDER_DARK(new Color(139, 91, 194)),
    PARSE_TERMINAL_BORDER_DARK(new Color(214, 91, 139)),
    PARSE_EDGE_DARK(new Color(170, 92, 122)),
    PARSE_ERROR_DARK(new Color(170, 48, 48)),
    PARSE_ERROR_BORDER_DARK(new Color(255, 95, 95));

    private final Color colorSet;

    AstColors(Color setColor) {
        this.colorSet = setColor;
    }

    public Color getColorSet() {
        return colorSet;
    }
}