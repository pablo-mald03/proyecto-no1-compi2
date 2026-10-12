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
        String sig = String.join("_", s.getParameterTypes());
        return sanitize(s.getQualifiedName()) + "_" + fileTag(s.getFilePath()) + "_" + sanitize(sig);
    }

    /**
     * Principal Method to sanitize a string by replacing invalid characters with underscores and appending a hash if necessary
     */
    private static String sanitize(String input) {
        if (input == null) {
            return "";
        }
        return input.replaceAll("[^A-Za-z0-9_]", "_");
//        return cleaned + "_" + Integer.toHexString(input.hashCode());
    }

    /**
     * Principal Method to extract and sanitize a file tag from the file path
     */
    private static String fileTag(String filePath) {
        String path = filePath == null ? "" : filePath;
        String base = path.substring(Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\')) + 1);
        int dot = base.lastIndexOf('.');
        if (dot > 0) base = base.substring(0, dot);
        return base.replaceAll("[^A-Za-z0-9_]", "_") + Integer.toHexString(path.hashCode());
    }
}