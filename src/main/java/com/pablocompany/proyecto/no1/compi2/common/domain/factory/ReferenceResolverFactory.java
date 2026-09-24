package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.ReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.resolver.YReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.resolver.ZReferenceResolver;

/**
 * Factory for the third phase of compiler
 *
 */
public class ReferenceResolverFactory {

    /**
     * Principal create reference resolver method
     *
     */
    public static ReferenceResolver create(String extension) {
        if (extension == null) return null;
        return switch (extension) {
            case ".y" -> new YReferenceResolver();
            case ".z" -> new ZReferenceResolver();
            /*  case ".pig" -> new PigLatinReferenceResolver();*/
            default -> null;
        };
    }
}