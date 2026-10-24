package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.labels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.LoadLabelAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * C emitter to load the address of a label or table into a register.
 */
public class CLoadLabelAddressEmitter implements InstructionEmitter<LoadLabelAddress> {

    @Override
    public Class<LoadLabelAddress> handles() {
        return LoadLabelAddress.class;
    }

    @Override
    public void emit(LoadLabelAddress instruction, CodeWriter out) {
        out.line(CSyntax.registerTo(instruction.getDestination()) + " = (long)" + instruction.getLabel() + ";");
    }
}
