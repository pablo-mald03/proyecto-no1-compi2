package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal jump emitter instruction class
 *
 */
public class RvJumpEmitter implements InstructionEmitter<Jump> {
    @Override
    public Class<Jump> handles() {
        return Jump.class;
    }

    /**
     * Method to trigger the action
     *
     */
    @Override
    public void emit(Jump instruction, CodeWriter out) {
        out.line("j " + instruction.getTarget());
    }
}
