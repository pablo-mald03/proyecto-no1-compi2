package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.YArraySizeEvaluatorService;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.YScopeService;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.YSemanticErrorReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 *
 *
 */
public class YArraySizeValidatorVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final YArraySizeEvaluatorService evaluator;
    private final YSemanticErrorReporter reporter;
    private final YScopeService scopes;

    public YArraySizeValidatorVisitor(GlobalSymbolTable table,
                                      EditorContext context) {
        this.table = table;
        this.context = context;
        this.evaluator = new YArraySizeEvaluatorService();
        this.reporter = new YSemanticErrorReporter(context);
        this.scopes = new YScopeService(table, context);
    }

    // ============================================================
    // TOP LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeY node) {
        if (node.getStructures() != null) node.getStructures().accept(this);
        if (node.getFunctions() != null) node.getFunctions().accept(this);
        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY s : node.getStructs()) if (s != null) s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (YAstNode f : node.getFunctions()) if (f != null) f.accept(this);
        }
        return null;
    }

    // ============================================================
    // STRUCTS
    // ============================================================

    @Override
    public Void visit(StructDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        if (node.getAttributes() != null) {
            for (StructAttributeNodeY a : node.getAttributes()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
        // Struct attributes can't have array init expressions in Y (they use
        // the `type name[size]` syntax). If your AST allows an init, visit it.
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodeY p : node.getProperties()) if (p != null) p.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        if (node.getLiteral() != null) node.getLiteral().accept(this);
        return null;
    }

    // ============================================================
    // FUNCTIONS / PROCEDURES
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
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
    // THE ACTUAL CHECKS
    // ============================================================

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        // 1) Validate declared dimensions.
        if (node.getDimensions() != null) {
            for (ExpressionNodeY dim : node.getDimensions()) {
                validateSize(dim, node.getIdentifier(), node);
            }
        }

        // 2) Visit initializer (may be ArrayInitExpression).
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
            checkInitShape(node);
        }
        return null;
    }

    // ============================================================
    // SIZE VALIDATION
    // ============================================================

    private void validateSize(ExpressionNodeY expr, String arrayName, YAstNode errorNode) {
        if (expr == null) return;

        OptionalInt size = evaluator.evaluate(expr);
        if (size.isEmpty()) return;

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

    private void checkInitShape(ArrayDeclarationNodeY node) {
        if (node.getInitializer() == null) return;
        if (node.getDimensions() == null || node.getDimensions().isEmpty()) return;

        List<Integer> dims = new ArrayList<>();
        for (ExpressionNodeY dim : node.getDimensions()) {
            OptionalInt size = evaluator.evaluate(dim);
            if (size.isEmpty()) return;
            dims.add(size.getAsInt());
        }

        if (!(node.getInitializer() instanceof ArrayInitExpressionNodeY init)) {
            return;
        }

        validateInitShapeRecursive(init, dims, 0, node.getIdentifier(), node);
    }

    private void validateInitShapeRecursive(ArrayInitExpressionNodeY init,
                                            List<Integer> dims,
                                            int dimIndex,
                                            String arrayName,
                                            YAstNode errorNode) {
        if (dimIndex >= dims.size()) return;

        int expected = dims.get(dimIndex);
        List<ExpressionNodeY> elements = init.getElements();
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
                ExpressionNodeY elem = elements.get(i);
                if (elem instanceof ArrayInitExpressionNodeY nested) {
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
    // EXPRESSIONS (visit children so nested checks happen)
    // ============================================================

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        if (node.getIndexExpression() != null) node.getIndexExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getIndex() != null) node.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        if (node.getElements() != null) {
            for (ExpressionNodeY e : node.getElements()) if (e != null) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        if (node.getValues() != null) {
            for (ExpressionNodeY e : node.getValues()) if (e != null) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY a : node.getArguments()) if (a != null) a.accept(this);
        }
        return null;
    }

    // ============================================================
    // STATEMENTS THAT CONTAIN EXPRESSIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        if (node.getInitializer() != null) node.getInitializer().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        if (node.getId() != null) node.getId().accept(this);
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    // ============================================================
    // CONTROL FLOW (visit conditions + bodies)
    // ============================================================

    @Override
    public Void visit(IfStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getThenBody() != null) {
                for (YAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeY e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ElseIfNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
            if (node.getCondition() != null) node.getCondition().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getSelector() != null) node.getSelector().accept(this);
            if (node.getCases() != null) {
                for (SwitchCaseNodeY c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getValue() != null) node.getValue().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    // ============================================================
    // LEAVES: no-op
    // ============================================================

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
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
}