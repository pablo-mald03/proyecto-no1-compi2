package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;

/**
 * Principal semantic error reporter service class
 *
 */
public class YSemanticErrorReporter {

    private final EditorContext context;

    public YSemanticErrorReporter(EditorContext context) {
        this.context = context;
    }

    /**
     * Duplicate reporter helper method
     */
    public void reportDuplicate(String name, String kindLabel, YAstNode node) {
        report(name,
                "Ya existe un " + kindLabel + " con el nombre '" + name + "' en este ambito",
                node);
    }


    /**
     * type error reporter helper method
     */
    public void reportTypeError(String lexeme, String description, YAstNode node) {
        report(lexeme, description, node);
    }

    /**
     * Error reporter service
     *
     */
    public void report(String lexeme, String description, YAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(lexeme);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription(description);
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }
}