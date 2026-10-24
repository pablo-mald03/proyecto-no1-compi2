package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import lombok.NonNull;
import lombok.Value;

/**
 * Immediate value for CHAR numeric code of booleans
 */
@Value
public class Immediate implements Operand {
    @NonNull
    String literal;
    @NonNull
    ValueType type;

    /**
     * Method to evaluate an int
     *
     */
    public static Immediate ofInt(long v) {
        return new Immediate(Long.toString(v), ValueType.INT);
    }

    /**
     * Method to evaluate a float
     *
     */
    public static Immediate ofFloat(double v) {
        return new Immediate(Double.toString(v), ValueType.FLOAT);
    }

    /**
     * Method to evaluate a boolean
     *
     */
    public static Immediate ofBool(boolean v) {
        return new Immediate(v ? "1" : "0", ValueType.BOOLEAN);
    }

    /**
     * Method to evaluate a char
     *
     */
    public static Immediate ofChar(char c) {
        return new Immediate(Integer.toString(c), ValueType.CHAR);
    }
}
