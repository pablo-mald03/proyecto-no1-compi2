package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFG;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFGBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.ZCFGBuilderVisitor;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;

/**
 * Principal cfg builder for z language
 *
 */
public class ZCFGBuilder implements CFGBuilder {

    @Override
    public CFG build(AstNode ast, EditorContext context) {
        CFG cfg = new CFG();
        if (ast instanceof ProgramNodeZ program) {
            ZCFGBuilderVisitor visitor = new ZCFGBuilderVisitor(cfg, context);
            program.accept(visitor);
        }
        return cfg;
    }

    @Override
    public String getSupportedExtension() {
        return ".z";
    }
}