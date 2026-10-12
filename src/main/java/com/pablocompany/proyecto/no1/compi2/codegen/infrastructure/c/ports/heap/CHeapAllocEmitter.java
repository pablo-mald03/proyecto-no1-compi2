package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class code heap allocation emitter for the 3D C code port
 *
 */
public class CHeapAllocEmitter implements InstructionEmitter<HeapAlloc> {

    @Override
    public Class<HeapAlloc> handles() {
        return HeapAlloc.class;
    }

    @Override
    public void emit(HeapAlloc instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = hptr;");
        out.line("hptr = hptr + " + instruction.getSlots() + ";");
    }
}
