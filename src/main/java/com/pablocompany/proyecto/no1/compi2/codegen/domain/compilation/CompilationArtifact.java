package com.pablocompany.proyecto.no1.compi2.codegen.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal compilation artifact class representation
 *
 */
@Data
@AllArgsConstructor
public class CompilationArtifact {

    private Target target;
    private String fileName;
    private String content;
}
