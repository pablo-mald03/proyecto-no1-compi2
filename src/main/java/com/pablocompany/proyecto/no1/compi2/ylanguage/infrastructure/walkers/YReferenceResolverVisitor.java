package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
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

import java.util.List;

/**
 * Principal y reference resolver visitor
 */
public class YReferenceResolverVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public YReferenceResolverVisitor(GlobalSymbolTable table, EditorContext context) {
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
            for (YAstNode function : node.getFunctions()) {
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
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getAttributes() != null) {
            node.getAttributes().accept(this);
        }

        table.setCurrentScope(previous);
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
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    // ============================================================
    // FUNCTIONS AND PROCEDURES
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(StructParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(PrimitiveParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayParameterNodeY node) {
        return null;
    }

    // ============================================================
    // VARIABLE DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        if (node.getDimensions() != null) {
            for (ExpressionNodeY dim : node.getDimensions()) {
                if (dim != null) {
                    dim.accept(this);
                }
            }
        }
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        if (node.getLiteral() != null) {
            node.getLiteral().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }

    // ============================================================
    // EXPRESSIONS (references)
    // ============================================================

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        String name = node.getIdentifier();
        List<Symbol> found = table.resolveByName(name);
        if (found.isEmpty()) {
            reportUndeclared(name, node);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        } else {
            String name = node.getFunctionName();
            List<Symbol> found = table.resolveByName(name);
            if (found.isEmpty()) {
                reportUndeclared(name, node);
            }
        }

        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        if (node.getIndexExpression() != null) {
            node.getIndexExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getIndex() != null) {
            node.getIndex().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        if (node.getElements() != null) {
            for (ExpressionNodeY expressionNodeY : node.getElements()) {
                expressionNodeY.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        if (node.getValues() != null) {
            for (ExpressionNodeY value : node.getValues()) {
                if (value != null) {
                    value.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodeY property : node.getProperties()) {
                if (property != null) {
                    property.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        if (node.getIdentifier() != null) {
            node.getIdentifier().accept(this);
        }
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
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

    // ============================================================
    // CONTROL FLOW BLOCKS (with scope lookup)
    // ============================================================

    @Override
    public Void visit(IfStatementNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(ElseIfNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        if (node.getId() != null) {
            node.getId().accept(this);
        }
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

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

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.setCurrentScope(previous);
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        table.setCurrentScope(previous);
        return null;
    }

    // ============================================================
    // NODES WITH NO REFERENCES
    // ============================================================

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    /**
     * Looks up the scope registered by the collector for this node.
     */
    private SymbolScope lookupRegisteredScope(YAstNode node) {
        String key = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        return table.getRegisteredScope(key);
    }

    private void reportUndeclared(String name, YAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(name);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("El simbolo '" + name + "' no esta declarado en este ambito");
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }

}