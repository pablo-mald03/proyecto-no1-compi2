package com.pablocompany.proyecto.no1.compi2.common.domain.parsing;


import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

/**
 * Interface for AST builders
 * Each language implements this to convert ANTLR parse tree into its own AST representation
 */
public interface AstBuilder {

    /**
     * Build the AST from the parse tree
     *
     * @param context The EditorContext with the ANTLR parse tree
     * @return The root node of the custom AST, or null if building failed
     */
    PigLatinAstNode build(EditorContext context);

    /**
     * Get the file extension this builder handles
     */
    String getSupportedExtension();
}