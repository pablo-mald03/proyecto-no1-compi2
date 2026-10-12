package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Frame pointer movement for the stack pointer following the bellow slots
 *
 */
@Data
@AllArgsConstructor
public class FrameRebase implements Instruction {
    private int slotsBelowTop;
}
