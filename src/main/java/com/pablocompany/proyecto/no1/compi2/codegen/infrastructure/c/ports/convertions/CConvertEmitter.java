package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.convertions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.convertion.Convert;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

public class CConvertEmitter implements InstructionEmitter<Convert> {
    @Override
    public Class<Convert> handles() {
        return Convert.class;
    }

    @Override
    public void emit(Convert i, CodeWriter out) {
        String src = CSyntax.registerTo(i.getSource());
        String dst = CSyntax.registerTo(i.getDestination());
        String target = CSyntax.cType(i.getTarget());
        out.line(dst + " = (" + target + ")" + src + ";");
    }
}