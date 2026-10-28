package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings;

import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Helper class to evaluate the strings equality .
 */
public class RvStringEq {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private RvStringEq() {
    }

    /**
     * Method to emit the string equality.
     */
    public static void emitStringEquals(CodeWriter out, String l, String r, String d, boolean negate) {
        int id = COUNTER.incrementAndGet();
        String eqLabel = "__eq_" + id;
        String neLabel = "__ne_" + id;
        String loopLabel = "__loop_" + id;
        String endLabel = "__end_" + id;

        out.line("beq " + l + ", " + r + ", " + eqLabel);
        out.line("beqz " + l + ", " + neLabel);
        out.line("beqz " + r + ", " + neLabel);
        out.line("li " + d + ", 0");

        out.raw(loopLabel + ":");
        out.line("add " + RvRegisters.SCRATCH + ", " + l + ", " + d);
        out.line("lbu " + RvRegisters.SCRATCH + ", 0(" + RvRegisters.SCRATCH + ")");
        out.line("add " + RvRegisters.SCRATCH2 + ", " + r + ", " + d);
        out.line("lbu " + RvRegisters.SCRATCH2 + ", 0(" + RvRegisters.SCRATCH2 + ")");
        out.line("bne " + RvRegisters.SCRATCH + ", " + RvRegisters.SCRATCH2 + ", " + neLabel);
        out.line("beqz " + RvRegisters.SCRATCH + ", " + eqLabel);
        out.line("addi " + d + ", " + d + ", 1");
        out.line("j " + loopLabel);

        out.raw(eqLabel + ":");
        out.line("li " + d + ", " + (negate ? "0" : "1"));
        out.line("j " + endLabel);

        out.raw(neLabel + ":");
        out.line("li " + d + ", " + (negate ? "1" : "0"));

        out.raw(endLabel + ":");
    }

    public static void reset() {
        COUNTER.set(0);
    }
}
