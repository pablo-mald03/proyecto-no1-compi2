package com.pablocompany.proyecto.no1.compi2.codegen.domain.enums;

import lombok.Getter;

/**
 * Value type representation enum
 *
 */
@Getter
public enum ValueType {
    INT("int", Storage.WORD),
    FLOAT("float", Storage.FLOAT),
    CHAR("char", Storage.WORD),
    BOOLEAN("boolean", Storage.WORD),
    STRING("string", Storage.POINTER);

    private final String suffix;
    private final Storage storage;

    ValueType(String suffix, Storage storage) {
        this.suffix = suffix;
        this.storage = storage;
    }

    /**
     * Helper to know the type
     *
     */
    public boolean isFloat() {
        return this == FLOAT;
    }

    /**
     * Helper method to evaluate from suffix
     *
     */
    public ValueType fromSuffix(String suffix) {
        for (ValueType t : values()) if (t.suffix.equals(suffix)) return t;
        throw new IllegalArgumentException("Tipo desconocido: " + suffix);
    }
}
