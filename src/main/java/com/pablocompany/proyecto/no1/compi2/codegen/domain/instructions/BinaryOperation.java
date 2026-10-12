package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal binary operation representation class
 *
 */
@Data
public class BinaryOperation implements Instruction {

    private BinaryOperations operator;
    private Register left;
    private Register right;
    private Register destination;
}
