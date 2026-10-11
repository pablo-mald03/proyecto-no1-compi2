package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.BinaryExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.UnaryExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.LiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;

import java.util.OptionalInt;

/**
 * Principal array size evaluator service
 *
 */
public class YArraySizeEvaluatorService {


    /**
     * Principal method to evaluate the array
     *
     */
    public OptionalInt evaluate(ExpressionNodeY expr) {
        if (expr == null) return OptionalInt.empty();

        if (expr instanceof LiteralExpressionNodeY lit) {
            return evaluateLiteral(lit);
        }
        if (expr instanceof UnaryExpressionNodeY un) {
            return evaluateUnary(un);
        }
        if (expr instanceof BinaryExpressionNodeY bin) {
            return evaluateBinary(bin);
        }
        return OptionalInt.empty();
    }

    /**
     * Method to evaluate the literal
     *
     */
    private OptionalInt evaluateLiteral(LiteralExpressionNodeY lit) {
        YDataType dt = lit.getValueType();
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

    /**
     * Helper method to evaluate the unary expressions
     *
     */
    private OptionalInt evaluateUnary(UnaryExpressionNodeY un) {
        if (un.getOperator() != UnaryOperator.NEGATE) return OptionalInt.empty();
        OptionalInt inner = evaluate(un.getExpressionNode());
        return inner.isEmpty() ? OptionalInt.empty() : OptionalInt.of(-inner.getAsInt());
    }

    /**
     * Helper method to evaluate the binary expressions
     *
     */
    private OptionalInt evaluateBinary(BinaryExpressionNodeY bin) {
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
