package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.generate;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringConstant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.modules.AbstractBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.CSyntax;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CLoadAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CLoadEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.assingation.CMoveEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.functions.CCallEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.gotoFunc.CJumpEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.heap.CFramePopEmitter;
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
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CFramePushEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CIndexAddressEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stack.CLoadIndexedEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements.CBranchIfEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.statements.CReturnEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores.CStoreEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.stores.CStoreIndexedEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.ports.strings.CNewStringEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.EmitterRegistry;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Backend a C: cada instrucción del IR se convierte en una sentencia C.
 */
public class CBackend extends AbstractBackend {

    public CBackend(GenerationOptions options) {
        super(options, registry(), "  ");
    }

    /**
     * Principal method to register the classes
     *
     */
    private static EmitterRegistry registry() {
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
                .register(new CCallEmitter())
                .register(new CReturnEmitter())
                .register(new CFramePushEmitter())
                .register(new CFramePopEmitter())
                .register(new CFrameRebaseEmitter())
                .register(new CAdjustStackTopEmitter())
                .register(new CHeapAllocEmitter())
                .register(new CStringConcatEmitter())
                .register(new CNewStringEmitter())
                .register(new CConvertToStringEmitter());
    }

    @Override
    public Target target() {
        return Target.C;
    }

    @Override
    protected void emitProgramStart(IntermediateProgram program, CodeWriter out) {
        int stack = options.getStackSlots();
        int h = options.getHeapSlots();
        out.raw("#include <stdio.h>").raw("#include <stdlib.h>").raw("#include <string.h>").blank();
        out.raw("int sptr = " + options.getReservedSlots() + ";");
        out.raw("int hptr = 0;");
        out.raw("int fp = " + options.getReservedSlots() + ";");
        out.raw("int fpstack[" + stack + "];");
        out.raw("int fpsp = 0;").blank();
        for (String space : new String[]{"stack", "heap"}) {
            int size = space.equals("stack") ? stack : h;
            out.raw("int " + space + "integer[" + size + "];");
            out.raw("char* " + space + "string[" + size + "];");
            out.raw("float " + space + "float[" + size + "];").blank();
        }
        for (ValueType type : ValueType.values()) {
            String names = Stream.of("AX", "BX", "CX")
                    .map(r -> (type == ValueType.STRING ? "*" : "") + r + "_" + type.name())
                    .collect(Collectors.joining(", "));
            String base = type == ValueType.STRING ? "char " : CSyntax.cType(type) + " ";
            out.raw(base + names + ";");
        }
        out.blank();
        for (StringConstant constant : program.getStrings()) {
            out.raw("char* " + constant.getId() + " = \"" + CSyntax.escape(constant.getValue()) + "\";");
        }
        if (!program.getStrings().isEmpty()) out.blank();
        for (IntermediateFunction func : program.getFunctions()) out.raw("void " + func.getName() + "();");
        out.blank();
    }

    @Override
    protected void emitFunctionStart(IntermediateFunction function, CodeWriter out) {
        out.raw("void " + function.getName() + "() {");
    }

    @Override
    protected void emitFunctionEnd(IntermediateFunction function, CodeWriter out) {
        out.raw("}").blank();
    }

    @Override
    protected void emitProgramEnd(IntermediateProgram program, CodeWriter out) {
        if (!options.isEmitEntryPoint()) return;
        out.raw("int main() {");
        program.entryPoint().ifPresent(name -> out.line(name + "();"));
        out.line("return 0;");
        out.raw("}");
    }
}
