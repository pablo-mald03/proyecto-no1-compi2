package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FrameRebase;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class code frame rebase pointer emitter for the 3D C code port
 *
 */
public class CFrameRebaseEmitter implements InstructionEmitter<FrameRebase> {
    @Override
    public Class<FrameRebase> handles() {
        return FrameRebase.class;
    }

    @Override
    public void emit(FrameRebase instruction, CodeWriter out) {
        out.line("fp = sptr - " + instruction.getSlotsBelowTop() + ";");
    }
}
