package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal call model class
 *
 */
@Data
@AllArgsConstructor
public class Call implements Instruction {

    private String function;
}
