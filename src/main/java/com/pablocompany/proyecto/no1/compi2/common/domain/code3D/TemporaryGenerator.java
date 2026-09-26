package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.Getter;

/**
 * Principal class to generate temporary variable names
 */
@Getter
public class TemporaryGenerator {
    private int counter = 0;

    public String next() {
        counter++;
        return "temp" + counter;
    }

    public int getCounter() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }
}