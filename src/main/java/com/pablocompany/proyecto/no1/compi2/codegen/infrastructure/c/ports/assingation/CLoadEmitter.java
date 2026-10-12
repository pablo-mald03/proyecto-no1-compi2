package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class load from register value emitter for the 3D C code port
 *
 */
public class CLoadEmitter implements InstructionEmitter<Load> {
    @Override
    public Class<Load> handles() {
        return Load.class;
    }

    @Override
    public void emit(Load instruction, CodeWriter out) {
        String idx = CSyntax.resolve(out, instruction.getAddress());
        String array = CSyntax.memory(instruction.getSpace(), instruction.getDestination().getType());
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + array + "[" + idx + "];");
    }
}

