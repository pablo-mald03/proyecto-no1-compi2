package com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;

import java.util.List;
import java.util.Map;

/**
 * Principal dependency graph builder representation
 *
 */
public interface DependencyGraphBuilder {
    /**
     * The built dependency graph with errors accumulated
     */
    DependencyGraph build(List<EditorContext> pigFiles, Map<String, EditorContext> allContexts);
}
