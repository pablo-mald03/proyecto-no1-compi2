package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports;

/**
 * Represents the type of imported file. Used by the dependency graph
 * to know how to resolve each import without re-parsing the path.
 *
 */
public enum ImportType {

    Y_LANGUAGE(".y"),
    Z_LANGUAGE(".z"),
    PIG_LANGUAGE(".pig");

    private final String extension;

    ImportType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    //Resolves an ImportType from a file extension (ej. ".y")
    //Returns null if the extension is not supported
    public static ImportType fromExtension(String extension) {
        if (extension == null || extension.isEmpty()) return null;
        return switch (extension.toLowerCase()) {
            case ".y" -> Y_LANGUAGE;
            case ".z" -> Z_LANGUAGE;
            case ".pig" -> PIG_LANGUAGE;
            default -> null;
        };
    }
}