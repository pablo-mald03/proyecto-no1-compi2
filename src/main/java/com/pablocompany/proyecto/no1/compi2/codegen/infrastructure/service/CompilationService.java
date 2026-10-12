package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.compilation.CompilationArtifact;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.factory.BackendFactory;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.TargetBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;

import java.util.List;

/**
 * Principal compilation service for the different types of machine code
 *
 */
public class CompilationService {

    private final BackendFactory factory;

    public CompilationService(BackendFactory factory) {
        this.factory = factory;
    }

    /**
     * Method to generate the code
     *
     */
    public CompilationArtifact generate(IntermediateProgram program, Target target, GenerationOptions options) {
        TargetBackend backend = factory.create(target, options);
        String code = backend.generate(program);
        return new CompilationArtifact(target, fileNameFor(target), code);
    }

    /**
     * Alternance to generate all types of code
     *
     */
    public List<CompilationArtifact> generateAll(IntermediateProgram program, GenerationOptions options) {
        return List.of(
                generate(program, Target.C, options),
                generate(program, Target.RISCV, options)
        );
    }

    /**
     * Helper method
     *
     */
    private static String fileNameFor(Target target) {
        return switch (target) {
            case C -> "main.c";
            case RISCV -> "main.s";
        };
    }
}