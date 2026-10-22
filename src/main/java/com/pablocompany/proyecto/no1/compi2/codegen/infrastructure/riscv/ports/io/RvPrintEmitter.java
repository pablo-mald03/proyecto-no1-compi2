package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Print action emitter class
 *
 */
public class RvPrintEmitter implements InstructionEmitter<Print> {
    @Override
    public Class<Print> handles() {
        return Print.class;
    }

    /**
     * Method to emit the action
     *
     */
    @Override
    public void emit(Print instruction, CodeWriter out) {
        String src = RvRegisters.of(instruction.getSource());
        switch (instruction.getSource().getType()) {
            case STRING -> printWithSyscall(out, src, 4);
            case CHAR -> printWithSyscall(out, src, 11);
            case INT, BOOLEAN -> printWithSyscall(out, src, 1);
            case FLOAT -> {
                out.line("fmv.s fa0, " + src);
                out.line("la a1, __rt_fbuf");
                out.line("jal ra, __rt_ftoa");
                out.line("la a0, __rt_fbuf");
                out.line("li a7, 4");
                out.line("ecall");
            }
        }
        if (instruction.isNewLine()) {
            out.line("li a0, 10");
            out.line("li a7, 11");
            out.line("ecall");
        }
    }

    /**
     * Helper method to write the system call
     *
     */
    private static void printWithSyscall(CodeWriter out, String reg, int syscall) {
        out.line("mv a0, " + reg);
        out.line("li a7, " + syscall);
        out.line("ecall");
    }
}
