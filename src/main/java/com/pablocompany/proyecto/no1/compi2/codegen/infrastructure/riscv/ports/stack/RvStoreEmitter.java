package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal store emitter class
 *
 */
public class RvStoreEmitter implements InstructionEmitter<Store> {
    @Override
    public Class<Store> handles() {
        return Store.class;
    }

    /**
     * Method to trigger the action
     *
     */
    @Override
    public void emit(Store instruction, CodeWriter out) {
        String mem = RvMemory.operand(out, instruction.getMemorySpace(), instruction.getAddress(), RvRegisters.SCRATCH);
        out.line(RvRegisters.storeOp(instruction.getSource()) + " " + RvRegisters.of(instruction.getSource()) + ", " + mem);
    }
}
