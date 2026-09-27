package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.collector;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.SymbolCollector;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZSymbolCollectorVisitor;

/**
 * Principal symbol collector for Z language
 *
 */
public class ZSymbolCollector implements SymbolCollector {

    @Override
    public void collect(EditorContext context, GlobalSymbolTable table) {
        if (!(context.getAstNode() instanceof ZAstNode zAst)) {
            return;
        }

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        ZSymbolCollectorVisitor visitor = new ZSymbolCollectorVisitor(table, context);
        zAst.accept(visitor);

        table.resetToGlobal();
    }

}