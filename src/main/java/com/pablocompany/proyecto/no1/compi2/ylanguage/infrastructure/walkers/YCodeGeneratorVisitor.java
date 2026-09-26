package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/**
 * Principal visitor to excecute the code generator
 */
public class YCodeGeneratorVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;
    private final CodeGeneratorOutput output;
    private final CodeGenContext ctx;
    private final StringPool stringPool;

    private int nextOffset = 1;

    private final Map<String, Integer> localOffsets = new HashMap<>();

    private final Map<String, Integer> paramOffsets = new HashMap<>();

    private final Map<String, TypeKind> localTypes = new HashMap<>();

    private final Deque<String> breakLabels = new ArrayDeque<>();
    private final Deque<String> continueLabels = new ArrayDeque<>();

    private String lastExpr;

    public YCodeGeneratorVisitor(GlobalSymbolTable table,
                                 EditorContext context,
                                 Map<AstNode, Type> typeAnnotations,
                                 CodeGeneratorOutput output,
                                 CodeGenContext ctx,
                                 StringPool stringPool) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
        this.output = output;
        this.ctx = ctx;
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
    // FUNCTIONS
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        String funcName = uniqueFunctionName(node.getName(), node);
        output.getFunctionNames().add(funcName);
        output.emit("function_start", funcName, null, null);

        emitPrologue();
        resetFunctionState();

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    String pname = param.getIdentifier();
                    paramOffsets.put(pname, nextOffset);
                    Type t = typeAnnotations.get(param);
                    localTypes.put(pname, t != null ? t.getKind() : TypeKind.INT);
                    nextOffset++;
                }
            }
        }

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        emitEpilogue();
        output.emit("return", null, null, null);
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        String funcName = uniqueFunctionName(node.getName(), node);
        output.getFunctionNames().add(funcName);
        output.emit("function_start", funcName, null, null);

        emitPrologue();
        resetFunctionState();

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    String pname = param.getIdentifier();
                    paramOffsets.put(pname, nextOffset);
                    Type t = typeAnnotations.get(param);
                    localTypes.put(pname, t != null ? t.getKind() : TypeKind.INT);
                    nextOffset++;
                }
            }
        }

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        emitEpilogue();
        output.emit("return", null, null, null);
        return null;
    }

    private void emitPrologue() {
        output.emit("fp_push", null, null, null);
        output.emit("fp_set", null, null, null);
    }

    private void emitEpilogue() {
        output.emit("fp_pop", null, null, null);
    }

    private void resetFunctionState() {
        localOffsets.clear();
        paramOffsets.clear();
        localTypes.clear();
        nextOffset = 1;
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        String localName = node.getIdentifier();
        allocateLocal(localName, node);

        if (node.getInitializer() != null) {
            String valueRef = exprToString(node.getInitializer());
            String dest = getStackRefByName(localName);
            storeValueTo(valueRef, dest);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        // TODO: arrays.
        allocateLocal(node.getIdentifier(), node);
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        String localName = node.getId();
        allocateLocal(localName, node);

        if (node.getExpr() != null) {
            String valueRef = exprToString(node.getExpr());
            String dest = getStackRefByName(localName);
            storeValueTo(valueRef, dest);
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        String targetRef = exprToString(node.getTarget());
        switch (node.getOperator()) {
            case INCREMENT:
            case PREFIX_INCREMENT: {
                int oneOffset = nextOffset++;
                output.emit("=", "1", null, "stackinteger[fp + " + oneOffset + "]");
                String oneRef = "stackinteger[fp + " + oneOffset + "]";
                loadRegister(targetRef, "AX_INT");
                loadRegister(oneRef, "BX_INT");
                output.emit("+", "AX_INT", "BX_INT", "CX_INT");
                storeRegisterBack("CX_INT", targetRef);
                break;
            }
            case DECREMENT:
            case PREFIX_DECREMENT: {
                int oneOffset = nextOffset++;
                output.emit("=", "1", null, "stackinteger[fp + " + oneOffset + "]");
                String oneRef = "stackinteger[fp + " + oneOffset + "]";
                loadRegister(targetRef, "AX_INT");
                loadRegister(oneRef, "BX_INT");
                output.emit("-", "AX_INT", "BX_INT", "CX_INT");
                storeRegisterBack("CX_INT", targetRef);
                break;
            }
            case ASSIGN:
                if (node.getValue() != null) {
                    String valueRef = exprToString(node.getValue());
                    storeValueTo(valueRef, targetRef);
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
        String valueRef = exprToString(node.getExpressionNode());
        String targetRef = exprToString(node.getIdentifier());
        storeValueTo(valueRef, targetRef);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        String targetRef = exprToString(node.getTarget());
        String valueRef = exprToString(node.getValue());

        loadRegister(targetRef, "AX_INT");
        loadRegister(valueRef, "BX_INT");

        String op = shortlyOpToBinary(node.getOperator());
        output.emit(op, "AX_INT", "BX_INT", "CX_INT");
        storeRegisterBack("CX_INT", targetRef);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        String targetRef = exprToString(node.getTargetVariable());
        int oneOffset = nextOffset++;
        output.emit("=", "1", null, "stackinteger[fp + " + oneOffset + "]");
        String oneRef = "stackinteger[fp + " + oneOffset + "]";
        loadRegister(targetRef, "AX_INT");
        loadRegister(oneRef, "BX_INT");
        output.emit("+", "AX_INT", "BX_INT", "CX_INT");
        storeRegisterBack("CX_INT", targetRef);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        String targetRef = exprToString(node.getTargetVariable());
        int oneOffset = nextOffset++;
        output.emit("=", "1", null, "stackinteger[fp + " + oneOffset + "]");
        String oneRef = "stackinteger[fp + " + oneOffset + "]";
        loadRegister(targetRef, "AX_INT");
        loadRegister(oneRef, "BX_INT");
        output.emit("-", "AX_INT", "BX_INT", "CX_INT");
        storeRegisterBack("CX_INT", targetRef);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        return visit((IncrementStatementNodeY) null);
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        return visit((DecrementStatementNodeY) null);
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        if (node.getExpression() != null) {
            String valueRef = exprToString(node.getExpression());
            Type t = typeAnnotations.get(node.getExpression());
            String typeName = typeToString(t);
            String register = registerFor(typeName);
            loadRegister(valueRef, register);
            output.emit("print", register, typeName, null);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        int offset = nextOffset++;
        Type t = typeAnnotations.get(node);
        String typeName = typeToString(t);
        String arrayName = stackArrayForKind(t != null ? t.getKind() : TypeKind.INT);
        String dest = arrayName + "[fp + " + offset + "]";

        if ("string".equals(typeName)) {
            output.emit("read_string", null, null, dest);
        } else {
            output.emit("read_int", null, null, dest);
        }

        lastExpr = dest;
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        if (node.getValue() != null) {
            String valueRef = exprToString(node.getValue());
            Type t = typeAnnotations.get(node.getValue());
            String arrayName = stackArrayForKind(t != null ? t.getKind() : TypeKind.INT);
            String dest = arrayName + "[fp + 0]";
            storeValueTo(valueRef, dest);
        }
        output.emit("return", null, null, null);
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
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

    @Override
    public Void visit(IfStatementNodeY node) {
        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");

        String elseLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("ifFalse", "AX_INT", null, elseLabel);

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
        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");

        String nextLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("ifFalse", "AX_INT", null, nextLabel);

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
        String startLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("label", startLabel, null, null);

        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");
        output.emit("ifFalse", "AX_INT", null, endLabel);

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
        String startLabel = ctx.nextLabel();
        String condLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

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
        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");
        output.emit("ifTrue", "AX_INT", null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        String startLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        if (node.getInit() != null) node.getInit().accept(this);

        output.emit("label", startLabel, null, null);

        if (node.getCondition() != null) {
            String condRef = exprToString(node.getCondition());
            loadRegister(condRef, "AX_INT");
            output.emit("ifFalse", "AX_INT", null, endLabel);
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
    // EXPRESSIONS
    // ============================================================

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        Type t = typeAnnotations.get(node);
        Object value = node.getDataValue();

        if (t != null && t.getKind() == TypeKind.STRING) {
            lastExpr = stringPool.intern(String.valueOf(value));
        } else if (t != null && t.getKind() == TypeKind.BOOLEAN) {
            lastExpr = Boolean.TRUE.equals(value) ? "1" : "0";
        } else {
            lastExpr = String.valueOf(value);
        }
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        lastExpr = getStackRefByName(node.getIdentifier());
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        String leftRef = exprToString(node.getLeft());
        String rightRef = exprToString(node.getRight());

        loadRegister(leftRef, "AX_INT");
        loadRegister(rightRef, "BX_INT");

        String op = binaryOpToSymbol(node.getOperator());
        output.emit(op, "AX_INT", "BX_INT", "CX_INT");

        int offset = nextOffset++;
        String dest = "stackinteger[fp + " + offset + "]";
        output.emit("store_int", String.valueOf(offset), null, "CX_INT");

        lastExpr = dest;
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        String operandRef = exprToString(node.getExpressionNode());
        loadRegister(operandRef, "AX_INT");

        String op = unaryOpToSymbol(node.getOperator());
        output.emit(op, "AX_INT", null, "CX_INT");

        int offset = nextOffset++;
        String dest = "stackinteger[fp + " + offset + "]";
        output.emit("store_int", String.valueOf(offset), null, "CX_INT");

        lastExpr = dest;
        return null;
    }

    // ============================================================
    // STUBS
    // ============================================================

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
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
    public Void visit(StructInstanceNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
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
    public Void visit(ArgumentsNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

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

    private String exprToString(ExpressionNodeY node) {
        node.accept(this);
        return lastExpr;
    }

    private String uniqueFunctionName(String baseName, YAstNode node) {
        return baseName + "_" + node.getLine() + "_" + node.getColumn();
    }

    private int allocateLocal(String name, YAstNode node) {
        int offset = nextOffset++;
        localOffsets.put(name, offset);

        Type t = typeAnnotations.get(node);
        localTypes.put(name, t != null ? t.getKind() : TypeKind.INT);
        return offset;
    }

    /**
     * Returns a stack reference string like "stackinteger[fp + 5]"
     * for a variable or parameter name.
     */
    private String getStackRefByName(String name) {
        Integer offset = localOffsets.get(name);
        if (offset == null) offset = paramOffsets.get(name);
        if (offset == null) return "0";

        TypeKind kind = localTypes.get(name);
        if (kind == null) kind = TypeKind.INT;
        return stackArrayForKind(kind) + "[fp + " + offset + "]";
    }

    /**
     * Loads a value (either a stack reference, a register, or a literal)
     * into the given register.
     */
    private void loadRegister(String operandRef, String register) {
        if (operandRef == null) return;

        if (isRegister(operandRef)) {
            output.emit("=", operandRef, null, register);
            return;
        }

        if (operandRef.startsWith("stack")) {
            int bs = operandRef.indexOf('[');
            int be = operandRef.indexOf(']');
            if (bs >= 0 && be > bs) {
                String arrayName = operandRef.substring(0, bs);
                String offsetExpr = operandRef.substring(bs + 1, be);
                String suffix = suffixForArray(arrayName);
                output.emit("load_" + suffix, offsetExpr, null, register);
                return;
            }
        }

        output.emit("=", operandRef, null, register);
    }

    /**
     * Stores a value into a destination stack slot.
     */
    private void storeValueTo(String valueRef, String destRef) {
        if (destRef == null || !destRef.startsWith("stack")) return;

        int bs = destRef.indexOf('[');
        int be = destRef.indexOf(']');
        if (bs < 0 || be <= bs) return;

        String arrayName = destRef.substring(0, bs);
        String offsetExpr = destRef.substring(bs + 1, be);
        String suffix = suffixForArray(arrayName);

        if (isRegister(valueRef)) {
            output.emit("store_" + suffix, offsetExpr, null, valueRef);
        } else if (valueRef != null && valueRef.startsWith("stack")) {
            loadRegister(valueRef, "CX_INT");
            output.emit("store_" + suffix, offsetExpr, null, "CX_INT");
        } else {
            output.emit("=", valueRef, null, destRef);
        }
    }

    private void storeRegisterBack(String register, String destRef) {
        if (destRef == null || !destRef.startsWith("stack")) return;

        int bs = destRef.indexOf('[');
        int be = destRef.indexOf(']');
        if (bs < 0 || be <= bs) return;

        String arrayName = destRef.substring(0, bs);
        String offsetExpr = destRef.substring(bs + 1, be);
        String suffix = suffixForArray(arrayName);

        output.emit("store_" + suffix, offsetExpr, null, register);
    }

    private boolean isRegister(String s) {
        if (s == null) return false;
        return s.startsWith("AX_") || s.startsWith("BX_") || s.startsWith("CX_");
    }

    private String suffixForArray(String arrayName) {
        return switch (arrayName) {
            case "stackstring" -> "string";
            case "stackfloat" -> "float";
            case "stackchar" -> "char";
            case "stackboolean" -> "boolean";
            default -> "int";
        };
    }

    private String stackArrayForKind(TypeKind kind) {
        if (kind == null) return "stackinteger";
        return switch (kind) {
            case STRING -> "stackstring";
            case FLOAT -> "stackfloat";
            case CHAR -> "stackchar";
            case BOOLEAN -> "stackboolean";
            default -> "stackinteger";
        };
    }

    private String registerFor(String typeName) {
        return switch (typeName) {
            case "string" -> "AX_STRING";
            case "float" -> "AX_FLOAT";
            case "char" -> "AX_CHAR";
            default -> "AX_INT";
        };
    }

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

    private String typeToString(Type t) {
        if (t == null) return "int";
        return switch (t.getKind()) {
            case STRING -> "string";
            case FLOAT -> "float";
            case CHAR -> "char";
            case BOOLEAN -> "int";
            default -> "int";
        };
    }
}