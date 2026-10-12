package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Data;

/**
 * Principal class to representation the read statement
 *
 */
@Data
public class Read implements Instruction {
    private ValueType type;
    private Address target;

}
