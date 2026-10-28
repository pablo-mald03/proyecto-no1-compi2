package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models;

import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Helper unificado para la reserva manual de memoria en el heap y control de límites en RISC-V.
 */
public class RvAlloc {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private RvAlloc() {
    }

    /**
     * Emite la reserva de memoria en el heap manual (s2) con redondeo a múltiplo de 4
     * y comprobación contra el límite del heap (s3).
     *
     * Entrada: a0 = bytes pedidos.
     * Salida:  a0 = puntero a la memoria reservada.
     */
    public static void emitAlloc(CodeWriter out) {
        String okLabel = "_ok_" + COUNTER.incrementAndGet();
        out.line("addi a0, a0, 3");
        out.line("andi a0, a0, -4");
        out.line("mv a7, " + RvRegisters.HEAP_TOP);
        out.line("add " + RvRegisters.HEAP_TOP + ", " + RvRegisters.HEAP_TOP + ", a0");
        out.line("bleu " + RvRegisters.HEAP_TOP + ", " + RvRegisters.HEAP_LIMIT + ", " + okLabel);
        out.line("j __rt_oom");
        out.raw(okLabel + ":");
        out.line("mv a0, a7");
    }

    /**
     * Emite la comprobación de límite del heap tras haber avanzado s2.
     * Utilizado para objetos y arreglos (RvHeapAllocEmitter).
     */
    public static void emitLimitCheck(CodeWriter out) {
        String okLabel = "_ok_" + COUNTER.incrementAndGet();
        out.line("bleu " + RvRegisters.HEAP_TOP + ", " + RvRegisters.HEAP_LIMIT + ", " + okLabel);
        out.line("j __rt_oom");
        out.raw(okLabel + ":");
    }

    public static void reset() {
        COUNTER.set(0);
    }
}
