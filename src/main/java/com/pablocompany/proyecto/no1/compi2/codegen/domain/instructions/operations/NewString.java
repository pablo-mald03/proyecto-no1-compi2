package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class representation for the string buffer memory reservation
 *
 */
@Data
public class NewString implements Instruction {
    private Register destination;
}
