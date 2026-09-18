package com.pablocompany.proyecto.no1.compi2.common.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.SymbolCollectorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.SymbolTableFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Principal method to start the symbol collection pass over all files in topological order.
 */
public class SymbolCollectorOrchestrator {


    /**
     * Principal port to collect all symbols
     *
     */
    public GlobalSymbolTable collectAll(Map<String, EditorContext> allContexts, List<String> topologicalOrder) {

        GlobalSymbolTable table = SymbolTableFactory.create();
        Set<String> processed = new HashSet<>();

        // Topological order (dependencies first registered at the dependency graph)
        for (String filePath : topologicalOrder) {
            collectOne(filePath, allContexts, table);
            processed.add(filePath);
        }

        // Any file not in the graph (unused .z/.y)
        for (String filePath : allContexts.keySet()) {
            if (!processed.contains(filePath)) {
                collectOne(filePath, allContexts, table);
            }
        }

        return table;
    }

    /**
     * Principal method to collect the symbols in the tree order
     */
    private void collectOne(String filePath, Map<String, EditorContext> allContexts,
                            GlobalSymbolTable table) {
        EditorContext context = allContexts.get(filePath);
        if (context == null) {
            return;
        }

        String extension = context.getFileExtension();
        if (extension == null) {
            return;
        }

        SymbolCollector collector = SymbolCollectorFactory.create(extension);
        if (collector == null) {
            return;
        }

        collector.collect(context, table);
    }

}