package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.checker;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.TypeChecker;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinTypeCheckerVisitor;

import java.util.Map;

/**
 * Principal type checker class
 *
 */
public class PigLatinTypeChecker implements TypeChecker {

    @Override
    public void check(EditorContext context,
                      GlobalSymbolTable table,
                      Map<AstNode, Type> typeAnnotations) {
        if (!(context.getAstNode() instanceof PigLatinAstNode pigAst)) return;

        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);

        PigLatinTypeCheckerVisitor visitor =
                new PigLatinTypeCheckerVisitor(table, context, typeAnnotations);
        pigAst.accept(visitor);

        table.resetToGlobal();
    }
}