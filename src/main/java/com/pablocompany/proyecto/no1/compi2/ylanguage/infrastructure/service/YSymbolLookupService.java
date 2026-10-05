package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.List;

/**
 * Symbol lookup service class
 *
 */
public class YSymbolLookupService {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public YSymbolLookupService(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    public List<Symbol> resolveByName(String name) {
        return table.resolveByName(name);
    }

    public Symbol findStruct(String structName) {
        if (structName == null) return null;
        return firstOfKind(inFile(structName), SymbolKind.STRUCT);
    }

    public Symbol findType(String typeName) {
        if (typeName == null) return null;

        Symbol s = firstOfKind(inFile(typeName), SymbolKind.STRUCT);
        if (s != null) return s;
        s = firstOfKind(inFile(typeName), SymbolKind.CLASS);
        if (s != null) return s;

        // Fallback: cross-file lookup
        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol symbol : bucket) {
                    if ((symbol.getKind() == SymbolKind.STRUCT
                            || symbol.getKind() == SymbolKind.CLASS)
                            && symbol.getName().equals(typeName)) {
                        return symbol;
                    }
                }
            }
        }
        return null;
    }

    public Symbol findMemberInStruct(Type structType, String memberName) {
        if (structType == null || !structType.isCustom()) return null;
        if (memberName == null) return null;

        Symbol struct = findStruct(structType.getCustomName());
        if (struct == null) return null;

        List<Symbol> members = struct.getMembers();
        if (members == null) return null;

        for (Symbol m : members) {
            if (memberName.equals(m.getName())) return m;
        }
        return null;
    }

    // -------- private helpers --------

    private List<Symbol> inFile(String name) {
        return table.resolveDeepInFile(context.getFilePath(), name);
    }

    private Symbol firstOfKind(List<Symbol> symbols, SymbolKind kind) {
        for (Symbol s : symbols) {
            if (s.getKind() == kind) return s;
        }
        return null;
    }
}