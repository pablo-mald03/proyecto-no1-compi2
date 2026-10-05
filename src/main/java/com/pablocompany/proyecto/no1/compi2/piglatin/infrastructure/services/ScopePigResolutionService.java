package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

/**
 * Scope resolution service helper
 *
 */
public class ScopePigResolutionService {
    private final GlobalSymbolTable table;
    private final EditorContext context;

    public ScopePigResolutionService(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    /**
     * Register a new scope and return it key
     */
    public SymbolScope registerScope(PigLatinAstNode node, SymbolScopeKind kind) {
        SymbolScope scope = table.enterScope(kind, context.getFilePath());
        table.registerScope(buildKey(node), scope);
        return scope;
    }

    /**
     * Method to look up the registered scope
     *
     */
    public SymbolScope lookupRegisteredScope(PigLatinAstNode node) {
        return table.getRegisteredScope(buildKey(node));
    }

    /**
     * Helper to build key
     *
     */
    private String buildKey(PigLatinAstNode node) {
        return GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn());
    }
}