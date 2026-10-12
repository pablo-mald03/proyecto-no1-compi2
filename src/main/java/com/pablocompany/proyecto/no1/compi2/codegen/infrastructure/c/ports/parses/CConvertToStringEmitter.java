package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.parses;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.ConvertToString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class string parse emitter for the 3D C code port
 *
 */
public class CConvertToStringEmitter implements InstructionEmitter<ConvertToString> {
    @Override
    public Class<ConvertToString> handles() {
        return ConvertToString.class;
    }

    @Override
    public void emit(ConvertToString instruction, CodeWriter out) {
        String spec = CSyntax.printfSpec(instruction.getSource().getType());
        out.line("sprintf(" + CSyntax.registerTo(instruction.getTarget()) + ", \"" + spec + "\", " + CSyntax.registerTo(instruction.getSource()) + ");");
    }
}
