package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

import java.util.List;

/**
 * Principal service for import resolution helper class
 *
 */
public class ImportPigResolutionService {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final SemanticPigErrorReporterService reporter;
    private final SymbolPigLookupService lookup;

    public ImportPigResolutionService(GlobalSymbolTable table,
                                      EditorContext context,
                                      SemanticPigErrorReporterService reporter,
                                      SymbolPigLookupService lookup) {
        this.table = table;
        this.context = context;
        this.reporter = reporter;
        this.lookup = lookup;
    }

    public String extractLogicalName(String rawPath) {
        if (rawPath == null) return null;
        int lastDot = rawPath.lastIndexOf('.');
        String withoutExt = lastDot != -1 ? rawPath.substring(0, lastDot) : rawPath;
        int lastSep = withoutExt.lastIndexOf('.');
        return lastSep != -1 ? withoutExt.substring(lastSep + 1) : withoutExt;
    }

    /**
     * Method to bring the imported symbols from another scopes
     *
     */
    public void bringImportedSymbols(String resolvedPath, PigLatinAstNode node) {
        if (resolvedPath == null) return;
        SymbolScope importedScope = table.getFileScope(resolvedPath);
        if (importedScope == null) return;

        for (List<Symbol> bucket : importedScope.getSymbols().values()) {
            for (Symbol symbol : bucket) {
                if (!isImportable(symbol.getKind())) continue;

                Symbol copy = copy(symbol);
                table.declare(copy);
            }
        }
    }

    /**
     * Helper to validate if its importable
     *
     */
    private boolean isImportable(SymbolKind kind) {
        return kind == SymbolKind.STRUCT
                || kind == SymbolKind.FUNCTION
                || kind == SymbolKind.CLASS;
    }

    /**
     * Helper to copty the attributes from symbol
     *
     */
    private Symbol copy(Symbol src) {
        Symbol c = new Symbol();
        c.setName(src.getName());
        c.setKind(src.getKind());
        c.setType(src.getType());
        c.setQualifiedName(src.getQualifiedName());
        c.setFilePath(src.getFilePath());
        c.setFileName(src.getFileName());
        c.setLine(src.getLine());
        c.setColumn(src.getColumn());
        c.setParameterTypes(src.getParameterTypes());
        c.setMembers(src.getMembers());
        c.setReturnType(src.getReturnType());
        c.setArray(src.isArray());
        c.setDimensions(src.getDimensions());
        return c;
    }

    /**
     * Method to validate if the type exists
     */
    public boolean typeExists(String typeName, PigLatinAstNode node) {
        if (lookup.existsInFile(context.getFilePath(), typeName,
                SymbolKind.STRUCT, SymbolKind.CLASS)) {
            return true;
        }
        for (Symbol imported : lookup.findImportsInFile(context.getFilePath())) {
            String path = imported.getType();
            if (path == null) continue;
            SymbolScope target = table.getFileScope(path);
            if (target == null) continue;
            if (!target.resolveDeepByName(typeName).isEmpty()) return true;
        }
        return false;
    }

    /**
     * Method to validate if the member exists
     */
    public void validateMemberOfImport(Symbol importSymbol, String memberName, PigLatinAstNode node) {
        String targetPath = importSymbol.getType();
        if (targetPath == null) return;
        SymbolScope target = table.getFileScope(targetPath);
        if (target == null) return;
        if (target.resolveDeepByName(memberName).isEmpty()) {
            reporter.reportUndeclared(memberName, node);
        }
    }

    /**
     * Method to resolve the direct calling for any function
     */
    public void validateDirectCall(String functionName, PigLatinAstNode node) {
        List<Symbol> local = lookup.resolveInFile(context.getFilePath(), functionName);
        for (Symbol s : local) {
            if (s.getKind() != SymbolKind.IMPORT) return;
        }
        for (Symbol imported : lookup.findImportsInFile(context.getFilePath())) {
            String path = imported.getType();
            if (path == null || !path.endsWith(".y")) continue;
            SymbolScope target = table.getFileScope(path);
            if (target == null) continue;
            if (!target.resolveDeepByName(functionName).isEmpty()) return;
        }
        reporter.reportUndeclared(functionName, node);
    }

    /**
     * Method to try to resolve the import target
     */
    public Symbol resolveImportTarget(String name) {
        for (Symbol s : lookup.resolveInFile(context.getFilePath(), name)) {
            if (s.getKind() == SymbolKind.IMPORT) return s;
        }
        return null;
    }
}