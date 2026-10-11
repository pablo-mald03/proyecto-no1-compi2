package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.ArrayList;
import java.util.List;

/**
 * Symbol look up service helper class
 *
 */
public class SymbolPigLookupService {

    private final GlobalSymbolTable table;

    public SymbolPigLookupService(GlobalSymbolTable table) {
        this.table = table;
    }


    /**
     * Method to Finds a CLASS or STRUCT symbol by name, anywhere in the project.
     */
    public Symbol findTypeSymbolGlobal(String filePath, String typeName) {
        if (typeName == null) return null;

        List<Symbol> inFile = table.resolveDeepInFile(filePath, typeName);
        for (Symbol s : inFile) {
            if (s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT) {
                return s;
            }
        }

        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol s : bucket) {
                    if ((s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT)
                            && s.getName().equals(typeName)) {
                        return s;
                    }
                }
            }
        }

        SymbolScope global = table.getGlobalScope();
        for (List<Symbol> bucket : global.getSymbols().values()) {
            for (Symbol s : bucket) {
                if ((s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT)
                        && s.getName().equals(typeName)) {
                    return s;
                }
            }
        }
        return null;
    }


    /**
     * Look up to the imports
     */
    public List<Symbol> resolveByName(String name) {
        return table.resolveByName(name);
    }

    /**
     * Find in a specific file
     */
    public List<Symbol> resolveInFile(String filePath, String name) {
        return table.resolveDeepInFile(filePath, name);
    }

    public boolean existsInFile(String filePath, String name, SymbolKind... kinds) {
        for (Symbol s : resolveInFile(filePath, name)) {
            for (SymbolKind k : kinds) {
                if (s.getKind() == k) return true;
            }
        }
        return false;
    }

    public List<Symbol> findImportsInFile(String filePath) {
        List<Symbol> result = new ArrayList<>();
        SymbolScope fileScope = table.getFileScope(filePath);
        if (fileScope == null) return result;
        for (Symbol s : collectAll(fileScope)) {
            if (s.getKind() == SymbolKind.IMPORT) result.add(s);
        }
        return result;
    }

    public List<Symbol> collectAll(SymbolScope scope) {
        List<Symbol> result = new ArrayList<>();
        for (List<Symbol> bucket : scope.getSymbols().values()) {
            result.addAll(bucket);
        }
        for (SymbolScope child : scope.getChildren()) {
            result.addAll(collectAll(child));
        }
        return result;
    }

    public SymbolScope getFileScope(String filePath) {
        return table.getFileScope(filePath);
    }
}