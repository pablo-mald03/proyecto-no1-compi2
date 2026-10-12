package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.FramePush;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class code frame pointer emitter for the 3D C code port
 *
 */
public class CFramePushEmitter implements InstructionEmitter<FramePush> {
    @Override
    public Class<FramePush> handles() {
        return FramePush.class;
    }

    @Override
    public void emit(FramePush instruction, CodeWriter out) {
        out.line("fpstack[fpsp++] = fp;");
    }
}
