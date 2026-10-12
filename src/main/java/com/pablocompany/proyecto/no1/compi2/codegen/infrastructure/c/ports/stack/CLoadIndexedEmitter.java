package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class load form stack index value emitter for the 3D C code port
 *
 */
public class CLoadIndexedEmitter implements InstructionEmitter<LoadIndexed> {
    @Override
    public Class<LoadIndexed> handles() {
        return LoadIndexed.class;
    }

    @Override
    public void emit(LoadIndexed instruction, CodeWriter out) {
        String array = CSyntax.memory(MemorySpace.STACK, instruction.getDestination().getType());
        out.line("addr = " + CSyntax.address(instruction.getBase()) + ";");
        out.line("addr = addr + " + CSyntax.registerTo(instruction.getIndex()) + ";");
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + array + "[addr];");
    }
}
