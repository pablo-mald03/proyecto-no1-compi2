package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.TypeChecker;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.checker.YTypeChecker;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.checker.ZTypeChecker;

/**
 * Principal factory for the type checker phase
 *
 */
public class TypeCheckerFactory {
    public static TypeChecker create(String extension) {
        if (extension == null) return null;
        return switch (extension) {
            case ".y" -> new YTypeChecker();
            case ".z" -> new ZTypeChecker();
            /*            case ".pig" -> new PigLatinTypeChecker();*/
            default -> null;
        };
    }
}