package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.codegen.PigLatinCodeGenerator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen.YCodeGenerator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.codegenerator.ZCodeGenerator;

/**
 * Principal factory to manage the code generation
 *
 */
public class CodeGeneratorFactory {
    public static CodeGenerator create(String extension) {
        if (extension == null) return null;
        return switch (extension) {
            case ".y" -> new YCodeGenerator();
            case ".z" -> new ZCodeGenerator();
            case ".pig" -> new PigLatinCodeGenerator();
            default -> null;
        };
    }
}