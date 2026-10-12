package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal class to represent the label mark
 *
 */
@Data
@AllArgsConstructor
public class MarkLabel implements Instruction {
    private String name;
}
