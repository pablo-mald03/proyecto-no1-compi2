package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal unary operation emitter class
 *
 */
public class RvUnaryOperationEmitter implements InstructionEmitter<UnaryOperation> {
    @Override
    public Class<UnaryOperation> handles() {
        return UnaryOperation.class;
    }

    @Override
    public void emit(UnaryOperation instruction, CodeWriter out) {
        String d = RvRegisters.of(instruction.getDestination()), s = RvRegisters.of(instruction.getSource());
        switch (instruction.getOperator()) {
            case NEG ->
                    out.line(RvRegisters.isFloat(instruction.getSource()) ? "fneg.s " + d + ", " + s : "sub " + d + ", zero, " + s);
            case NOT -> out.line("seqz " + d + ", " + s);
        }
    }
}
