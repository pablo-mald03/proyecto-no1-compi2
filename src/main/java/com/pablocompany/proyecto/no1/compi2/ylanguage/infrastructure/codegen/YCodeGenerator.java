package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YCodeGeneratorVisitor;

import java.util.Map;

/**
 * Code generator implementation contest
 *
 */
public class YCodeGenerator implements CodeGenerator {

    @Override
    public CodeGeneratorOutput generate(EditorContext context,
                                        GlobalSymbolTable table,
                                        Map<AstNode, Type> typeAnnotations,
                                        StringPool sharedStringPool) {
        CodeGeneratorOutput output = new CodeGeneratorOutput(context.getFilePath());

        if (!(context.getAstNode() instanceof YAstNode yAst)) return output;

        CodeGenContext ctx = new CodeGenContext();

        YCodeGeneratorVisitor visitor = new YCodeGeneratorVisitor(
                table, context, typeAnnotations, output, ctx, sharedStringPool
        );
        yAst.accept(visitor);
        return output;
    }
}