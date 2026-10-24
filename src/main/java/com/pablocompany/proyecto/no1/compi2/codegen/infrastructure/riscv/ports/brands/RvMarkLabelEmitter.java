package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.brands;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal mark label emitter class
 *
 */
public class RvMarkLabelEmitter implements InstructionEmitter<MarkLabel> {
    @Override
    public Class<MarkLabel> handles() {
        return MarkLabel.class;
    }

    /**
     * Method to trigger the label naming actions
     *
     */
    @Override
    public void emit(MarkLabel i, CodeWriter out) {
        out.raw(i.getName() + ":");
    }
}
