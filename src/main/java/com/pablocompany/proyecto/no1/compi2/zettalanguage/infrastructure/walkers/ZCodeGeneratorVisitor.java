package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.ArrayInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.ObjectInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
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

import java.util.*;

public class ZCodeGeneratorVisitor implements ZAstVisitor<Void> {

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

    // Z-specific
    private final Map<String, List<String>> classLayouts = new HashMap<>();
    private final Map<String, ObjectInfo> objectVariables = new HashMap<>();
    private final Map<String, ArrayInfo> arrayInfos = new HashMap<>();

    private String currentClassName = null;
    private String currentSelfSlot = null;   // "fp + 1" when inside a method

    public ZCodeGeneratorVisitor(GlobalSymbolTable table,
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
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) node.getClassNode().accept(this);
        return null;
    }

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        String previousClass = currentClassName;
        currentClassName = node.getClassName();

        // Build layout (attributes in declaration order).
        List<String> fields = new ArrayList<>();
        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member instanceof VariableDeclarationNodeZ attr) {
                    fields.add(attr.getIdentifier());
                }
            }
        }
        classLayouts.put(currentClassName, fields);

        // Emit members.
        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member != null) member.accept(this);
            }
        }

        currentClassName = previousClass;
        return null;
    }

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
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        String className = currentClassName != null ? currentClassName : "Unknown";
        String funcName = className + "_" + node.getName();
        output.getFunctionNames().add(funcName);
        output.emit("function_start", funcName, null, null);

        int numArgs = node.getParams() != null ? node.getParams().size() : 0;

        // +1 for the implicit 'self' pointer.
        emitPrologue(numArgs + 1);
        resetFunctionState();

        // self is at [fp + 1].
        currentSelfSlot = "fp + 1";
        localTypes.put("self", TypeKind.INT);
        paramOffsets.put("self", 1);

        // Then the regular parameters.
        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) registerParameter(param);
            }
        }

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        emitEpilogue();
        output.emit("return", null, null, null);

        currentSelfSlot = null;
        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        String className = currentClassName != null ? currentClassName : "Unknown";
        String funcName = className + "_" + node.getName();
        output.getFunctionNames().add(funcName);
        output.emit("function_start", funcName, null, null);

        int numArgs = node.getParams() != null ? node.getParams().size() : 0;

        emitPrologue(numArgs + 1);
        resetFunctionState();

        currentSelfSlot = "fp + 1";
        localTypes.put("self", TypeKind.INT);
        paramOffsets.put("self", 1);

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) registerParameter(param);
            }
        }

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        emitEpilogue();
        output.emit("return", null, null, null);

        currentSelfSlot = null;
        return null;
    }

    private void emitPrologue(int numArgs) {
        output.emit("fp_push", null, null, null);
        output.emit("fp_set_offset", String.valueOf(numArgs + 1), null, null);
    }

    private void emitEpilogue() {
        output.emit("fp_pop", null, null, null);
    }

    private void resetFunctionState() {
        localOffsets.clear();
        paramOffsets.clear();
        localTypes.clear();
        objectVariables.clear();
        arrayInfos.clear();
        nextOffset = 1;
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        String localName = node.getIdentifier();

        Type declaredType = typeAnnotations.get(node);
        boolean isObject = declaredType != null
                && declaredType.isCustom()
                && !"String".equals(declaredType.getCustomName());

        int offset = allocateLocal(localName, node);

        if (isObject) {
            objectVariables.put(localName,
                    new ObjectInfo(declaredType.getCustomName(), offset));
        }

        if (node.getInitializer() != null) {
            if (node.getInitializer() instanceof ReadStatementNodeZ read) {
                read.accept(this);
                String dest = getStackRefByName(localName);
                storeValueTo(lastExpr, dest);
                return null;
            }
            String valueRef = exprToString(node.getInitializer());

            String dest = getStackRefByName(localName);
            storeValueTo(valueRef, dest);
        }
        return null;
    }


    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        int totalSize = 1;
        boolean allLiteral = true;
        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dim : node.getDimensions()) {
                Integer size = tryExtractIntLiteral(dim);
                if (size == null) {
                    allLiteral = false;
                    break;
                }
                totalSize *= size;
            }
        }
        if (!allLiteral) totalSize = 1;

        int base = nextOffset;
        nextOffset += totalSize;

        TypeKind elementKind = mapTypeNodeToType(node.getDataType()).getKind();
        arrayInfos.put(node.getIdentifier(),
                new ArrayInfo(base, elementKind, totalSize, false));

        if (node.getInitializer() != null
                && node.getInitializer() instanceof ArrayInitExpressionNodeZ init
                && init.getElements() != null) {
            List<ExpressionNodeZ> values = init.getElements();
            String suffix = kindToSuffix(elementKind);
            String cxReg = "CX_" + suffix.toUpperCase();
            for (int i = 0; i < values.size() && i < totalSize; i++) {
                String valueRef = exprToString(values.get(i));
                loadRegister(valueRef, cxReg);
                output.emit("store_" + suffix, "fp + " + (base + i), null, cxReg);
            }
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
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
    public Void visit(ForInitAssignmentNodeZ node) {
        if (node.getId() != null && node.getExpr() != null) {
            String targetRef = exprToString(node.getId());
            String valueRef = exprToString(node.getExpr());
            storeValueTo(valueRef, targetRef);
        }
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        String targetRef = exprToString(node.getTarget());
        switch (node.getOperator()) {
            case INCREMENT:
            case PREFIX_INCREMENT:
                emitIncDec(targetRef, "+");
                break;
            case DECREMENT:
            case PREFIX_DECREMENT:
                emitIncDec(targetRef, "-");
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    String valueRef = exprToString(node.getValue());
                    storeValueTo(valueRef, targetRef);
                }
                break;
        }
        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        String valueRef = exprToString(node.getExpressionNode());
        String targetRef = exprToString(node.getIdentifier());
        storeValueTo(valueRef, targetRef);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
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
    public Void visit(IncrementStatementNodeZ node) {
        emitIncDec(exprToString(node.getTargetVariable()), "+");
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        emitIncDec(exprToString(node.getTargetVariable()), "-");
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        emitIncDec(exprToString(node.getTargetVariable()), "+");
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        emitIncDec(exprToString(node.getTargetVariable()), "-");
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        if (node.getExpression() != null) {
            String valueRef = exprToString(node.getExpression());
            Type t = typeAnnotations.get(node.getExpression());
            String typeName = typeToString(t);
            String register = registerFor(typeName);
            loadRegister(valueRef, register);
            output.emit(node.isEndless() ? "println" : "print", register, typeName, null);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        int offset = nextOffset++;
        Type t = typeAnnotations.get(node);
        TypeKind kind = t != null ? t.getKind() : TypeKind.INT;
        String arrayName = stackArrayForKind(kind);

        if (kind == TypeKind.STRING) {
            output.emit("read_string", String.valueOf(offset), null, null);
        } else {
            output.emit("read_int", String.valueOf(offset), null, null);
        }

        lastExpr = arrayName + "[fp + " + offset + "]";
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
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
    public Void visit(BreakStatementNodeZ node) {
        if (!breakLabels.isEmpty()) output.emit("goto", null, null, breakLabels.peek());
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
        if (!continueLabels.isEmpty()) output.emit("goto", null, null, continueLabels.peek());
        return null;
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Void visit(IfStatementNodeZ node) {
        String endLabel = ctx.nextLabel();

        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");

        String elseLabel = ctx.nextLabel();
        output.emit("ifFalse", "AX_INT", null, elseLabel);

        if (node.getThenBody() != null) {
            for (ZAstNode s : node.getThenBody()) {
                if (s != null) s.accept(this);
            }
        }
        output.emit("goto", null, null, endLabel);
        output.emit("label", elseLabel, null, null);

        if (node.getElseIfs() != null) {
            for (ElseIfNodeZ elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;

                String condRef2 = exprToString(elseIf.getCondition());
                loadRegister(condRef2, "AX_INT");

                String nextElse = ctx.nextLabel();
                output.emit("ifFalse", "AX_INT", null, nextElse);

                if (elseIf.getBody() != null) {
                    for (ZAstNode s : elseIf.getBody()) {
                        if (s != null) s.accept(this);
                    }
                }
                output.emit("goto", null, null, endLabel);
                output.emit("label", nextElse, null, null);
            }
        }

        if (node.getElseBlockNode() != null && node.getElseBlockNode().getBody() != null) {
            for (ZAstNode s : node.getElseBlockNode().getBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {
        String startLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("label", startLabel, null, null);
        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");
        output.emit("ifFalse", "AX_INT", null, endLabel);

        breakLabels.push(endLabel);
        continueLabels.push(startLabel);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
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
    public Void visit(DoWhileStatementNodeZ node) {
        String startLabel = ctx.nextLabel();
        String condLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("label", startLabel, null, null);
        breakLabels.push(endLabel);
        continueLabels.push(condLabel);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
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
    public Void visit(ForStatementNodeZ node) {
        String startLabel = ctx.nextLabel();
        String continueLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        if (node.getInit() != null) node.getInit().accept(this);
        output.emit("label", startLabel, null, null);

        if (node.getCondition() != null) {
            String condRef = exprToString(node.getCondition());
            loadRegister(condRef, "AX_INT");
            output.emit("ifFalse", "AX_INT", null, endLabel);
        }

        breakLabels.push(endLabel);
        continueLabels.push(continueLabel);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        continueLabels.pop();
        breakLabels.pop();

        output.emit("label", continueLabel, null, null);
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        output.emit("goto", null, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        // Minimal support: evaluate selector, then each case as a labeled block.
        // (Full switch lowering is a TODO; for now emits case bodies in order.)
        if (node.getSelector() != null) {
            exprToString(node.getSelector());
        }
        if (node.getCases() != null) {
            for (SwitchCaseNodeZ c : node.getCases()) if (c != null) c.accept(this);
        }
        if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
        }
        return null;
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================

    @Override
    public Void visit(ExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeZ node) {
        Type t = typeAnnotations.get(node);
        Object value = node.getDataValue();

        if (t != null && t.getKind() == TypeKind.STRING) {
            lastExpr = stringPool.intern(String.valueOf(value));
        } else if (t != null && t.getKind() == TypeKind.BOOLEAN) {
            lastExpr = Boolean.TRUE.equals(value) ? "1" : "0";
        } else if (t != null && t.getKind() == TypeKind.NULL) {
            lastExpr = "0";
        } else {
            lastExpr = String.valueOf(value);
        }
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeZ node) {
        lastExpr = getStackRefByName(node.getIdentifier());
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        Type leftType = typeAnnotations.get(node.getLeft());
        Type rightType = typeAnnotations.get(node.getRight());
        Type resultType = typeAnnotations.get(node);

        TypeKind leftKind = leftType != null ? leftType.getKind() : TypeKind.INT;
        TypeKind rightKind = rightType != null ? rightType.getKind() : TypeKind.INT;

        TypeKind operandKind;
        if (leftKind == TypeKind.NULL || leftKind == TypeKind.CUSTOM
                || rightKind == TypeKind.NULL || rightKind == TypeKind.CUSTOM) {
            operandKind = TypeKind.INT;
        } else if (leftKind == TypeKind.STRING || rightKind == TypeKind.STRING) {
            operandKind = TypeKind.STRING;
        } else if (leftKind == TypeKind.FLOAT || rightKind == TypeKind.FLOAT) {
            operandKind = TypeKind.FLOAT;
        } else {
            operandKind = TypeKind.INT;
        }

        String operandSuffix = kindToSuffix(operandKind);
        String aReg = "AX_" + operandSuffix.toUpperCase();
        String bReg = "BX_" + operandSuffix.toUpperCase();

        String leftRef = exprToString(node.getLeft());
        String rightRef = exprToString(node.getRight());

        loadRegister(leftRef, aReg);
        loadRegister(rightRef, bReg);

        TypeKind resultKind = resultType != null ? resultType.getKind() : TypeKind.INT;
        String resultSuffix = kindToSuffix(resultKind);
        String cReg = "CX_" + resultSuffix.toUpperCase();

        String op;
        if (resultKind == TypeKind.STRING && node.getOperator() == BinaryOperator.PLUS) {
            op = "strcat";
        } else {
            op = binaryOpToSymbol(node.getOperator());
        }
        output.emit(op, aReg, bReg, cReg);

        int offset = nextOffset++;
        String dest = stackArrayForKind(resultKind) + "[fp + " + offset + "]";
        output.emit("store_" + resultSuffix, "fp + " + offset, null, cReg);

        lastExpr = dest;
        return null;
    }


    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        String operandRef = exprToString(node.getExpressionNode());
        loadRegister(operandRef, "AX_INT");

        String op = unaryOpToSymbol(node.getOperator());
        output.emit(op, "AX_INT", null, "CX_INT");

        int offset = nextOffset++;
        String dest = "stackinteger[fp + " + offset + "]";
        output.emit("store_int", "fp + " + offset, null, "CX_INT");

        lastExpr = dest;
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        // result = cond ? then : else
        Type resultType = typeAnnotations.get(node);
        TypeKind kind = resultType != null ? resultType.getKind() : TypeKind.INT;
        String suffix = kindToSuffix(kind);
        String arrayName = stackArrayForKind(kind);

        String thenLabel = ctx.nextLabel();
        String elseLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");
        output.emit("ifFalse", "AX_INT", null, elseLabel);

        output.emit("label", thenLabel, null, null);
        String thenRef = exprToString(node.getThenExpr());
        String cxReg = "CX_" + suffix.toUpperCase();
        loadRegister(thenRef, cxReg);
        int destOffset = nextOffset++;
        output.emit("store_" + suffix, "fp + " + destOffset, null, cxReg);
        output.emit("goto", null, null, endLabel);

        output.emit("label", elseLabel, null, null);
        String elseRef = exprToString(node.getElseExpr());
        loadRegister(elseRef, cxReg);
        output.emit("store_" + suffix, "fp + " + destOffset, null, cxReg);

        output.emit("label", endLabel, null, null);
        lastExpr = arrayName + "[fp + " + destOffset + "]";
        return null;
    }

    // ============================================================
    // OBJECTS
    // ============================================================

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        // novus Clase(args)
        TypeNodeZ typeNode = node.getType();
        String className = typeNode != null ? typeNode.getCustomTypeName() : null;

        // String built-in: novus String("a") -> just the string value.
        if ("String".equals(className)) {
            if (node.getArguments() != null && !node.getArguments().isEmpty()) {
                lastExpr = exprToString(node.getArguments().get(0));
            } else {
                lastExpr = "\"\"";
            }
            return null;
        }

        List<String> fields = classLayouts.get(className);
        int numFields = fields != null ? fields.size() : 0;

        // Allocate object in heap.
        output.emit("heap_alloc", String.valueOf(numFields), null, "AX_INT");

        // Store pointer in a fresh stack slot so we can push it as self later.
        int ptrSlot = nextOffset++;
        output.emit("store_int", "fp + " + ptrSlot, null, "AX_INT");

        List<ExpressionNodeZ> args = node.getArguments();
        int numArgs = args != null ? args.size() : 0;

        // Reserve return slot.
        output.emit("sptr_inc", "1", null, null);

        // Push self.
        output.emit("load_int", "fp + " + ptrSlot, null, "AX_INT");
        output.emit("store_int", "sptr", null, "AX_INT");
        output.emit("sptr_inc", "1", null, null);

        // Push user args.
        if (args != null) {
            for (ExpressionNodeZ arg : args) {
                String argRef = exprToString(arg);
                Type t = typeAnnotations.get(arg);
                TypeKind kind = t != null ? t.getKind() : TypeKind.INT;
                String suffix = kindToSuffix(kind);
                String axReg = "AX_" + suffix.toUpperCase();
                loadRegister(argRef, axReg);
                output.emit("store_" + suffix, "sptr", null, axReg);
                output.emit("sptr_inc", "1", null, null);
            }
        }

        String ctorName = className + "_" + className;
        output.emit("call", resolveFunctionName(ctorName), null, null);

        // sptr still points at return slot. Cleanup.
        output.emit("sptr_dec", String.valueOf(numArgs + 2), null, null);

        lastExpr = "stackinteger[fp + " + ptrSlot + "]";
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        // novus int[3][4] etc. For now delegate to a simple linear reservation.
        // TODO: dynamic dims + heap arrays when needed.
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        ExpressionNodeZ target = node.getTarget();
        String fieldName = node.getPropertyName();

        if (!(target instanceof IdentifierExpressionNodeZ id)) return null;

        ObjectInfo info = objectVariables.get(id.getIdentifier());
        if (info == null) return null;

        List<String> layout = classLayouts.get(info.getClassName());
        if (layout == null) return null;

        int fieldOffset = layout.indexOf(fieldName);
        if (fieldOffset < 0) return null;

        Type fieldType = typeAnnotations.get(node);
        TypeKind kind = fieldType != null ? fieldType.getKind() : TypeKind.INT;
        String suffix = kindToSuffix(kind);
        String arrayName = stackArrayForKind(kind);

        // Load pointer from stack slot.
        output.emit("load_int", "fp + " + info.getPtrSlot(), null, "AX_INT");

        String cxReg = "CX_" + suffix.toUpperCase();
        output.emit("heap_load_" + suffix,
                "stackinteger[AX_INT] + " + fieldOffset,
                null,
                cxReg);

        int dest = nextOffset++;
        output.emit("store_" + suffix, "fp + " + dest, null, cxReg);
        lastExpr = arrayName + "[fp + " + dest + "]";
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        // obj.arr[i] not yet supported.
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        String funcName = node.getFunctionName();
        List<ExpressionNodeZ> args = node.getArguments();
        int numArgs = args != null ? args.size() : 0;

        // Determine target name: obj.method() vs bare method().
        String targetFunc;
        boolean isMethodCall = node.getTarget() != null;

        if (isMethodCall) {
            // obj.method() -> Clase_method(self, args...)
            String className = null;
            if (node.getTarget() instanceof IdentifierExpressionNodeZ id) {
                ObjectInfo info = objectVariables.get(id.getIdentifier());
                if (info != null) className = info.getClassName();
            }
            if (className == null) return null;
            targetFunc = className + "_" + funcName;

            output.emit("sptr_inc", "1", null, null);

            // Push self.
            if (node.getTarget() instanceof IdentifierExpressionNodeZ id) {
                ObjectInfo info = objectVariables.get(id.getIdentifier());
                if (info != null) {
                    output.emit("load_int", "fp + " + info.getPtrSlot(), null, "AX_INT");
                    output.emit("store_int", "sptr", null, "AX_INT");
                    output.emit("sptr_inc", "1", null, null);
                }
            }
        } else {
            targetFunc = resolveFunctionName(funcName);

            // Is it an implicit 'this' method call?
            if (currentSelfSlot != null && currentClassName != null) {
                targetFunc = currentClassName + "_" + funcName;
                output.emit("sptr_inc", "1", null, null);

                // Push self from currentSelfSlot.
                output.emit("load_int", currentSelfSlot, null, "AX_INT");
                output.emit("store_int", "sptr", null, "AX_INT");
                output.emit("sptr_inc", "1", null, null);
            } else {
                output.emit("sptr_inc", "1", null, null);
            }
        }

        // Push user args.
        if (args != null) {
            for (ExpressionNodeZ arg : args) {
                String argRef = exprToString(arg);
                Type t = typeAnnotations.get(arg);
                TypeKind kind = t != null ? t.getKind() : TypeKind.INT;
                String suffix = kindToSuffix(kind);
                String axReg = "AX_" + suffix.toUpperCase();
                loadRegister(argRef, axReg);
                output.emit("store_" + suffix, "sptr", null, axReg);
                output.emit("sptr_inc", "1", null, null);
            }
        }

        output.emit("call", targetFunc, null, null);

        Type returnType = typeAnnotations.get(node);
        TypeKind returnKind = returnType != null ? returnType.getKind() : TypeKind.INT;
        String returnSuffix = kindToSuffix(returnKind);
        String returnArray = stackArrayForKind(returnKind);
        String cxReg = "CX_" + returnSuffix.toUpperCase();

        output.emit("load_" + returnSuffix, "sptr", null, cxReg);

        int destOffset = nextOffset++;
        output.emit("store_" + returnSuffix, "fp + " + destOffset, null, cxReg);

        // Cleanup: numArgs + 1 (return slot) + (isMethodCall || implicit this ? 1 : 0).
        int extra = (isMethodCall || currentSelfSlot != null) ? 1 : 0;
        output.emit("sptr_dec", String.valueOf(numArgs + 1 + extra), null, null);

        lastExpr = returnArray + "[fp + " + destOffset + "]";
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
    public Void visit(ArgumentsNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private String exprToString(ExpressionNodeZ node) {
        node.accept(this);
        return lastExpr;
    }

    private int allocateLocal(String name, ZAstNode node) {
        int offset = nextOffset++;
        localOffsets.put(name, offset);

        TypeKind kind = TypeKind.INT;
        if (node instanceof VariableDeclarationNodeZ decl && decl.getDataType() != null) {
            Type t = mapTypeNodeToType(decl.getDataType());
            if (t != null) {
                kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
            }
        } else if (node instanceof ForInitDeclarationNodeZ f && f.getType() != null) {
            Type t = mapTypeNodeToType(f.getType());
            if (t != null) {
                kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
            }
        } else {
            Type t = typeAnnotations.get(node);
            if (t != null) {
                kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
            }
        }
        localTypes.put(name, kind);
        return offset;
    }

    private Type mapTypeNodeToType(TypeNodeZ typeNode) {
        if (typeNode == null) return null;
        return switch (typeNode.getDataType()) {
            case INT -> Type.intType();
            case DOUBLE -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case VOID -> Type.voidType();
            case NULL -> Type.nullType();
            case CLASS -> "String".equals(typeNode.getCustomTypeName())
                    ? Type.stringType()
                    : Type.customType(typeNode.getCustomTypeName());
        };
    }

    private String getStackRefByName(String name) {
        Integer offset = localOffsets.get(name);
        if (offset == null) offset = paramOffsets.get(name);
        if (offset == null) return "0";

        TypeKind kind = localTypes.get(name);
        if (kind == null) kind = TypeKind.INT;
        return stackArrayForKind(kind) + "[fp + " + offset + "]";
    }

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

    private void storeValueTo(String valueRef, String destRef) {
        if (destRef == null || !destRef.startsWith("stack")) return;

        int bs = destRef.indexOf('[');
        int be = destRef.indexOf(']');
        if (bs < 0 || be <= bs) return;

        String arrayName = destRef.substring(0, bs);
        String offsetExpr = destRef.substring(bs + 1, be);
        String suffix = suffixForArray(arrayName);
        String cxRegister = "CX_" + suffix.toUpperCase();

        if (isRegister(valueRef)) {
            output.emit("store_" + suffix, offsetExpr, null, valueRef);
        } else if (valueRef != null && valueRef.startsWith("stack")) {
            loadRegister(valueRef, cxRegister);
            output.emit("store_" + suffix, offsetExpr, null, cxRegister);
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

    private String kindToSuffix(TypeKind kind) {
        if (kind == null) return "int";
        return switch (kind) {
            case STRING -> "string";
            case FLOAT -> "float";
            case CHAR -> "char";
            case BOOLEAN -> "boolean";
            default -> "int";
        };
    }

    private String resolveFunctionName(String bareName) {
        for (String fname : output.getFunctionNames()) {
            if (fname.startsWith(bareName + "_")) return fname;
        }
        return bareName;
    }

    private void emitIncDec(String targetRef, String op) {
        int oneOffset = nextOffset++;
        output.emit("=", "1", null, "stackinteger[fp + " + oneOffset + "]");
        loadRegister(targetRef, "AX_INT");
        loadRegister("stackinteger[fp + " + oneOffset + "]", "BX_INT");
        output.emit(op, "AX_INT", "BX_INT", "CX_INT");
        storeRegisterBack("CX_INT", targetRef);
    }

    private int registerParameter(ParameterNodeZ param) {
        String pname = param.getName();
        TypeKind kind = TypeKind.INT;
        int slots = 1;

        if (param.getType() != null) {
            Type t = mapTypeNodeToType(param.getType());
            if (t != null) {
                kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
                if (t.getKind() == TypeKind.CUSTOM && !"String".equals(t.getCustomName())) {
                    objectVariables.put(pname, new ObjectInfo(t.getCustomName(), nextOffset));
                }
            }
        }

        localTypes.put(pname, kind);
        paramOffsets.put(pname, nextOffset);
        nextOffset += slots;
        return slots;
    }

    private Integer tryExtractIntLiteral(ExpressionNodeZ expr) {
        if (expr instanceof LiteralExpressionNodeZ lit) {
            Object v = lit.getDataValue();
            if (v instanceof Integer i) return i;
        }
        return null;
    }
}