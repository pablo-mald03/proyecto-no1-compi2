package com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Principal text representation value
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text implements Value {
    private String poolId;

    @Override
    public ValueType type() {
        return ValueType.STRING;
    }
}