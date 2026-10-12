package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.codegenerator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZCodeGeneratorVisitor;

import java.util.Map;

/**
 * Principal class coe generator for the z language
 */
public class ZCodeGenerator implements CodeGenerator {

    @Override
    public void generate(EditorContext context, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations,
                         IntermediateBuilder intermediate, CodeGenContext labels) {

        if (!(context.getAstNode() instanceof ZAstNode pigAst)) return;
        pigAst.accept(new ZCodeGeneratorVisitor(table, context, typeAnnotations, intermediate, labels));
    }

    @Override
    public void declare(EditorContext context, CodeGenContext codeGen) {
        if (context.getAstNode() instanceof ProgramNodeY program) {
//            new SymbolLookup().collect(program, context.getFilePath(), codeGen);
        }
    }
}