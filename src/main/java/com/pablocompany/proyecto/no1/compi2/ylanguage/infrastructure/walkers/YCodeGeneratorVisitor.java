package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.LabelGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.TemporaryGenerator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
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

import java.util.List;
import java.util.Map;

public class YCodeGeneratorVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;
    private final CodeGeneratorOutput output;
    private final TemporaryGenerator tempGen;
    private final LabelGenerator labelGen;
    private final StringPool stringPool;

    public YCodeGeneratorVisitor(GlobalSymbolTable table,
                                 EditorContext context,
                                 Map<AstNode, Type> typeAnnotations,
                                 CodeGeneratorOutput output,
                                 TemporaryGenerator tempGen,
                                 LabelGenerator labelGen,
                                 StringPool stringPool) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
        this.output = output;
        this.tempGen = tempGen;
        this.labelGen = labelGen;
        this.stringPool = stringPool;
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeY node) {
        if (node.getStructures() != null) node.getStructures().accept(this);
        if (node.getFunctions() != null) node.getFunctions().accept(this);
        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        // Structs are handled by the serializer (they become C structs).
        // No quadruples to emit.
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (YAstNode fn : node.getFunctions()) {
                if (fn != null) fn.accept(this);
            }
        }
        return null;
    }

    // ============================================================
    // FUNCTIONS AND PROCEDURES
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        output.getFunctionNames().add(node.getName());

        output.emit("label", node.getName(), null, null);

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("return", null, null, null);
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        output.getFunctionNames().add(node.getName());
        output.emit("label", node.getName(), null, null);

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("return", null, null, null);
        return null;
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        if (node.getInitializer() != null) {
            String value = exprToString(node.getInitializer());
            output.emit("=", value, null, node.getIdentifier());
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {

        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
            String temp = lastResult();
            output.emit("array_init", node.getIdentifier(), temp, null);
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        if (node.getExpr() != null) {
            String value = exprToString(node.getExpr());
            output.emit("=", value, null, node.getId());
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        String target = exprToString(node.getId());
        String value = exprToString(node.getExpr());
        output.emit("=", value, null, target);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        String target = exprToString(node.getTarget());
        switch (node.getOperator()) {
            case INCREMENT:
            case PREFIX_INCREMENT:
                output.emit("+", target, "1", target);
                break;
            case DECREMENT:
            case PREFIX_DECREMENT:
                output.emit("-", target, "1", target);
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    String value = exprToString(node.getValue());
                    output.emit("=", value, null, target);
                }
                break;
        }
        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        String target = exprToString(node.getIdentifier());
        String value = exprToString(node.getExpressionNode());

        // If the target is a field access (e.g. p.x), use set_field.
        if (node.getIdentifier() instanceof PropertyAccessExpressionNodeY prop) {
            String obj = exprToString(prop.getTarget());
            String valueForField = exprToString(node.getExpressionNode());
            output.emit("set_field", obj, prop.getPropertyName(), valueForField);
        } else {
            output.emit("=", value, null, target);
        }
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        String target = exprToString(node.getTarget());
        String value = exprToString(node.getValue());
        String op = shortlyOpToBinary(node.getOperator());
        output.emit(op, target, value, target);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        String target = exprToString(node.getTargetVariable());
        output.emit("+", target, "1", target);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        String target = exprToString(node.getTargetVariable());
        output.emit("-", target, "1", target);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        String target = exprToString(node.getTargetVariable());
        output.emit("+", target, "1", target);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        String target = exprToString(node.getTargetVariable());
        output.emit("-", target, "1", target);
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
            String value = exprToString(node.getExpression());
            output.emit("print", value, null, null);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        // read is an expression: emit read into a new temp.
        String temp = tempGen.next();
        output.emit("read", null, null, temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        if (node.getValue() != null) {
            String value = exprToString(node.getValue());
            output.emit("return", value, null, null);
        } else {
            output.emit("return", null, null, null);
        }
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        // break labels are handled by the enclosing loop.
        if (!breakLabels.isEmpty()) {
            output.emit("goto", null, null, breakLabels.peek());
        }
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
        if (!continueLabels.isEmpty()) {
            output.emit("goto", null, null, continueLabels.peek());
        }
        return null;
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    private final java.util.Deque<String> breakLabels = new java.util.ArrayDeque<>();
    private final java.util.Deque<String> continueLabels = new java.util.ArrayDeque<>();

    @Override
    public Void visit(IfStatementNodeY node) {
        String cond = exprToString(node.getCondition());

        String elseLabel = labelGen.next();
        String endLabel = labelGen.next();

        output.emit("ifFalse", cond, null, elseLabel);

        if (node.getThenBody() != null) {
            for (StatementNodeY s : node.getThenBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("goto", null, null, endLabel);
        output.emit("label", elseLabel, null, null);

        if (node.getElseIfs() != null) {
            for (ElseIfNodeY elseIf : node.getElseIfs()) {
                if (elseIf != null) elseIf.accept(this);
            }
        }
        if (node.getElseBlockNode() != null) {
            node.getElseBlockNode().accept(this);
        }

        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ElseIfNodeY node) {
        // Handled as part of the if-chain.
        String cond = exprToString(node.getCondition());
        String nextLabel = labelGen.next();
        String endLabel = labelGen.next();

        output.emit("ifFalse", cond, null, nextLabel);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("goto", null, null, endLabel);
        output.emit("label", nextLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        String startLabel = labelGen.next();
        String endLabel = labelGen.next();

        output.emit("label", startLabel, null, null);
        String cond = exprToString(node.getCondition());
        output.emit("ifFalse", cond, null, endLabel);

        breakLabels.push(endLabel);
        continueLabels.push(startLabel);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        continueLabels.pop();
        breakLabels.pop();

        output.emit("goto", null, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        String startLabel = labelGen.next();
        String condLabel = labelGen.next();
        String endLabel = labelGen.next();

        output.emit("label", startLabel, null, null);

        breakLabels.push(endLabel);
        continueLabels.push(condLabel);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        continueLabels.pop();
        breakLabels.pop();

        output.emit("label", condLabel, null, null);
        String cond = exprToString(node.getCondition());
        output.emit("ifTrue", cond, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        String startLabel = labelGen.next();
        String endLabel = labelGen.next();

        if (node.getInit() != null) node.getInit().accept(this);

        output.emit("label", startLabel, null, null);

        if (node.getCondition() != null) {
            String cond = exprToString(node.getCondition());
            output.emit("ifFalse", cond, null, endLabel);
        }

        breakLabels.push(endLabel);
        continueLabels.push(startLabel);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        continueLabels.pop();
        breakLabels.pop();

        if (node.getUpdate() != null) node.getUpdate().accept(this);

        output.emit("goto", null, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
        // For now, not implemented. Just visit the body.
        if (node.getCases() != null) {
            for (SwitchCaseNodeY c : node.getCases()) if (c != null) c.accept(this);
        }
        if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
        }
        return null;
    }

    // ============================================================
    // EXPRESSIONS — these produce a value into a temporary.
    // ============================================================

    /**
     * Keeps the last produced expression result (temp/var/literal).
     */
    private String lastExpr;

    /**
     * Returns the current value of lastExpr.
     */
    private String lastResult() {
        return lastExpr;
    }

    /**
     * Evaluates an expression, returns the "value" (temp/var/literal).
     */
    private String exprToString(ExpressionNodeY node) {
        node.accept(this);
        return lastExpr;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        Type t = typeAnnotations.get(node);
        Object value = node.getDataValue();

        if (t != null && t.getKind() == TypeKind.STRING) {
            String strId = stringPool.intern(String.valueOf(value));
            lastExpr = strId;
        } else {
            lastExpr = String.valueOf(value);
        }
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        lastExpr = node.getIdentifier();
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        String left = exprToString(node.getLeft());
        String right = exprToString(node.getRight());
        String temp = tempGen.next();

        String op = binaryOpToSymbol(node.getOperator());
        output.emit(op, left, right, temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        String operand = exprToString(node.getExpressionNode());
        String temp = tempGen.next();

        String op = unaryOpToSymbol(node.getOperator());
        output.emit(op, operand, null, temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        // Visit arguments and emit param quadruples.
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                String argVal = exprToString(arg);
                output.emit("param", argVal, null, null);
            }
        }

        int argCount = node.getArguments() != null ? node.getArguments().size() : 0;
        String temp = tempGen.next();
        output.emit("call", node.getFunctionName(), String.valueOf(argCount), temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        String index = exprToString(node.getIndexExpression());
        String temp = tempGen.next();
        output.emit("array_get", node.getArrayName(), index, temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        // Each element is emitted as a separate "array_element" quadruple.
        String temp = tempGen.next();
        if (node.getElements() != null) {
            for (int i = 0; i < node.getElements().size(); i++) {
                String value = exprToString(node.getElements().get(i));
                output.emit("array_element", value, String.valueOf(i), temp);
            }
        }
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        if (node.getValues() != null) {
            for (ExpressionNodeY v : node.getValues()) {
                if (v != null) v.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        // Allocate struct, then set fields.
        String temp = tempGen.next();
        output.emit("alloc_struct", node.getStructType(), null, temp);

        if (node.getLiteral() != null) {
            List<StructPropertyNodeY> props = node.getLiteral().getProperties();
            for (int i = 0; i < props.size(); i++) {
                StructPropertyNodeY prop = props.get(i);
                String value = exprToString(prop.getValue());
                output.emit("set_field", temp, String.valueOf(i), value);
            }
        }

        output.emit("=", temp, null, node.getIdentifier());
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        // Standalone struct literal (e.g. as function argument).
        String temp = tempGen.next();
        output.emit("alloc_struct", "?", null, temp);
        if (node.getProperties() != null) {
            for (int i = 0; i < node.getProperties().size(); i++) {
                StructPropertyNodeY prop = node.getProperties().get(i);
                String value = exprToString(prop.getValue());
                output.emit("set_field", temp, String.valueOf(i), value);
            }
        }
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        if (node.getValue() != null) {
            lastExpr = exprToString(node.getValue());
        }
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        String obj = exprToString(node.getTarget());
        String temp = tempGen.next();
        output.emit("get_field", obj, node.getPropertyName(), temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        String target = exprToString(node.getTarget());
        String index = exprToString(node.getIndex());
        String temp = tempGen.next();
        output.emit("array_get_dyn", target, index, temp);
        lastExpr = temp;
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                String argVal = exprToString(arg);
                output.emit("param", argVal, null, null);
            }
        }
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    // ============================================================
    // NO-OP
    // ============================================================

    @Override
    public Void visit(StructDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
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

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }


    // ============================================================
    // HELPERS
    // ============================================================

    private String binaryOpToSymbol(BinaryOperator op) {
        return switch (op) {
            case PLUS -> "+";
            case MINUS -> "-";
            case MULTIPLICATION -> "*";
            case DIVIDE -> "/";
            case MODULE -> "%";
            case EQUALS -> "==";
            case DIFFERENT -> "!=";
            case LESS -> "<";
            case GREATER -> ">";
            case LESS_EQUALS -> "<=";
            case GREATER_EQUALS -> ">=";
            case AND -> "&&";
            case OR -> "||";
        };
    }

    private String unaryOpToSymbol(UnaryOperator op) {
        return switch (op) {
            case NEGATE -> "-";
            case NOT -> "!";
        };
    }

    private String shortlyOpToBinary(ShortlyOperator op) {
        return switch (op) {
            case PLUS_ASSIGN -> "+";
            case MINUS_ASSIGN -> "-";
            case MULTIPLY_ASSIGN -> "*";
            case DIVIDE_ASSIGN -> "/";
            case MODULO_ASSIGN -> "%";
        };
    }
}