package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.StructInstanceNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructPropertyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.VariableDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.functions.FunctionsRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.StructuresRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Principal symbol collector visitor
 *
 */
@Getter
public class YSymbolCollectorVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public YSymbolCollectorVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeY node) {
        if (node.getStructures() != null) {
            node.getStructures().accept(this);
        }
        if (node.getFunctions() != null) {
            node.getFunctions().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY struct : node.getStructs()) {
                if (struct != null) {
                    struct.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (FunctionDeclarationNodeY function : node.getFunctions()) {
                if (function != null) {
                    function.accept(this);
                }
            }
        }
        return null;
    }

    // ============================================================
    // STRUCTS
    // ============================================================

    @Override
    public Void visit(StructDeclarationNodeY node) {
        Symbol structSymbol = buildSymbol(
                node.getStructName(),
                SymbolKind.STRUCT,
                null,
                node
        );
        structSymbol.setQualifiedName(node.getStructName());

        if (!table.declare(structSymbol)) {
            reportDuplicate(node.getStructName(), "struct", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.STRUCT, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getAttributes() != null) {
            node.getAttributes().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        if (node.getAttributes() != null) {
            for (StructAttributeNodeY attribute : node.getAttributes()) {
                if (attribute != null) {
                    attribute.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
        String typeName = resolveTypeName(node.getType());

        Symbol attribute = buildSymbol(
                node.getIdentifier(),
                SymbolKind.ATTRIBUTE,
                typeName,
                node
        );
        attribute.setArray(node.isArray());

        if (!table.declare(attribute)) {
            reportDuplicate(node.getIdentifier(), "atributo", node);
        }
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        return null;
    }

    // ============================================================
    // FUNCTIONS AND PROCEDURES
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        Symbol functionSymbol = buildSymbol(
                node.getName(),
                SymbolKind.FUNCTION,
                null,
                node
        );

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    String type = resolveParameterType(param);
                    if (param.isArray()) {
                        type = type + "[]".repeat(param.getDimensions());
                    }
                    functionSymbol.getParameterTypes().add(type);
                }
            }
        }

        if (!table.declare(functionSymbol)) {
            reportDuplicate(node.getName(), "funcion", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.FUNCTION, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        Symbol procedureSymbol = buildSymbol(
                node.getName(),
                SymbolKind.FUNCTION,
                null,
                node
        );

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    String type = resolveParameterType(param);
                    if (param.isArray()) {
                        type = type + "[]".repeat(param.getDimensions());
                    }
                    procedureSymbol.getParameterTypes().add(type);
                }
            }
        }

        if (!table.declare(procedureSymbol)) {
            reportDuplicate(node.getName(), "procedimiento", node);
            return null;
        }

        SymbolScope scope = table.enterScope(SymbolScopeKind.FUNCTION, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (YAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(StructParameterNodeY node) {
        Symbol parameter = buildSymbol(
                node.getIdentifier(),
                SymbolKind.PARAMETER,
                resolveTypeName(node.getDataType()),
                node
        );
        parameter.setDimensions(node.getDimensions());
        parameter.setArray(node.isArray());
        parameter.setParameterKind(node.getKind());

        if (!table.declare(parameter)) {
            reportDuplicate(node.getIdentifier(), "parametro", node);
        }
        return null;
    }

    @Override
    public Void visit(PrimitiveParameterNodeY node) {
        Symbol parameter = buildSymbol(
                node.getIdentifier(),
                SymbolKind.PARAMETER,
                resolveTypeName(node.getType()),
                node
        );
        parameter.setDimensions(node.getDimensions());
        parameter.setArray(node.isArray());
        parameter.setParameterKind(node.getKind());

        if (!table.declare(parameter)) {
            reportDuplicate(node.getIdentifier(), "parametro", node);
        }
        return null;
    }

    @Override
    public Void visit(ArrayParameterNodeY node) {
        Symbol parameter = buildSymbol(
                node.getIdentifier(),
                SymbolKind.PARAMETER,
                resolveTypeName(node.getElementType()),
                node
        );
        parameter.setDimensions(node.getDimensions());
        parameter.setArray(node.isArray());
        parameter.setParameterKind(node.getKind());

        if (!table.declare(parameter)) {
            reportDuplicate(node.getIdentifier(), "parametro", node);
        }
        return null;
    }

    // ============================================================
    // VARIABLE DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        String typeName = resolveTypeName(node.getDataType());

        Symbol variable = buildSymbol(
                node.getIdentifier(),
                SymbolKind.LOCAL_VARIABLE,
                typeName,
                node
        );

        if (!table.declare(variable)) {
            reportDuplicate(node.getIdentifier(), "variable", node);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        String typeName = resolveTypeName(node.getDataType());

        Symbol array = buildSymbol(
                node.getIdentifier(),
                SymbolKind.LOCAL_VARIABLE,
                typeName,
                node
        );

        if (node.getDimensions() != null) {
            array.setDimensions(node.getDimensions().size());
        }
        array.setArray(true);

        if (!table.declare(array)) {
            reportDuplicate(node.getIdentifier(), "arreglo", node);
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        Symbol instance = buildSymbol(
                node.getIdentifier(),
                SymbolKind.LOCAL_VARIABLE,
                node.getStructType(),
                node
        );

        if (!table.declare(instance)) {
            reportDuplicate(node.getIdentifier(), "instancia de struct", node);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
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
    public Void visit(IfStatementNodeY node) {
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
            for (StatementNodeY statement : node.getThenBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodeY elseIf : node.getElseIfs()) {
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
    public Void visit(ElseIfNodeY node) {
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
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
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
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
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
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
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
            for (SwitchCaseNodeY caseNode : node.getCases()) {
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
    public Void visit(SwitchCaseNodeY node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        SymbolScope scope = table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());
        String scopeKey = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        table.registerScope(scopeKey, scope);

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    // ============================================================
    // NON-DECLARING NODES (no-op)
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        return null;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private Symbol buildSymbol(String name, SymbolKind kind, String type, YAstNode node) {
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

    private void reportDuplicate(String name, String kindLabel, YAstNode node) {
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

    private String resolveTypeName(TypeNodeY typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) {
            return typeNode.getCustomTypeName();
        }
        if (typeNode.getDataType() != null) {
            return typeNode.getDataType().getValue();
        }
        return null;
    }

    private String resolveParameterType(ParameterNodeY node) {
        if (node instanceof StructParameterNodeY structParam) {
            return resolveTypeName(structParam.getDataType());
        }
        if (node instanceof ArrayParameterNodeY arrayParam) {
            return resolveTypeName(arrayParam.getElementType());
        }
        if (node instanceof PrimitiveParameterNodeY primitiveParam) {
            return resolveTypeName(primitiveParam.getType());
        }
        return resolveTypeName(node.getType());
    }
}