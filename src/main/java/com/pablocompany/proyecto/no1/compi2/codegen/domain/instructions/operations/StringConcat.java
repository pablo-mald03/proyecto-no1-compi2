package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class representation for the concat operation
 *
 */
@Data
public class StringConcat implements Instruction {
    private Register left;
    private Register right;
    private Register destination;
}
