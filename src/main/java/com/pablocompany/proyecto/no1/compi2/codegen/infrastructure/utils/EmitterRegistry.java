package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.InstructionEmitter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Code dispatcher class
 *
 */
public class EmitterRegistry {
    private final String backendName;
    private final Map<Class<? extends Instruction>, InstructionEmitter<?>> emitters = new LinkedHashMap<>();

    public EmitterRegistry(String backendName) {
        this.backendName = backendName;
    }

    /**
     * Register method for code
     *
     */
    public EmitterRegistry register(InstructionEmitter<?> emitter) {
        if (emitters.put(emitter.handles(), emitter) != null) {
            throw new IllegalStateException(backendName + ": emisor duplicado para " + emitter.handles().getSimpleName());
        }
        return this;
    }

    /**
     * Method to emit the code
     *
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void emit(Instruction instruction, CodeWriter out) {
        InstructionEmitter emitter = emitters.get(instruction.getClass());
        if (emitter == null) {
            throw new IllegalStateException(backendName + ": sin emisor para " + instruction.getClass().getSimpleName());
        }
        emitter.emit(instruction, out);
    }

    /**
     * Method to verification if the code generation was succeeded.
     */
    public EmitterRegistry verifyComplete() {
        Set<Class<?>> missing = new LinkedHashSet<>(Arrays.asList(Instruction.class.getPermittedSubclasses()));
        missing.removeAll(emitters.keySet());
        if (!missing.isEmpty()) {
            throw new IllegalStateException(backendName + " no implementa: "
                    + missing.stream().map(Class::getSimpleName).collect(Collectors.joining(", ")));
        }
        return this;
    }
}
