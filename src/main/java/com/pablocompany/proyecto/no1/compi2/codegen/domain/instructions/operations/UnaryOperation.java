package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal unary operation representation class for the operation
 *
 */
@Data
@AllArgsConstructor
public class UnaryOperation implements Instruction {
    private UnaryOperations operator;
    private Register source;
    private Register destination;
}
