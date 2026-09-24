package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
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

import java.util.List;

/**
 * Principal Z reference resolver visitor class
 *
 */
public class ZReferenceResolverVisitor implements ZAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public ZReferenceResolverVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) {
            node.getClassNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclarationNodeZ node) {

        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member != null) {
                    member.accept(this);
                }
            }
        }

        return null;
    }

    // ============================================================
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;
    }

    // ============================================================
    // EXPRESSIONS (references)
    // ============================================================

    // En ZReferenceResolverVisitor
    @Override
    public Void visit(IdentifierExpressionNodeZ node) {
        String name = node.getIdentifier();
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
        if (found.isEmpty()) {
            reportUndeclared(name, node);
        }
        return null;
    }


    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        } else {
            String name = node.getFunctionName();
            List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
            if (found.isEmpty()) {
                reportUndeclared(name, node);
            }
        }
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                if (arg != null) arg.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getIndex() != null) {
            node.getIndex().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenExpr() != null) {
            node.getThenExpr().accept(this);
        }
        if (node.getElseExpr() != null) {
            node.getElseExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeZ node) {
        if (node.getElements() != null) {

            for (ExpressionNodeZ expressionNodeZ : node.getElements()) {
                expressionNodeZ.accept(this);
            }

        }
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeZ node) {
        if (node.getValues() != null) {
            for (ExpressionNodeZ value : node.getValues()) {
                if (value != null) {
                    value.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        // new int[expr]: visit the size expression(s).
        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dim : node.getDimensions()) {
                if (dim != null) {
                    dim.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    // ============================================================
    // VARIABLE DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }

    // ============================================================
    // STATEMENTS (references + block scoping)
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        if (node.getIdentifier() != null) {
            node.getIdentifier().accept(this);
        }
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
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
    // CONTROL FLOW BLOCKS
    // ============================================================

    @Override
    public Void visit(IfStatementNodeZ node) {

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBody() != null) {
            for (ZAstNode statement : node.getThenBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
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

        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeZ node) {

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ForStatementNodeZ node) {

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
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        if (node.getId() != null) {
            node.getId().accept(this);
        }
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {

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

        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        return null;
    }

    // ============================================================
    // NON-RESOLVING NODES
    // ============================================================

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeZ node) {
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

    // ============================================================
    // HELPERS
    // ============================================================

    private void reportUndeclared(String name, ZAstNode node) {
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