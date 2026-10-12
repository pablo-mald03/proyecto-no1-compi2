package com.pablocompany.proyecto.no1.compi2.codegen.domain.modules;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.TargetBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.EmitterRegistry;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;

/**
 * Principal class contest for the backend compilator
 *
 */
public abstract class AbstractBackend implements TargetBackend {
    protected final GenerationOptions options;
    private final EmitterRegistry registry;
    private final String indent;

    protected AbstractBackend(GenerationOptions options, EmitterRegistry registry, String indent) {
        this.options = options;
        this.registry = registry.verifyComplete();
        this.indent = indent;
    }

    /**
     * Principal method port for the code generation
     *
     */
    @Override
    public final String generate(IntermediateProgram program) {
        CodeWriter out = new CodeWriter(indent);
        emitProgramStart(program, out);
        for (IntermediateFunction function : program.getFunctions()) {
            emitFunctionStart(function, out);
            for (Instruction instruction : function.getBody()) registry.emit(instruction, out);
            emitFunctionEnd(function, out);
        }
        emitProgramEnd(program, out);
        return out.toString();
    }

    protected abstract void emitProgramStart(IntermediateProgram program, CodeWriter out);

    protected abstract void emitFunctionStart(IntermediateFunction function, CodeWriter out);

    protected abstract void emitFunctionEnd(IntermediateFunction function, CodeWriter out);

    protected abstract void emitProgramEnd(IntermediateProgram program, CodeWriter out);
}
