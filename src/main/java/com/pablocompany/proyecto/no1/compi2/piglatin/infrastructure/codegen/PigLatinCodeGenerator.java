package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigLatinCodeGeneratorVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal class code generator
 *
 */
public class PigLatinCodeGenerator implements CodeGenerator {

    @Override
    public CodeGeneratorOutput generate(EditorContext context,
                                        GlobalSymbolTable table,
                                        Map<AstNode, Type> typeAnnotations,
                                        StringPool stringPool) {
        CodeGeneratorOutput output = new CodeGeneratorOutput(context.getFilePath());
        CodeGenContext ctx = new CodeGenContext();

        PigLatinAstNode ast = (PigLatinAstNode) context.getAstNode();
        if (ast instanceof ProgramNodePigLatin program) {
            PigLatinCodeGeneratorVisitor visitor = new PigLatinCodeGeneratorVisitor(
                    table, context, typeAnnotations, output, ctx, stringPool, new HashMap<>());
            program.accept(visitor);
        }
        return output;
    }

    public void generate(EditorContext context,
                         GlobalSymbolTable table,
                         Map<AstNode, Type> typeAnnotations,
                         StringPool stringPool,
                         Map<String, List<String>> classLayouts,
                         CodeGeneratorOutput sharedOutput) {

        CodeGenContext ctx = new CodeGenContext();

        PigLatinAstNode ast = (PigLatinAstNode) context.getAstNode();
        if (ast instanceof ProgramNodePigLatin program) {
            PigLatinCodeGeneratorVisitor visitor = new PigLatinCodeGeneratorVisitor(
                    table, context, typeAnnotations, sharedOutput, ctx, stringPool, classLayouts);
            program.accept(visitor);
        }
    }
}