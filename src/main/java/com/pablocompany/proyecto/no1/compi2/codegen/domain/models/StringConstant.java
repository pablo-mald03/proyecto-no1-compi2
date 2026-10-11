package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import lombok.NonNull;
import lombok.Value;

/**
 * Principal string constant model representation
 *
 */
@Value
public class StringConstant {
    @NonNull
    String id;
    @NonNull
    String value;
}
