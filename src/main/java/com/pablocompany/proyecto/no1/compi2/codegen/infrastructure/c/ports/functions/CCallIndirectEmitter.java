package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallIndirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallSites;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import lombok.RequiredArgsConstructor;

/**
 * C indirect function call emitter for virtual method dispatch.
 */
@RequiredArgsConstructor
public class CCallIndirectEmitter implements InstructionEmitter<CallIndirect> {

    private final CallSites sites;

    @Override
    public Class<CallIndirect> handles() {
        return CallIndirect.class;
    }

    @Override
    public void emit(CallIndirect instruction, CodeWriter out) {
        int id = sites.next();
        out.line("rastack[rasp] = " + id + ";");
        out.line("rasp = rasp + 1;");
        out.line("goto *(void*)(long)" + CSyntax.registerTo(instruction.getTargetRegister()) + ";");
        out.raw("ret_" + id + ":;");
    }
}
