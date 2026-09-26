package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

/**
 * Principal class generate label names
 */
public class LabelGenerator {
    private int counter = 0;

    public String next() {
        counter++;
        return "et" + counter;
    }

    public int getCounter() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }
}