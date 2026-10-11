package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;

/**
 * Principal symbol declaration service
 *
 */
public class SymbolPigDeclarationService {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final SemanticPigErrorReporterService reporter;
    private final TypePigResolutionService types;

    public SymbolPigDeclarationService(GlobalSymbolTable table,
                                       EditorContext context,
                                       SemanticPigErrorReporterService reporter,
                                       TypePigResolutionService types) {
        this.table = table;
        this.context = context;
        this.reporter = reporter;
        this.types = types;
    }

    public void declareVariable(String name, TypeNodePigLatin type, PigLatinAstNode node) {
        declare(name, currentKind(), types.resolveTypeName(type), node, "variable");
    }

    public void declareArray(String name, TypeNodePigLatin type, int dims, PigLatinAstNode node) {
        Symbol s = base(name, currentKind(), types.resolveTypeName(type), node);
        s.setArray(true);
        s.setDimensions(dims);
        if (!table.declare(s)) reporter.reportDuplicate(name, "arreglo", node);
    }

    public void declareStructInstance(String name, String structType, PigLatinAstNode node) {
        declare(name, currentKind(), structType, node, "instancia de struct");
    }

    public void declareForVariable(String name, TypeNodePigLatin type, PigLatinAstNode node) {
        declare(name, SymbolKind.LOCAL_VARIABLE,
                types.resolveTypeName(type), node, "variable de for");
    }

    public void declareImport(String logicalName, String resolvedPath, PigLatinAstNode node) {
        Symbol s = base(logicalName, SymbolKind.IMPORT, resolvedPath, node);
        s.setQualifiedName(resolvedPath);
        if (!table.declare(s)) reporter.reportDuplicate(logicalName, "import", node);
    }

    public void declareStruct(String name, PigLatinAstNode node, java.util.List<Symbol> members) {
        Symbol s = base(name, SymbolKind.STRUCT, name, node);
        s.setMembers(members);
        if (!table.declare(s)) reporter.reportDuplicate(name, "struct", node);
    }

    private void declare(String name, SymbolKind kind, String type,
                         PigLatinAstNode node, String label) {
        Symbol s = base(name, kind, type, node);
        if (!table.declare(s)) reporter.reportDuplicate(name, label, node);
    }

    private SymbolKind currentKind() {
        SymbolScopeKind k = table.getCurrentScope().getKind();
        return (k == SymbolScopeKind.FILE || k == SymbolScopeKind.GLOBAL)
                ? SymbolKind.GLOBAL_VARIABLE
                : SymbolKind.LOCAL_VARIABLE;
    }

    private Symbol base(String name, SymbolKind kind, String type, PigLatinAstNode node) {
        Symbol s = new Symbol();
        s.setName(name);
        s.setKind(kind);
        s.setType(type);
        s.setFilePath(context.getFilePath());
        s.setFileName(context.getFileName());
        s.setLine(node.getLine());
        s.setColumn(node.getColumn());
        return s;
    }
}

