package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallIndirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * RISC-V indirect function call emitter (virtual method dispatch via jalr).
 */
public class RvCallIndirectEmitter implements InstructionEmitter<CallIndirect> {

    @Override
    public Class<CallIndirect> handles() {
        return CallIndirect.class;
    }

    @Override
    public void emit(CallIndirect instruction, CodeWriter out) {
        out.line("jalr ra, " + RvRegisters.of(instruction.getTargetRegister()) + ", 0");
    }
}
