package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal class representation for the stack dynamic store
 *
 */
@Data
@AllArgsConstructor
public class StoreIndexed implements Instruction {
    private Address base;
    private Register index;
    private Register source;
}
