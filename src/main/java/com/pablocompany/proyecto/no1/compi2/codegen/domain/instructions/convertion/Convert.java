package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.convertion;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal domain class for the conversion types
 *
 */
@Data
@AllArgsConstructor
public class Convert implements Instruction {
    private Register source;
    private Register destination;
    private ValueType target;
}
