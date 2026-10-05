package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;

/**
 * Principal type mapper service helper
 *
 */
public class YTypeMapperService {

    /**
     * Method to map the type of the node
     *
     */
    public Type mapTypeNode(TypeNodeY typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapYDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    /**
     * Datatype helper method
     *
     */
    public Type mapYDataType(YDataType dt, String customName) {
        if (dt == null) return Type.unknown();
        return switch (dt) {
            case INT -> Type.intType();
            case FLOAT -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case CUSTOM -> Type.customType(customName);
            default -> Type.unknown();
        };
    }

    /**
     * Maps a Symbol to a Type, honoring array dims and the isArray flag.
     */
    public Type mapSymbolToType(Symbol symbol) {
        if (symbol == null) return Type.unknown();

        String typeName = symbol.getType();
        if (typeName == null) return Type.unknown();

        Type base = resolveTypeName(typeName);
        if (base == null) return Type.unknown();

        int dims = symbol.getDimensions();
        if (dims <= 0 && symbol.isArray()) {
            // Defensive: isArray=true but dimensions not set -> assume 1D.
            dims = 1;
        }
        return dims > 0 ? Type.arrayType(base, dims) : base;
    }

    /**
     * Method to parses "int[]", "int[][]"
     */
    public Type resolveTypeName(String typeName) {
        if (typeName == null) return Type.unknown();

        int dims = 0;
        String baseName = typeName;
        while (baseName.endsWith("[]")) {
            dims++;
            baseName = baseName.substring(0, baseName.length() - 2);
        }

        Type base = resolveBaseTypeName(baseName);
        return dims > 0 ? Type.arrayType(base, dims) : base;
    }

    /**
     * Principal base type name resolver
     *
     */
    private Type resolveBaseTypeName(String typeName) {
        if (typeName == null) return Type.unknown();
        return switch (typeName) {
            // PigLatin
            case "numerus" -> Type.intType();
            case "decimalis" -> Type.floatType();
            case "textum" -> Type.stringType();
            case "littera" -> Type.charType();

            // Y
            case "entero" -> Type.intType();
            case "flotante" -> Type.floatType();
            case "cadena" -> Type.stringType();
            case "caracter" -> Type.charType();
            case "bool" -> Type.booleanType();

            // Z
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