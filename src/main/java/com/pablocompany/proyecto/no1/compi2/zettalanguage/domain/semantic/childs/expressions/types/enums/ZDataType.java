package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums;

//This enum is the principal variable types
public enum ZDataType {

    INT("int"),
    DOUBLE("double"),
    STRING("string"),
    CHAR("char"),
    BOOLEAN("boolean"),
    VOID("void"),
    CLASS("clase");

    private final String operation;

    ZDataType(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }

}
