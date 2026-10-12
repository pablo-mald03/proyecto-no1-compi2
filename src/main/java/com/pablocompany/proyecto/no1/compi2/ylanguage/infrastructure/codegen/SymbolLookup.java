package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Principal delcaration collector helper class
 *
 */
public class SymbolLookup {

    private final GlobalSymbolTable table;
    private final Map<AstNode, Symbol> resolvedCalls;
    private Map<String, List<String>> structFields;

    public SymbolLookup(GlobalSymbolTable table, Map<AstNode, Symbol> resolvedCalls) {
        this.table = table;
        this.resolvedCalls = resolvedCalls;
    }

    /**
     * Generate function name declaration
     */
    public Symbol declaration(String filePath, String name, int line, int column) {
        SymbolScope scope = table.getFileScope(filePath);
        if (scope != null) {
            for (Symbol s : scope.resolveLocalByName(name)) {
                if (s.isCallable() && s.getLine() == line && s.getColumn() == column) return s;
            }
        }
        throw new IllegalStateException("Sin símbolo para '" + name + "' en " + filePath + ":" + line + ":" + column);
    }

    /**
     * Symbol helper resolver for the target
     */
    public Symbol target(AstNode call) {
        Symbol s = resolvedCalls.get(call);
        if (s == null) throw new IllegalStateException("La semántica no registró el destino de la llamada: " + call);
        return s;
    }

    /**
     * Struct fields resolver helper
     * */
    public List<String> structFields(String structName) {
        if (structFields == null) {
            structFields = new HashMap<>();
            for (Symbol s : table.getAllSymbols()) {
                if (s.getKind() == SymbolKind.STRUCT && s.getMembers() != null) {
                    structFields.putIfAbsent(s.getName(),
                            s.getMembers().stream().map(Symbol::getName).collect(Collectors.toList()));
                }
            }
        }
        return structFields.get(structName);
    }
}