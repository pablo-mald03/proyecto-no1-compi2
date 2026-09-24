package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A lexical scope. Holds symbols declared in this scope.
 * Symbols are stored in a map keyed by signatureKey, allowing overloads.
 */
@Data
public class SymbolScope {

    private SymbolScopeKind kind;
    private SymbolScope parent;
    private String ownerPath;        // filePath that owns this scope (null for global)
    private Map<String, List<Symbol>> symbols;
    private List<SymbolScope> children;

    public SymbolScope() {
        this.symbols = new HashMap<>();
        this.children = new ArrayList<>();
    }

    public SymbolScope(SymbolScopeKind kind, SymbolScope parent, String ownerPath) {
        this.kind = kind;
        this.parent = parent;
        this.ownerPath = ownerPath;
        this.symbols = new HashMap<>();
        this.children = new ArrayList<>();
        if (parent != null) {
            parent.getChildren().add(this);
        }
    }
    /**
     * Declares a symbol in this scope.
     */
    public boolean declare(Symbol symbol) {
        String key = symbol.getSignatureKey();
        List<Symbol> bucket = symbols.computeIfAbsent(key, k -> new ArrayList<>());

        for (Symbol existing : bucket) {
            if (existing.getSignatureKey().equals(key)) {
                return false;
            }
        }
        bucket.add(symbol);
        return true;
    }

    /**
     * Looks up a symbol by signatureKey in this scope only
     */
    public Symbol resolveLocal(String signatureKey) {
        List<Symbol> bucket = symbols.get(signatureKey);
        if (bucket == null || bucket.isEmpty()) {
            return null;
        }
        return bucket.get(0);
    }

    /**
     * Deep search: this scope + all descendants.
     */
    public List<Symbol> resolveDeepByName(String name) {
        List<Symbol> result = new ArrayList<>(resolveLocalByName(name));
        for (SymbolScope child : children) {
            result.addAll(child.resolveDeepByName(name));
        }
        return result;
    }

    /**
     * Looks up a symbol by simple name in this scope only.
     */
    public List<Symbol> resolveLocalByName(String name) {
        List<Symbol> result = new ArrayList<>();
        for (List<Symbol> bucket : symbols.values()) {
            for (Symbol symbol : bucket) {
                if (symbol.getName().equals(name)) {
                    result.add(symbol);
                }
            }
        }
        return result;
    }

    /**
     * Helper to validate if the scope is global
     *
     */
    public boolean isGlobal() {
        return kind == SymbolScopeKind.GLOBAL;
    }

}