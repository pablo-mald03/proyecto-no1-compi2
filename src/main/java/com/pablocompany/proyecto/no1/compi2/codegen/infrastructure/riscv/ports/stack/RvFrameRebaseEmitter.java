package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FrameRebase;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal frame pointer rebase emitter
 *
 */
public class RvFrameRebaseEmitter implements InstructionEmitter<FrameRebase> {
    @Override
    public Class<FrameRebase> handles() {
        return FrameRebase.class;
    }

    /**
     * Method to emit the rebase action
     *
     */
    @Override
    public void emit(FrameRebase instruction, CodeWriter out) {
        RvMemory.addSlots(out, RvRegisters.FP, RvRegisters.STACK_TOP, -instruction.getSlotsBelowTop(), RvRegisters.SCRATCH);
    }
}
