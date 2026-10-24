package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal frame pointer operation pop emitter for3D C code port
 *
 */
public class CFramePopEmitter implements InstructionEmitter<FramePop> {
    @Override
    public Class<FramePop> handles() {
        return FramePop.class;
    }

    @Override
    public void emit(FramePop instruction, CodeWriter out) {
        out.line("fpsp = fpsp - 1;");
        out.line("fp = fpstack[fpsp];");
    }
}
