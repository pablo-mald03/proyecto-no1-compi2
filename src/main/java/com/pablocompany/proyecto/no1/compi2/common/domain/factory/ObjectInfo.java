package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Metadata for an object variable in Z language.
 */
@Data
@AllArgsConstructor
public class ObjectInfo {

    private final String className;
    private final int ptrSlot;
}
