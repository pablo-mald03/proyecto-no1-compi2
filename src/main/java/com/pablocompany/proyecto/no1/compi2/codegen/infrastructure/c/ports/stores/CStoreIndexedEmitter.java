package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class store array or data blocks emitter for the 3D C code port
 *
 */
public class CStoreIndexedEmitter implements InstructionEmitter<StoreIndexed> {
    @Override
    public Class<StoreIndexed> handles() {
        return StoreIndexed.class;
    }

    @Override
    public void emit(StoreIndexed instruction, CodeWriter out) {
        String cell = CSyntax.memory(MemorySpace.STACK, instruction.getSource().getType())
                + "[" + CSyntax.address(instruction.getBase()) + " + " + CSyntax.registerTo(instruction.getIndex()) + "]";
        out.line(cell + " = " + CSyntax.registerTo(instruction.getSource()) + ";");
    }
}
