package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Frame;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Indirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal memory management model
 *
 */
public class RvMemory {
    public static final int CELL = 4;

    /**
     * Method to fit the string
     */
    public static boolean fits12(long value) {
        return value >= -2048 && value <= 2047;
    }

    /**
     * Method to execute the base register
     */
    public static String baseRegister(MemorySpace space, Address address) {
        return switch (address) {
            case Frame frame -> requireStack(space, address, RvRegisters.FP);
            case StackTop stack -> requireStack(space, address, RvRegisters.STACK_TOP);
            case Indirect indirect -> {
                if (RvRegisters.isFloat(indirect.getBase()))
                    throw new IllegalArgumentException("Un puntero no puede estar en un registro float");
                yield RvRegisters.of(indirect.getBase());
            }
            default -> throw new IllegalStateException("Valor inesperado: " + address);
        };
    }

    /**
     * Method to require the stack
     *
     */
    public static String requireStack(MemorySpace space, Address a, String reg) {
        if (space != MemorySpace.STACK) throw new IllegalArgumentException(a + " solo es válida en la pila");
        return reg;
    }

    /**
     * Method to calculate the slot offset
     *
     */
    public static int slotOffset(Address a) {
        return switch (a) {
            case Frame frame -> frame.getOffset();
            case StackTop stack -> stack.getOffset();
            case Indirect indirect -> indirect.getOffset();
            default -> throw new IllegalStateException("Valor inesperado: " + a);
        };
    }

    /**
     * Method to return the operand
     */
    public static String operand(CodeWriter out, MemorySpace space, Address a, String scratch) {
        return operandFrom(out, baseRegister(space, a), slotOffset(a), scratch);
    }

    public static String operandFrom(CodeWriter out, String baseReg, int slotOffset, String scratch) {
        long bytes = (long) slotOffset * CELL;
        if (fits12(bytes)) return bytes + "(" + baseReg + ")";
        out.line("li " + scratch + ", " + bytes);
        out.line("add " + scratch + ", " + scratch + ", " + baseReg);
        return "0(" + scratch + ")";
    }

    /**
     * Method to add slots memory to the program
     */
    public static void addSlots(CodeWriter out, String dest, String src, int slots, String scratch) {
        long bytes = (long) slots * CELL;
        if (fits12(bytes)) {
            out.line("addi " + dest + ", " + src + ", " + bytes);
        } else {
            out.line("li " + scratch + ", " + bytes);
            out.line("add " + dest + ", " + src + ", " + scratch);
        }
    }
}
