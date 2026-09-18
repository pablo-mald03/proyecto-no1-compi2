package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.collector;

import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.SymbolCollector;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinSymbolCollectorVisitor;
import lombok.Getter;

/**
 * Principal symbol collector visitor
 *
 */
@Getter
public class PigLatinSymbolCollector implements SymbolCollector {

    @Override
    public void collect(EditorContext context, GlobalSymbolTable table) {

        if (!(context.getAstNode() instanceof PigLatinAstNode pigAst)) {
            return;
        }

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        PigLatinSymbolCollectorVisitor visitor = new PigLatinSymbolCollectorVisitor(table, context);
        pigAst.accept(visitor);

        table.resetToGlobal();
    }

}