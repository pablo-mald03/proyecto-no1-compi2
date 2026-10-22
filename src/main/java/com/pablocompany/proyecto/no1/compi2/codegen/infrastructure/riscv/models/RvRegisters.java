package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;

/**
 * Principal class representation for the risc V registers
 */
public class RvRegisters {
    public static final String FP = "s0";
    public static final String STACK_TOP = "s1";
    public static final String HEAP_TOP = "s2";
    public static final String SCRATCH = "t6";
    public static final String SCRATCH2 = "a1";

    /**
     * Method to get the register string
     *
     */
    public static String of(Register r) {
        int n = r.getRole().ordinal();
        return switch (r.getType()) {
            case FLOAT -> "ft" + n;
            case STRING -> "t" + (3 + n);
            case INT, CHAR, BOOLEAN -> "t" + n;
        };
    }

    /**
     * Method to return if the register is float type
     */
    public static boolean isFloat(Register register) {
        return register.getType().isFloat();
    }

    /**
     * Method to load an operation
     *
     */
    public static String loadOp(Register r) {
        return isFloat(r) ? "flw" : "lw";
    }

    /**
     * Method to store an operation
     *
     */
    public static String storeOp(Register r) {
        return isFloat(r) ? "fsw" : "sw";
    }
}
