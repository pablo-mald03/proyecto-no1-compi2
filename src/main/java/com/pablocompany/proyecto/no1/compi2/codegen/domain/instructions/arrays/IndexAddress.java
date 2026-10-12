package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Getter;

/**
 * Principal class representation for the pointer management at lower level
 * represents the assignation for the quadruple
 *
 */
@Getter
public class IndexAddress implements Instruction {

    private Register base;
    private Register index;
    private Register destination;
}
