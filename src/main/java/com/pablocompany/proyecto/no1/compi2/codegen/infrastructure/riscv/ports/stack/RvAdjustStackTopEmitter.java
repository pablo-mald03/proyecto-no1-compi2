package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal stack top emmiter class
 *
 */
public class RvAdjustStackTopEmitter implements InstructionEmitter<AdjustStackTop> {
    private static int currentWindow = 200;

    public static void setCurrentWindow(int window) {
        currentWindow = window;
    }

    public static int getCurrentWindow() {
        return currentWindow;
    }

    public static void reset() {
        currentWindow = 200;
    }

    @Override
    public Class<AdjustStackTop> handles() {
        return AdjustStackTop.class;
    }

    @Override
    public void emit(AdjustStackTop instruction, CodeWriter out) {
        int delta = instruction.getDelta();
        if (delta == 200) {
            delta = currentWindow;
        } else if (delta <= -200) {
            int n = -delta - 200;
            delta = -(currentWindow + n);
        }
        RvMemory.addSlots(out, RvRegisters.STACK_TOP, RvRegisters.STACK_TOP, delta, RvRegisters.SCRATCH);
    }
}
