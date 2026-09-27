package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Principal quadruple representation for the 3D code
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quadruple {
    private String op;
    private String arg1;
    private String arg2;
    private String result;


    @Override
    public String toString() {
        return "(" + op + ", " + arg1 + ", " + arg2 + ", " + result + ")";
    }
    
}