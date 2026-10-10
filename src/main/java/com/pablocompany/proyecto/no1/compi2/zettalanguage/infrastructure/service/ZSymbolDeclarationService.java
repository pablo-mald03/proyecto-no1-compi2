package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.FieldDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.ConstructorDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;

import java.util.List;

/**
 * Symbol declaration service
 *
 */
public class ZSymbolDeclarationService {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final ZSemanticErrorReporter reporter;

    public ZSymbolDeclarationService(GlobalSymbolTable table, EditorContext context, ZSemanticErrorReporter reporter) {
        this.table = table;
        this.context = context;
        this.reporter = reporter;
    }


    /**
     * Method who declares the class symbol in the current scope.
     */
    public Symbol declareClass(ClassDeclarationNodeZ node) {
        Symbol symbol = base(node.getClassName(), SymbolKind.CLASS, null, node);
        symbol.setQualifiedName(node.getClassName());
        symbol.setAccessModifier(node.getModifier());
        symbol.setParentName(node.getParentName());

        if (!table.declare(symbol)) {
            reporter.reportDuplicate(node.getClassName(), "clase", node);
            return null;
        }
        return symbol;
    }


    /**
     * Method who declares the method symbol. When polymorphism/inheritance arrive, this
     */
    public Symbol declareMethod(MethodDeclarationNodeZ node,
                                List<String> parameterTypes,
                                String returnType) {
        Symbol symbol = base(node.getName(), SymbolKind.METHOD, null, node);
        symbol.getParameterTypes().addAll(parameterTypes);
        symbol.setReturnType(returnType != null ? returnType : "void");
        symbol.setAccessModifier(node.getModifier());
        symbol.setOverriding(node.isOverride());
        symbol.setDeclaringClass(currentClassName());

        if (!table.declare(symbol)) {
            reporter.reportDuplicate(node.getName(), "metodo", node);
            return null;
        }
        return symbol;
    }


    /**
     * Field declaration helper
     *
     */
    public Symbol declareField(FieldDeclarationNodeZ node, String typeName) {
        SymbolKind kind = SymbolKind.ATTRIBUTE;
        Symbol s = base(node.getName(), kind, typeName, node);
        s.setDimensions(node.getDimensions());
        s.setArray(node.getDimensions() > 0);
        s.setAccessModifier(node.getModifier());
        s.setDeclaringClass(currentClassName());

        if (!table.declare(s)) {
            reporter.reportDuplicate(node.getName(), "atributo", node);
            return null;
        }
        return s;
    }


    /**
     * Method who declares the constructor symbol. When inheritance/polymorphism arrive,
     */
    public Symbol declareConstructor(ConstructorDeclarationNodeZ node,
                                     String name,
                                     List<String> parameterTypes) {
        Symbol symbol = base(name, SymbolKind.CONSTRUCTOR, null, node);
        symbol.getParameterTypes().addAll(parameterTypes);
        symbol.setAccessModifier(node.getModifier());
        symbol.setDeclaringClass(currentClassName());

        if (!table.declare(symbol)) {
            reporter.reportDuplicate(name, "constructor", node);
            return null;
        }
        return symbol;
    }


    /**
     * Declares a parameter. When 'this' arrives, this will also register the
     */
    public void declareParameter(ParameterNodeZ param, String typeName) {
        Symbol s = base(param.getName(), SymbolKind.PARAMETER, typeName, param);
        s.setDimensions(param.getDimensions());
        s.setArray(param.isArray());
        if (!table.declare(s)) {
            reporter.reportDuplicate(param.getName(), "parametro", param);
        }
    }


    /**
     * Declares a variable. The kind is auto-detected from the current scope:
     */
    public void declareVariable(String name, String typeName, int dims, ZAstNode node) {
        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.CLASS
                ? SymbolKind.ATTRIBUTE
                : SymbolKind.LOCAL_VARIABLE;
        Symbol s = base(name, kind, typeName, node);
        s.setDimensions(dims);
        s.setArray(dims > 0);
        if (kind == SymbolKind.ATTRIBUTE) s.setDeclaringClass(currentClassName());
        if (!table.declare(s)) {
            String label = kind == SymbolKind.ATTRIBUTE ? "atributo" : "variable";
            reporter.reportDuplicate(name, label, node);
        }
    }

    public void declareArray(String name, String typeName, int dimensions, ZAstNode node) {
        SymbolKind kind = currentKind();
        Symbol s = base(name, kind, typeName, node);
        s.setDimensions(dimensions);
        s.setArray(true);
        if (!table.declare(s)) {
            String label = kind == SymbolKind.ATTRIBUTE ? "arreglo atributo" : "arreglo";
            reporter.reportDuplicate(name, label, node);
        }
    }

    public void declareForVariable(String name, String typeName, ZAstNode node) {
        Symbol s = base(name, SymbolKind.LOCAL_VARIABLE, typeName, node);
        if (!table.declare(s)) {
            reporter.reportDuplicate(name, "variable de for", node);
        }
    }


    /**
     * Registers an implicit `this` symbol in the current method/constructor scope.
     */
    public void declareThis(String className, ZAstNode node) {
        Symbol s = base("this", SymbolKind.THIS, className, node);
        table.declare(s);
    }

    private String currentClassName() {
        SymbolScope scope = table.getCurrentScope();
        while (scope != null && scope.getKind() != SymbolScopeKind.CLASS) {
            scope = scope.getParent();
        }
        return scope != null ? scope.getClassName() : null;
    }


    /**
     * Method to find the current kind
     *
     */
    private SymbolKind currentKind() {
        return table.getCurrentScope().getKind() == SymbolScopeKind.CLASS
                ? SymbolKind.ATTRIBUTE
                : SymbolKind.LOCAL_VARIABLE;
    }

    /**
     * Method to declarate the base symbol
     *
     */
    private Symbol base(String name, SymbolKind kind, String type, ZAstNode node) {
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