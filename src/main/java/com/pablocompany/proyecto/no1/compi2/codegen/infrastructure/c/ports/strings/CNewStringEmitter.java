package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.strings;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.NewString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class new string instance process emitter for the 3D C code port
 *
 */
public class CNewStringEmitter implements InstructionEmitter<NewString> {
    @Override
    public Class<NewString> handles() {
        return NewString.class;
    }

    @Override
    public void emit(NewString instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = malloc(64);");
    }
}
