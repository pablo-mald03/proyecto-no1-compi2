package com.pablocompany.proyecto.no1.compi2.common.domain.orchestator;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.TypeChecker;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.TypeCheckerFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Principal type checker orchestator
 *
 */
public class TypeCheckerOrchestrator {

    /**
     * Method to start the checking at all files
     *
     */
    public void checkAll(Map<String, EditorContext> allContexts,
                         List<String> topologicalOrder,
                         GlobalSymbolTable table,
                         Map<AstNode, Type> typeAnnotations) {

        Set<String> processed = new HashSet<>();

        // Pass 1: .y and .z
        for (String filePath : allContexts.keySet()) {
            EditorContext ctx = allContexts.get(filePath);
            if (ctx == null) continue;
            String ext = ctx.getFileExtension();
            if (".y".equals(ext) || ".z".equals(ext)) {
                checkOne(filePath, allContexts, table, typeAnnotations);
                processed.add(filePath);
            }
        }

        // Pass 2: .pig in topological order
        for (String filePath : topologicalOrder) {
            if (!processed.contains(filePath)) {
                checkOne(filePath, allContexts, table, typeAnnotations);
                processed.add(filePath);
            }
        }

        // Pass 3: remaining.
        for (String filePath : allContexts.keySet()) {
            if (!processed.contains(filePath)) {
                checkOne(filePath, allContexts, table, typeAnnotations);
            }
        }
    }

    /**
     * Method to check one by one file
     *
     */
    private void checkOne(String filePath,
                          Map<String, EditorContext> allContexts,
                          GlobalSymbolTable table,
                          Map<AstNode, Type> typeAnnotations) {
        EditorContext context = allContexts.get(filePath);
        if (context == null) return;

        String extension = context.getFileExtension();
        if (extension == null) return;

        TypeChecker checker = TypeCheckerFactory.create(extension);
        if (checker == null) return;

        checker.check(context, table, typeAnnotations);
    }
}