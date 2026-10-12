package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class string concat action emitter for the 3D C code port
 *
 */
public class CStringConcatEmitter implements InstructionEmitter<StringConcat> {
    @Override
    public Class<StringConcat> handles() {
        return StringConcat.class;
    }

    @Override
    public void emit(StringConcat instruction, CodeWriter out) {
        String d = CSyntax.registerTo(instruction.getDestination()), a = CSyntax.registerTo(instruction.getLeft()), b = CSyntax.registerTo(instruction.getRight());
        out.line(d + " = (char*)malloc(strlen(" + a + ") + strlen(" + b + ") + 1);");
        out.line("strcpy(" + d + ", " + a + ");");
        out.line("strcat(" + d + ", " + b + ");");
    }
}
