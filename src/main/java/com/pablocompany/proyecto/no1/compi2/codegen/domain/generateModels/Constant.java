package com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import lombok.Data;

/**
 * Principal constant representation for value
 *
 */
@Data
public class Constant implements Value {
    private String literal;
    private ValueType type;
}