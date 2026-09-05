package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.lexical.style.TokenPigLatinStyleResolver;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.lexical.style.TokenYStyleResolver;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.lexical.style.TokenZettaradianStyleResolver;

/**
 *
 * @author pablo03
 */
//This class provides the color for the tokens
public class TokenStyleResolverFactory {
    /**
     * Create the appropriate syntax color highlight based on file extension
     */
    public static TokenStyleProvider createProvider(String extension) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }

        return switch (extension.toLowerCase()) {
            case ".z" -> new TokenZettaradianStyleResolver();
            case ".pig" -> new TokenPigLatinStyleResolver();
            case ".y" -> new TokenYStyleResolver();
            default -> null;
        };
    }
}
