package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.BinaryExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.UnaryExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.ZDataType;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values.LiteralExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;

import java.util.OptionalInt;

/**
 * Principal service class to evaluates Z expressions to integer constants at compile time, when possible.
 */
public class ZArraySizeEvaluatorService {

    /**
     * Principal method to evaluate the array
     *
     */
    public OptionalInt evaluate(ExpressionNodeZ expr) {
        if (expr == null) return OptionalInt.empty();

        if (expr instanceof LiteralExpressionNodeZ lit) {
            return evaluateLiteral(lit);
        }

        if (expr instanceof UnaryExpressionNodeZ un) {
            return evaluateUnary(un);
        }

        if (expr instanceof BinaryExpressionNodeZ bin) {
            return evaluateBinary(bin);
        }

        return OptionalInt.empty();
    }

    /**
     * Method to evaluate the literal
     *
     */
    private OptionalInt evaluateLiteral(LiteralExpressionNodeZ lit) {
        ZDataType dt = lit.getValueType();
        if (dt == null) return OptionalInt.empty();

        Object value = lit.getDataValue();
        if (value == null) return OptionalInt.empty();

        return switch (dt) {
            case INT -> {
                if (value instanceof Integer i) yield OptionalInt.of(i);
                yield OptionalInt.empty();
            }
            case CHAR -> {
                if (value instanceof Character c) yield OptionalInt.of((int) c);
                yield OptionalInt.empty();
            }
            default -> OptionalInt.empty();
        };
    }

    // ---------------- unary ----------------

    private OptionalInt evaluateUnary(UnaryExpressionNodeZ un) {
        if (un.getOperator() != UnaryOperator.NEGATE) return OptionalInt.empty();

        OptionalInt inner = evaluate(un.getExpressionNode());
        if (inner.isEmpty()) return OptionalInt.empty();

        return OptionalInt.of(-inner.getAsInt());
    }

    // ---------------- binary ----------------

    private OptionalInt evaluateBinary(BinaryExpressionNodeZ bin) {
        OptionalInt left = evaluate(bin.getLeft());
        OptionalInt right = evaluate(bin.getRight());
        if (left.isEmpty() || right.isEmpty()) return OptionalInt.empty();

        int a = left.getAsInt();
        int b = right.getAsInt();

        return switch (bin.getOperator()) {
            case PLUS -> OptionalInt.of(a + b);
            case MINUS -> OptionalInt.of(a - b);
            case MULTIPLICATION -> OptionalInt.of(a * b);
            case DIVIDE -> b == 0 ? OptionalInt.empty() : OptionalInt.of(a / b);
            case MODULE -> b == 0 ? OptionalInt.empty() : OptionalInt.of(a % b);
            default -> OptionalInt.empty();
        };
    }
}