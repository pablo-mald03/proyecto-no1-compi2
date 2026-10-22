package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal binary operation emitter class
 *
 */
public class RvBinaryOperationEmitter implements InstructionEmitter<BinaryOperation> {
    @Override
    public Class<BinaryOperation> handles() {
        return BinaryOperation.class;
    }

    /**
     * Method to emit the action
     *
     */
    @Override
    public void emit(BinaryOperation i, CodeWriter out) {
        String l = RvRegisters.of(i.getLeft()), r = RvRegisters.of(i.getRight()), d = RvRegisters.of(i.getDestination());
        if (RvRegisters.isFloat(i.getLeft())) emitFloat(i, l, r, d, out);
        else emitInteger(i, l, r, d, out);
    }

    /**
     * Helper method to emit an integer operation
     *
     */
    private void emitInteger(BinaryOperation instruction, String l, String r, String d, CodeWriter out) {
        switch (instruction.getOperator()) {
            case ADD -> out.line("add " + d + ", " + l + ", " + r);
            case SUB -> out.line("sub " + d + ", " + l + ", " + r);
            case MUL -> out.line("mul " + d + ", " + l + ", " + r);
            case DIV -> out.line("div " + d + ", " + l + ", " + r);
            case MOD -> out.line("rem " + d + ", " + l + ", " + r);
            case EQ -> {
                out.line("sub " + d + ", " + l + ", " + r);
                out.line("seqz " + d + ", " + d);
            }
            case NE -> {
                out.line("sub " + d + ", " + l + ", " + r);
                out.line("snez " + d + ", " + d);
            }
            case LT -> out.line("slt " + d + ", " + l + ", " + r);
            case GT -> out.line("slt " + d + ", " + r + ", " + l);
            case LE -> {
                out.line("slt " + d + ", " + r + ", " + l);
                out.line("xori " + d + ", " + d + ", 1");
            }
            case GE -> {
                out.line("slt " + d + ", " + l + ", " + r);
                out.line("xori " + d + ", " + d + ", 1");
            }
            case AND -> {
                out.line("snez " + RvRegisters.SCRATCH + ", " + l);
                out.line("snez " + RvRegisters.SCRATCH2 + ", " + r);
                out.line("and " + d + ", " + RvRegisters.SCRATCH + ", " + RvRegisters.SCRATCH2);
            }
            case OR -> {
                out.line("or " + d + ", " + l + ", " + r);
                out.line("snez " + d + ", " + d);
            }
        }
    }

    /**
     * Method to emit the float operation
     *
     */
    private void emitFloat(BinaryOperation instruction, String l, String r, String d, CodeWriter out) {
        boolean arithmetic = !instruction.getOperator().isComparison();
        if (arithmetic && !RvRegisters.isFloat(instruction.getDestination())) {
            throw new IllegalStateException("Aritmética float con destino entero: " + instruction);
        }
        switch (instruction.getOperator()) {
            case ADD -> out.line("fadd.s " + d + ", " + l + ", " + r);
            case SUB -> out.line("fsub.s " + d + ", " + l + ", " + r);
            case MUL -> out.line("fmul.s " + d + ", " + l + ", " + r);
            case DIV -> out.line("fdiv.s " + d + ", " + l + ", " + r);
            case EQ -> out.line("feq.s " + d + ", " + l + ", " + r);
            case NE -> {
                out.line("feq.s " + d + ", " + l + ", " + r);
                out.line("xori " + d + ", " + d + ", 1");
            }
            case LT -> out.line("flt.s " + d + ", " + l + ", " + r);
            case GT -> out.line("flt.s " + d + ", " + r + ", " + l);
            case LE -> out.line("fle.s " + d + ", " + l + ", " + r);
            case GE -> out.line("fle.s " + d + ", " + r + ", " + l);
            case MOD, AND, OR ->
                    throw new UnsupportedOperationException(instruction.getOperator() + " no está definido para float");
        }
    }
}
