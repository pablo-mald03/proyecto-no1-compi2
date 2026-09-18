package com.pablocompany.proyecto.no1.compi2.common.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;
import lombok.Data;

/**
 * Principal class to hold the temporary state of a single compilation run.
 */
@Data
public class CompilationContext {

    private DependencyGraph dependencyGraph;
    private GlobalSymbolTable symbolTable;

}