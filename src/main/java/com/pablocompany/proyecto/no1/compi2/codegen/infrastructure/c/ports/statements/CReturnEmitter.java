package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.Return;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class return function emitter for the 3D C code port
 *
 */
public class CReturnEmitter implements InstructionEmitter<Return> {
    @Override
    public Class<Return> handles() {
        return Return.class;
    }

    @Override
    public void emit(Return instruction, CodeWriter out) {
        out.line("return;");
    }
}
