package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Cell;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Constant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Text;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallIndirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePush;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FrameRebase;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.LoadLabelAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Return;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Frame;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Indirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.FunctionFrame;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.IntermediateTypes;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.ValueEmitter;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.naming.NameMangler;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.ArrayInfo;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZInheritanceService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSymbolLookupService;

import java.util.*;

/**
 * Principal code generator visitor for the .z language
 *
 */
public class ZCodeGeneratorVisitor implements ZAstVisitor<Void> {

    private static final int CALL_AREA = 200;

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;
    private final Map<AstNode, Symbol> resolvedCalls;
    private final IntermediateBuilder ir;
    private final CodeGenContext labels;

    private final Deque<String> breakLabels = new ArrayDeque<>();
    private final Deque<String> continueLabels = new ArrayDeque<>();

    private FunctionFrame frame = new FunctionFrame();
    private ValueEmitter values;
    private Value last;

    private Symbol currentClassSymbol;
    private Symbol currentCallableSymbol;
    private ClassDeclarationNodeZ currentClassNode;

    private final ZInheritanceService inheritance;

    public ZCodeGeneratorVisitor(GlobalSymbolTable table, EditorContext context,
                                 Map<AstNode, Type> typeAnnotations,
                                 Map<AstNode, Symbol> resolvedCalls,
                                 IntermediateBuilder ir, CodeGenContext labels) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations != null ? typeAnnotations : Map.of();
        this.resolvedCalls = resolvedCalls != null ? resolvedCalls : Map.of();
        this.ir = ir;
        this.labels = labels != null ? labels : new CodeGenContext();
        this.values = new ValueEmitter(ir, frame);
        this.inheritance = new ZInheritanceService(new ZSymbolLookupService(table, context));
    }

    // ============================================================
    // TOP-LEVEL & CLASSES
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
        this.currentClassNode = node;
        this.currentClassSymbol = findClassSymbol(node.getClassName());
        if (this.currentClassSymbol != null) {
            inheritance.link(this.currentClassSymbol);
        }

        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member instanceof ConstructorDeclarationNodeZ || member instanceof MethodDeclarationNodeZ) {
                    member.accept(this);
                }
            }
        }

        this.currentClassNode = null;
        this.currentClassSymbol = null;
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


    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        Symbol ctorSymbol = findCallableSymbol(node.getName(), node.getLine(), node.getColumn());
        if (ctorSymbol == null) {
            ctorSymbol = findConstructorByParams(currentClassSymbol, node.getParams());
        }
        generateCallable(ctorSymbol, node.getParams(), node.getBody(), true);
        return null;
    }

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        Symbol methodSymbol = findCallableSymbol(node.getName(), node.getLine(), node.getColumn());
        generateCallable(methodSymbol, node.getParams(), node.getBody(), false);
        return null;
    }

    private void generateCallable(Symbol callableSymbol,
                                  List<ParameterNodeZ> params,
                                  List<ZAstNode> body,
                                  boolean isConstructor) {
        this.currentCallableSymbol = callableSymbol;
        String functionName = callableSymbol != null ? NameMangler.codeLabel(callableSymbol) : "anon_func";

        ir.beginFunction(functionName);
        frame = new FunctionFrame();
        values = new ValueEmitter(ir, frame);
        breakLabels.clear();
        continueLabels.clear();

        int declaredParams = params != null ? params.size() : 0;
        int numArgs = 1 + declaredParams;

        ir.emit(new FramePush());
        ir.emit(new FrameRebase(numArgs + 1));

        frame.declare("this", ValueType.INT);

        if (params != null) {
            for (ParameterNodeZ p : params) {
                if (p != null) registerParameter(p);
            }
        }

        if (isConstructor) {
            emitConstructorPrologue(body);
        }

        if (body != null) {
            for (ZAstNode stmt : body) {
                if (stmt == null) continue;
                if (isConstructor && stmt instanceof SuperConstructorCallNodeZ) continue;
                stmt.accept(this);
            }
        }

        ir.emit(new FramePop());
        ir.emit(new Return());

        this.currentCallableSymbol = null;
    }

    /**
     * Prólogo de un constructor de Z:
     * 1. super(...) explícito o super() implícito si la clase tiene padre
     * 2. Inicializadores de campos propios declarados en esta clase
     */
    private void emitConstructorPrologue(List<ZAstNode> body) {
        SuperConstructorCallNodeZ explicitSuper = null;
        if (body != null && !body.isEmpty() && body.get(0) instanceof SuperConstructorCallNodeZ sc) {
            explicitSuper = sc;
        }

        Symbol parentClass = currentClassSymbol != null ? currentClassSymbol.getParentSymbol() : null;

        if (explicitSuper != null) {
            explicitSuper.accept(this);
        } else if (parentClass != null) {
            Symbol emptyParentCtor = findEmptyConstructor(parentClass);
            if (emptyParentCtor != null) {
                emitSuperConstructorCall(emptyParentCtor, List.of());
            }
        }

        if (currentClassNode != null && currentClassNode.getMembers() != null) {
            for (ZAstNode m : currentClassNode.getMembers()) {
                if (m instanceof FieldDeclarationNodeZ field && field.getInitializer() != null) {
                    emitFieldInitializer(field);
                }
            }
        }
    }

    private void emitFieldInitializer(FieldDeclarationNodeZ field) {
        Symbol fieldSym = findFieldSymbol(currentClassSymbol, field.getName());
        if (fieldSym == null) return;

        Value initVal = eval(field.getInitializer());
        int slot = fieldSym.getFieldIndex() + 1; // +1 por el __vptr

        Register thisReg = Register.ax(ValueType.INT);
        values.load(frame.lookup("this"), thisReg);

        ValueType fType = declaredType(field.getType());
        Register scratch = Register.cx(fType);
        values.loadCoerced(initVal, scratch);
        ir.emit(new Store(MemorySpace.HEAP, new Indirect(thisReg, slot), scratch));
    }

    private void registerParameter(ParameterNodeZ param) {
        ValueType type = declaredType(param.getType());
        frame.declare(param.getName(), type);
    }

    // ============================================================
    // SENTENCIAS Y CONTROL DE FLUJO
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        Cell cell = frame.declare(node.getIdentifier(), declaredType(node.getDataType()));
        if (node.getInitializer() != null) {
            if (node.getInitializer() instanceof ReadStatementNodeZ) {
                ir.emit(new Read(cell.type(), cell.getAddress()));
                return null;
            }
            values.store(eval(node.getInitializer()), cell);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        Value val = eval(node.getExpressionNode());
        assign(node.getIdentifier(), val);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        Value target = eval(node.getTarget());
        Value operand = eval(node.getValue());
        Cell cell = values.requireCell(target);
        ValueType type = cell.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT;
        Register a = Register.ax(type), b = Register.bx(type), c = Register.cx(type);
        values.loadCoerced(cell, a);
        values.loadCoerced(operand, b);
        ir.emit(new BinaryOperation(IntermediateTypes.shortly(node.getOperator()), a, b, c));
        ir.emit(new Store(MemorySpace.STACK, cell.getAddress(), c));
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.ADD);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.SUB);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.ADD);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.SUB);
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
        if (node.getExpression() == null) return null;
        Value value = eval(node.getExpression());
        Register reg = Register.ax(value.type());
        values.loadCoerced(value, reg);
        ir.emit(new Print(reg, true));
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        ValueType type = valueTypeOf(node);
        Cell cell = frame.temp(type);
        ir.emit(new Read(type, cell.getAddress()));
        last = cell;
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        if (node.getValue() != null) {
            Value val = eval(node.getValue());
            ValueType retType = currentCallableSymbol != null ? returnTypeOf(currentCallableSymbol) : val.type();
            Register scratch = Register.ax(retType);
            values.loadCoerced(val, scratch);
            ir.emit(new Store(MemorySpace.STACK, new Frame(0), scratch));
        }
        ir.emit(new FramePop());
        ir.emit(new Return());
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeZ node) {
        if (!breakLabels.isEmpty()) ir.emit(new Jump(breakLabels.peek()));
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
        if (!continueLabels.isEmpty()) ir.emit(new Jump(continueLabels.peek()));
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IfStatementNodeZ node) {
        String end = labels.nextLabel();
        String next = labels.nextLabel();

        branch(node.getCondition(), false, next);
        visitAll(node.getThenBody());
        ir.emit(new Jump(end));
        ir.emit(new MarkLabel(next));

        if (node.getElseIfs() != null) {
            for (ElseIfNodeZ elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;
                String skip = labels.nextLabel();
                branch(elseIf.getCondition(), false, skip);
                visitAll(elseIf.getBody());
                ir.emit(new Jump(end));
                ir.emit(new MarkLabel(skip));
            }
        }
        if (node.getElseBlockNode() != null && node.getElseBlockNode().getBody() != null) {
            visitAll(node.getElseBlockNode().getBody());
        }
        ir.emit(new MarkLabel(end));
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
    public Void visit(DoWhileStatementNodeZ node) {
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
    public Void visit(ForStatementNodeZ node) {
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
    public Void visit(ForInitDeclarationNodeZ node) {
        Cell cell = frame.declare(node.getId(), declaredType(node.getType()));
        if (node.getExpr() != null) {
            values.store(eval(node.getExpr()), cell);
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        Value val = eval(node.getExpr());
        assign(node.getId(), val);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        Value target = eval(node.getTarget());
        switch (node.getOperator()) {
            case INCREMENT, PREFIX_INCREMENT -> values.incDec(target, BinaryOperations.ADD);
            case DECREMENT, PREFIX_DECREMENT -> values.incDec(target, BinaryOperations.SUB);
            case ASSIGN -> {
                if (node.getValue() != null) values.store(eval(node.getValue()), values.requireCell(target));
            }
        }
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        String end = labels.nextLabel();
        Value selector = eval(node.getSelector());
        List<SwitchCaseNodeZ> cases = node.getCases() != null ? node.getCases() : List.of();
        List<String> bodyLabels = new ArrayList<>();

        for (SwitchCaseNodeZ c : cases) {
            String bodyLabel = labels.nextLabel();
            bodyLabels.add(bodyLabel);
            Value caseValue = eval(c.getValue());
            ValueType t = operandTypeOf(selector, caseValue);
            Register a = Register.ax(t), b = Register.bx(t), r = Register.cx(ValueType.BOOLEAN);
            values.load(selector, a);
            values.load(caseValue, b);
            ir.emit(new BinaryOperation(BinaryOperations.EQ, a, b, r));
            ir.emit(new com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf(r, true, bodyLabel));
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
    public Void visit(SwitchCaseNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        return null;
    }

    // ============================================================
    // EXPRESIONES BÁSICAS
    // ============================================================

    @Override
    public Void visit(LiteralExpressionNodeZ node) {
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
    public Void visit(IdentifierExpressionNodeZ node) {
        String id = node.getIdentifier();
        // 1. Variable local o parámetro
        Cell local = frame.lookup(id);
        if (local != null) {
            last = local;
            return null;
        }
        // 2. Campo de instancia de 'this'
        if (currentClassSymbol != null) {
            Symbol field = findFieldSymbol(currentClassSymbol, id);
            if (field != null) {
                last = loadFieldFromHeap(frame.lookup("this"), field);
                return null;
            }
        }
        throw new IllegalStateException("Identificador no resuelto: '" + id + "' en línea " + node.getLine());
    }

    @Override
    public Void visit(ThisExpressionNodeZ node) {
        Cell thisCell = frame.lookup("this");
        if (thisCell == null) throw new IllegalStateException("'this' utilizado fuera del contexto de instancia");
        last = thisCell;
        return null;
    }

    @Override
    public Void visit(SuperExpressionNodeZ node) {
        Cell thisCell = frame.lookup("this");
        if (thisCell == null) throw new IllegalStateException("'super' utilizado fuera del contexto de instancia");
        last = thisCell;
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
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

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        Value operand = eval(node.getExpressionNode());
        UnaryOperations op = IntermediateTypes.unary(node.getOperator());
        ValueType type = op == UnaryOperations.NOT ? ValueType.BOOLEAN
                : (op == UnaryOperations.NEG && operand.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT);
        Register src = Register.ax(operand.type());
        Register dest = Register.cx(type);
        values.load(operand, src);
        ir.emit(new UnaryOperation(op, src, dest));
        last = values.spill(dest);
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        String trueLabel = labels.nextLabel();
        String endLabel = labels.nextLabel();

        branch(node.getCondition(), true, trueLabel);
        Value falseVal = eval(node.getElseExpr());
        Cell res = frame.temp(valueTypeOf(node));
        values.store(falseVal, res);
        ir.emit(new Jump(endLabel));

        ir.emit(new MarkLabel(trueLabel));
        Value trueVal = eval(node.getThenExpr());
        values.store(trueVal, res);

        ir.emit(new MarkLabel(endLabel));
        last = res;
        return null;
    }

    // ============================================================
    // OBJECTS
    // ============================================================

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        String className = node.getType() != null
                ? (node.getType().getCustomTypeName() != null ? node.getType().getCustomTypeName() : (node.getType().getDataType() != null ? node.getType().getDataType().getValue() : null))
                : null;
        emitObjectCreation(className, node.getArguments(), node);
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodeZ node) {
        emitObjectCreation(node.getClassName(), node.getArguments(), node);
        return null;
    }

    private void emitObjectCreation(String className, List<ExpressionNodeZ> args, AstNode callNode) {
        Symbol cls = findClassSymbol(className);
        if (cls == null) throw new IllegalStateException("Clase no encontrada: " + className);
        inheritance.link(cls);

        int slots = cls.getFieldSlots().size() + 1;

        Register objPtr = Register.ax(ValueType.INT);
        ir.emit(new HeapAlloc(slots, objPtr));

        Register vptrReg = Register.bx(ValueType.INT);
        ir.emit(new LoadLabelAddress(cls.getVtableLabel(), vptrReg));
        ir.emit(new Store(MemorySpace.HEAP, new Indirect(objPtr, 0), vptrReg));

        // Preserve the newly allocated object reference across argument evaluations and constructor call
        Value savedObj = values.spill(objPtr);

        Symbol ctor = resolvedCalls.get(callNode);
        if (ctor == null) {
            ctor = findConstructorByParams(cls, args != null ? args : List.of());
        }

        ir.emit(new AdjustStackTop(CALL_AREA));
        values.load(savedObj, objPtr);
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), objPtr));
        ir.emit(new AdjustStackTop(1));

        if (args != null) {
            for (ExpressionNodeZ arg : args) pushArgument(arg);
        }

        String ctorLabel = NameMangler.codeLabel(ctor);
        ir.emit(new Call(ctorLabel));

        int totalArgs = 1 + (args != null ? args.size() : 0);
        ir.emit(new AdjustStackTop(-(totalArgs + CALL_AREA)));

        last = savedObj;
    }

    @Override
    public Void visit(SuperConstructorCallNodeZ node) {
        Symbol parentClass = currentClassSymbol != null ? currentClassSymbol.getParentSymbol() : null;
        if (parentClass == null) return null;

        Symbol ctor = resolvedCalls.get(node);
        if (ctor == null) {
            ctor = findConstructorByParams(parentClass, node.getArguments());
        }
        emitSuperConstructorCall(ctor, node.getArguments());
        return null;
    }

    private void emitSuperConstructorCall(Symbol ctor, List<ExpressionNodeZ> args) {
        if (ctor == null) return;
        ir.emit(new AdjustStackTop(CALL_AREA));

        Register thisReg = Register.ax(ValueType.INT);
        values.load(frame.lookup("this"), thisReg);
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), thisReg));
        ir.emit(new AdjustStackTop(1));

        if (args != null) {
            for (ExpressionNodeZ arg : args) pushArgument(arg);
        }

        ir.emit(new Call(NameMangler.codeLabel(ctor)));
        int totalArgs = 1 + (args != null ? args.size() : 0);
        ir.emit(new AdjustStackTop(-(totalArgs + CALL_AREA)));
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        String prop = node.getPropertyName();

        if (node.getTarget() instanceof SuperExpressionNodeZ) {
            Symbol parent = currentClassSymbol != null ? currentClassSymbol.getParentSymbol() : null;
            Symbol field = findFieldSymbol(parent, prop);
            last = loadFieldFromHeap(frame.lookup("this"), field);
            return null;
        }

        if (node.getTarget() instanceof ThisExpressionNodeZ || node.getTarget() == null) {
            Symbol field = findFieldSymbol(currentClassSymbol, prop);
            last = loadFieldFromHeap(frame.lookup("this"), field);
            return null;
        }

        Value targetVal = eval(node.getTarget());
        Symbol targetClass = classSymbolOf(node.getTarget());
        Symbol field = findFieldSymbol(targetClass, prop);
        last = loadFieldFromHeap(targetVal, field);
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        Symbol targetMethod = resolvedCalls.get(node);
        if (targetMethod == null) {
            throw new IllegalStateException("Método no resuelto para la llamada: " + node.getFunctionName() + " en línea " + node.getLine());
        }

        List<ExpressionNodeZ> args = node.getArguments() != null ? node.getArguments() : List.of();
        boolean isSuperCall = node.getTarget() instanceof SuperExpressionNodeZ;

        Value selfVal;
        if (node.getTarget() == null || node.getTarget() instanceof ThisExpressionNodeZ || isSuperCall) {
            selfVal = frame.lookup("this");
        } else {
            selfVal = eval(node.getTarget());
        }

        Cell preservedSelf;
        if (selfVal instanceof Cell c) {
            preservedSelf = c;
        } else {
            preservedSelf = frame.temp(selfVal.type());
            values.store(selfVal, preservedSelf);
        }

        Register selfReg = Register.ax(ValueType.INT);
        values.load(preservedSelf, selfReg);

        ir.emit(new AdjustStackTop(CALL_AREA));

        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), selfReg));
        ir.emit(new AdjustStackTop(1));

        for (ExpressionNodeZ arg : args) pushArgument(arg);

        int totalArgs = 1 + args.size();

        if (isSuperCall || !targetMethod.isVirtual()) {
            ir.emit(new Call(NameMangler.codeLabel(targetMethod)));
        } else {
            Register vptr = Register.bx(ValueType.INT);
            Register fnPtr = Register.cx(ValueType.INT);
            values.load(preservedSelf, selfReg);
            ir.emit(new Load(MemorySpace.HEAP, new Indirect(selfReg, 0), vptr));
            ir.emit(new Load(MemorySpace.HEAP, new Indirect(vptr, targetMethod.getVtableIndex()), fnPtr));
            ir.emit(new CallIndirect(fnPtr));
        }

        if (!"void".equalsIgnoreCase(targetMethod.getReturnType())) {
            ValueType retType = returnTypeOf(targetMethod);
            Register result = Register.cx(retType);
            ir.emit(new Load(MemorySpace.STACK, new StackTop(-(totalArgs + 1)), result));
            last = values.spill(result);
        } else {
            last = null;
        }

        ir.emit(new AdjustStackTop(-(totalArgs + CALL_AREA)));
        return null;
    }

    // ============================================================
    // ARRAYS
    // ============================================================

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        int total = 1;
        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dim : node.getDimensions()) {
                Integer size = literalInt(dim);
                if (size != null) total *= size;
            }
        }
        int base = frame.allocate(total);
        TypeKind elementKind = kindOf(node.getDataType());
        ValueType elementType = IntermediateTypes.of(elementKind);
        frame.registerArray(node.getIdentifier(), new ArrayInfo(base, elementKind, total, false));
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
    public Void visit(ArrayInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        Value targetVal = eval(node.getTarget());
        Value indexVal = eval(node.getIndex());
        Register targetReg = Register.bx(ValueType.INT);
        Register indexReg = Register.ax(ValueType.INT);
        values.load(targetVal, targetReg);
        values.load(indexVal, indexReg);

        ValueType element = valueTypeOf(node);
        Register result = Register.cx(element);
        Register addr = Register.ax(ValueType.INT);
        ir.emit(new IndexAddress(targetReg, indexReg, addr));
        ir.emit(new Load(MemorySpace.STACK, new Indirect(addr, 0), result));
        last = values.spill(result);
        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private void assign(ExpressionNodeZ target, Value value) {
        if (value == null) {
            throw new IllegalStateException("Asignación a '" + target + "' produjo un valor nulo (posible llamada void usada como expresión)");
        }
        if (target instanceof IdentifierExpressionNodeZ id) {
            Cell cell = frame.lookup(id.getIdentifier());
            if (cell != null) {
                values.store(value, cell);
                return;
            }
            if (currentClassSymbol != null) {
                Symbol field = findFieldSymbol(currentClassSymbol, id.getIdentifier());
                if (field != null) {
                    storeFieldToHeap(frame.lookup("this"), field, value);
                    return;
                }
            }
            throw new IllegalStateException("Destino de asignación no encontrado: " + id.getIdentifier());
        }

        if (target instanceof PropertyAccessExpressionNodeZ prop) {
            if (prop.getTarget() instanceof SuperExpressionNodeZ) {
                Symbol parent = currentClassSymbol != null ? currentClassSymbol.getParentSymbol() : null;
                Symbol field = findFieldSymbol(parent, prop.getPropertyName());
                storeFieldToHeap(frame.lookup("this"), field, value);
                return;
            }
            if (prop.getTarget() instanceof ThisExpressionNodeZ || prop.getTarget() == null) {
                Symbol field = findFieldSymbol(currentClassSymbol, prop.getPropertyName());
                storeFieldToHeap(frame.lookup("this"), field, value);
                return;
            }
            Value targetObj = eval(prop.getTarget());
            Symbol targetClass = classSymbolOf(prop.getTarget());
            Symbol field = findFieldSymbol(targetClass, prop.getPropertyName());
            storeFieldToHeap(targetObj, field, value);
            return;
        }

        if (target instanceof MemberArrayAccessExpressionNodeZ arr) {
            Value targetVal = eval(arr.getTarget());
            Value indexVal = eval(arr.getIndex());
            Register targetReg = Register.bx(ValueType.INT);
            Register indexReg = Register.ax(ValueType.INT);
            values.load(targetVal, targetReg);
            values.load(indexVal, indexReg);

            Register addr = Register.ax(ValueType.INT);
            ir.emit(new IndexAddress(targetReg, indexReg, addr));

            Register valReg = Register.cx(value.type());
            values.loadCoerced(value, valReg);
            ir.emit(new Store(MemorySpace.STACK, new Indirect(addr, 0), valReg));
            return;
        }

        throw new IllegalStateException("Destino de asignación no soportado: " + target);
    }

    private Value loadFieldFromHeap(Value objRef, Symbol field) {
        if (field == null) throw new IllegalStateException("Campo nulo al intentar leer de heap");
        int slot = field.getFieldIndex() + 1;
        ValueType type = declaredType(field.getType());
        Register objReg = Register.ax(ValueType.INT);
        values.load(objRef, objReg);

        Register result = Register.cx(type);
        ir.emit(new Load(MemorySpace.HEAP, new Indirect(objReg, slot), result));
        return values.spill(result);
    }

    private void storeFieldToHeap(Value objRef, Symbol field, Value value) {
        if (field == null) throw new IllegalStateException("Campo nulo al intentar escribir en heap");
        int slot = field.getFieldIndex() + 1;
        ValueType type = declaredType(field.getType());

        Register objReg = Register.bx(ValueType.INT);
        values.load(objRef, objReg);

        Register scratch = Register.cx(type);
        values.loadCoerced(value, scratch);
        ir.emit(new Store(MemorySpace.HEAP, new Indirect(objReg, slot), scratch));
    }

    private void pushArgument(ExpressionNodeZ arg) {
        Value val = eval(arg);
        Register reg = Register.ax(val.type());
        values.loadCoerced(val, reg);
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), reg));
        ir.emit(new AdjustStackTop(1));
    }

    // ============================================================
    // INHERITANCE / SUPER HELPERS
    // ============================================================

    private Value eval(ExpressionNodeZ expr) {
        if (expr == null) return new Constant("0", ValueType.INT);
        last = null;
        expr.accept(this);
        if (last == null) {
            return new Constant("0", ValueType.INT);
        }
        return last;
    }

    private void visitAll(List<? extends ZAstNode> nodes) {
        if (nodes == null) return;
        for (ZAstNode n : nodes) if (n != null) n.accept(this);
    }

    private void loopBody(List<? extends ZAstNode> body, String breakLabel, String continueLabel) {
        breakLabels.push(breakLabel);
        continueLabels.push(continueLabel);
        visitAll(body);
        continueLabels.pop();
        breakLabels.pop();
    }

    private void branch(ExpressionNodeZ condition, boolean jumpWhen, String label) {
        Register reg = Register.ax(ValueType.BOOLEAN);
        values.load(eval(condition), reg);
        ir.emit(new com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf(reg, jumpWhen, label));
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

    private Symbol findClassSymbol(String name) {
        if (name == null) return null;
        for (SymbolScope s : table.getFileScopes().values()) {
            for (Symbol sym : s.resolveLocalByName(name)) {
                if (sym.getKind() == SymbolKind.CLASS) return sym;
            }
        }
        for (Symbol sym : table.getAllSymbols()) {
            if (sym.getKind() == SymbolKind.CLASS && name.equals(sym.getName())) return sym;
        }
        return null;
    }

    private Symbol findCallableSymbol(String name, int line, int column) {
        SymbolScope scope = table.getFileScope(context.getFilePath());
        if (scope != null) {
            for (Symbol s : scope.resolveLocalByName(name)) {
                if (s.isCallable() && s.getLine() == line && s.getColumn() == column) return s;
            }
        }
        for (Symbol s : table.getAllSymbols()) {
            if (s.isCallable() && s.getName().equals(name) && s.getLine() == line && s.getColumn() == column) return s;
        }
        return null;
    }

    private Symbol findFieldSymbol(Symbol cls, String fieldName) {
        if (cls == null || fieldName == null) return null;
        inheritance.link(cls);
        if (cls.getFieldSlots() != null) {
            for (Symbol f : cls.getFieldSlots()) {
                if (fieldName.equals(f.getName())) return f;
            }
        }
        return null;
    }

    private Symbol findConstructorByParams(Symbol cls, List<?> params) {
        if (cls == null) return null;
        inheritance.link(cls);
        int arity = params != null ? params.size() : 0;
        if (cls.getMembers() != null) {
            for (Symbol m : cls.getMembers()) {
                if (m.getKind() == SymbolKind.CONSTRUCTOR && m.getParameterTypes() != null && m.getParameterTypes().size() == arity) {
                    return m;
                }
            }
        }
        return null;
    }

    private Symbol findEmptyConstructor(Symbol cls) {
        if (cls == null) return null;
        inheritance.link(cls);
        if (cls.getMembers() != null) {
            for (Symbol m : cls.getMembers()) {
                if (m.getKind() == SymbolKind.CONSTRUCTOR && (m.getParameterTypes() == null || m.getParameterTypes().isEmpty())) {
                    return m;
                }
            }
        }
        return null;
    }

    private Symbol classSymbolOf(ExpressionNodeZ node) {
        Type t = typeAnnotations.get(node);
        if (t != null && t.getCustomName() != null) {
            return findClassSymbol(t.getCustomName());
        }
        return null;
    }

    private ValueType valueTypeOf(AstNode node) {
        Type t = typeAnnotations.get(node);
        return t != null ? IntermediateTypes.of(t.getKind()) : ValueType.INT;
    }

    private ValueType returnTypeOf(Symbol s) {
        if (s == null || s.getReturnType() == null) return ValueType.INT;
        return declaredType(s.getReturnType());
    }

    private ValueType declaredType(String typeName) {
        if (typeName == null) return ValueType.INT;
        return switch (typeName.toLowerCase()) {
            case "int" -> ValueType.INT;
            case "float", "double" -> ValueType.FLOAT;
            case "boolean", "bool" -> ValueType.BOOLEAN;
            case "char" -> ValueType.CHAR;
            case "string" -> ValueType.STRING;
            default -> ValueType.INT;
        };
    }

    private ValueType declaredType(TypeNodeZ typeNode) {
        if (typeNode == null) return ValueType.INT;
        if (typeNode.getDataType() != null) {
            return switch (typeNode.getDataType()) {
                case INT -> ValueType.INT;
                case DOUBLE -> ValueType.FLOAT;
                case BOOLEAN -> ValueType.BOOLEAN;
                case CHAR -> ValueType.CHAR;
                case STRING -> ValueType.STRING;
                default -> ValueType.INT;
            };
        }
        return ValueType.INT;
    }

    private TypeKind kindOf(TypeNodeZ typeNode) {
        if (typeNode == null || typeNode.getDataType() == null) return TypeKind.INT;
        return switch (typeNode.getDataType()) {
            case INT -> TypeKind.INT;
            case DOUBLE -> TypeKind.FLOAT;
            case BOOLEAN -> TypeKind.BOOLEAN;
            case CHAR -> TypeKind.CHAR;
            case STRING -> TypeKind.STRING;
            default -> TypeKind.CUSTOM;
        };
    }

    private static ValueType operandTypeOf(Value left, Value right) {
        if (left.type() == ValueType.STRING || right.type() == ValueType.STRING) return ValueType.STRING;
        if (left.type() == ValueType.FLOAT || right.type() == ValueType.FLOAT) return ValueType.FLOAT;
        return ValueType.INT;
    }

    private static Integer literalInt(ExpressionNodeZ node) {
        if (node instanceof LiteralExpressionNodeZ lit && lit.getDataValue() instanceof Number n) {
            return n.intValue();
        }
        return null;
    }

    private static String charCode(Object literal) {
        if (literal instanceof Character c) return String.valueOf((int) c);
        if (literal instanceof String s && !s.isEmpty()) return String.valueOf((int) s.charAt(0));
        return "0";
    }
}
