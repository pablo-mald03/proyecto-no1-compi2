package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Cell;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Frame;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.ArrayInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StructInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Principal representation of a function execution frame and symbol table
 */
public class FunctionFrame {
    private int next = 1;
    private final Map<String, Cell> variables = new HashMap<>();
    private final Map<String, StructInfo> structs = new HashMap<>();
    private final Map<String, ArrayInfo> arrays = new HashMap<>();

    /**
     * Principal Method to peek the next available offset
     */
    public int peekOffset() {
        return next;
    }

    /**
     * Principal Method to allocate memory slots and advance the offset
     */
    public int allocate(int slots) {
        int offset = next;
        next += slots;
        return offset;
    }

    /**
     * Principal Method to declare a new variable cell
     */
    public Cell declare(String name, ValueType type) {
        Cell cell = new Cell(type, new Frame(allocate(1)));
        variables.put(name, cell);
        return cell;
    }

    /**
     * Principal Method to create a temporary cell
     */
    public Cell temp(ValueType type) {
        return new Cell(type, new Frame(allocate(1)));
    }

    /**
     * Principal Method to look up a variable by its name
     */
    public Cell lookup(String name) {
        return variables.get(name);
    }

    /**
     * Principal Method to register a struct definition
     */
    public void registerStruct(String name, StructInfo info) {
        structs.put(name, info);
    }

    /**
     * Principal Method to register an array definition
     */
    public void registerArray(String name, ArrayInfo info) {
        arrays.put(name, info);
    }

    /**
     * Principal Method to retrieve a registered struct information
     */
    public StructInfo structOf(String name) {
        return structs.get(name);
    }

    /**
     * Principal Method to retrieve a registered array information
     */
    public ArrayInfo arrayOf(String name) {
        return arrays.get(name);
    }
}