package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The central symbol table shared across all files in the project.
 * Holds a global scope plus one file scope per source file.
 */
@Data
public class GlobalSymbolTable {

    private SymbolScope globalScope;
    private Map<String, SymbolScope> fileScopes;
    private SymbolScope currentScope;

    public GlobalSymbolTable() {
        this.globalScope = new SymbolScope(SymbolScopeKind.GLOBAL, null, null);
        this.fileScopes = new HashMap<>();
        this.currentScope = this.globalScope;
    }

    /**
     * Returns (or creates) the file scope for a given filePath.
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
     * Returns false if a duplicate signature exists.
     */
    public boolean declare(Symbol symbol) {
        return currentScope.declare(symbol);
    }

    /**
     * Resolves a symbol by signatureKey, walking up from the current scope
     * all the way to the global scope.
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
     * Used to bridge imports: the .pig's ImportSymbol points to the target file scope.
     */
    public SymbolScope getFileScope(String filePath) {
        return fileScopes.get(filePath);
    }

    /**
     * Resets the dynamic pointer back to the global scope.
     * Useful at the start of each visitor run.
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