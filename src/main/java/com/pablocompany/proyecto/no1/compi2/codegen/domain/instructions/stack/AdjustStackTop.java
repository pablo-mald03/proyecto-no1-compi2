package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal adjust stack top class
 *
 */
@Data
@AllArgsConstructor
public class AdjustStackTop implements Instruction {
    private int delta;
}
