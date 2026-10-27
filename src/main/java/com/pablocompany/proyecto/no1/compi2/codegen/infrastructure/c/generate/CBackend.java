package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.generate;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallSites;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringConstant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.port.AbstractBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CLoadAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CLoadEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CMoveEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions.CCallEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.gotoFunc.CJumpEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap.CFramePopEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap.CFramePushEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap.CFrameRebaseEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap.CHeapAllocEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.io.CPrintEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.io.CReadEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.labels.CMarkLabelEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations.CBinaryOperationEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations.CStringConcatEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.operations.CUnaryOperationEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.parses.CConvertToStringEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CAdjustStackTopEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CIndexAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CLoadIndexedEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements.CBranchIfEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements.CReturnEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores.CStoreEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores.CStoreIndexedEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.convertions.CConvertEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.strings.CNewStringEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.EmitterRegistry;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Principal backend for the compiler to translate the high level code to the C code
 */
public class CBackend extends AbstractBackend {

    private final CallSites sites;

    public CBackend(GenerationOptions options) {
        this(options, new CallSites());
    }

    private CBackend(GenerationOptions o, CallSites sites) {
        super(o, registry(sites), "  ");
        this.sites = sites;
    }

    private static EmitterRegistry registry(CallSites callSites) {
        return new EmitterRegistry("C")
                .register(new CMoveEmitter())
                .register(new CLoadAddressEmitter())
                .register(new CLoadEmitter())
                .register(new CStoreEmitter())
                .register(new CLoadIndexedEmitter())
                .register(new CStoreIndexedEmitter())
                .register(new CIndexAddressEmitter())
                .register(new CBinaryOperationEmitter())
                .register(new CUnaryOperationEmitter())
                .register(new CJumpEmitter())
                .register(new CBranchIfEmitter())
                .register(new CMarkLabelEmitter())
                .register(new CPrintEmitter())
                .register(new CReadEmitter())
                .register(new CCallEmitter(callSites))
                .register(new CReturnEmitter())
                .register(new CFramePushEmitter())
                .register(new CFramePopEmitter())
                .register(new CFrameRebaseEmitter())
                .register(new CAdjustStackTopEmitter())
                .register(new CHeapAllocEmitter())
                .register(new CStringConcatEmitter())
                .register(new CNewStringEmitter())
                .register(new CConvertToStringEmitter())
                .register(new CConvertEmitter())
                .register(new com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions.CCallIndirectEmitter(callSites))
                .register(new com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.labels.CLoadLabelAddressEmitter());
    }

    @Override
    public Target target() {
        return Target.C;
    }

    @Override
    protected void emitProgramStart(IntermediateProgram program, CodeWriter out) {
        sites.reset();
        int stack = options.getStackSlots();
        int h = options.getHeapSlots();
        out.raw("#include <stdio.h>").raw("#include <stdlib.h>").raw("#include <string.h>").blank();
        out.raw("int sptr = " + options.getReservedSlots() + ";");
        out.raw("int hptr = 0;");
        out.raw("int fp = " + options.getReservedSlots() + ";");
        out.raw("int fpstack[" + stack + "];");
        out.raw("int fpsp = 0;");
        out.raw("int rastack[" + stack + "];");
        out.raw("int rasp = 0;");
        out.raw("int ra;");
        out.raw("int addr;");
        out.raw("int n1, n2;");
        out.raw("char* tp;").blank();
        for (String space : new String[]{"stack", "heap"}) {
            int size = space.equals("stack") ? stack : h;
            out.raw("long " + space + "integer[" + size + "];");
            out.raw("char* " + space + "string[" + size + "];");
            out.raw("float " + space + "float[" + size + "];").blank();
        }
        for (ValueType type : ValueType.values()) {
            String names = Stream.of("AX", "BX", "CX")
                    .map(r -> (type == ValueType.STRING ? "*" : "") + r + "_" + type.name())
                    .collect(Collectors.joining(", "));
            String base = type == ValueType.STRING ? "char " : (type == ValueType.INT || type == ValueType.BOOLEAN ? "long " : CSyntax.cType(type) + " ");
            out.raw(base + names + ";");
        }
        out.blank();
        for (StringConstant constant : program.getStrings()) {
            out.raw("char* " + constant.getId() + " = \"" + CSyntax.escape(constant.getValue()) + "\";");
        }
        if (!program.getStrings().isEmpty()) out.blank();

        int vtableOffset = 0;
        for (com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition vt : program.getVtables()) {
            out.raw("int " + vt.getName() + " = " + vtableOffset + ";");
            vtableOffset += vt.getEntries().size();
        }
        if (!program.getVtables().isEmpty()) out.blank();

        out.raw("int main() {");
        int vtOffset = 0;
        for (com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition vt : program.getVtables()) {
            for (String entry : vt.getEntries()) {
                out.line("heapinteger[" + vtOffset + "] = (long)&&" + entry + ";");
                vtOffset++;
            }
        }
        if (vtOffset > 0) {
            out.line("hptr = " + vtOffset + ";");
        }
        out.line("rastack[rasp] = 0;");
        out.line("rasp = rasp + 1;");
        out.line("goto " + program.entryPoint().orElse("halt") + ";");
        out.blank();
    }

    @Override
    protected void emitFunctionStart(IntermediateFunction function, CodeWriter out) {
        out.raw(function.getName() + ":;");
    }

    @Override
    protected void emitFunctionEnd(IntermediateFunction function, CodeWriter out) {
        out.blank();
    }

    @Override
    protected void emitProgramEnd(IntermediateProgram program, CodeWriter out) {
        out.raw("dispatch:;");
        out.line("if (ra == 0) goto halt;");
        for (int id = 1; id <= sites.total(); id++) {
            out.line("if (ra == " + id + ") goto ret_" + id + ";");
        }
        out.raw("halt:;");
        out.line("return 0;");
        out.raw("}");
    }
}