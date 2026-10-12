package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class read function emitter for the 3D C code port
 *
 */
public class CReadEmitter implements InstructionEmitter<Read> {
    private static final String FLUSH_LINE = "{ int _c; while ((_c = getchar()) != '\\n' && _c != EOF); }";

    @Override
    public Class<Read> handles() {
        return Read.class;
    }

    @Override
    public void emit(Read instruction, CodeWriter out) {
        String cell = CSyntax.cell(MemorySpace.STACK, instruction.getType(), instruction.getTarget());
        switch (instruction.getType()) {
            case STRING -> {
                out.line(cell + " = (char*)malloc(1024);");
                out.line("scanf(\"%1023s\", " + cell + ");");
            }
            case FLOAT -> out.line("if (scanf(\" %f\", &" + cell + ") != 1) { " + cell + " = 0; }");
            case CHAR -> out.line("{ char _ch = 0; scanf(\" %c\", &_ch); " + cell + " = _ch; }");
            case INT, BOOLEAN -> out.line("if (scanf(\" %d\", &" + cell + ") != 1) { " + cell + " = 0; }");
        }
        out.line(FLUSH_LINE);
    }
}
