package com.pablocompany.proyecto.no1.compi2.common.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.builder.PigAstBuilder;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.builder.YAstBuilder;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.builder.ZettarianAstBuilder;
import lombok.NoArgsConstructor;

/**
 * Factory for AST builders
 *
 */
@NoArgsConstructor
public class AstBuilderFactory {

    /**
     * Get the appropriate AST builder for a file extension
     */
    public static AstBuilder getBuilder(String extension) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }

        return switch (extension.toLowerCase()) {
            case ".y" -> new YAstBuilder();
            case ".z" -> new ZettarianAstBuilder();
            case ".pig" -> new PigAstBuilder();
            default -> null;
        };
    }

    /**
     * Check if an extension is supported by any AST builder
     */
    public static boolean isSupported(String extension) {
        if (extension == null || extension.isEmpty()) {
            return false;
        }

        return switch (extension.toLowerCase()) {
            case ".y", ".z", ".pig" -> true;
            default -> false;
        };
    }
}
