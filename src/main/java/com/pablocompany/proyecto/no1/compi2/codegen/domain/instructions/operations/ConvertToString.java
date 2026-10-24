package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal string converter class
 *
 */
@Data
@AllArgsConstructor
public class ConvertToString implements Instruction {

    private Register source;
    private Register target;
}
