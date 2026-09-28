package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.cfg.ZCFGBuilder;

/**
 * Principal factory class for the different CFG implementations
 *
 */
public class CFGBuilderFactory {

    public static CFGBuilder create(String extension) {
        if (extension == null) return null;
        return switch (extension) {
            case ".z" -> new ZCFGBuilder();
            /*           case ".pig" -> new PigCFGBuilder();*/
            /*            case ".y" -> new YCFGBuilder();*/
            default -> null;
        };
    }
}