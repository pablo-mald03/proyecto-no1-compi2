package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class for the binary operations emitter for the 3D C code port
 *
 */
public class CBinaryOperationEmitter implements InstructionEmitter<BinaryOperation> {
    @Override
    public Class<BinaryOperation> handles() {
        return BinaryOperation.class;
    }

    @Override
    public void emit(BinaryOperation i, CodeWriter out) {
        out.line(CSyntax.registerTo(i.getDestination()) + " = " + CSyntax.registerTo(i.getLeft()) + " " + i.getOperator().getSymbol() + " " + CSyntax.registerTo(i.getRight()) + ";");
    }
}
