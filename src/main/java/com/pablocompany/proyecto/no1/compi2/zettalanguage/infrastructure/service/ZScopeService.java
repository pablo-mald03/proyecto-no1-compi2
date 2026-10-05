package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

public class ZScopeService {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public ZScopeService(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    /**
     * Creates a new scope of the given kind and registers it under a key
     */
    public SymbolScope registerScope(ZAstNode node, SymbolScopeKind kind) {
        SymbolScope scope = table.enterScope(kind, context.getFilePath());
        table.registerScope(buildKey(node), scope);
        return scope;
    }

    public SymbolScope lookupRegisteredScope(ZAstNode node) {
        return table.getRegisteredScope(buildKey(node));
    }

    /**
     * Method to runs inside the scope registered for {@code node},
     */
    public void withScope(ZAstNode node, Runnable body) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);
        try {
            body.run();
        } finally {
            table.setCurrentScope(previous);
        }
    }

    /**
     * Method to build the key for the symbol
     *
     */
    private String buildKey(ZAstNode node) {
        return GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn());
    }
}