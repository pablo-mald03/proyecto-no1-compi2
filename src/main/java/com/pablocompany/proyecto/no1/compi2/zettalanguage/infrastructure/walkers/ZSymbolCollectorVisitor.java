package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.InstanceCreationExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.FieldDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.VariableDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.ConstructorDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.CodeBodyNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZClassMemberCollectorService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZScopeService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSemanticErrorReporter;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSymbolDeclarationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal symbol collector visitor
 *
 */
public class ZSymbolCollectorVisitor implements ZAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    private final ZSemanticErrorReporter reporter;
    private final ZScopeService scopes;
    private final ZSymbolDeclarationService declarations;
    private final ZClassMemberCollectorService classMembers;

    public ZSymbolCollectorVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
        this.reporter = new ZSemanticErrorReporter(context);
        this.scopes = new ZScopeService(table, context);
        this.declarations = new ZSymbolDeclarationService(table, context, reporter);
        this.classMembers = new ZClassMemberCollectorService();
    }

    // ============================================================
    // PROGRAM
    // ============================================================

    @Override
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) {
            node.getClassNode().accept(this);
        }
        return null;
    }

    // ============================================================
    // CLASS
    // ============================================================

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        Symbol classSymbol = declarations.declareClass(node);

        classMembers.begin();

        scopes.registerScope(node, SymbolScopeKind.CLASS);
        try {
            if (node.getMembers() != null) {
                for (ZAstNode m : node.getMembers()) {
                    if (m != null) m.accept(this);
                }
            }
        } finally {
            table.exitScope();
        }

        Symbol parent = classSymbol != null && classSymbol.getParentName() != null
                ? lookupClassInFile(classSymbol.getParentName())
                : null;
        if (classSymbol != null) {
            classSymbol.setMembers(classMembers.end(parent));
        } else {
            classMembers.end(null);
        }
        return null;
    }

    // ============================================================
    // METHODS / CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        List<String> paramTypes = collectParameterTypes(node.getParams());

        String returnType = node.getType() != null
                ? resolveTypeName(node.getType())
                : "void";

        Symbol method = declarations.declareMethod(node, paramTypes, returnType);
        if (method != null) classMembers.add(method);

        scopes.registerScope(node, SymbolScopeKind.METHOD);
        try {
            declarations.declareThis(currentClassName(), node);
            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }


    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        String name = node.getName() != null ? node.getName() : currentClassName();
        List<String> paramTypes = collectParameterTypes(node.getParams());

        Symbol ctor = declarations.declareConstructor(node, name, paramTypes);
        if (ctor != null) classMembers.add(ctor);

        scopes.registerScope(node, SymbolScopeKind.CONSTRUCTOR);
        try {
            declarations.declareThis(currentClassName(), node);
            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }


    @Override
    public Void visit(ParameterNodeZ node) {
        declarations.declareParameter(node, resolveParameterType(node));
        return null;
    }

    // ============================================================
    // CODE BODY
    // ============================================================

    @Override
    public Void visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode s : node.getStatements()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    // ============================================================
    // VARIABLES
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getDataType());
        int dims = node.getDimensions();
        declarations.declareVariable(node.getIdentifier(), typeName, dims, node);

        if (isInClassScope()) {
            Symbol attr = lookupInCurrentScope(node.getIdentifier());
            if (attr != null) classMembers.add(attr);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getType());
        Symbol field = declarations.declareField(node, typeName);
        if (field != null) classMembers.add(field);
        return null;
    }


    @Override
    public Void visit(ThisExpressionNodeZ node) {
        // Nothing to declare here. The checker resolves `this` against the enclosing class and annotates the node.
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getDataType());
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 0;
        declarations.declareArray(node.getIdentifier(), typeName, dims, node);

        if (isInClassScope()) {
            Symbol attr = lookupInCurrentScope(node.getIdentifier());
            if (attr != null) classMembers.add(attr);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        declarations.declareForVariable(node.getId(), resolveTypeName(node.getType()), node);
        return null;
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Void visit(IfStatementNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getThenBody() != null) {
                for (ZAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeZ e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
            if (node.getCondition() != null) node.getCondition().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ForStatementNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getSelector() != null) node.getSelector().accept(this);
            if (node.getCases() != null) {
                for (SwitchCaseNodeZ c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    // ============================================================
    // NON-DECLARING (no-op)
    // ============================================================

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeZ node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        return null;
    }


    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        return null;
    }

    // ============================================================
    // HELPERS (only what the visitor itself needs)
    // ============================================================

    /**
     * Returns true if the current scope is a class scope.
     */
    private boolean isInClassScope() {
        return table.getCurrentScope().getKind() == SymbolScopeKind.CLASS;
    }

    /**
     * Looks up a symbol with the given name in the current scope only.
     */
    private Symbol lookupInCurrentScope(String name) {
        List<Symbol> found = table.getCurrentScope().resolveLocalByName(name);
        return found.isEmpty() ? null : found.get(0);
    }

    /**
     * Looks up a class symbol by name in the file scope.
     */
    private Symbol lookupClass(String className) {
        return table.resolveDeepInFile(context.getFilePath(), className).stream()
                .filter(s -> s.getKind() == SymbolKind.CLASS)
                .findFirst()
                .orElse(null);
    }

    /**
     * Resolves the type name of a TypeNode. Delegates to the mapper in the checker
     */
    private String resolveTypeName(TypeNodeZ typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    /**
     * Resolves the raw type name of a parameter.
     */
    private String resolveParameterType(ParameterNodeZ node) {
        String fromType = resolveTypeName(node.getType());
        return fromType != null ? fromType : "?";
    }

    //Helpers to collect the parameters
    private List<String> collectParameterTypes(List<ParameterNodeZ> params) {
        List<String> result = new ArrayList<>();
        if (params == null) return result;
        for (ParameterNodeZ p : params) {
            if (p == null) continue;
            String t = resolveParameterType(p);
            if (p.isArray()) t = t + "[]".repeat(p.getDimensions());
            result.add(t);
        }
        return result;
    }

    /**
     * Look up class in file helper resolver
     *
     */
    private Symbol lookupClassInFile(String className) {
        return table.resolveDeepInFile(context.getFilePath(), className).stream()
                .filter(s -> s.getKind() == SymbolKind.CLASS)
                .findFirst()
                .orElse(null);
    }

    /**
     * Helper to resolve the class name
     *
     */
    private String currentClassName() {
        SymbolScope scope = table.getCurrentScope();
        while (scope != null && scope.getKind() != SymbolScopeKind.CLASS) scope = scope.getParent();
        return scope != null ? scope.getClassName() : null;
    }
}