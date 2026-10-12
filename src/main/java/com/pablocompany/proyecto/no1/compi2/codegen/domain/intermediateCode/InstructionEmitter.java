package com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode;

import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class to translate an instruction to the destination code
 *
 */
public interface InstructionEmitter<I extends Instruction> {

    Class<I> handles();

    void emit(I instruction, CodeWriter out);
}
