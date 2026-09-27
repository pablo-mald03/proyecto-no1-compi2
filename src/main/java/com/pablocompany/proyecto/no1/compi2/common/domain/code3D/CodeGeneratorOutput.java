package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class for the output of the code generation phase for a single file.
 */
@Data
public class CodeGeneratorOutput {
    private List<Quadruple> quadruples;
    private List<String> functionNames;
    private String filePath;
    private StringPool stringPool;

    public CodeGeneratorOutput(String filePath) {
        this.filePath = filePath;
        this.quadruples = new ArrayList<>();
        this.functionNames = new ArrayList<>();
        this.stringPool = new StringPool(filePrefix(filePath));
    }

    private static String filePrefix(String filePath) {
        if (filePath == null || filePath.isEmpty()) return "str";
        String base = filePath.substring(filePath.lastIndexOf('/') + 1);
        int dot = base.lastIndexOf('.');
        if (dot > 0) base = base.substring(0, dot);
        if (base.isEmpty()) return "str";
        return base.substring(0, 1) + "_str";
    }
    /**
     * Principal emit quadruple generation
     *
     */
    public void emit(Quadruple quad) {
        quadruples.add(quad);
    }


    /**
     * Emit for the result
     *
     */
    public void emit(String op, String arg1, String arg2, String result) {
        quadruples.add(new Quadruple(op, arg1, arg2, result));
    }
}