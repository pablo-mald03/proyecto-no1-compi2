package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.ZDataType;

/**
 * Principal Type mapper service helper class
 *
 */
public class ZTypeMapperService {

    // -------- TypeNode -> Type --------

    public Type mapTypeNode(TypeNodeZ typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapZDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    public Type mapZDataType(ZDataType dt, String customName) {
        if (dt == null) return Type.unknown();
        return switch (dt) {
            case INT -> Type.intType();
            case DOUBLE -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case VOID -> Type.voidType();
            case NULL -> Type.nullType();
            case CLASS -> "String".equals(customName)
                    ? Type.stringType()
                    : Type.customType(customName);
        };
    }

    // -------- Symbol -> Type --------

    /**
     * Method who maps a Symbol to a Type. Honors array dimensions.
     */
    public Type mapSymbolToType(Symbol symbol) {
        if (symbol == null) return Type.unknown();
        String typeName = symbol.getType();
        if (typeName == null) return Type.unknown();

        Type base = resolveTypeName(typeName);
        if (base == null) return Type.unknown();

        int dims = symbol.getDimensions();
        if (dims <= 0 && symbol.isArray()) dims = 1;
        return dims > 0 ? Type.arrayType(base, dims) : base;
    }

    // -------- Type name parsing --------

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
     * Method to resolve the base typename
     *
     */
    private Type resolveBaseTypeName(String typeName) {
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
            case "void" -> Type.voidType();
            case "String" -> Type.stringType();
            case "null" -> Type.nullType();
            default -> Type.customType(typeName);
        };
    }
}