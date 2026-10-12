package com.pablocompany.proyecto.no1.compi2.common.domain.semantic;

import lombok.Getter;

/**
 * Enum to represents abbreviated operation
 *
 */
@Getter
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

}
