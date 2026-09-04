package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.operators.enums;

//This enum represents the unary operators
public enum UnaryOperator {

    //RELATIONAL OPERATORS
    NEGATE("-"),
    NOT("non");

    private final String operation;

    UnaryOperator(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }
}
