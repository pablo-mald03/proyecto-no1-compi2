package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal load data action class
 *
 */
public class RvLoadEmitter implements InstructionEmitter<Load> {
    @Override
    public Class<Load> handles() {
        return Load.class;
    }

    /**
     * Method to trigger the action
     *
     */
    @Override
    public void emit(Load instruction, CodeWriter out) {
        String mem = RvMemory.operand(out, instruction.getSpace(), instruction.getAddress(), RvRegisters.SCRATCH);
        out.line(RvRegisters.loadOp(instruction.getDestination()) + " " + RvRegisters.of(instruction.getDestination()) + ", " + mem);
    }
}
