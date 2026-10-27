package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Instruction to load the memory address of a global label (such as a VTable) into a register.
 */
@Data
@AllArgsConstructor
public class LoadLabelAddress implements Instruction {

    private String label;
    private Register destination;
}
