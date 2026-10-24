package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinCodeGeneratorVisitor;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;

import java.util.Map;

/**
 * Principal class code generator
 *
 */
public class PigLatinCodeGenerator implements CodeGenerator {

    @Override
    public void generate(EditorContext context, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations,
                         Map<AstNode, Symbol> resolvedCalls, IntermediateBuilder intermediate, CodeGenContext labels){

        if (!(context.getAstNode() instanceof PigLatinAstNode pigAst)) return;
        pigAst.accept(new PigLatinCodeGeneratorVisitor(table, context, typeAnnotations, resolvedCalls, intermediate, labels));
    }
}