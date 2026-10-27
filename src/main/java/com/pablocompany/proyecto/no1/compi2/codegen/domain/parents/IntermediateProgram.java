package com.pablocompany.proyecto.no1.compi2.codegen.domain.parents;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringConstant;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

/**
 * Programa completo; independiente del lenguaje destino.
 */
@Getter
public class IntermediateProgram {

    String sourceName;
    List<StringConstant> strings;
    List<IntermediateFunction> functions;
    List<com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition> vtables;

    public IntermediateProgram(String sourceName, List<StringConstant> strings, List<IntermediateFunction> functions) {
        this(sourceName, strings, functions, List.of());
    }

    public IntermediateProgram(String sourceName, List<StringConstant> strings, List<IntermediateFunction> functions,
                               List<com.pablocompany.proyecto.no1.compi2.codegen.domain.models.VTableDefinition> vtables) {
        this.sourceName = sourceName;
        this.strings = List.copyOf(strings);
        this.functions = List.copyOf(functions);
        this.vtables = vtables != null ? List.copyOf(vtables) : List.of();
    }

    /**
     * Fistr function to initialize the code
     */
    public Optional<String> entryPoint() {
        return functions.stream()
                .map(IntermediateFunction::getName)
                .filter(n -> n.equals("main") || n.startsWith("main_"))
                .findFirst();
    }
}