package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Return;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal return statement emitter class
 *
 */
public class RvReturnEmitter implements InstructionEmitter<Return> {
    @Override
    public Class<Return> handles() {
        return Return.class;
    }

    /**
     * Method to trigger the return action code
     *
     */
    @Override
    public void emit(Return instruction, CodeWriter out) {
        out.line("lw ra, 0(sp)");
        out.line("addi sp, sp, 4");
        out.line("ret");
    }
}
