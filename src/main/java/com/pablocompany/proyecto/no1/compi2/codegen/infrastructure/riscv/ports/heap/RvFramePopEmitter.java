package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal frame pointer emitter class
 *
 */
public class RvFramePopEmitter implements InstructionEmitter<FramePop> {
    @Override
    public Class<FramePop> handles() {
        return FramePop.class;
    }

    /**
     * Method to emit the frame pop instruction
     *
     */
    @Override
    public void emit(FramePop instruction, CodeWriter out) {
        out.line("lw " + RvRegisters.FP + ", 0(sp)");
        out.line("addi sp, sp, 4");
    }
}
