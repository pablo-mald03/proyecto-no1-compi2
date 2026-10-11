package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.AdjustStackTop;

public class CAdjustStackTopEmitter implements InstructionEmitter<AdjustStackTop> {
    @Override
    public Class<AdjustStackTop> handles() {
        return AdjustStackTop.class;
    }

    @Override
    public void emit(AdjustStackTop i, CodeWriter out) {
        out.line("sptr = sptr " + (i.getDelta() < 0 ? "- " : "+ ") + Math.abs(i.getDelta()) + ";");
    }
}
