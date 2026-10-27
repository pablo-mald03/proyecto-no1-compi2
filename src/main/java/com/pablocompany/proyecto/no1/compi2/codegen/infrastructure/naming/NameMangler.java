package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.naming;

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
        String params = s.getParameterTypes() == null || s.getParameterTypes().isEmpty()
                ? "void"
                : String.join("_", s.getParameterTypes());
        String unique = Integer.toHexString(
                (s.getFilePath() + "#" + s.getSignatureKey()).hashCode());
        return sanitize(base) + "_" + sanitize(params) + "_" + unique;
    }

    /**
     * Principal Method to generate a unique, deterministic code label for symbols.
     */
    public static String codeLabel(Symbol s) {
        if (s == null) return "unknown";
        String declaring = s.getDeclaringClass() != null && !s.getDeclaringClass().isBlank()
                ? s.getDeclaringClass()
                : (s.getQualifiedName() != null && !s.getQualifiedName().isBlank() ? s.getQualifiedName() : "");

        String name = s.getName() != null ? s.getName() : "anon";
        if (s.getKind() == com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind.CONSTRUCTOR
                || "constructor".equalsIgnoreCase(name)
                || name.equals(declaring)) {
            name = "__init__";
        }

        String params = s.getParameterTypes() == null || s.getParameterTypes().isEmpty()
                ? "void"
                : String.join("_", s.getParameterTypes());

        String label = (declaring.isEmpty() ? "" : sanitize(declaring) + "_")
                + sanitize(name) + "_" + sanitize(params);
        s.setCodeLabel(label);
        return label;
    }

    /**
     * Principal method to resolve the target function label for a call, taking into account whether
     */
    public static String resolveCallLabel(Symbol s) {
        if (s == null) return "unknown";
        if (s.getCodeLabel() != null && !s.getCodeLabel().isBlank()) {
            return s.getCodeLabel();
        }
        if (s.getKind() == com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind.FUNCTION) {
            return functionName(s);
        }
        return codeLabel(s);
    }

    /**
     * Principal Method to sanitize a string by replacing invalid characters with underscores and appending a hash if necessary
     */
    public static String sanitize(String text) {
        if (text == null) return "";
        return text.replace("[]", "_arr").replaceAll("[^A-Za-z0-9_]", "_");
    }
}