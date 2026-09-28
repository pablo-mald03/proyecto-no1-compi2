package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;

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