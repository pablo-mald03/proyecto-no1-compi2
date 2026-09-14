package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums;

//This enum is the principal variable types
public enum YDataType {

    INT("entero"),
    FLOAT("flotante"),
    STRING("cadena"),
    CHAR("caracter"),
    BOOLEAN("bool"),
    DEF("definir"),
    CUSTOM("custom");

    private final String operation;

    YDataType(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }

}
