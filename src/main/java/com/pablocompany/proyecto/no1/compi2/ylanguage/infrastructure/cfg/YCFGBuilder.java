package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFG;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFGBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YCFGBuilderVisitor;

/**
 * Principal CFG builder
 *
 */
public class YCFGBuilder implements CFGBuilder {

    @Override
    public CFG build(AstNode ast, EditorContext context) {
        CFG cfg = new CFG();
        if (ast instanceof ProgramNodeY program) {
            YCFGBuilderVisitor visitor = new YCFGBuilderVisitor(cfg, context);
            program.accept(visitor);
        }
        return cfg;
    }

    @Override
    public String getSupportedExtension() {
        return ".y";
    }
}