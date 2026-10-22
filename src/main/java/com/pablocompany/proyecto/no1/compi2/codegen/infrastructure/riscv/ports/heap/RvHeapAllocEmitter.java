package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal heap allocation emitter class
 *
 */
public class RvHeapAllocEmitter implements InstructionEmitter<HeapAlloc> {
    @Override
    public Class<HeapAlloc> handles() {
        return HeapAlloc.class;
    }

    /**
     * Principal heap allocation action
     *
     */
    @Override
    public void emit(HeapAlloc instruction, CodeWriter out) {
        out.line("mv " + RvRegisters.of(instruction.getDestination()) + ", " + RvRegisters.HEAP_TOP);
        RvMemory.addSlots(out, RvRegisters.HEAP_TOP, RvRegisters.HEAP_TOP, instruction.getSlots(), RvRegisters.SCRATCH);
    }
}
