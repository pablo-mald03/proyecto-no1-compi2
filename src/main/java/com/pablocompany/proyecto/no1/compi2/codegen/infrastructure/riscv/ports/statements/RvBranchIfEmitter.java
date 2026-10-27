package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.statements;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Principal if statement emitter class
 *
 */
public class RvBranchIfEmitter implements InstructionEmitter<BranchIf> {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public Class<BranchIf> handles() {
        return BranchIf.class;
    }

    @Override
    public void emit(BranchIf instruction, CodeWriter out) {
        String skipLabel = instruction.getTarget() + "_far" + counter.incrementAndGet();
        String invertedBranch = instruction.isJumpWhen() ? "beqz " : "bnez ";
        out.line(invertedBranch + RvRegisters.of(instruction.getCondition()) + ", " + skipLabel);
        out.line("j " + instruction.getTarget());
        out.raw(skipLabel + ":");
    }
}
