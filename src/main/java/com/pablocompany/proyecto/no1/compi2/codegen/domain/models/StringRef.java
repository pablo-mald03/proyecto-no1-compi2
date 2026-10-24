package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import lombok.NonNull;
import lombok.Value;

/**
 * Constant reference for the string pool
 */
@Value
public class StringRef implements Operand {

    @NonNull
    String id;

}