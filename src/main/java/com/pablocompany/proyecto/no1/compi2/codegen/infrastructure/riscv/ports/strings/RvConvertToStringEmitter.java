package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.ConvertToString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal string converter emitter class
 *
 */
public class RvConvertToStringEmitter implements InstructionEmitter<ConvertToString> {
    @Override
    public Class<ConvertToString> handles() {
        return ConvertToString.class;
    }

    /**
     * Method to emit the action
     *
     */
    @Override
    public void emit(ConvertToString instruction, CodeWriter out) {
        String src = RvRegisters.of(instruction.getSource()), target = RvRegisters.of(instruction.getTarget());
        switch (instruction.getSource().getType()) {
            case FLOAT -> {
                out.line("fmv.s fa0, " + src);
                out.line("mv a1, " + target);
                out.line("jal ra, __rt_ftoa");
            }
            case CHAR -> {
                out.line("sb " + src + ", 0(" + target + ")");
                out.line("sb zero, 1(" + target + ")");
            }
            case STRING -> throw new IllegalStateException("Una cadena no se convierte a cadena");
            case INT, BOOLEAN -> {
                out.line("mv a0, " + src);
                out.line("mv a1, " + target);
                out.line("jal ra, __rt_itoa");
            }
        }
    }
}
