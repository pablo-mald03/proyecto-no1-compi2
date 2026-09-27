package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Principal struct info model
 *
 */
@Getter
@AllArgsConstructor
public class StructInfo {
    private final String structTypeName;
    private final int baseOffset;
    private final boolean isReference;
}