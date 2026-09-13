package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.operators.enums;

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
