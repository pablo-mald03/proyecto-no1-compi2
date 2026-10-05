package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

/**
 * Principal class reporter service
 *
 */
public class SemanticPigErrorReporterService {

    private final EditorContext context;

    public SemanticPigErrorReporterService(EditorContext context) {
        this.context = context;
    }

    /**
     * Helper to report undeclared symbol
     *
     */
    public void reportUndeclared(String name, PigLatinAstNode node) {
        report(name, node,
                "El simbolo '" + name + "' no esta declarado en este ambito");
    }

    /**
     * Helper to report duplicated symbol
     *
     */
    public void reportDuplicate(String name, String kindLabel, PigLatinAstNode node) {
        report(name, node,
                "Ya existe un " + kindLabel + " con el nombre '" + name + "' en este ambito");
    }

    /**
     * Helper to report unknow type symbol
     *
     */
    public void reportUnknownType(String typeName, PigLatinAstNode node) {
        report(typeName, node,
                "El tipo '" + typeName + "' no esta declarado ni importado");
    }

    /**
     * Principal method to report a new error
     *
     */
    private void report(String lexeme, PigLatinAstNode node, String description) {
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