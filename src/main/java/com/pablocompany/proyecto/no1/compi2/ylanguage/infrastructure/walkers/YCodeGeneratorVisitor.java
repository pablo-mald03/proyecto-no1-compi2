package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Cell;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Constant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.FieldReference;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Text;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePush;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FrameRebase;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Move;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.LoadAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Return;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Frame;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Indirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.FunctionFrame;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.IntermediateTypes;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.StructLayout;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.ValueEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.naming.NameMangler;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.ArrayInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StructInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.StructInstanceNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructPropertyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.ArrayCallExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.FunctionCallExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.IdentifierExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.LiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.VariableDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.functions.FunctionsRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.StructuresRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen.SymbolLookup;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen.YNoOperatorVisitor;

import java.util.*;


/**
 * Principal visitor to execute the code generator
 */
public class YCodeGeneratorVisitor extends YNoOperatorVisitor {

    private static final int CALL_AREA = 200;

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;
    private final IntermediateBuilder ir;
    private final CodeGenContext labels;

    private final Deque<String> breakLabels = new ArrayDeque<>();
    private final Deque<String> continueLabels = new ArrayDeque<>();

    private FunctionFrame frame = new FunctionFrame();
    private ValueEmitter values;
    private Value last;
    private Symbol currentFunctionSymbol;

    private final SymbolLookup symbols;
    private final StructLayout layout;

    public YCodeGeneratorVisitor(GlobalSymbolTable table, EditorContext context,
                                 Map<AstNode, Type> typeAnnotations,
                                 Map<AstNode, Symbol> resolvedCalls,
                                 IntermediateBuilder ir, CodeGenContext labels) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
        this.ir = ir;
        this.labels = labels;
        this.values = new ValueEmitter(ir, frame);
        this.symbols = new SymbolLookup(table, resolvedCalls);
        this.layout = new StructLayout(table);
    }
    // ============================================================ top level

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
        if (node.getFunctions() == null) return null;
        for (YAstNode fn : node.getFunctions()) if (fn != null) fn.accept(this);
        return null;
    }

    @Override
    public Void visit(StructDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        String name = node.getIdentifier();
        String structType = node.getStructType();
        int totalCells = layout.structSizeCells(structType);
        int base = frame.allocate(totalCells);
        frame.registerStruct(name, new StructInfo(structType, base, false));
        frame.declare(name, ValueType.INT);

        if (node.getLiteral() != null) {
            populateStructLiteral(base, structType, node.getLiteral());
        }
        return null;
    }

    private void populateStructLiteral(int base, String structType, StructLiteralExpressionNodeY lit) {
        if (lit.getProperties() == null) return;
        List<Symbol> members = layout.members(structType);
        List<StructPropertyNodeY> props = lit.getProperties();
        int count = Math.min(props.size(), members != null ? members.size() : 0);
        for (int i = 0; i < count; i++) {
            StructPropertyNodeY prop = props.get(i);
            if (prop.getValue() == null) continue;
            Symbol member = members.get(i);
            int cellOff = layout.fieldOffsetCells(structType, member.getName());
            if (member.isArray()) {
                // Embedded array: copy source elements into struct slots
                int arrayCells = layout.fieldSizeCells(structType, member.getName());
                ArrayInfo srcInfo = (prop.getValue() instanceof IdentifierExpressionNodeY id)
                        ? frame.arrayOf(id.getIdentifier()) : null;
                if (srcInfo != null) {
                    // copy from source array
                    ValueType elemType = IntermediateTypes.of(srcInfo.getElementType());
                    Register idx = Register.ax(ValueType.INT);
                    Register val = Register.cx(elemType);
                    for (int j = 0; j < arrayCells; j++) {
                        ir.emit(new Move(new Immediate(String.valueOf(j), ValueType.INT), idx));
                        if (srcInfo.isHeap()) {
                            Register ptr = Register.bx(ValueType.INT);
                            ir.emit(new Load(MemorySpace.STACK, new Frame(srcInfo.getBaseOffset()), ptr));
                            ir.emit(new IndexAddress(ptr, idx, ptr));
                            ir.emit(new Load(MemorySpace.STACK, new Indirect(ptr, 0), val));
                        } else {
                            ir.emit(new LoadIndexed(new Frame(srcInfo.getBaseOffset()), idx, val));
                        }
                        ir.emit(new Store(MemorySpace.STACK, new Frame(base + cellOff + j), val));
                    }
                }
                // else: source not known at compile time, skip initialization
            } else {
                Value val = eval(prop.getValue());
                values.store(val, new Cell(val.type(), new Frame(base + cellOff)));
            }
        }
    }

    // ==== Functions ===

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        Symbol fnSymbol = symbols.declaration(
                context.getFilePath(),
                node.getName(),
                node.getLine(),
                node.getColumn()
        );
        generateFunction(fnSymbol, node.getParameters(), node.getBody());
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        Symbol fnSymbol = symbols.declaration(
                context.getFilePath(),
                node.getName(),
                node.getLine(),
                node.getColumn()
        );
        generateFunction(fnSymbol, node.getParameters(), node.getBody());
        return null;
    }

    private void generateFunction(Symbol fnSymbol,
                                  List<? extends ParameterNodeY> params,
                                  List<? extends YAstNode> body) {
        int numArgs = params != null ? params.size() : 0;

        ir.beginFunction(NameMangler.functionName(fnSymbol));
        frame = new FunctionFrame();
        values = new ValueEmitter(ir, frame);
        breakLabels.clear();
        continueLabels.clear();

        currentFunctionSymbol = fnSymbol;

        ir.emit(new FramePush());
        ir.emit(new FrameRebase(numArgs + 1));

        if (params != null) {
            for (ParameterNodeY p : params) if (p != null) registerParameter(p);
        }
        visitAll(body);

        ir.emit(new FramePop());
        ir.emit(new Return());

        currentFunctionSymbol = null;
    }

    private void registerParameter(ParameterNodeY param) {
        ValueType type = ValueType.INT;
        int offset = frame.peekOffset();
        if (param instanceof PrimitiveParameterNodeY p && p.getType() != null) {
            type = declaredType(p.getType());
        } else if (param instanceof StructParameterNodeY sp && sp.getDataType() != null) {
            frame.registerStruct(param.getIdentifier(), new StructInfo(sp.getDataType().getCustomTypeName(), offset, true));
        } else if (param instanceof ArrayParameterNodeY ap && ap.getElementType() != null) {
            TypeKind element = kindOf(ap.getElementType());
            frame.registerArray(param.getIdentifier(), new ArrayInfo(offset, element, -1, true));
        }
        frame.declare(param.getIdentifier(), type);
    }

    // ============================================================ declarations

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        declareAndInitialize(node.getIdentifier(), declaredType(node.getDataType()), node.getInitializer());
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        declareAndInitialize(node.getId(), declaredType(node.getType()), node.getExpr());
        return null;
    }

    private void declareAndInitialize(String name, ValueType type, ExpressionNodeY initializer) {
        Cell variable = frame.declare(name, type);
        if (initializer == null) return;
        if (initializer instanceof ReadStatementNodeY) {
            ir.emit(new Read(type, variable.getAddress()));
            return;
        }
        values.store(eval(initializer), variable);
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        int total = 1;
        boolean allLiteral = true;
        if (node.getDimensions() != null) {
            for (ExpressionNodeY dim : node.getDimensions()) {
                Integer size = literalInt(dim);
                if (size == null) {
                    allLiteral = false;
                    break;
                }
                total *= size;
            }
        }
        if (!allLiteral) total = 1;

        int base = frame.allocate(total);
        TypeKind elementKind = kindOf(node.getDataType());
        ValueType elementType = IntermediateTypes.of(elementKind);
        frame.registerArray(node.getIdentifier(), new ArrayInfo(base, elementKind, total, false));

        if (node.getInitializer() instanceof ArrayInitExpressionNodeY init && init.getElements() != null) {
            List<ExpressionNodeY> elements = init.getElements();
            for (int i = 0; i < elements.size() && i < total; i++) {
                values.store(eval(elements.get(i)), new Cell(elementType, new Frame(base + i)));
            }
        }
        return null;
    }

    // ============================================================ statements

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        Value value = eval(node.getExpressionNode());
        assign(node.getIdentifier(), value);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        Value targetVal = eval(node.getTarget());
        Value operand = eval(node.getValue());
        Value newVal;
        ValueType targetAnn = typeAnnotations.containsKey(node.getTarget()) ? valueTypeOf(node.getTarget()) : null;
        if (node.getOperator() == ShortlyOperator.PLUS_ASSIGN &&
                (targetAnn == ValueType.STRING || targetVal.type() == ValueType.STRING || operand.type() == ValueType.STRING)) {
            newVal = concat(targetVal, operand);
        } else {
            BinaryOperations op = IntermediateTypes.shortly(node.getOperator());
            ValueType type = operandTypeOf(targetVal, operand);
            Register a = Register.ax(type), b = Register.bx(type), c = Register.cx(type);
            values.loadCoerced(targetVal, a);
            values.loadCoerced(operand, b);
            ir.emit(new BinaryOperation(op, a, b, c));
            newVal = values.spill(c);
        }
        assign(node.getTarget(), newVal);
        last = newVal;
        return null;
    }

    private void handleIncDec(ExpressionNodeY target, BinaryOperations op, boolean isPrefix) {
        Value currentVal = eval(target);
        ValueType type = currentVal.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT;
        Register a = Register.ax(type);
        Register b = Register.bx(type);
        Register c = Register.cx(type);
        values.loadCoerced(currentVal, a);

        Cell prevVal = null;
        if (!isPrefix) {
            prevVal = values.spill(a);
        }

        ir.emit(new Move(new Immediate("1", type), b));
        ir.emit(new BinaryOperation(op, a, b, c));
        Cell newVal = values.spill(c);

        assign(target, newVal);

        last = isPrefix ? newVal : prevVal;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        handleIncDec(node.getTargetVariable(), BinaryOperations.ADD, false);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        handleIncDec(node.getTargetVariable(), BinaryOperations.SUB, false);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        handleIncDec(node.getTargetVariable(), BinaryOperations.ADD, true);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        handleIncDec(node.getTargetVariable(), BinaryOperations.SUB, true);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        if (node.getExpression() == null) return null;
        Value value = eval(node.getExpression());
        Register reg = Register.ax(value.type());
        values.loadCoerced(value, reg);
        ir.emit(new Print(reg, true));
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        ValueType type = valueTypeOf(node);
        Cell cell = frame.temp(type);
        ir.emit(new Read(type, cell.getAddress()));
        last = cell;
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        if (node.getValue() != null) {

            Value value = eval(node.getValue());
            ValueType returnType = returnTypeOf(currentFunctionSymbol);
            Register scratch = Register.ax(returnType);
            values.loadCoerced(value, scratch);
            ir.emit(new Store(MemorySpace.STACK, new Frame(0), scratch));
        }
        ir.emit(new FramePop());
        ir.emit(new Return());
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        if (!breakLabels.isEmpty()) ir.emit(new Jump(breakLabels.peek()));
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
        if (!continueLabels.isEmpty()) ir.emit(new Jump(continueLabels.peek()));
        return null;
    }

    // ============================================================ control flow

    @Override
    public Void visit(IfStatementNodeY node) {
        String end = labels.nextLabel();
        String next = labels.nextLabel();

        branch(node.getCondition(), false, next);
        visitAll(node.getThenBody());
        ir.emit(new Jump(end));
        ir.emit(new MarkLabel(next));

        if (node.getElseIfs() != null) {
            for (ElseIfNodeY elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;
                String skip = labels.nextLabel();
                branch(elseIf.getCondition(), false, skip);
                visitAll(elseIf.getBody());
                ir.emit(new Jump(end));
                ir.emit(new MarkLabel(skip));
            }
        }
        if (node.getElseBlockNode() != null) visitAll(node.getElseBlockNode().getBody());
        ir.emit(new MarkLabel(end));
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        String start = labels.nextLabel();
        String end = labels.nextLabel();

        ir.emit(new MarkLabel(start));
        branch(node.getCondition(), false, end);
        loopBody(node.getBody(), end, start);
        ir.emit(new Jump(start));
        ir.emit(new MarkLabel(end));
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        String start = labels.nextLabel();
        String cond = labels.nextLabel();
        String end = labels.nextLabel();

        ir.emit(new MarkLabel(start));
        loopBody(node.getBody(), end, cond);
        ir.emit(new MarkLabel(cond));
        branch(node.getCondition(), true, start);
        ir.emit(new MarkLabel(end));
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        String start = labels.nextLabel();
        String update = labels.nextLabel();
        String end = labels.nextLabel();

        if (node.getInit() != null) node.getInit().accept(this);
        ir.emit(new MarkLabel(start));
        if (node.getCondition() != null) branch(node.getCondition(), false, end);
        loopBody(node.getBody(), end, update);
        ir.emit(new MarkLabel(update));
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        ir.emit(new Jump(start));
        ir.emit(new MarkLabel(end));
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        switch (node.getOperator()) {
            case INCREMENT, PREFIX_INCREMENT -> handleIncDec(node.getTarget(), BinaryOperations.ADD, false);
            case DECREMENT, PREFIX_DECREMENT -> handleIncDec(node.getTarget(), BinaryOperations.SUB, false);
            case ASSIGN -> {
                if (node.getValue() != null) assign(node.getTarget(), eval(node.getValue()));
            }
        }
        return null;
    }


    @Override
    public Void visit(SwitchStatementNodeY node) {
        String end = labels.nextLabel();
        Value selector = eval(node.getSelector());
        List<SwitchCaseNodeY> cases = node.getCases() != null ? node.getCases() : List.of();
        List<String> bodyLabels = new ArrayList<>();

        for (SwitchCaseNodeY c : cases) {
            String bodyLabel = labels.nextLabel();
            bodyLabels.add(bodyLabel);
            Value caseValue = eval(c.getValue());
            ValueType t = operandTypeOf(selector, caseValue);
            Register a = Register.ax(t), b = Register.bx(t), r = Register.cx(ValueType.BOOLEAN);
            values.load(selector, a);
            values.load(caseValue, b);
            ir.emit(new BinaryOperation(BinaryOperations.EQ, a, b, r));
            ir.emit(new BranchIf(r, true, bodyLabel));
        }
        String defaultLabel = node.getDefaultCase() != null ? labels.nextLabel() : end;
        ir.emit(new Jump(defaultLabel));

        breakLabels.push(end);
        for (int i = 0; i < cases.size(); i++) {
            ir.emit(new MarkLabel(bodyLabels.get(i)));
            visitAll(cases.get(i).getBody());
        }
        if (node.getDefaultCase() != null) {
            ir.emit(new MarkLabel(defaultLabel));
            visitAll(node.getDefaultCase().getBody());
        }
        breakLabels.pop();
        ir.emit(new MarkLabel(end));
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        Value value = eval(node.getExpr());
        assign(node.getId(), value);
        return null;
    }



    private void loopBody(List<? extends YAstNode> body, String breakLabel, String continueLabel) {
        breakLabels.push(breakLabel);
        continueLabels.push(continueLabel);
        visitAll(body);
        continueLabels.pop();
        breakLabels.pop();
    }

    private void branch(ExpressionNodeY condition, boolean jumpWhen, String label) {
        Register reg = Register.ax(ValueType.BOOLEAN);
        values.load(eval(condition), reg);
        ir.emit(new BranchIf(reg, jumpWhen, label));
    }

    // ============================================================ expressions

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        ValueType type = valueTypeOf(node);
        Object v = node.getDataValue();
        if (v == null) {
            last = switch (type) {
                case STRING  -> new Text(ir.intern(""));
                case FLOAT   -> new Constant("0.0", ValueType.FLOAT);
                case CHAR    -> new Constant("0",   ValueType.CHAR);
                case BOOLEAN -> new Constant("0",   ValueType.BOOLEAN);
                default      -> new Constant("0",   type);
            };
            return null;
        }
        last = switch (type) {
            case STRING  -> new Text(ir.intern(String.valueOf(v)));
            case BOOLEAN -> new Constant(Boolean.TRUE.equals(v) ? "1" : "0", ValueType.BOOLEAN);
            case CHAR    -> new Constant(charCode(v), ValueType.CHAR);
            default -> {
                String lit = String.valueOf(v);
                yield new Constant(lit.equals("null") ? "0" : lit, type);
            }
        };
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        Cell cell = frame.lookup(node.getIdentifier());
        if (cell == null) {
            throw new IllegalStateException("Identificador sin declarar: '" + node.getIdentifier()
                    + "' (línea " + node.getLine() + ")");
        }
        last = cell;
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        if (node.getOperator() == BinaryOperator.AND || node.getOperator() == BinaryOperator.OR) {
            boolean jumpWhen = (node.getOperator() == BinaryOperator.OR);
            Cell result = frame.temp(ValueType.BOOLEAN);
            Value left = eval(node.getLeft());
            values.store(left, result);

            String endLabel = labels.nextLabel();
            Register condReg = Register.ax(ValueType.BOOLEAN);
            values.load(result, condReg);
            ir.emit(new BranchIf(condReg, jumpWhen, endLabel));

            Value right = eval(node.getRight());
            values.store(right, result);

            ir.emit(new MarkLabel(endLabel));
            last = result;
            return null;
        }

        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());
        BinaryOperations op = IntermediateTypes.binary(node.getOperator());
        ValueType annotated = typeAnnotations.containsKey(node) ? valueTypeOf(node) : null;

        if (annotated == ValueType.STRING && op == BinaryOperations.ADD) {
            last = concat(left, right);
            return null;
        }

        ValueType operandType = operandTypeOf(left, right);
        ValueType resultType = annotated != null ? annotated : (op.isComparison() || op.isLogical() ? ValueType.BOOLEAN : operandType);

        Register a = Register.ax(operandType), b = Register.bx(operandType), c = Register.cx(resultType);
        values.loadCoerced(left, a);
        values.loadCoerced(right, b);
        ir.emit(new BinaryOperation(op, a, b, c));
        last = values.spill(c);
        return null;
    }

    private Value concat(Value left, Value right) {
        Value l = values.asString(left);
        Value r = values.asString(right);
        Register a = Register.ax(ValueType.STRING), b = Register.bx(ValueType.STRING), c = Register.cx(ValueType.STRING);
        values.load(l, a);
        values.load(r, b);
        ir.emit(new StringConcat(a, b, c));
        return values.spill(c);
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        Value operand = eval(node.getExpressionNode());
        UnaryOperations op = IntermediateTypes.unary(node.getOperator());
        ValueType type = op == UnaryOperations.NOT ? ValueType.BOOLEAN
                : (operand.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT);
        Register a = Register.ax(type), c = Register.cx(type);
        values.load(operand, a);
        ir.emit(new UnaryOperation(op, a, c));
        last = values.spill(c);
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        List<ExpressionNodeY> args = node.getArguments() != null ? node.getArguments() : List.of();
        int n = args.size();

        Symbol target = symbols.target(node);
        List<String> paramTypes = target != null ? target.getParameterTypes() : null;

        ir.emit(new AdjustStackTop(CALL_AREA));
        for (int i = 0; i < n; i++) {
            ExpressionNodeY arg = args.get(i);
            ValueType expectedType = (paramTypes != null && i < paramTypes.size())
                    ? paramValueType(paramTypes.get(i))
                    : null;
            pushArgument(arg, expectedType);
        }

        ir.emit(new Call(NameMangler.functionName(target)));

        Register result = Register.cx(valueTypeOf(node));
        ir.emit(new Load(MemorySpace.STACK, new StackTop(-(n + 1)), result));
        last = values.spill(result);
        ir.emit(new AdjustStackTop(-(n + CALL_AREA)));
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        ArrayInfo info = requireArray(node.getArrayName());
        ValueType element = IntermediateTypes.of(info.getElementType());
        Register index = Register.ax(ValueType.INT);
        Register result = Register.cx(element);

        values.load(eval(node.getIndexExpression()), index);
        if (info.isHeap()) {
            Register pointer = Register.bx(ValueType.INT);
            ir.emit(new Load(MemorySpace.STACK, new Frame(info.getBaseOffset()), pointer));
            ir.emit(new IndexAddress(pointer, index, pointer));
            ir.emit(new Load(MemorySpace.STACK, new Indirect(pointer, 0), result));
        } else {
            ir.emit(new LoadIndexed(new Frame(info.getBaseOffset()), index, result));
        }
        last = values.spill(result);
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        FieldReference field = resolveField(node);
        ValueType type = valueTypeOf(node);
        if (field.getInfo().isReference()) {
            Register pointer = Register.ax(ValueType.INT);
            Register result = Register.cx(type);
            ir.emit(new Load(MemorySpace.STACK, new Frame(field.getInfo().getBaseOffset()), pointer));
            ir.emit(new Load(MemorySpace.STACK, new Indirect(pointer, field.getOffset()), result));
            last = values.spill(result);
        } else {
            last = new Cell(type, new Frame(field.getInfo().getBaseOffset() + field.getOffset()));
        }
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        if (node.getTarget() instanceof PropertyAccessExpressionNodeY prop) {
            FieldReference field = resolveField(prop);
            ValueType type = valueTypeOf(node);
            if (type == ValueType.INT && field.getInfo().getStructTypeName() != null) {
                Symbol structSym = table.getAllSymbols().stream()
                        .filter(s -> s.getKind() == SymbolKind.STRUCT && s.getName().equals(field.getInfo().getStructTypeName()))
                        .findFirst().orElse(null);
                Symbol memberSym = (structSym != null && structSym.getMembers() != null)
                        ? structSym.getMembers().stream().filter(m -> m.getName().equals(prop.getPropertyName())).findFirst().orElse(null)
                        : null;
                if (memberSym != null && memberSym.getType() != null) {
                    ValueType symType = paramValueType(memberSym.getType());
                    if (symType != null) type = symType;
                }
            }
            Value index = eval(node.getIndex());
            Register idx = Register.ax(ValueType.INT);
            Register result = Register.cx(type);
            values.loadCoerced(index, idx);

            if (field.getInfo().isReference()) {
                Register pointer = Register.bx(ValueType.INT);
                ir.emit(new Load(MemorySpace.STACK, new Frame(field.getInfo().getBaseOffset()), pointer));
                if (field.getOffset() > 0) {
                    Register offsetReg = Register.ax(ValueType.INT);
                    ir.emit(new Move(new com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate(String.valueOf(field.getOffsetBytes()), ValueType.INT), offsetReg));
                    ir.emit(new BinaryOperation(BinaryOperations.ADD, pointer, offsetReg, pointer));
                    values.loadCoerced(index, idx);
                }
                ir.emit(new IndexAddress(pointer, idx, pointer));
                ir.emit(new Load(MemorySpace.STACK, new Indirect(pointer, 0), result));
            } else {
                int base = field.getInfo().getBaseOffset() + field.getOffset();
                ir.emit(new LoadIndexed(new Frame(base), idx, result));
            }
            last = values.spill(result);
            return null;
        }

        if (node.getTarget() instanceof IdentifierExpressionNodeY id) {
            ArrayInfo info = frame.arrayOf(id.getIdentifier());
            if (info != null) {
                return visit(new ArrayCallExpressionNodeY(node.getLine(), node.getColumn(), id.getIdentifier(), node.getIndex()));
            }
        }

        Value targetVal = eval(node.getTarget());
        Cell preservedTarget = (targetVal instanceof Cell c) ? c : frame.temp(targetVal.type());
        if (!(targetVal instanceof Cell)) values.store(targetVal, preservedTarget);

        Value indexVal = eval(node.getIndex());
        Register targetReg = Register.bx(ValueType.INT);
        Register indexReg = Register.ax(ValueType.INT);
        values.load(preservedTarget, targetReg);
        values.load(indexVal, indexReg);

        ValueType element = valueTypeOf(node);
        Register result = Register.cx(element);
        Register addr = Register.ax(ValueType.INT);
        ir.emit(new IndexAddress(targetReg, indexReg, addr));
        ir.emit(new Load(MemorySpace.STACK, new Indirect(addr, 0), result));
        last = values.spill(result);
        return null;
    }


    private static ValueType operandTypeOf(Value left, Value right) {
        if (left.type() == ValueType.STRING || right.type() == ValueType.STRING) return ValueType.STRING;
        if (left.type() == ValueType.FLOAT || right.type() == ValueType.FLOAT) return ValueType.FLOAT;
        return ValueType.INT;
    }

    /**
     * Method to push the arguments for the arguments push
     *
     */
    private void pushArgument(ExpressionNodeY arg, ValueType expectedType) {
        if (arg instanceof IdentifierExpressionNodeY id) {
            ArrayInfo array = frame.arrayOf(id.getIdentifier());
            if (array != null) {
                pushReference(array.isHeap(), array.getBaseOffset());
                return;
            }
            StructInfo struct = frame.structOf(id.getIdentifier());
            if (struct != null) {
                pushReference(struct.isReference(), struct.getBaseOffset());
                return;
            }
        }
        // Passing an embedded struct array-field as argument: need to pass its address
        if (arg instanceof PropertyAccessExpressionNodeY prop) {
            FieldReference field = resolveField(prop);
            if (field != null) {
                StructInfo info = field.getInfo();
                String structType = info.getStructTypeName();
                String fieldName = prop.getPropertyName();
                if (structType != null) {
                    Symbol memberSym = layout.members(structType) == null ? null
                            : layout.members(structType).stream()
                                    .filter(m -> m.getName().equals(fieldName)).findFirst().orElse(null);
                    if (memberSym != null && memberSym.isArray()) {
                        // Embedded array field: pass address = base_ptr + field_byte_offset
                        Register addr = Register.ax(ValueType.INT);
                        if (info.isReference()) {
                            ir.emit(new Load(MemorySpace.STACK, new Frame(info.getBaseOffset()), addr));
                            int byteOffset = layout.fieldOffsetBytes(structType, fieldName);
                            if (byteOffset < 0) byteOffset = field.getOffsetBytes();
                            if (byteOffset > 0) {
                                Register off = Register.bx(ValueType.INT);
                                ir.emit(new Move(new Immediate(String.valueOf(byteOffset), ValueType.INT), off));
                                ir.emit(new BinaryOperation(BinaryOperations.ADD, addr, off, addr));
                            }
                        } else {
                            ir.emit(new LoadAddress(new Frame(info.getBaseOffset() + layout.fieldOffsetCells(structType, fieldName)), addr));
                        }
                        pushRegisterister(addr);
                        return;
                    }
                }
            }
        }
        Value value = eval(arg);
        ValueType targetType = (expectedType != null) ? expectedType : value.type();
        Register reg = Register.ax(targetType);
        values.loadCoerced(value, reg);
        pushRegisterister(reg);
    }

    /**
     * Reference push array helper
     */
    private void pushReference(boolean alreadyReference, int baseOffset) {
        Register reg = Register.ax(ValueType.INT);
        if (alreadyReference) ir.emit(new Load(MemorySpace.STACK, new Frame(baseOffset), reg));
        else ir.emit(new LoadAddress(new Frame(baseOffset), reg));
        pushRegisterister(reg);
    }

    /**
     * Push registerer helper
     *
     */
    private void pushRegisterister(Register reg) {
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), reg));
        ir.emit(new AdjustStackTop(1));
    }


    private void assign(ExpressionNodeY target, Value value) {
        if (target instanceof ArrayCallExpressionNodeY array) {
            assignArrayElement(array, value);
            return;
        }
        if (target instanceof MemberArrayAccessExpressionNodeY memberArr) {
            assignMemberArrayElement(memberArr, value);
            return;
        }
        if (target instanceof PropertyAccessExpressionNodeY prop) {
            FieldReference field = resolveField(prop);
            if (field.getInfo().isReference()) {
                assignThroughPointer(field, valueTypeOf(prop), value);
                return;
            }
        }
        values.store(value, values.requireCell(eval(target)));
    }

    private void assignMemberArrayElement(MemberArrayAccessExpressionNodeY node, Value value) {
        if (node.getTarget() instanceof PropertyAccessExpressionNodeY prop) {
            FieldReference field = resolveField(prop);
            ValueType type = valueTypeOf(node);
            if (type == ValueType.INT && field.getInfo().getStructTypeName() != null) {
                Symbol structSym = table.getAllSymbols().stream()
                        .filter(s -> s.getKind() == SymbolKind.STRUCT && s.getName().equals(field.getInfo().getStructTypeName()))
                        .findFirst().orElse(null);
                Symbol memberSym = (structSym != null && structSym.getMembers() != null)
                        ? structSym.getMembers().stream().filter(m -> m.getName().equals(prop.getPropertyName())).findFirst().orElse(null)
                        : null;
                if (memberSym != null && memberSym.getType() != null) {
                    ValueType symType = paramValueType(memberSym.getType());
                    if (symType != null) type = symType;
                }
            }
            Value index = eval(node.getIndex());
            Register idx = Register.ax(ValueType.INT);
            Register source = Register.cx(type);
            values.loadCoerced(index, idx);
            values.loadCoerced(value, source);

            if (field.getInfo().isReference()) {
                Register pointer = Register.bx(ValueType.INT);
                ir.emit(new Load(MemorySpace.STACK, new Frame(field.getInfo().getBaseOffset()), pointer));
                if (field.getOffset() > 0) {
                    Register offsetReg = Register.ax(ValueType.INT);
                    ir.emit(new Move(new com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate(String.valueOf(field.getOffsetBytes()), ValueType.INT), offsetReg));
                    ir.emit(new BinaryOperation(BinaryOperations.ADD, pointer, offsetReg, pointer));
                    values.loadCoerced(index, idx);
                }
                ir.emit(new IndexAddress(pointer, idx, pointer));
                ir.emit(new Store(MemorySpace.STACK, new Indirect(pointer, 0), source));
            } else {
                int base = field.getInfo().getBaseOffset() + field.getOffset();
                ir.emit(new StoreIndexed(new Frame(base), idx, source));
            }
            return;
        }

        if (node.getTarget() instanceof IdentifierExpressionNodeY id) {
            ArrayInfo info = frame.arrayOf(id.getIdentifier());
            if (info != null) {
                assignArrayElement(new ArrayCallExpressionNodeY(node.getLine(), node.getColumn(), id.getIdentifier(), node.getIndex()), value);
                return;
            }
        }

        Value targetVal = eval(node.getTarget());
        Cell preservedTarget = (targetVal instanceof Cell c) ? c : frame.temp(targetVal.type());
        if (!(targetVal instanceof Cell)) values.store(targetVal, preservedTarget);

        Value indexVal = eval(node.getIndex());
        Register targetReg = Register.bx(ValueType.INT);
        Register indexReg = Register.ax(ValueType.INT);
        values.load(preservedTarget, targetReg);
        values.load(indexVal, indexReg);

        Register addr = Register.ax(ValueType.INT);
        ir.emit(new IndexAddress(targetReg, indexReg, addr));

        Register source = Register.cx(value.type());
        values.loadCoerced(value, source);
        ir.emit(new Store(MemorySpace.STACK, new Indirect(addr, 0), source));
    }

    private void assignArrayElement(ArrayCallExpressionNodeY target, Value value) {
        ArrayInfo info = requireArray(target.getArrayName());
        ValueType element = IntermediateTypes.of(info.getElementType());
        Value index = eval(target.getIndexExpression());

        Register idx = Register.ax(ValueType.INT);
        Register source = Register.cx(element);
        values.loadCoerced(index, idx);
        if (info.isHeap()) {
            Register pointer = Register.bx(ValueType.INT);
            ir.emit(new Load(MemorySpace.STACK, new Frame(info.getBaseOffset()), pointer));
            ir.emit(new IndexAddress(pointer, idx, pointer));
            values.loadCoerced(value, source);
            ir.emit(new Store(MemorySpace.STACK, new Indirect(pointer, 0), source));
        } else {
            values.loadCoerced(value, source);
            ir.emit(new StoreIndexed(new Frame(info.getBaseOffset()), idx, source));
        }
    }

    private void assignThroughPointer(FieldReference field, ValueType type, Value value) {
        Register pointer = Register.ax(ValueType.INT);
        Register source = Register.cx(type);
        ir.emit(new Load(MemorySpace.STACK, new Frame(field.getInfo().getBaseOffset()), pointer));
        values.loadCoerced(value, source);
        ir.emit(new Store(MemorySpace.STACK, new Indirect(pointer, field.getOffset()), source));
    }


    private FieldReference resolveField(PropertyAccessExpressionNodeY node) {
        if (node.getTarget() instanceof IdentifierExpressionNodeY id) {
            StructInfo info = frame.structOf(id.getIdentifier());
            if (info == null) throw new IllegalStateException("'" + id.getIdentifier() + "' no es un struct conocido");
            int offsetCells = layout.fieldOffsetCells(info.getStructTypeName(), node.getPropertyName());
            if (offsetCells < 0)
                throw new IllegalStateException("El struct " + info.getStructTypeName() + " no tiene el campo '" + node.getPropertyName() + "'");
            return new FieldReference(info, offsetCells);
        } else if (node.getTarget() instanceof PropertyAccessExpressionNodeY parentProp) {
            FieldReference parentRef = resolveField(parentProp);
            String parentStructType = parentRef.getInfo().getStructTypeName();
            List<Symbol> parentMembers = layout.members(parentStructType);
            Symbol memberSym = (parentMembers != null)
                    ? parentMembers.stream().filter(m -> m.getName().equals(parentProp.getPropertyName())).findFirst().orElse(null)
                    : null;
            String memberType = memberSym != null ? memberSym.getType() : null;
            int innerOffsetCells = memberType != null ? layout.fieldOffsetCells(memberType, node.getPropertyName()) : -1;
            if (innerOffsetCells < 0)
                throw new IllegalStateException("El struct " + memberType + " no tiene el campo '" + node.getPropertyName() + "'");
            StructInfo nestedInfo = new StructInfo(memberType, parentRef.getInfo().getBaseOffset(), parentRef.getInfo().isReference());
            return new FieldReference(nestedInfo, parentRef.getOffset() + innerOffsetCells);
        }
        throw new IllegalStateException("Solo se soporta acceso a propiedades de una variable (línea " + node.getLine() + ")");
    }

    private Value eval(ExpressionNodeY node) {
        node.accept(this);
        return last;
    }

    private void visitAll(List<? extends YAstNode> nodes) {
        if (nodes == null) return;
        for (YAstNode n : nodes) if (n != null) n.accept(this);
    }

    private ValueType valueTypeOf(YAstNode node) {
        Type t = typeAnnotations.get(node);
        return t == null ? ValueType.INT : IntermediateTypes.of(t.getKind());
    }

    private ValueType declaredType(TypeNodeY typeNode) {
        return IntermediateTypes.of(kindOf(typeNode));
    }

    private TypeKind kindOf(TypeNodeY typeNode) {
        Type t = mapTypeNodeToType(typeNode);
        return t == null ? TypeKind.INT : t.getKind();
    }

    /**
     * Map type node to type helper method
     * */
    private Type mapTypeNodeToType(TypeNodeY typeNode) {
        if (typeNode == null) return null;
        return switch (typeNode.getDataType()) {
            case INT -> Type.intType();
            case FLOAT -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case CUSTOM -> Type.customType(typeNode.getCustomTypeName());
            default -> null;
        };
    }

    /**
     * Principal method to define the required array
     * */
    private ArrayInfo requireArray(String name) {
        ArrayInfo info = frame.arrayOf(name);
        if (info == null) throw new IllegalStateException("Arreglo no declarado: '" + name + "'");
        return info;
    }

    /**
     * Literal int helper method
     * */
    private static Integer literalInt(ExpressionNodeY expr) {
        if (expr instanceof LiteralExpressionNodeY lit && lit.getDataValue() instanceof Integer i) return i;
        return null;
    }

    /**
     * Char ascii code
     * */
    private static String charCode(Object v) {
        if (v instanceof Character c) return Integer.toString(c);
        String s = String.valueOf(v);
        return (s.length() == 1 && !Character.isDigit(s.charAt(0))) ? Integer.toString(s.charAt(0)) : s;
    }

    private static ValueType paramValueType(String typeName) {
        if (typeName == null) return null;
        return switch (typeName.toLowerCase()) {
            case "float", "flotante", "double", "decimal", "decimalis" -> ValueType.FLOAT;
            case "string", "cadena" -> ValueType.STRING;
            case "boolean", "bool", "booleano" -> ValueType.BOOLEAN;
            case "char", "caracter" -> ValueType.CHAR;
            case "int", "entero", "numerus" -> ValueType.INT;
            default -> ValueType.INT;
        };
    }

    /**
     * Helper resolver for the return type
     */
    private static ValueType returnTypeOf(Symbol fn) {
        if (fn == null || fn.getReturnType() == null)
            throw new IllegalStateException("Función sin tipo de retorno en la tabla: " + fn);
        return switch (fn.getReturnType().toLowerCase()) {
            case "int", "entero", "numerus" -> ValueType.INT;
            case "float", "flotante", "double", "decimal", "decimalis" -> ValueType.FLOAT;
            case "char", "caracter" -> ValueType.CHAR;
            case "boolean", "bool", "booleano" -> ValueType.BOOLEAN;
            case "string", "cadena" -> ValueType.STRING;
            case "void" -> throw new IllegalStateException(
                    "return con valor en función void: " + fn.getName());
            default -> ValueType.INT;
        };
    }
}