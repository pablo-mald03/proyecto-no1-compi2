package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.NewString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal new string emitter class
 *
 */
public class RvNewStringEmitter implements InstructionEmitter<NewString> {
    @Override
    public Class<NewString> handles() {
        return NewString.class;
    }

    /**
     * Method to emit the new string action
     *
     */
    @Override
    public void emit(NewString i, CodeWriter out) {
        out.line("li a0, 64");
        RvAlloc.emitAlloc(out);
        out.line("mv " + RvRegisters.of(i.getDestination()) + ", a0");
    }
}
