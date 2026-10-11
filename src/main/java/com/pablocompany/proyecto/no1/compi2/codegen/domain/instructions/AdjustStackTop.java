package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Data;

/**
 * Principal adjust stack top class
 *
 */
@Data
public class AdjustStackTop implements Instruction {
    private int delta;
}
