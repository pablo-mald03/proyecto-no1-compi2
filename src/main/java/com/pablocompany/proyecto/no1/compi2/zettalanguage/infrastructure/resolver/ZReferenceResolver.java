package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.resolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.ReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZReferenceResolverVisitor;

/**
 * Pricipal gateway for the reference resolution pass over a .z AST.
 */
public class ZReferenceResolver implements ReferenceResolver {

    @Override
    public void resolve(EditorContext context, GlobalSymbolTable table) {
        if (!(context.getAstNode() instanceof ZAstNode zAst)) {
            return;
        }

        ZReferenceResolverVisitor visitor = new ZReferenceResolverVisitor(table, context);
        zAst.accept(visitor);
    }

}