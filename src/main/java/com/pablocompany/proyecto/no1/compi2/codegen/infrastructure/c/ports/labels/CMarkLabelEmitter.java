package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.labels;


import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class label enumeration value emitter for the 3D C code port
 *
 */
public class CMarkLabelEmitter implements InstructionEmitter<MarkLabel> {
    @Override
    public Class<MarkLabel> handles() {
        return MarkLabel.class;
    }

    @Override
    public void emit(MarkLabel instruction, CodeWriter out) {
        out.raw(instruction.getName() + ":;");
    }
}
