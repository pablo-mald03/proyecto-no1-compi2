package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal unary operation representation class for the operation
 *
 */
@Data
public class UnaryOperation implements Instruction {
    private UnaryOperator operator;
    private Register source;
    private Register destination;
}
