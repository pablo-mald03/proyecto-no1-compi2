package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.convertion.Convert;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * RISC-V emitter for the Convert instruction.
 * Handles numeric type coercions between integer and floating-point registers:
 *   INT  → FLOAT : fcvt.s.w  (convert signed word to single-precision float)
 *   FLOAT → INT  : fcvt.w.s rtz (convert single-precision float to signed word, truncate toward zero)
 */
public class RvConvertEmitter implements InstructionEmitter<Convert> {

    @Override
    public Class<Convert> handles() {
        return Convert.class;
    }

    @Override
    public void emit(Convert instruction, CodeWriter out) {
        String src  = RvRegisters.of(instruction.getSource());
        String dst  = RvRegisters.of(instruction.getDestination());
        ValueType target = instruction.getTarget();

        if (target == ValueType.FLOAT) {
            // integer register → float register
            out.line("fcvt.s.w " + dst + ", " + src);
        } else {
            // float register → integer register (truncate toward zero)
            out.line("fcvt.w.s " + dst + ", " + src + ", rtz");
        }
    }
}
