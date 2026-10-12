package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 *
 * Principal class to pass the memory references
 */
@Data
public class LoadAddress implements Instruction {
    private Address address;
    private Register destination;
}
