package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.importResolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic.DependencyGraphBuilder;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic.DependencyGraphBuilderFactory;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;

import java.util.List;

public class DependencyAnalyzer {
    public DependencyGraph analyze(List<EditorContext> allFiles) {
        List<EditorContext> pigFiles = filterByExtension(allFiles, ".pig");
        DependencyGraphBuilder builder =
                DependencyGraphBuilderFactory.create(".pig");
        return builder.build(pigFiles, workspaceLookup);
    }
}
