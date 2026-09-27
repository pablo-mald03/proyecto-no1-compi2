package com.pablocompany.proyecto.no1.compi2.common.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Principal class to hold the temporary state of a single compilation run.
 */
@Data
public class CompilationContext {

    private DependencyGraph dependencyGraph;
    private GlobalSymbolTable symbolTable;
    private Map<AstNode, Type> typeAnnotations;


    public CompilationContext() {
        this.typeAnnotations = new HashMap<>();
    }

}