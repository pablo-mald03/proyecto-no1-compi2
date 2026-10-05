package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;

/**
 * Principal scope resolver service helper class
 *
 */
public class YScopeService {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public YScopeService(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    /**
     * Creates a new scope of the given kind and registers it under a key
     */
    public SymbolScope registerScope(YAstNode node, SymbolScopeKind kind) {
        SymbolScope scope = table.enterScope(kind, context.getFilePath());
        table.registerScope(buildKey(node), scope);
        return scope;
    }

    /**
     * Looks up the scope that was registered for the given node.
     */
    public SymbolScope lookupRegisteredScope(YAstNode node) {
        return table.getRegisteredScope(buildKey(node));
    }

    /**
     * Runs inside the scope registered for {@code node},
     */
    public void withScope(YAstNode node, Runnable body) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }
        try {
            body.run();
        } finally {
            table.setCurrentScope(previous);
        }
    }

    /**
     * Single source of truth for the scope key. Both registerScope and
     */
    private String buildKey(YAstNode node) {
        return GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn());
    }
}