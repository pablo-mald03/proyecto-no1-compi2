package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Role;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import lombok.NonNull;
import lombok.Value;

/**
 * Register virtual (AX/BX/CX) tipado. Cada backend decide a qué registro físico corresponde.
 */
@Value
public class Register implements Operand {

    @NonNull
    Role role;
    @NonNull
    ValueType type;

    /**
     * Method to get the AX register
     *
     */
    public static Register ax(ValueType t) {
        return new Register(Role.AX, t);
    }

    /**
     * Method to get the BX register
     *
     */
    public static Register bx(ValueType t) {
        return new Register(Role.BX, t);
    }

    /**
     * Method to get the CX register
     *
     */
    public static Register cx(ValueType t) {
        return new Register(Role.CX, t);
    }

    /**
     * Name for the register
     */
    public String legacyName() {
        return role + "_" + type.name();
    }

    /**
     * legacy name for the register
     *
     */
    public static boolean isLegacyName(String s) {
        return s != null && s.matches("[ABC]X_[A-Z]+");
    }

    /**
     * Parser helper method for the register
     *
     */
    public static Register parseLegacy(String s) {
        if (!isLegacyName(s)) throw new IllegalArgumentException("No es un registro: " + s);
        return new Register(Role.valueOf(s.substring(0, 2)), ValueType.valueOf(s.substring(3)));
    }
}