package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.*;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.ObjectInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.InstanceCreationExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.ShortlyOperationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.AccessorNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.instances.ExpressionStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.StructInstanceNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructPropertyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.VariableDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.BreakStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ContinueStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ReturnStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseBlockNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfListNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.IfStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.PrintStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.ReadStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.MaiorSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;

import java.util.*;

/**
 * Principal pig latin code generator
 *
 */
public class PigLatinCodeGeneratorVisitor implements PigLatinAstVisitor<Void> {

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

    private final Map<String, ObjectInfo> objectVariables = new HashMap<>();
    private final Map<String, StructInfo> structVariables = new HashMap<>();
    private final Map<String, ArrayInfo> arrayInfos = new HashMap<>();

    private final Map<String, List<String>> classLayouts;

    public PigLatinCodeGeneratorVisitor(GlobalSymbolTable table,
                                        EditorContext context,
                                        Map<AstNode, Type> typeAnnotations,
                                        CodeGeneratorOutput output,
                                        CodeGenContext ctx,
                                        StringPool stringPool,
                                        Map<String, List<String>> classLayouts) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
        this.output = output;
        this.ctx = ctx;
        this.stringPool = stringPool;
        this.classLayouts = classLayouts;
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodePigLatin node) {
        if (node.getBody() != null) node.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(BodyNodePigLatin node) {
        output.getFunctionNames().add("main");
        output.emit("function_start", "main", null, null);

        output.emit("=", "0", null, "sptr");
        output.emit("=", "0", null, "fp");
        nextOffset = 1;

        if (node.getVariablesSection() != null) {
            node.getVariablesSection().accept(this);
        }

        int slotsToReserve = nextOffset;
        if (slotsToReserve > 1) {
            output.emit("sptr_inc", String.valueOf(slotsToReserve), null, null);
        }

        if (node.getMaiorSection() != null) {
            node.getMaiorSection().accept(this);
        }

        output.emit("return", null, null, null);
        return null;
    }

    @Override
    public Void visit(MaiorSectionNodePigLatin node) {
        if (node.getStatements() != null) {
            node.getStatements().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CodeBodyNodePigLatin node) {
        if (node.getStatements() != null) {
            for (PigLatinAstNode s : node.getStatements()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(VariablesSectionNodePigLatin node) {
        if (node.getDeclarations() != null) node.getDeclarations().accept(this);
        return null;
    }

    @Override
    public Void visit(VariablesBodyNodePigLatin node) {
        if (node.getDeclarations() != null) {
            for (PigLatinAstNode d : node.getDeclarations()) {
                if (d != null) d.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ImportNodePigLatin node) {
        // Already merged by the orchestrator.
        return null;
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodePigLatin node) {
        String name = node.getIdentifier();

        TypeNodePigLatin dataType = node.getDataType();
        if (dataType == null && node.getInitializer() instanceof InstanceCreationExpressionNodePigLatin inst) {
            dataType = new TypeNodePigLatin(node.getLine(), node.getColumn(), DataType.CUSTOM, inst.getClassName());
        }

        Type declaredType = mapTypeNodeToType(dataType);

        boolean isObject = declaredType != null
                && declaredType.isCustom()
                && !"String".equals(declaredType.getCustomName());


        boolean isStruct = false;
        if (isObject) {
            Symbol sym = findTypeSymbolGlobal(declaredType.getCustomName());
            if (sym != null && sym.getKind() == SymbolKind.STRUCT) {
                isStruct = true;
                isObject = false;
            }
        }

        int offset = allocateLocal(name, node);

        if (isObject) {
            objectVariables.put(name, new ObjectInfo(declaredType.getCustomName(), offset));
        } else if (isStruct) {
            structVariables.put(name, new StructInfo(declaredType.getCustomName(), offset, false));
        }

        if (node.getInitializer() != null) {
            String valueRef = exprToString(node.getInitializer());
            if (valueRef != null) {
                String dest = getStackRefByName(name);
                storeValueTo(valueRef, dest);
            }
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {

        int totalSize = 1;
        boolean allLiteral = true;
        if (node.getDimensions() != null) {
            for (ExpressionNodePigLatin dim : node.getDimensions()) {
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
        if (elementKind == TypeKind.CUSTOM) elementKind = TypeKind.INT;

        arrayInfos.put(node.getIdentifier(),
                new ArrayInfo(base, elementKind, totalSize, false));

        System.out.println("  → registered base=" + base + " totalSize=" + totalSize);

        if (node.getInitializer() != null && node.getInitializer().getElements() != null) {
            List<ExpressionNodePigLatin> values = node.getInitializer().getElements();
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
    public Void visit(StructInstanceNodePigLatin node) {
        // struct declaration with literal -> stack struct
        String name = node.getIdentifier();
        String structType = node.getStructType();
        List<String> layout = classLayouts.get(structType);
        int numFields = layout != null ? layout.size() : 0;

        int base = nextOffset;
        nextOffset += numFields;
        structVariables.put(name, new StructInfo(structType, base, false));

        // Fill fields (positional).
        if (node.getLiteral() != null && node.getLiteral().getProperties() != null) {
            List<StructPropertyNodePigLatin> props = node.getLiteral().getProperties();
            for (int i = 0; i < props.size() && i < numFields; i++) {
                StructPropertyNodePigLatin prop = props.get(i);
                if (prop.getValue() == null) continue;

                Type fieldType = typeAnnotations.get(prop.getValue());
                TypeKind kind = fieldType != null ? fieldType.getKind() : TypeKind.INT;
                if (kind == TypeKind.CUSTOM || kind == TypeKind.NULL) kind = TypeKind.INT;
                String suffix = kindToSuffix(kind);
                String cxReg = "CX_" + suffix.toUpperCase();

                String valueRef = exprToString(prop.getValue());
                loadRegister(valueRef, cxReg);
                output.emit("store_" + suffix, "fp + " + (base + i), null, cxReg);
            }
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        String name = node.getId();
        allocateLocal(name, node);
        if (node.getExpr() != null) {
            String valueRef = exprToString(node.getExpr());
            String dest = getStackRefByName(name);
            storeValueTo(valueRef, dest);
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        if (node.getId() != null && node.getExpr() != null) {
            String targetRef = getStackRefByName(node.getId());
            String valueRef = exprToString(node.getExpr());
            storeValueTo(valueRef, targetRef);
        }
        return null;
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
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

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        if (node.getIdentifier() instanceof MemberArrayAccessExpressionNodePigLatin arrAccess) {
            if (!(arrAccess.getTarget() instanceof IdentifierExpressionNodePigLatin id)) return null;
            String arrayName = id.getIdentifier();
            ArrayInfo info = arrayInfos.get(arrayName);
            if (info == null) return null;

            String suffix = kindToSuffix(info.getElementType());
            String arrayStack = stackArrayForKind(info.getElementType());
            String cxReg = "CX_" + suffix.toUpperCase();

            String valueRef = exprToString(node.getExpressionNode());
            loadRegister(valueRef, cxReg);

            String indexRef = exprToString(arrAccess.getIndex());
            loadRegister(indexRef, "AX_INT");

            output.emit("array_store_" + suffix,
                    arrayStack + ", fp + " + info.getBaseOffset(),
                    "AX_INT",
                    cxReg);
            return null;
        }

        String valueRef = exprToString(node.getExpressionNode());
        String targetRef = exprToString(node.getIdentifier());
        storeValueTo(valueRef, targetRef);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
        String targetRef = exprToString(node.getTarget());
        String valueRef = exprToString(node.getValue());
        String op = shortlyOpToBinary(node.getOperator());

        loadRegister(targetRef, "AX_INT");
        loadRegister(valueRef, "BX_INT");
        output.emit(op, "AX_INT", "BX_INT", "CX_INT");
        storeRegisterBack("CX_INT", targetRef);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodePigLatin node) {
        emitIncDec(exprToString(node.getTargetVariable()), "+");
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        emitIncDec(exprToString(node.getTargetVariable()), "-");
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        emitIncDec(exprToString(node.getTargetVariable()), "+");
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        emitIncDec(exprToString(node.getTargetVariable()), "-");
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        if (node.getExpressionList() != null) {
            for (ExpressionNodePigLatin expr : node.getExpressionList()) {
                String valueRef = exprToString(expr);
                Type t = typeAnnotations.get(expr);
                String typeName = typeToString(t);
                String register = registerFor(typeName);
                loadRegister(valueRef, register);
                output.emit("println", register, typeName, null);
            }
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        if (node.getTarget() != null) {
            String targetRef = exprToString(node.getTarget());
            Type t = typeAnnotations.get(node.getTarget());
            TypeKind kind = t != null ? t.getKind() : TypeKind.INT;
            if (kind == TypeKind.STRING) {
                output.emit("read_string_to", targetRef, null, null);
            } else {
                output.emit("read_int_to", targetRef, null, null);
            }
        } else {
            int offset = nextOffset++;
            output.emit("read_string", String.valueOf(offset), null, null);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
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
    public Void visit(BreakStatementNodePigLatin node) {
        if (!breakLabels.isEmpty()) output.emit("goto", null, null, breakLabels.peek());
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodePigLatin node) {
        if (!continueLabels.isEmpty()) output.emit("goto", null, null, continueLabels.peek());
        return null;
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        String endLabel = ctx.nextLabel();

        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");

        String elseLabel = ctx.nextLabel();
        output.emit("ifFalse", "AX_INT", null, elseLabel);

        if (node.getThenBody() != null) {
            for (PigLatinAstNode s : node.getThenBody()) {
                if (s != null) s.accept(this);
            }
        }
        output.emit("goto", null, null, endLabel);
        output.emit("label", elseLabel, null, null);

        if (node.getElseIfs() != null) {
            for (ElseIfNodePigLatin elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;

                String condRef2 = exprToString(elseIf.getCondition());
                loadRegister(condRef2, "AX_INT");

                String nextElse = ctx.nextLabel();
                output.emit("ifFalse", "AX_INT", null, nextElse);

                if (elseIf.getBody() != null) {
                    for (PigLatinAstNode s : elseIf.getBody()) {
                        if (s != null) s.accept(this);
                    }
                }
                output.emit("goto", null, null, endLabel);
                output.emit("label", nextElse, null, null);
            }
        }

        if (node.getElseBlockNode() != null && node.getElseBlockNode().getBody() != null) {
            for (PigLatinAstNode s : node.getElseBlockNode().getBody()) {
                if (s != null) s.accept(this);
            }
        }

        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        String startLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("label", startLabel, null, null);
        String condRef = exprToString(node.getCondition());
        loadRegister(condRef, "AX_INT");
        output.emit("ifFalse", "AX_INT", null, endLabel);

        breakLabels.push(endLabel);
        continueLabels.push(startLabel);

        if (node.getBody() != null) node.getBody().accept(this);

        continueLabels.pop();
        breakLabels.pop();

        output.emit("goto", null, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        String startLabel = ctx.nextLabel();
        String condLabel = ctx.nextLabel();
        String endLabel = ctx.nextLabel();

        output.emit("label", startLabel, null, null);
        breakLabels.push(endLabel);
        continueLabels.push(condLabel);

        if (node.getBody() != null) node.getBody().accept(this);

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
    public Void visit(ForStatementNodePigLatin node) {
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

        if (node.getBody() != null) node.getBody().accept(this);

        continueLabels.pop();
        breakLabels.pop();

        output.emit("label", continueLabel, null, null);
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        output.emit("goto", null, null, startLabel);
        output.emit("label", endLabel, null, null);
        return null;
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================

    @Override
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodePigLatin node) {
        Type t = typeAnnotations.get(node);
        Object value = node.getDataValue();

        if (t != null && t.getKind() == TypeKind.STRING) {
            lastExpr = stringPool.intern(String.valueOf(value));
            return null;
        }
        if (t != null && t.getKind() == TypeKind.BOOLEAN) {
            lastExpr = Boolean.TRUE.equals(value) ? "1" : "0";
            return null;
        }
        if (t != null && t.getKind() == TypeKind.NULL) {
            lastExpr = "0";
            return null;
        }

        if (value == null) {
            if (node.getValueType() == DataType.INT) lastExpr = "0";
            else if (node.getValueType() == DataType.DECIMAL) lastExpr = "0.0";
            else if (node.getValueType() == DataType.CHAR) lastExpr = "'\\0'";
            else if (node.getValueType() == DataType.STRING) lastExpr = "\"\"";
            else if (node.getValueType() == DataType.BOOLEAN) lastExpr = "0";
            else lastExpr = "0";
            return null;
        }

        lastExpr = String.valueOf(value);
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        lastExpr = getStackRefByName(node.getIdentifier());
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
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

        TypeKind resultKind = resultType != null ? resultType.getKind() : TypeKind.INT;
        String resultSuffix = kindToSuffix(resultKind);
        String cReg = "CX_" + resultSuffix.toUpperCase();

        boolean isStringConcat = (resultKind == TypeKind.STRING
                && node.getOperator() == BinaryOperator.PLUS);

        String leftRef = exprToString(node.getLeft());
        String rightRef = exprToString(node.getRight());

        if (isStringConcat) {
            String leftStr = ensureStringRef(leftRef, leftKind);
            String rightStr = ensureStringRef(rightRef, rightKind);

            loadRegister(leftStr, "AX_STRING");
            loadRegister(rightStr, "BX_STRING");
            output.emit("strcat", "AX_STRING", "BX_STRING", "CX_STRING");

            int offset = nextOffset++;
            output.emit("store_string", "fp + " + offset, null, "CX_STRING");
            lastExpr = "stackstring[fp + " + offset + "]";
            return null;
        }

        String operandSuffix = kindToSuffix(operandKind);
        String aReg = "AX_" + operandSuffix.toUpperCase();
        String bReg = "BX_" + operandSuffix.toUpperCase();

        loadRegister(leftRef, aReg);
        loadRegister(rightRef, bReg);

        String op = binaryOpToSymbol(node.getOperator());
        output.emit(op, aReg, bReg, cReg);

        int offset = nextOffset++;
        String dest = stackArrayForKind(resultKind) + "[fp + " + offset + "]";
        output.emit("store_" + resultSuffix, "fp + " + offset, null, cReg);
        lastExpr = dest;
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodePigLatin node) {
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

    // ============================================================
    // OBJECTS AND STRUCTS
    // ============================================================

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        String className = node.getClassName();

        if ("String".equals(className)) {
            if (node.getArguments() != null && !node.getArguments().isEmpty()) {
                lastExpr = exprToString(node.getArguments().get(0));
            } else {
                lastExpr = "\"\"";
            }
            return null;
        }

        output.emit("sptr_inc", "200", null, null);

        List<String> fields = classLayouts.get(className);
        int numFields = fields != null ? fields.size() : 0;

        output.emit("heap_alloc", String.valueOf(numFields), null, "AX_INT");

        int ptrSlot = nextOffset++;
        output.emit("store_int", "fp + " + ptrSlot, null, "AX_INT");

        List<ExpressionNodePigLatin> args = node.getArguments();
        int numArgs = args != null ? args.size() : 0;
        
        output.emit("sptr_inc", "1", null, null);
        output.emit("load_int", "fp + " + ptrSlot, null, "AX_INT");
        output.emit("store_int", "sptr", null, "AX_INT");
        output.emit("sptr_inc", "1", null, null);

        if (args != null) {
            for (ExpressionNodePigLatin arg : args) {
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

        String ctorName = className + "_" + className + "_" + numArgs;
        output.emit("call", ctorName, null, null);
        output.emit("sptr_dec", String.valueOf(numArgs + 2 + 200), null, null);

        lastExpr = "stackinteger[fp + " + ptrSlot + "]";
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodePigLatin node) {
        ExpressionNodePigLatin target = node.getTarget();
        String fieldName = node.getPropertyName();

        if (!(target instanceof IdentifierExpressionNodePigLatin id)) return null;
        String idName = id.getIdentifier();

        ObjectInfo oinfo = objectVariables.get(idName);
        if (oinfo != null) {
            List<String> layout = classLayouts.get(oinfo.getClassName());
            if (layout == null) return null;
            int fieldOffset = layout.indexOf(fieldName);
            if (fieldOffset < 0) return null;

            Type fieldType = typeAnnotations.get(node);
            TypeKind kind = fieldType != null ? fieldType.getKind() : TypeKind.INT;
            String suffix = kindToSuffix(kind);
            String cxReg = "CX_" + suffix.toUpperCase();

            output.emit("load_int", "fp + " + oinfo.getPtrSlot(), null, "AX_INT");
            output.emit("heap_load_" + suffix,
                    "stackinteger[AX_INT] + " + fieldOffset, null, cxReg);

            int dest = nextOffset++;
            output.emit("store_" + suffix, "fp + " + dest, null, cxReg);
            lastExpr = stackArrayForKind(kind) + "[fp + " + dest + "]";
            return null;
        }

        StructInfo sinfo = structVariables.get(idName);
        if (sinfo != null) {
            List<String> layout = classLayouts.get(sinfo.getStructTypeName());
            if (layout == null) return null;
            int fieldOffset = layout.indexOf(fieldName);
            if (fieldOffset < 0) return null;

            Type fieldType = typeAnnotations.get(node);
            TypeKind kind = fieldType != null ? fieldType.getKind() : TypeKind.INT;
            String arrayName = stackArrayForKind(kind);
            lastExpr = arrayName + "[fp + " + (sinfo.getBaseOffset() + fieldOffset) + "]";
            return null;
        }

        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodePigLatin node) {
        if (!(node.getTarget() instanceof IdentifierExpressionNodePigLatin id)) {
            return null;
        }
        String arrayName = id.getIdentifier();
        ArrayInfo info = arrayInfos.get(arrayName);
        if (info == null) return null;

        String suffix = kindToSuffix(info.getElementType());
        String arrayStack = stackArrayForKind(info.getElementType());
        String cxReg = "CX_" + suffix.toUpperCase();
        int dest = nextOffset++;

        String indexRef = exprToString(node.getIndex());
        loadRegister(indexRef, "AX_INT");

        output.emit("array_load_" + suffix,
                arrayStack + ", fp + " + info.getBaseOffset(),
                "AX_INT",
                cxReg);

        output.emit("store_" + suffix, "fp + " + dest, null, cxReg);
        lastExpr = arrayStack + "[fp + " + dest + "]";
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodePigLatin node) {
        System.out.println("ARRAY CALL: " + node.getArrayName() + " info=" + arrayInfos.get(node.getArrayName()));
        String arrayName = node.getArrayName();
        ArrayInfo info = arrayInfos.get(arrayName);
        if (info == null) return null;

        String suffix = kindToSuffix(info.getElementType());
        String arrayStack = stackArrayForKind(info.getElementType());
        String cxReg = "CX_" + suffix.toUpperCase();
        int dest = nextOffset++;

        String indexRef = exprToString(node.getIndexExpression());
        loadRegister(indexRef, "AX_INT");
        output.emit("array_load_" + suffix,
                arrayStack + ", fp + " + info.getBaseOffset(),
                "AX_INT",
                cxReg);

        output.emit("store_" + suffix, "fp + " + dest, null, cxReg);
        lastExpr = arrayStack + "[fp + " + dest + "]";
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {

        String funcName = node.getFunctionName();
        List<ExpressionNodePigLatin> args = node.getArguments();
        int numArgs = args != null ? args.size() : 0;

        boolean isMethodCall = node.getTarget() != null;
        String targetFunc;
        boolean pushSelf = false;

        output.emit("sptr_inc", "200", null, null);

        if (isMethodCall) {
            String className = null;
            String selfPtrExpr = null;

            if (node.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
                ObjectInfo oinfo = objectVariables.get(id.getIdentifier());
                if (oinfo != null) {
                    className = oinfo.getClassName();
                    selfPtrExpr = "fp + " + oinfo.getPtrSlot();
                }
            }

            if (className == null || selfPtrExpr == null) {
                output.emit("sptr_dec", "200", null, null);
                return null;
            }

            targetFunc = className + "_" + funcName + "_" + numArgs;
            pushSelf = true;

            output.emit("sptr_inc", "1", null, null);
            output.emit("load_int", selfPtrExpr, null, "AX_INT");
            output.emit("store_int", "sptr", null, "AX_INT");
            output.emit("sptr_inc", "1", null, null);
        } else {
            targetFunc = resolveFunctionName(funcName);
            output.emit("sptr_inc", "1", null, null);
        }

        if (args != null) {
            for (ExpressionNodePigLatin arg : args) {
                if (arg instanceof IdentifierExpressionNodePigLatin id) {         // FIX: mismo bloque que Y
                    String name = id.getIdentifier();

                    ArrayInfo aInfo = arrayInfos.get(name);
                    if (aInfo != null) {
                        output.emit("+", "fp", String.valueOf(aInfo.getBaseOffset()), "AX_INT");
                        output.emit("store_int", "sptr", null, "AX_INT");
                        output.emit("sptr_inc", "1", null, null);
                        continue;
                    }

                    StructInfo sInfo = structVariables.get(name);
                    if (sInfo != null) {
                        output.emit("+", "fp", String.valueOf(sInfo.getBaseOffset()), "AX_INT");
                        output.emit("store_int", "sptr", null, "AX_INT");
                        output.emit("sptr_inc", "1", null, null);
                        continue;
                    }
                }

                String argRef = exprToString(arg);
                Type t = typeAnnotations.get(arg);
                TypeKind kind = t != null ? t.getKind() : TypeKind.INT;
                if (kind == TypeKind.CUSTOM || kind == TypeKind.NULL) kind = TypeKind.INT;
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
        int extra = pushSelf ? 1 : 0;
        int retOffset = numArgs + 1 + extra;
        int cleanup = numArgs + 1 + extra + 200;

        if (returnKind == TypeKind.VOID) {
            output.emit("sptr_dec", String.valueOf(cleanup), null, null);
            lastExpr = null;
            return null;
        }

        String returnSuffix = kindToSuffix(returnKind);
        String returnArray = stackArrayForKind(returnKind);
        String cxReg = "CX_" + returnSuffix.toUpperCase();

        output.emit("load_" + returnSuffix, "sptr - " + retOffset, null, cxReg);
        int destOffset = nextOffset++;
        output.emit("store_" + returnSuffix, "fp + " + destOffset, null, cxReg);
        output.emit("sptr_dec", String.valueOf(cleanup), null, null);

        lastExpr = returnArray + "[fp + " + destOffset + "]";
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(TypeNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructBodyNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructDeclarationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructAttributeNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(AccessorNodePigLatin node) {
        return null;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private String exprToString(ExpressionNodePigLatin node) {
        node.accept(this);
        return lastExpr;
    }

    private int allocateLocal(String name, PigLatinAstNode node) {
        int offset = nextOffset++;
        localOffsets.put(name, offset);

        TypeKind kind = TypeKind.INT;
        if (node instanceof VariableDeclarationNodePigLatin decl && decl.getDataType() != null) {
            Type t = mapTypeNodeToType(decl.getDataType());
            if (t != null) kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
        } else if (node instanceof ForInitDeclarationNodePigLatin f && f.getType() != null) {
            Type t = mapTypeNodeToType(f.getType());
            if (t != null) kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
        } else {
            Type t = typeAnnotations.get(node);
            if (t != null) kind = (t.getKind() == TypeKind.CUSTOM) ? TypeKind.INT : t.getKind();
        }
        localTypes.put(name, kind);
        return offset;
    }

    private Type mapTypeNodeToType(TypeNodePigLatin typeNode) {
        if (typeNode == null) return null;
        return switch (typeNode.getDataType()) {
            case INT -> Type.intType();
            case DECIMAL -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case CUSTOM -> "String".equals(typeNode.getCustomTypeName())
                    ? Type.stringType()
                    : Type.customType(typeNode.getCustomTypeName());
            default -> Type.unknown();
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
            case NEGATE -> "neg";
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

    private Integer tryExtractIntLiteral(ExpressionNodePigLatin expr) {
        if (expr instanceof LiteralExpressionNodePigLatin lit) {
            Object v = lit.getDataValue();
            if (v instanceof Integer i) return i;
        }
        return null;
    }

    private Symbol findTypeSymbolGlobal(String typeName) {
        if (typeName == null) return null;

        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), typeName);
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT) return s;
        }

        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol symbol : bucket) {
                    if ((symbol.getKind() == SymbolKind.CLASS || symbol.getKind() == SymbolKind.STRUCT)
                            && symbol.getName().equals(typeName)) {
                        return symbol;
                    }
                }
            }
        }

        SymbolScope global = table.getGlobalScope();
        for (List<Symbol> bucket : global.getSymbols().values()) {
            for (Symbol s : bucket) {
                if ((s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT)
                        && s.getName().equals(typeName)) {
                    return s;
                }
            }
        }
        return null;
    }


    private String ensureStringRef(String operandRef, TypeKind operandKind) {
        if (operandKind == TypeKind.STRING) {
            return operandRef;
        }

        String reg;
        String opName;
        switch (operandKind) {
            case FLOAT -> {
                reg = "AX_FLOAT";
                opName = "to_string_float";
            }
            case CHAR -> {
                reg = "AX_CHAR";
                opName = "to_string_char";
            }
            case BOOLEAN -> {
                reg = "AX_BOOLEAN";
                opName = "to_string_boolean";
            }
            default -> {
                reg = "AX_INT";
                opName = "to_string_int";
            }
        }

        loadRegister(operandRef, reg);

        int bufOffset = nextOffset++;
        output.emit("alloc_string", null, null, "CX_STRING");
        output.emit("store_string", "fp + " + bufOffset, null, "CX_STRING");

        output.emit(opName, reg, null, "stackstring[fp + " + bufOffset + "]");

        return "stackstring[fp + " + bufOffset + "]";
    }
}