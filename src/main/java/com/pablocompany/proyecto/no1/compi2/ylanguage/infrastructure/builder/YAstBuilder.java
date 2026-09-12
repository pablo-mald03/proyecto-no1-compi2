package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParser;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParserBaseVisitor;

/**
 * AST builder for the Y language
 */
public class YAstBuilder extends YParserBaseVisitor<AstNode> implements AstBuilder {

    private EditorContext context;

    @Override
    public AstNode build(EditorContext context) {
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
