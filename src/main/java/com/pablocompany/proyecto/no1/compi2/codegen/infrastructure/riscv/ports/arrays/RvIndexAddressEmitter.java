package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.arrays;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal index address emitter class
 *
 */
public class RvIndexAddressEmitter implements InstructionEmitter<IndexAddress> {
    @Override
    public Class<IndexAddress> handles() {
        return IndexAddress.class;
    }

    /**
     * Principal index address action
     *
     */
    @Override
    public void emit(IndexAddress instruction, CodeWriter out) {
        out.line("slli " + RvRegisters.SCRATCH + ", " + RvRegisters.of(instruction.getIndex()) + ", 2");
        out.line("add " + RvRegisters.of(instruction.getDestination()) + ", " + RvRegisters.of(instruction.getBase()) + ", " + RvRegisters.SCRATCH);
    }
}
