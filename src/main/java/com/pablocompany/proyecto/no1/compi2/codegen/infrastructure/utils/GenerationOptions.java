package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils;

import lombok.Data;

/**
 * Principal generation options class
 *
 */
@Data
public class GenerationOptions {
    private int stackSlots;
    private int heapSlots;
    private int reservedSlots;
    private boolean emitEntryPoint;

    public GenerationOptions(int stackSlots, int heapSlots, int reservedSlots, boolean emitEntryPoint) {
        if (stackSlots <= 0 || heapSlots <= 0) throw new IllegalArgumentException("Tamaños inválidos");
        if (reservedSlots < 1 || reservedSlots >= stackSlots)
            throw new IllegalArgumentException("reservedSlots inválido");
        this.stackSlots = stackSlots;
        this.heapSlots = heapSlots;
        this.reservedSlots = reservedSlots;
        this.emitEntryPoint = emitEntryPoint;
    }

    /**
     * Default memory generation method
     *
     */
    public static GenerationOptions defaults() {
        return new GenerationOptions(65536, 65536, 8, true);
    }
}