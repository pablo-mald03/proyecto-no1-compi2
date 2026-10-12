package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Conditional evaluation for the if value
 *
 */
@Data
@AllArgsConstructor
public class BranchIf implements Instruction {
    private Register condition;
    private boolean jumpWhen;
    private String target;
}
