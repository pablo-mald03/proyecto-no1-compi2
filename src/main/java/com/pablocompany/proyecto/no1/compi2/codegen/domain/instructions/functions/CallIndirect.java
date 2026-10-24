package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Instruction for indirect function calls via a register holding the function address.
 * Used for virtual method dispatch through VTables.
 */
@Data
@AllArgsConstructor
public class CallIndirect implements Instruction {

    private Register targetRegister;
}
