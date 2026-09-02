package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers;

import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.TokenStyleProvider;

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

        switch (extension.toLowerCase()) {
            case ".z":
                return new TokenZettaradianStyleResolver();
            case ".pig":
                return new TokenPigLatinStyleResolver();
            case ".y":
                return new TokenYStyleResolver();
            default:
                return null;
        }
    }
}
