package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal string concat emitter class
 *
 */
public class RvStringConcatEmitter implements InstructionEmitter<StringConcat> {
    @Override
    public Class<StringConcat> handles() {
        return StringConcat.class;
    }

    /**
     * Method to trigger the concat action
     *
     */
    @Override
    public void emit(StringConcat instruction, CodeWriter out) {
        out.line("mv a0, " + RvRegisters.of(instruction.getLeft()));
        out.line("mv a1, " + RvRegisters.of(instruction.getRight()));
        out.line("jal ra, __rt_concat");
        out.line("mv " + RvRegisters.of(instruction.getDestination()) + ", a0");
    }
}
