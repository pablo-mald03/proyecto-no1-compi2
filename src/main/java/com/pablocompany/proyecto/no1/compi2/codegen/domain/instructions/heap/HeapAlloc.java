package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class to represents the pointer to the heap block slots
 *
 */
@Data
public class HeapAlloc implements Instruction {

    private int slots;
    private Operand dynamicSlots;
    private Register destination;

    public HeapAlloc(int slots, Register destination) {
        this.slots = slots;
        this.dynamicSlots = null;
        this.destination = destination;
    }

    public HeapAlloc(Operand dynamicSlots, Register destination) {
        this.slots = 0;
        this.dynamicSlots = dynamicSlots;
        this.destination = destination;
    }
}
