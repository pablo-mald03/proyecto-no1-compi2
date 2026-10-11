package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.BinaryExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.UnaryExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.LiteralExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;

import java.util.OptionalInt;

/**
 * Principal service class to evaluates PigLatin expressions to integer constants at compile time,
 * when is possible
 */
public class PigArraySizeEvaluatorService {

    public OptionalInt evaluate(ExpressionNodePigLatin expr) {
        if (expr == null) return OptionalInt.empty();

        if (expr instanceof LiteralExpressionNodePigLatin lit) {
            return evaluateLiteral(lit);
        }

        if (expr instanceof UnaryExpressionNodePigLatin un) {
            return evaluateUnary(un);
        }

        if (expr instanceof BinaryExpressionNodePigLatin bin) {
            return evaluateBinary(bin);
        }

        return OptionalInt.empty();
    }

    /**
     * Method to evaluate the literals
     *
     */
    private OptionalInt evaluateLiteral(LiteralExpressionNodePigLatin literal) {
        Object value = literal.getDataValue();
        if (value == null) return OptionalInt.empty();

        if (value instanceof Integer i) return OptionalInt.of(i);
        if (value instanceof Character c) return OptionalInt.of((int) c);

        return OptionalInt.empty();
    }

    /**
     * Method to execute the unary operations
     *
     */
    private OptionalInt evaluateUnary(UnaryExpressionNodePigLatin un) {
        if (un.getOperator() != UnaryOperator.NEGATE) return OptionalInt.empty();

        OptionalInt inner = evaluate(un.getExpressionNode());
        if (inner.isEmpty()) return OptionalInt.empty();

        return OptionalInt.of(-inner.getAsInt());
    }

    /**
     * Method to evaluate the binary operations
     *
     */

    private OptionalInt evaluateBinary(BinaryExpressionNodePigLatin bin) {
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