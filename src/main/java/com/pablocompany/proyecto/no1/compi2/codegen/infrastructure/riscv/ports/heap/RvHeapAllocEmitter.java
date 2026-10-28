package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvAlloc;
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
        if (instruction.getDynamicSlots() != null) {
            Operand op = instruction.getDynamicSlots();
            if (op instanceof Immediate imm) {
                RvMemory.addSlots(out, RvRegisters.HEAP_TOP, RvRegisters.HEAP_TOP, Integer.parseInt(imm.getLiteral()), RvRegisters.SCRATCH);
            } else if (op instanceof Register reg) {
                out.line("slli " + RvRegisters.SCRATCH + ", " + RvRegisters.of(reg) + ", 2");
                out.line("add " + RvRegisters.HEAP_TOP + ", " + RvRegisters.HEAP_TOP + ", " + RvRegisters.SCRATCH);
            }
        } else {
            RvMemory.addSlots(out, RvRegisters.HEAP_TOP, RvRegisters.HEAP_TOP, instruction.getSlots(), RvRegisters.SCRATCH);
        }
        RvAlloc.emitLimitCheck(out);
    }
}
