package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class print function emitter for the 3D C code port
 *
 */
public class CPrintEmitter implements InstructionEmitter<Print> {
    @Override
    public Class<Print> handles() {
        return Print.class;
    }

    @Override
    public void emit(Print instruction, CodeWriter out) {
        out.line("printf(\"" + CSyntax.printfSpec(instruction.getSource().getType()) + (instruction.isNewLine() ? "\\n" : "")
                + "\", " + CSyntax.registerTo(instruction.getSource()) + ");");
        out.line("fflush(stdout);");
    }
}
