package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.resolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.ReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinReferenceResolverVisitor;

/**
 * Runs the reference resolution pass over a .pig AST.
 */
public class PigLatinReferenceResolver implements ReferenceResolver {

    @Override
    public void resolve(EditorContext context, GlobalSymbolTable table) {
        if (!(context.getAstNode() instanceof PigLatinAstNode pigAst)) {
            return;
        }

        PigLatinReferenceResolverVisitor visitor =
                new PigLatinReferenceResolverVisitor(table, context);
        pigAst.accept(visitor);
    }

}