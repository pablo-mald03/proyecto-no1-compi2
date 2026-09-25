package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The central symbol table shared across all files in the project.
 */
@Data
public class GlobalSymbolTable {

    private SymbolScope globalScope;
    private Map<String, SymbolScope> fileScopes;
    private SymbolScope currentScope;

    private Map<String, SymbolScope> scopeRegistry;

    public GlobalSymbolTable() {
        this.globalScope = new SymbolScope(SymbolScopeKind.GLOBAL, null, null);
        this.fileScopes = new HashMap<>();
        this.currentScope = this.globalScope;
        this.scopeRegistry = new HashMap<>();
    }

    /**
     * Registers a scope under a key derived from the AST node that created it.
     */
    public void registerScope(String scopeKey, SymbolScope scope) {
        scopeRegistry.put(scopeKey, scope);
    }

    /**
     * Retrieves a scope previously registered by a collector.
     */
    public SymbolScope getRegisteredScope(String scopeKey) {
        return scopeRegistry.get(scopeKey);
    }

    /**
     * Builds the canonical key for a scope created by an AST node.
     */
    public static String buildScopeKey(String filePath, String nodeType, int line, int column) {
        return filePath + ":" + nodeType + ":" + line + ":" + column;
    }

    /**
     * Clears the scope registry. Called between compilation runs.
     */
    public void clearScopeRegistry() {
        scopeRegistry.clear();
    }

    /**
     * Returns the file scope for a given filePath.
     */
    public SymbolScope getOrCreateFileScope(String filePath) {
        return fileScopes.computeIfAbsent(filePath, k ->
                new SymbolScope(SymbolScopeKind.FILE, globalScope, filePath)
        );
    }

    public List<Symbol> resolveDeepInFile(String filePath, String name) {
        SymbolScope fileScope = fileScopes.get(filePath);
        if (fileScope == null) return new ArrayList<>();
        return fileScope.resolveDeepByName(name);
    }

    /**
     * Enters a new scope of the given kind as a child of the current scope.
     */
    public SymbolScope enterScope(SymbolScopeKind kind, String ownerPath) {
        SymbolScope scope = new SymbolScope(kind, currentScope, ownerPath);
        currentScope = scope;
        return scope;
    }

    /**
     * Exits the current scope, moving the pointer back to the parent.
     */
    public void exitScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    /**
     * Declares a symbol in the current scope.
     */
    public boolean declare(Symbol symbol) {
        if (symbol.getKind() == SymbolKind.LOCAL_VARIABLE
                || symbol.getKind() == SymbolKind.PARAMETER) {

            SymbolScope scope = currentScope.getParent();
            while (scope != null) {
                List<Symbol> found = scope.resolveLocalByName(symbol.getName());
                for (Symbol existing : found) {
                    if (existing.getKind() == SymbolKind.LOCAL_VARIABLE
                            || existing.getKind() == SymbolKind.PARAMETER) {
                        return false;
                    }
                }
                scope = scope.getParent();
            }
        }

        return currentScope.declare(symbol);
    }

    /**
     * Resolves a symbol by signatureKey, walking up from the current scope
     */
    public Symbol resolve(String signatureKey) {
        SymbolScope scope = currentScope;
        while (scope != null) {
            Symbol found = scope.resolveLocal(signatureKey);
            if (found != null) {
                return found;
            }
            scope = scope.getParent();
        }
        return null;
    }

    /**
     * Resolves all symbols with the given simple name, walking up from the current scope.
     */
    public List<Symbol> resolveByName(String name) {
        SymbolScope scope = currentScope;
        while (scope != null) {
            List<Symbol> found = scope.resolveLocalByName(name);
            if (!found.isEmpty()) {
                return found;
            }
            scope = scope.getParent();
        }
        return new ArrayList<>();
    }

    /**
     * Looks up a file scope directly by filePath.
     */
    public SymbolScope getFileScope(String filePath) {
        return fileScopes.get(filePath);
    }

    /**
     * Resets the dynamic pointer back to the global scope.
     */
    public void resetToGlobal() {
        this.currentScope = this.globalScope;
    }

    /**
     * Sets the current scope pointer explicitly.
     */
    public void setCurrentScope(SymbolScope scope) {
        this.currentScope = scope;
    }

    /**
     * Declares a symbol, replacing any existing symbol with the same signature.
     */
    public void declareOrReplace(Symbol symbol) {
        String key = symbol.getSignatureKey();
        List<Symbol> bucket = currentScope.getSymbols()
                .computeIfAbsent(key, k -> new ArrayList<>());
        bucket.clear();
        bucket.add(symbol);
    }

}