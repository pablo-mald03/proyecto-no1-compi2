package com.pablocompany.proyecto.no1.compi2.codegen.domain.parents;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringConstant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Generator for the intermediate code representation
 */
public class IntermediateBuilder {
    private final String sourceName;
    private final String stringPrefix;
    private final Map<String, String> literalToId = new LinkedHashMap<>();
    private final List<IntermediateFunction> functions = new ArrayList<>();
    private final List<com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition> vtables = new ArrayList<>();
    private String currentName;
    private List<Instruction> currentBody;
    private int currentFrameSlots = 0;

    public IntermediateBuilder(String sourceName, String stringPrefix) {
        this.sourceName = sourceName;
        this.stringPrefix = stringPrefix;
    }

    public void addVTable(String name, List<String> entries) {
        vtables.add(new com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition(name, entries));
    }

    /**
     * Method to validate if the prefix is valid
     *
     */
    public String intern(String literal) {
        return literalToId.computeIfAbsent(literal, l -> stringPrefix + (literalToId.size() + 1));
    }

    /**
     * Method to register a new constan for string
     */
    public void addStringConstant(String id, String value) {
        literalToId.put(value, id);
    }

    /**
     * Method to begin a function
     *
     */
    public IntermediateBuilder beginFunction(String name) {
        closeFunction();
        currentName = name;
        currentBody = new ArrayList<>();
        return this;
    }

    /**
     * Method to trigger the emit call
     *
     */
    public IntermediateBuilder emit(Instruction instruction) {
        if (currentBody == null) throw new IllegalStateException("emit() fuera de una función");
        currentBody.add(instruction);
        return this;
    }

    /**
     * Last emitted instruction method
     */
    public Instruction last() {
        return (currentBody == null || currentBody.isEmpty()) ? null : currentBody.get(currentBody.size() - 1);
    }

    /**
     * Method to replace an instruction
     *
     */
    public void replaceLast(Instruction instruction) {
        currentBody.set(currentBody.size() - 1, instruction);
    }

    /**
     * Method to build the instance
     *
     */
    public IntermediateProgram build() {
        closeFunction();
        List<StringConstant> strings = new ArrayList<>();
        literalToId.forEach((value, id) -> strings.add(new StringConstant(id, value)));
        return new IntermediateProgram(sourceName, strings, functions, vtables);
    }

    public void setFrameSlots(int slots) {
        this.currentFrameSlots = slots;
    }

    /**
     * Method to mark as closed the function
     *
     */
    private void closeFunction() {
        if (currentName != null) {
            functions.add(new IntermediateFunction(currentName, currentBody, currentFrameSlots));
        }
        currentName = null;
        currentBody = null;
        currentFrameSlots = 0;
    }
}
