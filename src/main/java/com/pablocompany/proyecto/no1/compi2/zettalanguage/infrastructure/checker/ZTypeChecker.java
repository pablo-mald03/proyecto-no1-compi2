package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.checker;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.TypeChecker;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZTypeCheckerVisitor;

import java.util.Map;

public class ZTypeChecker implements TypeChecker {

    @Override
    public void check(EditorContext context,
                      GlobalSymbolTable table,
                      Map<AstNode, Type> typeAnnotations) {
        if (!(context.getAstNode() instanceof ZAstNode zAst)) return;

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        ZTypeCheckerVisitor visitor = new ZTypeCheckerVisitor(table, context, typeAnnotations);
        zAst.accept(visitor);

        table.resetToGlobal();
    }
}