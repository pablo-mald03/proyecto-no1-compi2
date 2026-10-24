package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class to represents the pointer to the heap block slots
 *
 */
@Data
@lombok.AllArgsConstructor
public class HeapAlloc implements Instruction {

    private int slots;
    private Register destination;
}
