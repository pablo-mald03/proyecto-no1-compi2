package com.pablocompany.proyecto.no1.compi2.common.domain.resolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.ReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.ReferenceResolverFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Principal class for the reference resolution pass over all files in topological order.
 */
public class ReferenceResolverOrchestrator {

    private final DependencyGraph dependencyGraph;

    public ReferenceResolverOrchestrator(DependencyGraph dependencyGraph) {
        this.dependencyGraph = dependencyGraph;
    }

    /**
     * Principal gateway to resolve all files
     *
     */
    public void resolveAll(Map<String, EditorContext> allContexts, List<String> topologicalOrder, GlobalSymbolTable table) {
        Set<String> processed = new HashSet<>();

        for (String filePath : topologicalOrder) {
            resolveOne(filePath, allContexts, table);
            processed.add(filePath);
        }

        for (String filePath : allContexts.keySet()) {
            if (!processed.contains(filePath)) {
                resolveOne(filePath, allContexts, table);
            }
        }
    }

    /**
     * Helper to resolve one file
     *
     */
    private void resolveOne(String filePath, Map<String, EditorContext> allContexts, GlobalSymbolTable table) {
        EditorContext context = allContexts.get(filePath);
        if (context == null) return;

        String extension = context.getFileExtension();
        if (extension == null) return;

        ReferenceResolver resolver = ReferenceResolverFactory.create(extension);
        if (resolver == null) return;

        resolver.resolve(context, table);
    }

}