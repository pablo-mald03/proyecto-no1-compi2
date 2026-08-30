package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.enums;

//This enum is the principal variable types
public enum DataType {

    INT("numerus"),
    DECIMAL("decimalis"),
    STRING("textum"),
    CHAR("littera"),
    BOOLEAN("bool"),
    VOID("actio"),
    CUSTOM("custom");

    private final String operation;

    DataType(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }

}
