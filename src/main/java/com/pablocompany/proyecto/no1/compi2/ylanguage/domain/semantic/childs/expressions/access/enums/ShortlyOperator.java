package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.enums;

/**
 * Enum to represents abbreviated operation
 *
 */
public enum ShortlyOperator {

    PLUS_ASSIGN("+="),
    MINUS_ASSIGN("-="),
    MULTIPLY_ASSIGN("*="),
    DIVIDE_ASSIGN("/="),
    MODULO_ASSIGN("%=");

    private final String value;

    ShortlyOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
