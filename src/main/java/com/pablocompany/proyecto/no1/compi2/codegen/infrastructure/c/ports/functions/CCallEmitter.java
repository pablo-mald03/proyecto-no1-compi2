package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallSites;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import lombok.RequiredArgsConstructor;

/**
 * Principal class for function calls emitter for the 3D C code port
 *
 */
@RequiredArgsConstructor
public class CCallEmitter implements InstructionEmitter<Call> {

    private final CallSites sites;

    @Override
    public Class<Call> handles() {
        return Call.class;
    }

    @Override
    public void emit(Call instruction, CodeWriter out) {
        int id = sites.next();
        out.line("rastack[rasp] = " + id + ";");
        out.line("rasp = rasp + 1;");
        out.line("goto " + instruction.getFunction() + ";");
        out.raw("ret_" + id + ":;");
    }
}
