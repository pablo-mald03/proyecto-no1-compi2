package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Data;

/**
 * Principal call model class
 *
 */
@Data
public class Call implements Instruction {

    private String function;
}
