package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal read emitter action class
 *
 */
public class RvReadEmitter implements InstructionEmitter<Read> {
    @Override
    public Class<Read> handles() {
        return Read.class;
    }

    /**
     * Method to trigger the action for read function
     *
     */
    @Override
    public void emit(Read instruction, CodeWriter out) {
        String mem = RvMemory.operand(out, MemorySpace.STACK, instruction.getTarget(), RvRegisters.SCRATCH);
        switch (instruction.getType()) {
            case INT, BOOLEAN -> {
                out.line("li a7, 5");
                out.line("ecall");
                out.line("sw a0, " + mem);
            }
            case CHAR -> {
                out.line("li a7, 12");
                out.line("ecall");
                out.line("sw a0, " + mem);
            }
            case FLOAT -> {
                out.line("li a7, 6");
                out.line("ecall");
                out.line("fsw fa0, " + mem);
            }
            case STRING -> {
                out.line("li a0, 1024");
                out.line("li a7, 9");
                out.line("ecall");
                out.line("sw a0, " + mem);
                out.line("jal ra, __rt_readline");
            }
        }
    }
}
