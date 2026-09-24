package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.resolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.ReferenceResolver;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YReferenceResolverVisitor;

/**
 * Runs the reference resolution pass over a .y AST.
 */
public class YReferenceResolver implements ReferenceResolver {

    /**
     * Principal resolver delegated method
     *
     */
    @Override
    public void resolve(EditorContext context, GlobalSymbolTable table) {
        if (!(context.getAstNode() instanceof YAstNode yAst)) {
            return;
        }

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        YReferenceResolverVisitor visitor = new YReferenceResolverVisitor(table, context);
        yAst.accept(visitor);

        table.resetToGlobal();
    }

}