package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Data;

/**
 * Principal class to represent the label mark
 *
 */
@Data
public class MarkLabel implements Instruction {
    private String name;
}
