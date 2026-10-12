package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class representation for the oad action for any stored value
 */
@Data
public class Load implements Instruction {

    private MemorySpace space;
    private Address address;
    private Register destination;
}
