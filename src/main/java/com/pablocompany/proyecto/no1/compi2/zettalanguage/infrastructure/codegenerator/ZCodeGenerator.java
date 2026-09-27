package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.codegenerator;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZCodeGeneratorVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal class coe generator for the z language
 */
public class ZCodeGenerator implements CodeGenerator {

    @Override
    public CodeGeneratorOutput generate(EditorContext context,
                                        GlobalSymbolTable table,
                                        Map<AstNode, Type> typeAnnotations,
                                        StringPool stringPool) {
        return generate(context, table, typeAnnotations, stringPool, new HashMap<>());
    }

    public CodeGeneratorOutput generate(EditorContext context,
                                        GlobalSymbolTable table,
                                        Map<AstNode, Type> typeAnnotations,
                                        StringPool stringPool,
                                        Map<String, List<String>> classLayouts) {

        CodeGeneratorOutput output = new CodeGeneratorOutput(context.getFilePath());
        CodeGenContext ctx = new CodeGenContext();

        ZAstNode ast = (ZAstNode) context.getAstNode();
        if (ast instanceof ProgramNodeZ program) {
            ZCodeGeneratorVisitor visitor = new ZCodeGeneratorVisitor(
                    table, context, typeAnnotations, output, ctx, stringPool, classLayouts);
            program.accept(visitor);
        }

        return output;
    }
}