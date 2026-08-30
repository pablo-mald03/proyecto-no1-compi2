package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.operators.enums;

//This is the principal type operator
public enum BinaryOperator {

    //MATHEMATIC  OPERATORS
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVIDE("/"),

    //RELATIONAL OPERATORS
    EQUALS("=="),
    LESS("<"),
    LESS_EQUALS("<="),
    GREATER(">"),
    GREATER_EQUALS(">="),
    DIFFERENT("!="),

    AND("&&"),
    OR("||");

    private final String operation;

    BinaryOperator(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }
}
