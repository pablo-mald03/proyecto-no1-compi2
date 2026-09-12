package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParserBaseVisitor;

/**
 * AST builder for the Pig Latin language (orchestrator)
 */
public class PigAstBuilder extends PigLatinParserBaseVisitor<AstNode> implements AstBuilder {

    private EditorContext context;

    @Override
    public AstNode build(EditorContext context) {
        this.context = context;

        if (context.getParseTree() == null) {
            return null;
        }

        // TODO: Visit the parse tree and build your custom AST

        return null;
    }

    @Override
    public String getSupportedExtension() {
        return ".pig";
    }

}
