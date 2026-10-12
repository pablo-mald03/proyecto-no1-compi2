package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import lombok.Data;

/**
 * Principal class representation for the goto action
 *
 */
@Data
public class Jump implements Instruction {
    private String target;
}
