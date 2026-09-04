package com.pablocompany.proyecto.no1.compi2.common.domain.highlight;

import java.awt.*;

/**
 *
 * @author pablo03
 */
public enum TokenStyle {

    DEFAULT(new Color(230, 235, 245)),
    NUMBER(new Color(181, 206, 168)),
    IDENTIFIER(new Color(125, 207, 255)),
    KEYWORD(new Color(185, 110, 255)),
    COMMENT(new Color(106, 153, 85)),
    STRING(new Color(240, 150, 100)),
    OPERATOR(new Color(78, 201, 176)),
    PUNCTUATION(new Color(255, 215, 0)),
    SEPARATOR(new Color(160, 230, 255)),
    ERROR(new Color(255, 83, 112));

    private final Color style;

    TokenStyle(Color style) {
        this.style = style;
    }

    public Color getStyle() {
        return style;
    }

}
