package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.operators.enums;

//This is the principal type operator
public enum BinaryOperator {

    //MATHEMATIC  OPERATORS
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVIDE("/"),
    MODULE("%"),

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
