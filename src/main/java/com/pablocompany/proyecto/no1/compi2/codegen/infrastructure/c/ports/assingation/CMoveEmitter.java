package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.Move;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class change value emitter for the 3D C code port
 *
 */
public class CMoveEmitter implements InstructionEmitter<Move> {
    @Override
    public Class<Move> handles() {
        return Move.class;
    }

    @Override
    public void emit(Move instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + CSyntax.operand(instruction.getSource()) + ";");
    }
}
