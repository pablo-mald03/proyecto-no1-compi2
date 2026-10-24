package com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Principal Cell representation  value
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell implements Value {
    private ValueType valuetype;
    private Address address;

    @Override
    public ValueType type() {
        return this.valuetype;
    }
}