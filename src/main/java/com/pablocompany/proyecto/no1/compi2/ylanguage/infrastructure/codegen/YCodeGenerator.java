package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YCodeGeneratorVisitor;

import java.util.Map;

/**
 * Code generator implementation contest
 *
 */
public class YCodeGenerator implements CodeGenerator {
    @Override
    public void generate(EditorContext context, GlobalSymbolTable table,
                         Map<AstNode, Type> typeAnnotations,
                         Map<AstNode, Symbol> resolvedCalls,
                         IntermediateBuilder intermediate, CodeGenContext labels) {
        if (!(context.getAstNode() instanceof YAstNode yAst)) return;
        yAst.accept(new YCodeGeneratorVisitor(
                table, context, typeAnnotations, resolvedCalls, intermediate, labels));
    }
}
