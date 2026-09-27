package com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic;

import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.importResolver.PigDependencyGraphBuilder;

/**
 * Principal factory for graph builder
 *
 */
public class DependencyGraphBuilderFactory {
    public static DependencyGraphBuilder create(String extension) {
        switch (extension) {
            case ".pig":
                return new PigDependencyGraphBuilder();
            default:
                return null;
        }
    }
}
