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

    public CodeGeneratorOutput(String filePath) {
        this.filePath = filePath;
        this.quadruples = new ArrayList<>();
        this.functionNames = new ArrayList<>();
    }

    public void emit(Quadruple quad) {
        quadruples.add(quad);
    }

    public void emit(String op, String arg1, String arg2, String result) {
        quadruples.add(new Quadruple(op, arg1, arg2, result));
    }
}