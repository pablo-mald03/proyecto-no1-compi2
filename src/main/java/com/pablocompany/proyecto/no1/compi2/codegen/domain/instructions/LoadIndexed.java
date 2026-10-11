package com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import lombok.Data;

/**
 * Principal class to load an indexed memory
 *
 */
@Data
public class LoadIndexed {

    private Address base;
    private Register index;
    private Register destination;
}
