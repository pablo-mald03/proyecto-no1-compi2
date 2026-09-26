package com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.Quadruple;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.CodeGeneratorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.models.CodeGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.serializer.QuadrupleSerializer;

import java.util.List;
import java.util.Map;

public class CodeGeneratorOrchestrator {

    public CodeGeneratorOutput generateAll(Map<String, EditorContext> allContexts,
                                           List<String> topologicalOrder,
                                           GlobalSymbolTable table,
                                           Map<AstNode, Type> typeAnnotations) {

        // For the first version, we only generate code for the Main Class (.pig).
        // And we only generate for .y and .z as needed.
        // For now: generate for the Main Class only.
/*
        for (String filePath : allContexts.keySet()) {
            EditorContext ctx = allContexts.get(filePath);
            if (ctx == null) continue;
            if (".pig".equals(ctx.getFileExtension())) {
                CodeGenerator gen = CodeGeneratorFactory.create(".pig");
                if (gen != null) {
                    return gen.generate(ctx, table, typeAnnotations);
                }
            }
        }*/


        for (String filePath : allContexts.keySet()) {
            EditorContext ctx = allContexts.get(filePath);
            if (ctx != null && ".y".equals(ctx.getFileExtension())) {
                CodeGenerator gen = CodeGeneratorFactory.create(".y");
                if (gen != null) {
                    CodeGeneratorOutput codeOutput = gen.generate(ctx, table, typeAnnotations);
                    QuadrupleSerializer serializer = new QuadrupleSerializer(codeOutput, new StringPool());
                    String finalCompiledCode = serializer.serialize();
                    System.out.println("=== CUARTETAS ===");
                    for (Quadruple q : codeOutput.getQuadruples()) {
                        System.out.println(q);
                    }
                    System.out.println("=== C ===");
                    System.out.println(finalCompiledCode);
                    return null;
                }
            }
        }

        return null;
    }
}