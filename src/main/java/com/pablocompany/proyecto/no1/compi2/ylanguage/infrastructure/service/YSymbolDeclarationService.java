package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ArrayParameterNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ParameterNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.PrimitiveParameterNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.StructParameterNodeY;

import java.util.List;

/**
 * Principal symbol declaration service helper class
 *
 */
public class YSymbolDeclarationService {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final YSemanticErrorReporter reporter;

    public YSymbolDeclarationService(GlobalSymbolTable table,
                                     EditorContext context,
                                     YSemanticErrorReporter reporter) {
        this.table = table;
        this.context = context;
        this.reporter = reporter;
    }

    public void declareVariable(String name, TypeNodeY type, YAstNode node) {
        declare(name, SymbolKind.LOCAL_VARIABLE, resolveTypeName(type), node, "variable");
    }

    public void declareArray(String name, TypeNodeY type, int dims, YAstNode node) {
        Symbol s = base(name, SymbolKind.LOCAL_VARIABLE, resolveTypeName(type), node);
        s.setDimensions(dims);
        s.setArray(true);
        if (!table.declare(s)) reporter.reportDuplicate(name, "arreglo", node);
    }

    public void declareStructInstance(String name, String structType, YAstNode node) {
        declare(name, SymbolKind.LOCAL_VARIABLE, structType, node, "instancia de struct");
    }

    public void declareForVariable(String name, TypeNodeY type, YAstNode node) {
        declare(name, SymbolKind.LOCAL_VARIABLE, resolveTypeName(type), node, "variable de for");
    }

    public void declareStruct(String name, YAstNode node, List<Symbol> members) {
        Symbol s = base(name, SymbolKind.STRUCT, name, node);
        s.setQualifiedName(name);
        s.setMembers(members);
        if (!table.declare(s)) reporter.reportDuplicate(name, "struct", node);
    }

    public void declareFunction(String name, YAstNode node,
                                List<String> parameterTypes, String returnType,
                                SymbolKind kind, String label) {
        Symbol s = base(name, kind, null, node);
        s.getParameterTypes().addAll(parameterTypes);
        s.setReturnType(returnType != null ? returnType : "void");
        if (!table.declare(s)) reporter.reportDuplicate(name, label, node);
    }

    public void declareParameter(ParameterNodeY param, YAstNode node) {
        String typeName = resolveParameterType(param);
        Symbol p = base(param.getIdentifier(), SymbolKind.PARAMETER, typeName, node);
        p.setDimensions(param.getDimensions());
        p.setArray(param.isArray());
        p.setParameterKind(param.getKind());
        if (!table.declare(p)) reporter.reportDuplicate(param.getIdentifier(), "parametro", node);
    }

    // -------- private helpers --------

    private void declare(String name, SymbolKind kind, String type, YAstNode node, String label) {
        Symbol s = base(name, kind, type, node);
        if (!table.declare(s)) reporter.reportDuplicate(name, label, node);
    }

    private Symbol base(String name, SymbolKind kind, String type, YAstNode node) {
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

    private String resolveTypeName(TypeNodeY typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    private String resolveParameterType(ParameterNodeY node) {
        if (node instanceof StructParameterNodeY s) return resolveTypeName(s.getDataType());
        if (node instanceof ArrayParameterNodeY a) return resolveTypeName(a.getElementType());
        if (node instanceof PrimitiveParameterNodeY p) return resolveTypeName(p.getType());
        return resolveTypeName(node.getType());
    }
}