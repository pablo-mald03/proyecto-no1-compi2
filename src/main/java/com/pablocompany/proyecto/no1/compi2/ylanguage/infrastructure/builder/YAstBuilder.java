package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParser;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParserBaseVisitor;

/**
 * AST builder for the Y language
 */
public class YAstBuilder extends YParserBaseVisitor<PigLatinAstNode> implements AstBuilder {

    private EditorContext context;

    @Override
    public PigLatinAstNode build(EditorContext context) {
        this.context = context;

        if (context.getParseTree() == null) {
            return null;
        }

        YParser.ProgramContext program = (YParser.ProgramContext) context.getParseTree();
        return visitProgram(program);
    }

    @Override
    public String getSupportedExtension() {
        return ".y";
    }
}
