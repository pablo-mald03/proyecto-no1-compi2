package com.pablocompany.proyecto.no1.compi2.common.domain.highlight;

import java.awt.*;

/**
 *
 * @author pablo03
 */
public enum TokenStyle {

    //PIG LATIN COLORS
    DEFAULT(new Color(230, 235, 245)),
    NUMBER(new Color(181, 206, 168)),
    IDENTIFIER(new Color(125, 207, 255)),
    KEYWORD(new Color(243, 117, 241)),
    COMMENT(new Color(106, 153, 85)),
    STRING(new Color(240, 150, 100)),
    OPERATOR(new Color(78, 201, 176)),
    PUNCTUATION(new Color(255, 215, 0)),
    SEPARATOR(new Color(160, 230, 255)),
    ERROR(new Color(255, 83, 112)),


    //Y COLORS
    Y_DEFAULT(new Color(230, 235, 245)),
    Y_NUMBER(new Color(181, 206, 168)),
    Y_IDENTIFIER(new Color(251, 250, 207)),
    Y_COMMENT(new Color(150, 148, 150)),
    Y_STRING(new Color(117, 171, 93)),
    Y_KEYWORD(new Color(240, 150, 100)),
    Y_OPERATOR(new Color(78, 201, 176)),
    Y_PUNCTUATION(new Color(243, 117, 241)),
    Y_SEPARATOR(new Color(160, 230, 255)),

    //ZETTARADIAN COLORS
    Z_DEFAULT(new Color(230, 235, 245)),
    Z_NUMBER(new Color(181, 206, 168)),
    Z_IDENTIFIER(new Color(125, 207, 255)),
    Z_KEYWORD(new Color(185, 110, 255)),
    Z_COMMENT(new Color(106, 153, 85)),
    Z_STRING(new Color(240, 150, 100)),
    Z_OPERATOR(new Color(78, 201, 176)),
    Z_PUNCTUATION(new Color(255, 215, 0)),
    Z_SEPARATOR(new Color(160, 230, 255));


    private final Color style;

    TokenStyle(Color style) {
        this.style = style;
    }

    public Color getStyle() {
        return style;
    }

}
