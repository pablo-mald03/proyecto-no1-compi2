package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal risc V function call emitter class
 *
 */
public class RvCallEmitter implements InstructionEmitter<Call> {
    @Override
    public Class<Call> handles() {
        return Call.class;
    }

    @Override
    public void emit(Call instruction, CodeWriter out) {
        out.line("jal ra, " + instruction.getFunction());
    }
}
