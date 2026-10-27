package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Move;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringRef;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal movement action class
 *
 */
public class RvMoveEmitter implements InstructionEmitter<Move> {
    @Override
    public Class<Move> handles() {
        return Move.class;
    }

    /**
     * Method to trigger the action
     *
     */
    @Override
    public void emit(Move instruction, CodeWriter out) {
        String dest = RvRegisters.of(instruction.getDestination());
        boolean destFloat = RvRegisters.isFloat(instruction.getDestination());
        switch (instruction.getSource()) {
            case Register register -> {
                if (RvRegisters.isFloat(register) != destFloat)
                    throw new IllegalStateException("Move entre float y entero: " + instruction);
                out.line((destFloat ? "fmv.s " : "mv ") + dest + ", " + RvRegisters.of(register));
            }
            case Immediate imm -> {
                if (destFloat) {
                    int bits = Float.floatToRawIntBits(Float.parseFloat(imm.getLiteral()));
                    out.line("li " + RvRegisters.SCRATCH + ", " + bits);
                    out.line("fmv.w.x " + dest + ", " + RvRegisters.SCRATCH);
                } else {
                    out.line("li " + dest + ", " + integerValue(imm.getLiteral()));
                }
            }
            case StringRef s -> out.line("la " + dest + ", " + s.getId());
            default -> throw new IllegalStateException("Valor inesperado: " + instruction.getSource());
        }
    }

    /**
     * Method to get the integer value
     *
     */
    private static long integerValue(String literal) {
        if (literal == null || literal.equals("null")) {
            throw new IllegalStateException("Literal de entero es null — probablemente un nodo sin valor inicializado correctamente");
        }
        try {
            return Long.parseLong(literal);
        } catch (NumberFormatException e) {
            if (literal.equals("true")) return 1;
            if (literal.equals("false")) return 0;
            return (long) Double.parseDouble(literal);
        }
    }

}