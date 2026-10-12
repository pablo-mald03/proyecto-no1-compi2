package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class unary operator emitter for the 3D C code port
 *
 */
public class CUnaryOperationEmitter implements InstructionEmitter<UnaryOperation> {
    
    @Override
    public Class<UnaryOperation> handles() {
        return UnaryOperation.class;
    }

    @Override
    public void emit(UnaryOperation instruction, CodeWriter out) {
        String symbol = instruction.getOperator() == UnaryOperator.NEG ? "-" : "!";
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = " + symbol + CSyntax.registerTo(instruction.getSource()) + ";");
    }
}
