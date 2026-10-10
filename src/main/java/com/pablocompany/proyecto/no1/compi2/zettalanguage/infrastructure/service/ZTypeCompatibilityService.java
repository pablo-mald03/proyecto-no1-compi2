package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

import java.util.List;

/**
 * Principal type compatibility service helper class
 *
 */
public class ZTypeCompatibilityService {

    private final ZTypeMapperService mapper;
    private final ZAssignabilityService assignability;

    public ZTypeCompatibilityService(ZTypeMapperService mapper,
                                     ZAssignabilityService assignability) {
        this.mapper = mapper;
        this.assignability = assignability;
    }

    // -------- predicates --------

    public boolean isNumericOrPromotable(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT || k == TypeKind.FLOAT
                || k == TypeKind.CHAR || k == TypeKind.BOOLEAN;
    }

    public boolean isIntLike(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT || k == TypeKind.CHAR || k == TypeKind.BOOLEAN;
    }

    public Type promoteNumeric(Type a, Type b) {
        if (a.getKind() == TypeKind.FLOAT || b.getKind() == TypeKind.FLOAT) {
            return Type.floatType();
        }
        return Type.intType();
    }

    /**
     * Method to call the compatibility
     */

    public boolean isCallCompatible(Symbol function, List<Type> argTypes) {
        List<String> paramTypes = function.getParameterTypes();
        if (paramTypes.size() != argTypes.size()) return false;

        for (int i = 0; i < paramTypes.size(); i++) {
            Type paramType = mapper.resolveTypeName(paramTypes.get(i));
            Type argType = argTypes.get(i);
            if (argType.isUnknown()) continue;
            if (!assignability.isAssignable(argType, paramType)) return false;
        }
        return true;
    }

    /**
     * Method to resolve the return type
     *
     */
    public Type resolveSymbolReturnType(Symbol function) {
        String rt = function.getReturnType();
        if (rt == null || "void".equals(rt)) return Type.voidType();
        return mapper.resolveTypeName(rt);
    }

    // -------- binary inference --------

    public Type inferBinaryType(Type left, Type right,
                                BinaryOperator op,
                                ZSemanticErrorReporter reporter,
                                ZAstNode node) {
        if (left.isUnknown() || right.isUnknown()) return Type.unknown();

        String opLexeme = op.getValue();

        switch (op) {
            case PLUS:
                if (left.getKind() == TypeKind.STRING && right.getKind() == TypeKind.STRING) {
                    return Type.stringType();
                }
                if (left.getKind() == TypeKind.STRING && isNumericOrPromotable(right)) {
                    return Type.stringType();
                }
                if (isNumericOrPromotable(left) && right.getKind() == TypeKind.STRING) {
                    return Type.stringType();
                }
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return promoteNumeric(left, right);
                }
                reporter.reportTypeError(opLexeme,
                        "Operador '+' incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case MINUS:
            case MULTIPLICATION:
            case DIVIDE:
            case MODULE:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return promoteNumeric(left, right);
                }
                reporter.reportTypeError(opLexeme,
                        "Operador aritmetico incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case LESS:
            case GREATER:
            case LESS_EQUALS:
            case GREATER_EQUALS:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return Type.booleanType();
                }
                reporter.reportTypeError(opLexeme,
                        "Operador relacional incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case EQUALS:
            case DIFFERENT:
                if (left.getKind() == TypeKind.NULL
                        && (right.isCustom() || right.isArray() || right.getKind() == TypeKind.STRING)) {
                    return Type.booleanType();
                }
                if (right.getKind() == TypeKind.NULL
                        && (left.isCustom() || left.isArray() || left.getKind() == TypeKind.STRING)) {
                    return Type.booleanType();
                }
                if (left.getKind() == TypeKind.NULL && right.getKind() == TypeKind.NULL) {
                    return Type.booleanType();
                }
                if (assignability.isAssignable(left, right)
                        || assignability.isAssignable(right, left)
                        || (isNumericOrPromotable(left) && isNumericOrPromotable(right))) {
                    return Type.booleanType();
                }
                reporter.reportTypeError(opLexeme,
                        "Operador de igualdad incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case AND:
            case OR:
                if (left.getKind() == TypeKind.BOOLEAN && right.getKind() == TypeKind.BOOLEAN) {
                    return Type.booleanType();
                }
                reporter.reportTypeError(opLexeme,
                        "Operador logico incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            default:
                return Type.unknown();
        }
    }
}