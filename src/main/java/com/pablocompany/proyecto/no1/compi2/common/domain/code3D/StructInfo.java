package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal struct info model
 *
 */
@Data
@AllArgsConstructor
public class StructInfo {
    private String structTypeName;
    private int baseOffset;
}