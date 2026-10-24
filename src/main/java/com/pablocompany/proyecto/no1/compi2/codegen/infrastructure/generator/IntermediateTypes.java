package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;

/**
 * Principal class to translate the AST operations to the intermediate code
 *
 */
public class IntermediateTypes {
    private IntermediateTypes() {
    }

    /**
     * Principal method to evaluate the type and translate to the intermediate operation
     *
     */
    public static ValueType of(TypeKind kind) {
        if (kind == null) return ValueType.INT;
        return switch (kind) {
            case STRING -> ValueType.STRING;
            case FLOAT -> ValueType.FLOAT;
            case CHAR -> ValueType.CHAR;
            case BOOLEAN -> ValueType.BOOLEAN;
            default -> ValueType.INT;
        };
    }

    /**
     * Principal method to evaluate the binary operations and translate to the intermediate operation
     *
     */
    public static BinaryOperations binary(BinaryOperator op) {
        return switch (op) {
            case PLUS -> BinaryOperations.ADD;
            case MINUS -> BinaryOperations.SUB;
            case MULTIPLICATION -> BinaryOperations.MUL;
            case DIVIDE -> BinaryOperations.DIV;
            case MODULE -> BinaryOperations.MOD;
            case EQUALS -> BinaryOperations.EQ;
            case DIFFERENT -> BinaryOperations.NE;
            case LESS -> BinaryOperations.LT;
            case GREATER -> BinaryOperations.GT;
            case LESS_EQUALS -> BinaryOperations.LE;
            case GREATER_EQUALS -> BinaryOperations.GE;
            case AND -> BinaryOperations.AND;
            case OR -> BinaryOperations.OR;
        };
    }

    /**
     * Principal method to evaluate the shortly operations and translate to the intermediate operation
     *
     */
    public static BinaryOperations shortly(ShortlyOperator op) {
        return switch (op) {
            case PLUS_ASSIGN -> BinaryOperations.ADD;
            case MINUS_ASSIGN -> BinaryOperations.SUB;
            case MULTIPLY_ASSIGN -> BinaryOperations.MUL;
            case DIVIDE_ASSIGN -> BinaryOperations.DIV;
            case MODULO_ASSIGN -> BinaryOperations.MOD;
        };
    }

    /**
     * Principal method to evaluate the unary operations and translate to the intermediate operation
     *
     */
    public static UnaryOperations unary(UnaryOperator op) {
        return switch (op) {
            case NEGATE -> UnaryOperations.NEG;
            case NOT -> UnaryOperations.NOT;
        };
    }
}
