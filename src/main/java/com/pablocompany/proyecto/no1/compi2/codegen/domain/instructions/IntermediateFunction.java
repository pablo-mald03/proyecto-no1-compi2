package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Getter;

import java.util.List;

/**
 * Principal intermediate function representation
 *
 */
@Getter
public class IntermediateFunction {

    private String name;
    private List<Instruction> body;

    public IntermediateFunction(String name, List<Instruction> body) {
        body = List.copyOf(body);
    }
}
