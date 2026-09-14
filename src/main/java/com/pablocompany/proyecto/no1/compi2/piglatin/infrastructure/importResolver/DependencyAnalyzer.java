package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.importResolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic.DependencyGraphBuilder;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic.DependencyGraphBuilderFactory;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Orchestrates the import/dependency analysis pass.
 * Only .pig files declare imports in this project.
 */
public class DependencyAnalyzer {

    /**
     * Principal method to analyze the .pig file
     *
     */
    public DependencyGraph analyze(Map<String, EditorContext> allContexts) {
        List<EditorContext> pigFiles = new ArrayList<>();
        for (EditorContext context : allContexts.values()) {
            if (".pig".equals(context.getFileExtension())) {
                pigFiles.add(context);
            }
        }

        DependencyGraphBuilder builder = DependencyGraphBuilderFactory.create(".pig");
        if (builder == null) {
            return new DependencyGraph();
        }

        return builder.build(pigFiles, allContexts);
    }

}