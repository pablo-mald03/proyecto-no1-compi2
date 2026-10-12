package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class store data emitter for the 3D C code port
 *
 */
public class CStoreEmitter implements InstructionEmitter<Store> {
    @Override
    public Class<Store> handles() {
        return Store.class;
    }

    @Override
    public void emit(Store instruction, CodeWriter out) {
        String idx = CSyntax.resolve(out, instruction.getAddress());
        String array = CSyntax.memory(instruction.getMemorySpace(), instruction.getSource().getType());
        out.line(array + "[" + idx + "] = " + CSyntax.registerTo(instruction.getSource()) + ";");
    }
}
