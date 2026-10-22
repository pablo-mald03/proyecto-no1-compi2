package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal if statement emitter class
 *
 */
public class RvBranchIfEmitter implements InstructionEmitter<BranchIf> {
    @Override
    public Class<BranchIf> handles() {
        return BranchIf.class;
    }

    @Override
    public void emit(BranchIf instruction, CodeWriter out) {
        out.line((instruction.isJumpWhen() ? "bnez " : "beqz ") + RvRegisters.of(instruction.getCondition()) + ", " + instruction.getTarget());
    }
}
