package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeZ;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ProcedureDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.ConstructorDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.CodeBodyNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;

/**
 * Principal symbol collector visitor
 *
 */
public class ZSymbolCollectorVisitor implements ZAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    private String currentClassName;

    public ZSymbolCollectorVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    // ============================================================
    // PROGRAM INIT VISIT NODE
    // ============================================================

    @Override
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) {
            node.getClassNode().accept(this);
        }
        return null;
    }

    // ============================================================
    // CLASS NODE
    // ============================================================

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        Symbol classSymbol = buildSymbol(
                node.getClassName(),
                SymbolKind.CLASS,
                null,
                node
        );
        classSymbol.setQualifiedName(node.getClassName());
        this.currentClassName = node.getClassName();

        if (!table.declare(classSymbol)) {
            reportDuplicate(node.getClassName(), "clase", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.CLASS, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        for (ZAstNode astNode : node.getMembers()) {
            astNode.accept(this);
        }

        table.exitScope();
        return null;
    }

    // ============================================================
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        Symbol methodSymbol = buildSymbol(
                node.getName(),
                SymbolKind.METHOD,
                null,
                node
        );

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    String type = resolveParameterType(param);
                    if (param.isArray()) {
                        type = type + "[]".repeat(param.getDimensions());
                    }
                    methodSymbol.getParameterTypes().add(type);
                }
            }
        }

        if (!table.declare(methodSymbol)) {
            reportDuplicate(node.getName(), "metodo", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.METHOD, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        for (ZAstNode astNode : node.getBody()) {
            astNode.accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        String constructorName = node.getName() != null
                ? node.getName()
                : currentClassName;

        Symbol constructorSymbol = buildSymbol(
                constructorName,
                SymbolKind.CONSTRUCTOR,
                null,
                node
        );

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    String type = resolveParameterType(param);
                    if (param.isArray()) {
                        type = type + "[]".repeat(param.getDimensions());
                    }
                    constructorSymbol.getParameterTypes().add(type);
                }
            }
        }

        if (!table.declare(constructorSymbol)) {
            reportDuplicate(constructorName, "constructor", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.CONSTRUCTOR, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }
        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        Symbol parameter = buildSymbol(
                node.getName(),
                SymbolKind.PARAMETER,
                resolveParameterType(node),
                node
        );
        parameter.setDimensions(node.getDimensions());
        parameter.setArray(node.isArray());

        if (!table.declare(parameter)) {
            reportDuplicate(node.getName(), "parametro", node);
        }
        return null;
    }

    // ============================================================
    // CODE BODY (method/constructor body)
    // ============================================================

    @Override
    public Void visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode statement : node.getStatements()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        return null;
    }

    // ============================================================
    // VARIABLE DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getDataType());

        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.CLASS
                ? SymbolKind.ATTRIBUTE
                : SymbolKind.LOCAL_VARIABLE;

        Symbol variable = buildSymbol(
                node.getIdentifier(),
                kind,
                typeName,
                node
        );

        variable.setDimensions(node.getDimensions());
        variable.setArray(node.getDimensions() > 0);

        if (!table.declare(variable)) {
            String label = kind == SymbolKind.ATTRIBUTE ? "atributo" : "variable";
            reportDuplicate(node.getIdentifier(), label, node);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getDataType());

        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.CLASS
                ? SymbolKind.ATTRIBUTE
                : SymbolKind.LOCAL_VARIABLE;

        Symbol array = buildSymbol(
                node.getIdentifier(),
                kind,
                typeName,
                node
        );
        array.setDimensions(node.getDimensions().size());
        array.setArray(true);

        if (!table.declare(array)) {
            String label = kind == SymbolKind.ATTRIBUTE ? "arreglo atributo" : "arreglo";
            reportDuplicate(node.getIdentifier(), label, node);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        String typeName = resolveTypeName(node.getType());

        Symbol variable = buildSymbol(
                node.getId(),
                SymbolKind.LOCAL_VARIABLE,
                typeName,
                node
        );

        if (!table.declare(variable)) {
            reportDuplicate(node.getId(), "variable de for", node);
        }
        return null;
    }

    // ============================================================
    // CONTROL FLOW BLOCKS
    // ============================================================

    @Override
    public Void visit(IfStatementNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBody() != null) {
            for (ZAstNode astNode : node.getThenBody()) {
                astNode.accept(this);
            }
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodeZ elseIf : node.getElseIfs()) {
                if (elseIf != null) {
                    elseIf.accept(this);
                }
            }
        }
        if (node.getElseBlockNode() != null) {
            node.getElseBlockNode().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ForStatementNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getInit() != null) {
            node.getInit().accept(this);
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getUpdate() != null) {
            node.getUpdate().accept(this);
        }
        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getSelector() != null) {
            node.getSelector().accept(this);
        }
        if (node.getCases() != null) {
            for (SwitchCaseNodeZ caseNode : node.getCases()) {
                if (caseNode != null) {
                    caseNode.accept(this);
                }
            }
        }
        if (node.getDefaultCase() != null) {
            node.getDefaultCase().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (ZAstNode astNode : node.getBody()) {
                astNode.accept(this);
            }
        }

        table.exitScope();
        return null;
    }

    // ============================================================
    // NON-DECLARING NODES
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
    public Void visit(ExpressionNodeZ node) {
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
    public Void visit(FunctionDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeZ node) {
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
    // HELPERS
    // ============================================================

    private Symbol buildSymbol(String name, SymbolKind kind, String type, ZAstNode node) {
        Symbol symbol = new Symbol();
        symbol.setName(name);
        symbol.setKind(kind);
        symbol.setType(type);
        symbol.setFilePath(context.getFilePath());
        symbol.setFileName(context.getFileName());
        symbol.setLine(node.getLine());
        symbol.setColumn(node.getColumn());
        return symbol;
    }

    private void reportDuplicate(String name, String kindLabel, ZAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(name);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("Ya existe un " + kindLabel + " con el nombre '" + name + "' en este ambito");
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }

    private String resolveTypeName(TypeNodeZ typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) {
            return typeNode.getCustomTypeName();
        }
        if (typeNode.getDataType() != null) {
            return typeNode.getDataType().getValue();
        }
        return null;
    }

    private String resolveParameterType(ParameterNodeZ node) {
        String fromType = resolveTypeName(node.getType());
        if (fromType != null) return fromType;
        return "?";
    }

    private String currentClassName() {
        return null;
    }
}