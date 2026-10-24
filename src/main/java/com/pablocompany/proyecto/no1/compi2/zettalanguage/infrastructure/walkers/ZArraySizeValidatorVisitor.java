package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.SuperConstructorCallNodeZ;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZArraySizeEvaluatorService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZScopeService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSemanticErrorReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * Principal class to walks the Z AST and validates array size expressions.
 */
public class ZArraySizeValidatorVisitor implements ZAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final ZArraySizeEvaluatorService evaluator;
    private final ZSemanticErrorReporter reporter;
    private final ZScopeService scopes;

    public ZArraySizeValidatorVisitor(GlobalSymbolTable table,
                                      EditorContext context) {
        this.table = table;
        this.context = context;
        this.evaluator = new ZArraySizeEvaluatorService();
        this.reporter = new ZSemanticErrorReporter(context);
        this.scopes = new ZScopeService(table, context);
    }

    // ============================================================
    // TOP LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() == null) return null;
        node.getClassNode().accept(this);
        return null;
    }

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getMembers() != null) {
                for (ZAstNode m : node.getMembers()) if (m != null) m.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode s : node.getStatements()) if (s != null) s.accept(this);
        }
        return null;
    }

    // ============================================================
    // METHODS / CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;   // parameters never contain array instantiation expressions
    }

    // ============================================================
    // THE ACTUAL CHECKS
    // ============================================================

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        // 1) Validate sizes of declared dimensions.
        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dim : node.getDimensions()) {
                validateSize(dim, node.getIdentifier(), node);
            }
        }

        // 2) Visit and validate initializer (which may be an ArrayInitExpression).
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
            checkInitShape(node);
        }
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        // `new int[d1][d2]...`
        if (node.getDimensions() != null) {
            String label = "arreglo";
            if (node.getType() != null) {
                if (node.getType().getCustomTypeName() != null) {
                    label = node.getType().getCustomTypeName();
                } else if (node.getType().getDataType() != null) {
                    label = node.getType().getDataType().getValue();
                }
            }
            for (ExpressionNodeZ dim : node.getDimensions()) {
                validateSize(dim, label, node);
            }
        }
        return null;
    }

    // ============================================================
    // SIZE VALIDATION
    // ============================================================

    private void validateSize(ExpressionNodeZ expr, String arrayName, ZAstNode errorNode) {
        if (expr == null) return;

        OptionalInt size = evaluator.evaluate(expr);
        if (size.isEmpty()) return;   // dynamic, leave to runtime

        if (size.getAsInt() < 0) {
            reporter.reportTypeError(arrayName,
                    "El tamano del arreglo '" + arrayName
                            + "' no puede ser negativo: " + size.getAsInt(),
                    errorNode);
        }
    }

    // ============================================================
    // SHAPE VALIDATION
    // ============================================================

    private void checkInitShape(ArrayDeclarationNodeZ node) {
        if (node.getInitializer() == null) return;
        if (node.getDimensions() == null || node.getDimensions().isEmpty()) return;

        List<Integer> dims = new ArrayList<>();
        for (ExpressionNodeZ dim : node.getDimensions()) {
            OptionalInt size = evaluator.evaluate(dim);
            if (size.isEmpty()) return;   // dynamic, silence
            dims.add(size.getAsInt());
        }

        if (!(node.getInitializer() instanceof ArrayInitExpressionNodeZ init)) {
            return;
        }

        validateInitShapeRecursive(init, dims, 0, node.getIdentifier(), node);
    }

    private void validateInitShapeRecursive(ArrayInitExpressionNodeZ init,
                                            List<Integer> dims,
                                            int dimIndex,
                                            String arrayName,
                                            ZAstNode errorNode) {
        if (dimIndex >= dims.size()) return;

        int expected = dims.get(dimIndex);
        List<ExpressionNodeZ> elements = init.getElements();
        int actual = elements != null ? elements.size() : 0;

        if (actual != expected) {
            reporter.reportTypeError(arrayName,
                    "El arreglo '" + arrayName + "' espera " + expected
                            + " elemento(s) en la dimension " + (dimIndex + 1)
                            + ", pero se dieron " + actual,
                    errorNode);
            return;
        }

        if (dimIndex + 1 < dims.size()) {
            for (int i = 0; i < actual; i++) {
                ExpressionNodeZ elem = elements.get(i);
                if (elem instanceof ArrayInitExpressionNodeZ nested) {
                    validateInitShapeRecursive(nested, dims, dimIndex + 1, arrayName, errorNode);
                } else {
                    reporter.reportTypeError(arrayName,
                            "El arreglo '" + arrayName + "' es multidimensional ("
                                    + dims.size() + "D) pero el elemento " + i
                                    + " de la dimension " + (dimIndex + 1)
                                    + " no es un arreglo anidado",
                            errorNode);
                    return;
                }
            }
        }
    }

    // ============================================================
    // CONTROL FLOW (visit conditions + bodies)
    // ============================================================

    @Override
    public Void visit(IfStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getThenBody() != null) {
                for (ZAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeZ e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
            if (node.getCondition() != null) node.getCondition().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ForStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getSelector() != null) node.getSelector().accept(this);
            if (node.getCases() != null) {
                for (SwitchCaseNodeZ c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getValue() != null) node.getValue().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    // ============================================================
    // EXPRESSIONS (visit children so nested ArrayInstantiation gets checked)
    // ============================================================

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        if (node.getCondition() != null) node.getCondition().accept(this);
        if (node.getThenExpr() != null) node.getThenExpr().accept(this);
        if (node.getElseExpr() != null) node.getElseExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getArguments() != null) {
            for (ExpressionNodeZ a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getIndex() != null) node.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeZ node) {
        if (node.getElements() != null) {
            for (ExpressionNodeZ e : node.getElements()) if (e != null) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeZ node) {
        if (node.getValues() != null) {
            for (ExpressionNodeZ e : node.getValues()) if (e != null) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    // ============================================================
    // STATEMENTS THAT CONTAIN EXPRESSIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        if (node.getInitializer() != null) node.getInitializer().accept(this);
        return null;
    }

    @Override
    public Void visit(FieldDeclarationNodeZ node) {
        if (node.getInitializer() != null) node.getInitializer().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(SuperExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(SuperConstructorCallNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        if (node.getId() != null) node.getId().accept(this);
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    // ============================================================
    // LEAVES: no-op
    // ============================================================

    @Override
    public Void visit(BreakStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ThisExpressionNodeZ node) {
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
    public Void visit(TypeNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }
}