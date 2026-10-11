package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums;

import lombok.Getter;

@Getter
public enum BinaryOperations {
    ADD("+"), SUB("-"), MUL("*"), DIV("/"), MOD("%"),
    EQ("=="), NE("!="), LT("<"), GT(">"), LE("<="), GE(">="),
    AND("&&"), OR("||");

    private final String symbol;

    BinaryOperations(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Comparation method
     *
     */
    public boolean isComparison() {
        return this == EQ || this == NE || this == LT || this == GT || this == LE || this == GE;
    }

    /**
     * Method to verify if its logical
     *
     */
    public boolean isLogical() {
        return this == AND || this == OR;
    }

    /**
     * Principal method to infer the symbol
     *
     */
    public BinaryOperations fromSymbol(String symbol) {
        for (BinaryOperations op : values()) if (op.symbol.equals(symbol)) return op;
        throw new IllegalArgumentException("Operador binario desconocido: " + symbol);
    }
}