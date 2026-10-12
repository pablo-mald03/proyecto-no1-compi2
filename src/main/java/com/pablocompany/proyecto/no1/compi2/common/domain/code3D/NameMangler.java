package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;

/**
 * Principal utility class for mangling function and symbol names to ensure uniqueness
 */
public class NameMangler {
    private NameMangler() {
    }

    /**
     * Principal Method to generate a mangled function name incorporating signature and file tags
     */
    public static String functionName(Symbol s) {
        String base = (s.getQualifiedName() != null && !s.getQualifiedName().isBlank())
                ? s.getQualifiedName() : s.getName();
        String params = String.join("_", s.getParameterTypes());
        String unique = Integer.toHexString((s.getFilePath() + "#" + s.getSignatureKey()).hashCode());
        return sanitize(base) + "_" + sanitize(params) + "_" + unique;
    }

    /**
     * Principal Method to sanitize a string by replacing invalid characters with underscores and appending a hash if necessary
     */
    private static String sanitize(String text) {
        return text.replaceAll("[^A-Za-z0-9_]", "_");
    }
}