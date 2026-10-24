package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import lombok.NonNull;
import lombok.Value;

/**
 * Stack pointer and offset class representation
 */
@Value
public class StackTop implements Address {
    
    @NonNull
    int offset;
}
