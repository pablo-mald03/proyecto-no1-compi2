package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFG;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFGBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinCFGBuilderVisitor;

/**
 * Principal CFG pig latin builder
 *
 */
public class PigLatinCFGBuilder implements CFGBuilder {

    @Override
    public CFG build(AstNode ast, EditorContext context) {
        CFG cfg = new CFG();
        if (ast instanceof ProgramNodePigLatin program) {
            PigLatinCFGBuilderVisitor visitor = new PigLatinCFGBuilderVisitor(cfg, context);
            program.accept(visitor);
        }
        return cfg;
    }

    @Override
    public String getSupportedExtension() {
        return ".pig";
    }
}