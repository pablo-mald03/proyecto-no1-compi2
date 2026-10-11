package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;

import java.util.List;

/**
 * Principal type compatibility checker service
 *
 */
public class YTypeCompatibilityService {

    private final YTypeMapperService mapper;

    public YTypeCompatibilityService(YTypeMapperService mapper) {
        this.mapper = mapper;
    }

    // -------- predicates --------

    public boolean isNumericOrPromotable(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT
                || k == TypeKind.FLOAT
                || k == TypeKind.CHAR
                || k == TypeKind.BOOLEAN;
    }

    public boolean isIntLike(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT
                || k == TypeKind.CHAR
                || k == TypeKind.BOOLEAN;
    }

    public Type promoteNumeric(Type a, Type b) {
        if (a.getKind() == TypeKind.FLOAT || b.getKind() == TypeKind.FLOAT) {
            return Type.floatType();
        }
        return Type.intType();
    }

    // -------- call compatibility --------

    public boolean isCallCompatible(Symbol function, List<Type> argTypes) {
        List<String> paramTypes = function.getParameterTypes();
        if (paramTypes.size() != argTypes.size()) return false;

        for (int i = 0; i < paramTypes.size(); i++) {
            Type paramType = mapper.resolveTypeName(paramTypes.get(i));
            Type argType = argTypes.get(i);
            if (argType.isUnknown()) continue;
            if (!argType.isAssignableTo(paramType)) return false;
        }
        return true;
    }

    public Type resolveSymbolReturnType(Symbol function) {
        String rt = function.getReturnType();
        if (rt == null || "void".equals(rt)) return Type.voidType();
        return mapper.resolveTypeName(rt);
    }

    // -------- binary inference --------

    public Type inferBinaryType(Type left, Type right,
                                BinaryOperator op,
                                YSemanticErrorReporter reporter,
                                YAstNode node) {
        if (left.isUnknown() || right.isUnknown()) return Type.unknown();

        String opLexeme = op.toString();
        switch (op) {
            case PLUS:
                if (left.getKind() == TypeKind.STRING || right.getKind() == TypeKind.STRING) {
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
                if (left.isCompatibleWith(right)
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