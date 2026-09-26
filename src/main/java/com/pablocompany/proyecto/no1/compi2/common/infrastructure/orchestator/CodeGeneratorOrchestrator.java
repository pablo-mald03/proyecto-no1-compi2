package com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.CodeGeneratorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.serializer.QuadrupleSerializer;

import java.util.Map;

/**
 * Principal code generator orchestator
 *
 */
public class CodeGeneratorOrchestrator {

    /**
     * Principal method to generate all 3D code
     *
     */
    public String generateAll(Map<String, EditorContext> allContexts,
                              GlobalSymbolTable table,
                              Map<AstNode, Type> typeAnnotations,
                              String mainClassPath) {

        CodeGeneratorOutput combined = new CodeGeneratorOutput("<combined>");
        StringPool stringPool = new StringPool();

        // --- .y ---
        for (String filePath : allContexts.keySet()) {
            EditorContext ctx = allContexts.get(filePath);
            if (ctx == null) continue;
            if (!".y".equals(ctx.getFileExtension())) continue;

            CodeGenerator gen = CodeGeneratorFactory.create(".y");
            if (gen == null) continue;

            CodeGeneratorOutput out = gen.generate(ctx, table, typeAnnotations, stringPool);
            combined.getQuadruples().addAll(out.getQuadruples());
            combined.getFunctionNames().addAll(out.getFunctionNames());

        }

        EditorContext mainCtx = allContexts.get(mainClassPath);
        if (mainCtx != null) {
            CodeGenerator gen = CodeGeneratorFactory.create(".pig");
            if (gen != null) {
                CodeGeneratorOutput out = gen.generate(mainCtx, table, typeAnnotations, stringPool);
                combined.getQuadruples().addAll(out.getQuadruples());
                combined.getFunctionNames().addAll(out.getFunctionNames());
            }
        } else {
            System.out.println("MAIN CTX NOT FOUND: " + mainClassPath);
        }

        QuadrupleSerializer serializer = new QuadrupleSerializer(combined, stringPool);
        String finalC = serializer.serialize();

        System.out.println(finalC);

        return finalC;
    }
}