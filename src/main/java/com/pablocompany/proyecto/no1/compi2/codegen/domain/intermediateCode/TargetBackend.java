package com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;

/**
 * Principal contest to for the translation of the code
 *
 */
public interface TargetBackend {

    Target target();

    String generate(IntermediateProgram program);
}
