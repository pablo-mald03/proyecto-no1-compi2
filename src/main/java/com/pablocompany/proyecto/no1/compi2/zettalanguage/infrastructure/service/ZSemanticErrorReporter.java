package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

/**
 * Principal semantic error reporter service
 *
 */
public class ZSemanticErrorReporter {

    private final EditorContext context;

    public ZSemanticErrorReporter(EditorContext context) {
        this.context = context;
    }

    /**
     * Reports a semantic error tied to an AST node.
     */
    public void reportTypeError(String lexeme, String description, ZAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(lexeme);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription(description.replace("float", "double"));
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }

    /**
     * Reports a duplicate declaration (collector-side).
     */
    public void reportDuplicate(String name, String kindLabel, ZAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(name);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("Ya existe un " + kindLabel + " con el nombre '"
                + name + "' en este ambito");
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }
}