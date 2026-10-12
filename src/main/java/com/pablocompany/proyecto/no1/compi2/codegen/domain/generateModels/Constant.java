package com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Principal constant representation  value
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constant implements Value {
    private String literal;
    private ValueType valuetype;

    @Override
    public ValueType type() {
        return this.valuetype;
    }
}