package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal class if comparation emitter for the 3D C code port
 *
 */
public class CBranchIfEmitter implements InstructionEmitter<BranchIf> {
    @Override
    public Class<BranchIf> handles() {
        return BranchIf.class;
    }

    @Override
    public void emit(BranchIf i, CodeWriter out) {
        String test = i.isJumpWhen() ? CSyntax.registerTo(i.getCondition()) : "!" + CSyntax.registerTo(i.getCondition());
        out.line("if (" + test + ") goto " + i.getTarget() + ";");
    }
}
