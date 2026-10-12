package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal instruction emitter for the c code generation
 *
 */
public class CAdjustStackTopEmitter implements InstructionEmitter<AdjustStackTop> {

    /**
     * Handler class representation
     *
     */
    @Override
    public Class<AdjustStackTop> handles() {
        return AdjustStackTop.class;
    }

    /**
     * Principal emitter  for the code translation
     *
     */
    @Override
    public void emit(AdjustStackTop instruction, CodeWriter out) {
        out.line("sptr = sptr " + (instruction.getDelta() < 0 ? "- " : "+ ") + Math.abs(instruction.getDelta()) + ";");
    }
}
