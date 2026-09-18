package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.collector;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.SymbolCollector;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YSymbolCollectorVisitor;

/**
 * Principal symbol collector for Y language
 *
 */
public class YSymbolCollector implements SymbolCollector {

    @Override
    public void collect(EditorContext context, GlobalSymbolTable table) {
        if (!(context.getAstNode() instanceof YAstNode yAst)) {
            return;
        }

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        YSymbolCollectorVisitor visitor = new YSymbolCollectorVisitor(table, context);
        yAst.accept(visitor);

        table.resetToGlobal();
    }

}