package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions;

/**
 * Principal call sites counter
 *
 */
public class CallSites {
    private int count = 0;

    /**
     * Method to get the next counter
     *
     */
    public int next() {
        return ++count;
    }

    /**
     * Method to get the total count
     *
     */
    public int total() {
        return count;
    }

    /**
     * Method to reset the counter
     *
     */
    public void reset() {
        count = 0;
    }
}