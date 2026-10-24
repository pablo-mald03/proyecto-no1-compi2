package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
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
        String d = CSyntax.registerTo(instruction.getDestination());
        String a = CSyntax.registerTo(instruction.getLeft());
        String b = CSyntax.registerTo(instruction.getRight());
        out.line("n1 = strlen(" + a + ");");
        out.line("n2 = strlen(" + b + ");");
        out.line("n2 = n1 + n2;");
        out.line("n2 = n2 + 1;");
        out.line(d + " = malloc(n2);");
        out.line("strcpy(" + d + ", " + a + ");");
        out.line("tp = " + d + " + n1;");
        out.line("strcpy(tp, " + b + ");");
    }
}
