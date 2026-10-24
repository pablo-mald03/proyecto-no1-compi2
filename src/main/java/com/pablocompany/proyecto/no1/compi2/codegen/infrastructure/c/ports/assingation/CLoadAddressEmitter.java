package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.LoadAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class load from stack emitter for the 3D C code port
 *
 */
public class CLoadAddressEmitter implements InstructionEmitter<LoadAddress> {
    @Override
    public Class<LoadAddress> handles() {
        return LoadAddress.class;
    }

    @Override
    public void emit(LoadAddress instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + CSyntax.address(instruction.getAddress()) + ";");
    }
}
