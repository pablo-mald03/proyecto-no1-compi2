package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.brands;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.LoadLabelAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * RISC-V emitter to load the address of a label into a register using 'la'.
 */
public class RvLoadLabelAddressEmitter implements InstructionEmitter<LoadLabelAddress> {

    @Override
    public Class<LoadLabelAddress> handles() {
        return LoadLabelAddress.class;
    }

    @Override
    public void emit(LoadLabelAddress instruction, CodeWriter out) {
        out.line("la " + RvRegisters.of(instruction.getDestination()) + ", " + instruction.getLabel());
    }
}
