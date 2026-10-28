package com.pablocompany.proyecto.no1.compi2.codegen.domain.parents;

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
    private int frameSlots;

    public IntermediateFunction(String name, List<Instruction> body) {
        this(name, body, 0);
    }

    public IntermediateFunction(String name, List<Instruction> body, int frameSlots) {
        this.name = name;
        this.body = List.copyOf(body);
        this.frameSlots = frameSlots;
    }
}
