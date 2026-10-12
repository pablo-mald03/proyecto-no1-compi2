package com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.CodeGeneratorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.codegen.PigLatinCodeGenerator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.VariableDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.codegenerator.ZCodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal code generator orchestator
 *
 */
public class CodeGeneratorOrchestrator {
    private IntermediateProgram lastProgram;

    public IntermediateProgram buildProgram(Map<String, EditorContext> allContexts, GlobalSymbolTable table,
                                            Map<AstNode, Type> typeAnnotations, String mainClassPath) {
        IntermediateBuilder intermediate = new IntermediateBuilder("program", "str");
        CodeGenContext labels = new CodeGenContext();
        Map<String, List<String>> layouts = collectClassLayouts(allContexts);

        for (EditorContext ctx : contextsOf(allContexts, ".y", mainClassPath)) {
            CodeGeneratorFactory.create(".y").generate(ctx, table, typeAnnotations, intermediate, labels);
        }
        for (EditorContext ctx : contextsOf(allContexts, ".z", mainClassPath)) {
            ((ZCodeGenerator) CodeGeneratorFactory.create(".z"))
                    .generate(ctx, table, typeAnnotations, intermediate, labels, layouts);
        }
        EditorContext mainCtx = allContexts.get(mainClassPath);
        if (mainCtx != null) {
            ((PigLatinCodeGenerator) CodeGeneratorFactory.create(".pig"))
                    .generate(mainCtx, table, typeAnnotations, intermediate, labels, layouts);
        }
        lastProgram = intermediate.build();
        return lastProgram;
    }

    /**
     * Extension context generation code
     */
    private List<EditorContext> contextsOf(Map<String, EditorContext> all, String ext, String firstPath) {
        List<EditorContext> result = new ArrayList<>();
        EditorContext first = all.get(firstPath);
        if (first != null && ext.equals(first.getFileExtension())) result.add(first);
        for (Map.Entry<String, EditorContext> e : all.entrySet()) {
            EditorContext c = e.getValue();
            if (c != null && c != first && ext.equals(c.getFileExtension())) result.add(c);
        }
        return result;
    }

    /**
     * Collect class layouts helper method
     *
     */
    private Map<String, List<String>> collectClassLayouts(Map<String, EditorContext> allContexts) {
        Map<String, List<String>> layouts = new HashMap<>();
        for (EditorContext ctx : allContexts.values()) {
            if (ctx == null || !".z".equals(ctx.getFileExtension())) continue;
            ZAstNode ast = (ZAstNode) ctx.getAstNode();
            if (ast instanceof ProgramNodeZ program && program.getClassNode() != null) {
                ClassDeclarationNodeZ cls = program.getClassNode();
                List<String> fields = new ArrayList<>();
                if (cls.getMembers() != null) {
                    for (ZAstNode member : cls.getMembers()) {
                        if (member instanceof VariableDeclarationNodeZ attr) fields.add(attr.getIdentifier());
                    }
                }
                layouts.put(cls.getClassName(), fields);
            }
        }
        return layouts;
    }

    /**
     * Dump instructions
     *
     */
    public String dumpInstructions() {
        if (lastProgram == null) return "";
        StringBuilder sb = new StringBuilder();
        for (IntermediateFunction f : lastProgram.getFunctions()) {
            sb.append(f.getName()).append(":\n");
            int i = 0;
            for (Instruction ins : f.getBody()) sb.append(String.format("  %-4d %s%n", i++, ins));
        }
        return sb.toString();
    }
}