package com.pablocompany.proyecto.no1.compi2.common.domain.checker;

import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import lombok.Getter;

import java.util.Objects;

/**
 * Principal type representation class
 *
 */
@Getter
public class Type {
    private final TypeKind kind;
    private final String customName;
    private final Type elementType;
    private final int dimensions;

    private Type(TypeKind kind, String customName, Type elementType, int dimensions) {
        this.kind = kind;
        this.customName = customName;
        this.elementType = elementType;
        this.dimensions = dimensions;
    }

    // ============================================================
    // Factory methods
    // ============================================================

    public static Type intType() {
        return new Type(TypeKind.INT, null, null, 0);
    }

    public static Type floatType() {
        return new Type(TypeKind.FLOAT, null, null, 0);
    }

    public static Type stringType() {
        return new Type(TypeKind.STRING, null, null, 0);
    }

    public static Type charType() {
        return new Type(TypeKind.CHAR, null, null, 0);
    }

    public static Type booleanType() {
        return new Type(TypeKind.BOOLEAN, null, null, 0);
    }

    public static Type voidType() {
        return new Type(TypeKind.VOID, null, null, 0);
    }

    public static Type customType(String name) {
        return new Type(TypeKind.CUSTOM, name, null, 0);
    }

    public static Type arrayType(Type elementType) {
        return new Type(TypeKind.ARRAY, null, elementType, 1);
    }

    public static Type arrayType(Type elementType, int dimensions) {
        return new Type(TypeKind.ARRAY, null, elementType, dimensions);
    }

    public static Type unknown() {
        return new Type(TypeKind.UNKNOWN, null, null, 0);
    }

    // ============================================================
    // Predicates
    // ============================================================

    public boolean isPrimitive() {
        return kind == TypeKind.INT
                || kind == TypeKind.FLOAT
                || kind == TypeKind.STRING
                || kind == TypeKind.CHAR
                || kind == TypeKind.BOOLEAN;
    }

    public boolean isArray() {
        return kind == TypeKind.ARRAY;
    }

    public boolean isCustom() {
        return kind == TypeKind.CUSTOM;
    }

    public boolean isNumeric() {
        return kind == TypeKind.INT || kind == TypeKind.FLOAT;
    }

    public boolean isVoid() {
        return kind == TypeKind.VOID;
    }

    public boolean isUnknown() {
        return kind == TypeKind.UNKNOWN;
    }

    // ============================================================
    // Compatibility
    // ============================================================

    /**
     * Strict equality of types.
     */
    public boolean isCompatibleWith(Type other) {
        if (other == null) return false;
        if (this.kind == TypeKind.UNKNOWN || other.kind == TypeKind.UNKNOWN) {
            return true;
        }
        if (this.kind != other.kind) return false;

        switch (kind) {
            case CUSTOM:
                return Objects.equals(this.customName, other.customName);
            case ARRAY:
                if (this.dimensions != other.dimensions) return false;
                return this.elementType == null
                        ? other.elementType == null
                        : this.elementType.isCompatibleWith(other.elementType);
            default:
                return true;
        }
    }

    /**
     * Assignability check. For now, same as compatibility.
     */
    public boolean isAssignableTo(Type other) {
        if (other == null) return false;
        if (this.kind == TypeKind.UNKNOWN || other.kind == TypeKind.UNKNOWN) {
            return true;
        }

        if (this.equals(other)) return true;

        if (this.kind == TypeKind.INT && other.kind == TypeKind.FLOAT) {
            return true;
        }

        if (this.kind == TypeKind.CHAR && other.kind == TypeKind.INT) {
            return true;
        }

        if (this.kind == TypeKind.BOOLEAN && other.kind == TypeKind.INT) {
            return true;
        }

        if (this.kind == TypeKind.ARRAY && other.kind == TypeKind.ARRAY) {
            if (this.dimensions != other.dimensions) return false;
            if (this.elementType == null || other.elementType == null) return this.elementType == other.elementType;
            return this.elementType.isAssignableTo(other.elementType);
        }

        return false;
    }

    // ============================================================
    // equals / hashCode / toString
    // ============================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type other)) return false;
        if (this.kind != other.kind) return false;
        if (!Objects.equals(this.customName, other.customName)) return false;
        if (this.dimensions != other.dimensions) return false;
        if (this.elementType == null && other.elementType == null) return true;
        if (this.elementType == null || other.elementType == null) return false;
        return this.elementType.equals(other.elementType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, customName, elementType, dimensions);
    }

    @Override
    public String toString() {
        switch (kind) {
            case ARRAY:
                return (elementType == null ? "?" : elementType.toString())
                        + "[]".repeat(dimensions);
            case CUSTOM:
                return customName == null ? "custom?" : customName;
            default:
                return kind.name().toLowerCase();
        }
    }
}