package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.arrays;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal array access index emitter class
 *
 */
public class RvStoreIndexedEmitter implements InstructionEmitter<StoreIndexed> {
    @Override
    public Class<StoreIndexed> handles() {
        return StoreIndexed.class;
    }

    /**
     * Principal store indexed action
     *
     */
    @Override
    public void emit(StoreIndexed instruction, CodeWriter out) {
        out.line("slli " + RvRegisters.SCRATCH + ", " + RvRegisters.of(instruction.getIndex()) + ", 2");
        out.line("add " + RvRegisters.SCRATCH + ", " + RvRegisters.SCRATCH + ", " + RvMemory.baseRegister(MemorySpace.STACK, instruction.getBase()));
        String mem = RvMemory.operandFrom(out, RvRegisters.SCRATCH, RvMemory.slotOffset(instruction.getBase()), RvRegisters.SCRATCH2);
        out.line(RvRegisters.storeOp(instruction.getSource()) + " " + RvRegisters.of(instruction.getSource()) + ", " + mem);
    }
}
