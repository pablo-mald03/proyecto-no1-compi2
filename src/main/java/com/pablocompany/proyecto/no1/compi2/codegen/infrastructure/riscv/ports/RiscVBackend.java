package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.LoadAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Frame;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringConstant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.port.AbstractBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.RiscVRuntime;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvMemory;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.models.RvRegisters;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.arrays.RvIndexAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.arrays.RvStoreIndexedEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.brands.RvLoadLabelAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.brands.RvMarkLabelEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions.RvCallEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions.RvCallIndirectEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.functions.RvReturnEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap.RvFramePopEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap.RvFramePushEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.heap.RvHeapAllocEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.io.RvPrintEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.io.RvReadEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations.RvBinaryOperationEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations.RvConvertEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations.RvMoveEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.operations.RvUnaryOperationEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.stack.*;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.statements.RvBranchIfEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.statements.RvJumpEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings.RvConvertToStringEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings.RvNewStringEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.strings.RvStringConcatEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.EmitterRegistry;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.StringEscapeUtil;

/**
 * Principal backend port code generation for Risc V class
 *
 */
public class RiscVBackend extends AbstractBackend {


    public RiscVBackend(GenerationOptions options) {
        super(options, registry(), "  ");
    }

    /**
     * Principal method registry module
     */
    private static EmitterRegistry registry() {
        return new EmitterRegistry("RISC-V")
                .register(new RvMoveEmitter())
                .register(new RvLoadAddressEmitter())
                .register(new RvLoadEmitter())
                .register(new RvStoreEmitter())
                .register(new RvLoadIndexedEmitter())
                .register(new RvStoreIndexedEmitter())
                .register(new RvIndexAddressEmitter())
                .register(new RvBinaryOperationEmitter())
                .register(new RvUnaryOperationEmitter())
                .register(new RvJumpEmitter())
                .register(new RvBranchIfEmitter())
                .register(new RvMarkLabelEmitter())
                .register(new RvPrintEmitter())
                .register(new RvReadEmitter())
                .register(new RvCallEmitter())
                .register(new RvReturnEmitter())
                .register(new RvFramePushEmitter())
                .register(new RvFramePopEmitter())
                .register(new RvFrameRebaseEmitter())
                .register(new RvAdjustStackTopEmitter())
                .register(new RvHeapAllocEmitter())
                .register(new RvStringConcatEmitter())
                .register(new RvNewStringEmitter())
                .register(new RvConvertToStringEmitter())
                .register(new RvConvertEmitter())
                .register(new RvCallIndirectEmitter())
                .register(new RvLoadLabelAddressEmitter());
    }

    /**
     * Method to get the target
     *
     */
    @Override
    public Target target() {
        return Target.RISCV;
    }

    /**
     * Method to emit the program startup
     *
     */
    @Override
    protected void emitProgramStart(IntermediateProgram program, CodeWriter out) {
        out.raw("# RISC-V RV32IMF para RARS  |  s0=fp  s1=sptr  s2=hptr  s3=hlimit  |  celda = 4 bytes");
        out.raw(".data");
        for (StringConstant constant : program.getStrings()) {
            out.raw(constant.getId() + ": .asciz \"" + escape(constant.getValue()) + "\"");
        }
        out.raw("__rt_msg_oom: .asciz \"Error: heap agotado\\n\"");
        for (VTableDefinition vt : program.getVtables()) {
            out.raw(".align 2");
            out.raw(vt.getName() + ":");
            for (String entry : vt.getEntries()) {
                out.line(".word " + entry);
            }
        }
        out.raw("__rt_fbuf: .space 64");
        out.raw(".align 2");
        out.raw("heap_mem: .space " + ((long) options.getHeapSlots() * RvMemory.CELL));
        out.raw("heap_end:");
        out.raw("stack_mem: .space " + ((long) options.getStackSlots() * RvMemory.CELL));
        out.blank();
        out.raw(".text");
        if (options.isEmitEntryPoint()) {
            out.raw(".globl __start");
            out.raw("__start:");

            out.line("la " + RvRegisters.STACK_TOP + ", stack_mem");
            RvMemory.addSlots(out, RvRegisters.STACK_TOP, RvRegisters.STACK_TOP, options.getReservedSlots(), RvRegisters.SCRATCH);
            out.line("mv " + RvRegisters.FP + ", " + RvRegisters.STACK_TOP);
            out.line("la " + RvRegisters.HEAP_TOP + ", heap_mem");
            out.line("la " + RvRegisters.HEAP_LIMIT + ", heap_end");

            program.entryPoint().ifPresent(name -> out.line("jal ra, " + name));
            out.line("li a7, 10");
            out.line("ecall");
            out.blank();
        }
    }

    public static final java.util.List<String> ANOMALIES = new java.util.ArrayList<>();

    /**
     * Method to emit the funciton start
     *
     */
    @Override
    protected void emitFunctionStart(IntermediateFunction function, CodeWriter out) {
        int maxInstructionOffset = calculateMaxFrameOffset(function);
        int frameSlots = function.getFrameSlots();
        if (frameSlots > 0 && frameSlots < maxInstructionOffset) {
            ANOMALIES.add(function.getName() + ": frameSlots=" + frameSlots + " < maxInstructionOffset=" + maxInstructionOffset);
        }
        int m = Math.max(frameSlots, maxInstructionOffset);
        int w = Math.max(200, m + 1);
        RvAdjustStackTopEmitter.setCurrentWindow(w);

        out.raw(function.getName() + ":");
        out.line("addi sp, sp, -4");
        out.line("sw ra, 0(sp)");
    }

    /**
     * Method to emit the function end
     *
     */
    @Override
    protected void emitFunctionEnd(IntermediateFunction function, CodeWriter out) {
        RvAdjustStackTopEmitter.reset();
        out.blank();
    }

    private static int calculateMaxFrameOffset(IntermediateFunction function) {
        int max = 0;
        if (function.getBody() == null) return 0;
        for (Instruction inst : function.getBody()) {
            int off = extractFrameOffset(inst);
            if (off > max) max = off;
        }
        return max;
    }

    private static int extractFrameOffset(Instruction inst) {
        if (inst instanceof Load load && load.getAddress() instanceof Frame f) {
            return f.getOffset();
        }
        if (inst instanceof Store store && store.getAddress() instanceof Frame f) {
            return f.getOffset();
        }
        if (inst instanceof LoadAddress la && la.getAddress() instanceof Frame f) {
            return f.getOffset();
        }
        if (inst instanceof LoadIndexed li && li.getBase() instanceof Frame f) {
            return f.getOffset();
        }
        if (inst instanceof StoreIndexed si && si.getBase() instanceof Frame f) {
            return f.getOffset();
        }
        if (inst instanceof Read read && read.getTarget() instanceof Frame f) {
            return f.getOffset();
        }
        return 0;
    }

    /**
     * Method to emit the program end
     *
     */
    @Override
    protected void emitProgramEnd(IntermediateProgram program, CodeWriter out) {
        RiscVRuntime.emit(out);
    }

    /**
     * Method to escape the action
     *
     */
    private static String escape(String string) {
        return StringEscapeUtil.escape(string);
    }
}
