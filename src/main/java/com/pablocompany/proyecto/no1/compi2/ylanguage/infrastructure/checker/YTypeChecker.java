package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.checker;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.TypeChecker;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YTypeCheckerVisitor;

import java.util.Map;

/**
 * Principal type checker class for Y language
 *
 */
public class YTypeChecker implements TypeChecker {

    @Override
    public void check(EditorContext context,
                      GlobalSymbolTable table,
                      Map<AstNode, Type> typeAnnotations) {
        if (!(context.getAstNode() instanceof YAstNode yAst)) return;

        YTypeCheckerVisitor visitor = new YTypeCheckerVisitor(table, context, typeAnnotations);
        yAst.accept(visitor);
    }
}