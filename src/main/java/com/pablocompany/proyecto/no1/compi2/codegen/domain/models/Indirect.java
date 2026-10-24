package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import lombok.NonNull;
import lombok.Value;

/**
 * Registry value with the pointer
 */
@Value
public class Indirect implements Address {

    @NonNull
    Register base;
    @NonNull
    int offset;

}