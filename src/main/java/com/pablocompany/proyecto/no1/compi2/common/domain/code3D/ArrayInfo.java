package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Principal array info class
 *
 */
@Getter
@AllArgsConstructor
public class ArrayInfo {
    private final int baseOffset;
    private final TypeKind elementType;
    private final int totalSize;
    private final boolean isHeap;
}