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
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZClassLayoutService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZInheritanceService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSymbolLookupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Principal code generator orchestator
 *
 */
public class CodeGeneratorOrchestrator {
    private IntermediateProgram lastProgram;

    public IntermediateProgram buildProgram(Map<String, EditorContext> allContexts, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations, Map<AstNode, Symbol> resolvedCalls, String mainClassPath) {

        IntermediateBuilder intermediate = new IntermediateBuilder("program", "str");
        CodeGenContext labels = new CodeGenContext();

        ZClassLayoutService layoutService = new ZClassLayoutService(table, new ZInheritanceService(new ZSymbolLookupService(table)));
        for (Symbol cls : layoutService.collectLinkedClasses()) {
            List<String> entries = new ArrayList<>();
            for (Symbol m : cls.getVtable()) {
                entries.add(com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.naming.NameMangler.codeLabel(m));
            }
            intermediate.addVTable(cls.getVtableLabel(), entries);
        }

        for (EditorContext ctx : contextsOf(allContexts, ".y", mainClassPath)) {
            CodeGeneratorFactory.create(".y").generate(ctx, table, typeAnnotations, resolvedCalls, intermediate, labels);
        }
        for (EditorContext ctx : contextsOf(allContexts, ".z", mainClassPath)) {
            CodeGeneratorFactory.create(".z").generate(ctx, table, typeAnnotations, resolvedCalls, intermediate, labels);
        }
        EditorContext mainCtx = allContexts.get(mainClassPath);
        if (mainCtx != null) {
            CodeGeneratorFactory.create(".pig").generate(mainCtx, table, typeAnnotations, resolvedCalls, intermediate, labels);
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