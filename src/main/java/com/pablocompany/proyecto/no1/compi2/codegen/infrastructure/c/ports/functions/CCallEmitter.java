package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class for function calls emitter for the 3D C code port
 *
 */
public class CCallEmitter implements InstructionEmitter<Call> {
    @Override
    public Class<Call> handles() {
        return Call.class;
    }

    @Override
    public void emit(Call instruction, CodeWriter out) {
        out.line(instruction.getFunction() + "();");
    }
}
