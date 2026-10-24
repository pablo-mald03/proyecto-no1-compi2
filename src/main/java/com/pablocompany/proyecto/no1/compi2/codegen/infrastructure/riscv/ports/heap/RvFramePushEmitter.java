package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePush;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal frame push emitter class
 *
 */
public class RvFramePushEmitter implements InstructionEmitter<FramePush> {
    @Override
    public Class<FramePush> handles() {
        return FramePush.class;
    }

    /**
     * Method to trigger the frame push action
     *
     */
    @Override
    public void emit(FramePush instruction, CodeWriter out) {
        out.line("addi sp, sp, -4");
        out.line("sw " + RvRegisters.FP + ", 0(sp)");
    }
}
