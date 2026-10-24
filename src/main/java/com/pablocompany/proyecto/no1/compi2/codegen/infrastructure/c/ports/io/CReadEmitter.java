package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class read function emitter for the 3D C code port
 *
 */
public class CReadEmitter implements InstructionEmitter<Read> {

    @Override
    public Class<Read> handles() {
        return Read.class;
    }

    @Override
    public void emit(Read instruction, CodeWriter out) {
        String idx = CSyntax.resolve(out, instruction.getTarget());
        String cell = CSyntax.memory(MemorySpace.STACK, instruction.getType()) + "[" + idx + "]";
        switch (instruction.getType()) {
            case STRING -> {
                out.line(cell + " = malloc(1024);");
                out.line("scanf(\"%1023s\", " + cell + ");");
            }
            case FLOAT -> out.line("scanf(\"%f\", &" + cell + ");");
            case INT, BOOLEAN -> out.line("scanf(\"%d\", &" + cell + ");");
            case CHAR -> {
                String ch = CSyntax.registerTo(Register.cx(ValueType.CHAR));
                out.line("scanf(\" %c\", &" + ch + ");");
                out.line(cell + " = " + ch + ";");
            }
        }
    }
}
