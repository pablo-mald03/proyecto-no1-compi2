package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation.enums;

//This enum represents an abreviated operation
public enum AbreviationOperator {

    ABREV_PLUS("++"),
    ABREV_MINUS("--"),

    ABREV_PREV_PLUS("++"),
    ABREV_PREV_MINUS("--");


    private final String operation;

    AbreviationOperator(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }
}
