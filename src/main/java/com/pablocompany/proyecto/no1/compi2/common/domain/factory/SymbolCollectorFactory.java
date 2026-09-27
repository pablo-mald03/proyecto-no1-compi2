package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.SymbolCollector;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.collector.PigLatinSymbolCollector;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.collector.YSymbolCollector;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.collector.ZSymbolCollector;

/**
 * Principal factory class for any symbol collector visitor
 *
 */
public class SymbolCollectorFactory {

    public static SymbolCollector create(String extension) {
        if (extension == null) {
            return null;
        }
        return switch (extension) {
            case ".y" -> new YSymbolCollector();
            case ".z" -> new ZSymbolCollector();
            case ".pig" -> new PigLatinSymbolCollector();
            default -> null;
        };
    }

}