package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal stack top emmiter class
 *
 */
public class RvAdjustStackTopEmitter implements InstructionEmitter<AdjustStackTop> {
    @Override
    public Class<AdjustStackTop> handles() {
        return AdjustStackTop.class;
    }

    @Override
    public void emit(AdjustStackTop instruction, CodeWriter out) {
        RvMemory.addSlots(out, RvRegisters.STACK_TOP, RvRegisters.STACK_TOP, instruction.getDelta(), RvRegisters.SCRATCH);
    }
}
