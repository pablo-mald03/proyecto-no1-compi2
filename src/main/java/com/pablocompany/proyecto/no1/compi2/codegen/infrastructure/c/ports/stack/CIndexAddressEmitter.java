package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class Index address emitter for the 3D C code port
 *
 */
public class CIndexAddressEmitter implements InstructionEmitter<IndexAddress> {
    @Override
    public Class<IndexAddress> handles() {
        return IndexAddress.class;
    }


    @Override
    public void emit(IndexAddress instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + CSyntax.registerTo(instruction.getBase()) + " + " + CSyntax.registerTo(instruction.getIndex()) + ";");
    }
}
