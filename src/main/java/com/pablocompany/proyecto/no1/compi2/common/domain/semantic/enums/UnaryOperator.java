package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums;

//This enum represents the unary operators
public enum UnaryOperator {

    //RELATIONAL OPERATORS
    NEGATE("-"),
    NOT("!");

    private final String operation;

    UnaryOperator(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }
}
