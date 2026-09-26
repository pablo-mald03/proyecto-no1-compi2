package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class go manage the shared state for the 3D code generator
 */
public class CodeGenContext {

    private int labelCounter = 0;
    private final List<String> allLabels = new ArrayList<>();

    public String nextLabel() {
        labelCounter++;
        String l = "et" + labelCounter;
        allLabels.add(l);
        return l;
    }

    public int getLabelCounter() {
        return labelCounter;
    }

    public List<String> getAllLabels() {
        return allLabels;
    }
}