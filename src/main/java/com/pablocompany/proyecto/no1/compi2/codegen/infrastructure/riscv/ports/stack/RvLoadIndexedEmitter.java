package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal load array index emitter class
 *
 */
public class RvLoadIndexedEmitter implements InstructionEmitter<LoadIndexed> {
    @Override
    public Class<LoadIndexed> handles() {
        return LoadIndexed.class;
    }

    /**
     * Method to trigger the action
     *
     */
    @Override
    public void emit(LoadIndexed instruction, CodeWriter out) {
        out.line("slli " + RvRegisters.SCRATCH + ", " + RvRegisters.of(instruction.getIndex()) + ", 2");
        out.line("add " + RvRegisters.SCRATCH + ", " + RvRegisters.SCRATCH + ", " + RvMemory.baseRegister(MemorySpace.STACK, instruction.getBase()));
        String mem = RvMemory.operandFrom(out, RvRegisters.SCRATCH, RvMemory.slotOffset(instruction.getBase()), RvRegisters.SCRATCH2);
        out.line(RvRegisters.loadOp(instruction.getDestination()) + " " + RvRegisters.of(instruction.getDestination()) + ", " + mem);
    }
}
