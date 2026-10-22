package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.LoadAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal load address emitter action class
 *
 */
public class RvLoadAddressEmitter implements InstructionEmitter<LoadAddress> {
    @Override
    public Class<LoadAddress> handles() {
        return LoadAddress.class;
    }

    @Override
    public void emit(LoadAddress instruction, CodeWriter out) {
        String base = RvMemory.baseRegister(MemorySpace.STACK, instruction.getAddress());
        RvMemory.addSlots(out, RvRegisters.of(instruction.getDestination()), base, RvMemory.slotOffset(instruction.getAddress()), RvRegisters.SCRATCH);
    }
}
