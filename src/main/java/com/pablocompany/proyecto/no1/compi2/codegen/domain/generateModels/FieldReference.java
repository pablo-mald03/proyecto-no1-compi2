package com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels;

import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StructInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Field reference  model
 *
 */
@Data
@AllArgsConstructor
public class FieldReference {
    private StructInfo info;
    private int offset;

}
