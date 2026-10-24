package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal class go manage the shared state for the 3D code generator
 */
@Getter
public class CodeGenContext {

    private int labelCounter = 0;
    private final List<String> allLabels = new ArrayList<>();

    private final Map<String, String> functions = new HashMap<>();
    private final Map<String, List<String>> structLayouts = new HashMap<>();

    public void registerFunction(String sourceName, String generatedName) {
        functions.putIfAbsent(sourceName, generatedName);
    }

    public String resolveFunction(String sourceName) {
        String name = functions.get(sourceName);
        if (name == null) throw new IllegalStateException("Función no declarada: '" + sourceName + "'");
        return name;
    }

    public void registerStruct(String name, List<String> fields) {
        structLayouts.put(name, fields);
    }

    public List<String> getStructLayout(String name) {
        return structLayouts.get(name);
    }

    public String nextLabel() {
        labelCounter++;
        String l = "et" + labelCounter;
        allLabels.add(l);
        return l;
    }
}