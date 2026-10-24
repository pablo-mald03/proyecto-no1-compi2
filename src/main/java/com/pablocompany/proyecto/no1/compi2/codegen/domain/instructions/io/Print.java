package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal class representation for the print statement instruction
 *
 */
@Data
@AllArgsConstructor
public class Print implements Instruction {
    private Register source;
    private boolean newLine;
}
