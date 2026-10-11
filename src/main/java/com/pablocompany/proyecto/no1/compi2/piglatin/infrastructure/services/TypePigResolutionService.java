package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;

/**
 * Principal service pig resolver helper
 *
 */
public class TypePigResolutionService {

    /**
     * Validates the logic type
     */
    public String resolveTypeName(TypeNodePigLatin typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    /**
     * validate if is custom
     *
     */
    public boolean isCustom(TypeNodePigLatin typeNode) {
        return typeNode != null && typeNode.getDataType() == DataType.CUSTOM;
    }

    /**
     * Method to validate if is Builtin
     *
     */
    public boolean isBuiltin(TypeNodePigLatin typeNode) {
        return typeNode != null
                && typeNode.getDataType() != null
                && typeNode.getDataType() != DataType.CUSTOM;
    }

    /**
     * Maps a TypeNodePigLatin to a semantic Type.
     */
    public Type mapTypeNode(TypeNodePigLatin typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    /**
     * Method to maps a DataType enum + customName to a semantic Type.
     */
    public Type mapDataType(DataType dt, String customName) {
        if (dt == null) return Type.unknown();
        return switch (dt) {
            case INT -> Type.intType();
            case DECIMAL -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case NULL -> Type.nullType();
            case CUSTOM -> "String".equals(customName)
                    ? Type.stringType()
                    : Type.customType(customName);
            default -> Type.unknown();
        };
    }


    /**
     * Helper to Maps a raw type name
     */
    public Type resolveRawTypeName(String typeName) {
        if (typeName == null) return Type.unknown();

        int dims = 0;
        String baseName = typeName;
        while (baseName.endsWith("[]")) {
            dims++;
            baseName = baseName.substring(0, baseName.length() - 2);
        }

        Type base = resolveBaseRawTypeName(baseName);
        return dims > 0 ? Type.arrayType(base, dims) : base;
    }

    /**
     * Resolve base raw type name helper
     *
     */
    public Type resolveBaseRawTypeName(String typeName) {
        if (typeName == null) return Type.unknown();
        return switch (typeName) {
            case "numerus" -> Type.intType();
            case "decimalis" -> Type.floatType();
            case "textum" -> Type.stringType();
            case "littera" -> Type.charType();

            case "entero" -> Type.intType();
            case "flotante" -> Type.floatType();
            case "cadena" -> Type.stringType();
            case "caracter" -> Type.charType();
            case "bool" -> Type.booleanType();

            case "int" -> Type.intType();
            case "double" -> Type.floatType();
            case "char" -> Type.charType();
            case "boolean" -> Type.booleanType();
            case "String" -> Type.stringType();

            case "void" -> Type.voidType();
            default -> Type.customType(typeName);
        };
    }
}