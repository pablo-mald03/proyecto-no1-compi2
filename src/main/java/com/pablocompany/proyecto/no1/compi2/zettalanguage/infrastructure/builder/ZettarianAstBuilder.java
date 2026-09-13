package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZParserBaseVisitor;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

/**
 * AST builder for the Z language
 */
public class ZettarianAstBuilder extends ZParserBaseVisitor<PigLatinAstNode> implements AstBuilder {


    @Override
    public PigLatinAstNode build(EditorContext context) {

        if (context.getParseTree() == null) {
            return null;
        }

        // TODO: Visit the parse tree and build your custom AST

        return null;
    }

    @Override
    public String getSupportedExtension() {
        return ".z";
    }
}
