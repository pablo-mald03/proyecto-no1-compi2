package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.gotoFunc;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class goto emitter for the 3D C code port
 *
 */
public class CJumpEmitter implements InstructionEmitter<Jump> {
    @Override
    public Class<Jump> handles() {
        return Jump.class;
    }

    @Override
    public void emit(Jump instruction, CodeWriter out) {
        out.line("goto " + instruction.getTarget() + ";");
    }
}
