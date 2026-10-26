package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.UnaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Cell;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Constant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Text;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallIndirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.LoadLabelAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.*;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.*;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.FunctionFrame;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator.IntermediateTypes;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZClassLayoutService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZInheritanceService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSymbolLookupService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Principal pig latin code generator
 *
 */
public class PigLatinCodeGeneratorVisitor implements PigLatinAstVisitor<Void> {

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

    private final Map<String, String> objectClassMap = new HashMap<>();
    private final ZInheritanceService inheritance;
    private final ZClassLayoutService layoutService;
    private Map<String, List<String>> structFieldLayouts;

    public PigLatinCodeGeneratorVisitor(GlobalSymbolTable table,
                                        EditorContext context,
                                        Map<AstNode, Type> typeAnnotations,
                                        Map<AstNode, Symbol> resolvedCalls,
                                        IntermediateBuilder ir,
                                        CodeGenContext labels) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations != null ? typeAnnotations : Map.of();
        this.resolvedCalls = resolvedCalls != null ? resolvedCalls : Map.of();
        this.ir = ir;
        this.labels = labels != null ? labels : new CodeGenContext();
        this.values = new ValueEmitter(ir, frame);
        this.inheritance = new ZInheritanceService(new ZSymbolLookupService(table, context));
        this.layoutService = new ZClassLayoutService(table, inheritance);
    }

    public PigLatinCodeGeneratorVisitor(GlobalSymbolTable table,
                                        EditorContext context,
                                        Map<AstNode, Type> typeAnnotations,
                                        IntermediateBuilder ir,
                                        CodeGenContext labels) {
        this(table, context, typeAnnotations, Map.of(), ir, labels);
    }

    // ============================================================
    // TOP-LEVEL & MAIN ORCHESTRATION
    // ============================================================

    @Override
    public Void visit(ProgramNodePigLatin node) {
        if (node.getBody() != null) node.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(BodyNodePigLatin node) {
        ir.beginFunction("main");
        frame = new FunctionFrame();
        values = new ValueEmitter(ir, frame);

        if (node.getVariablesSection() != null) {
            node.getVariablesSection().accept(this);
        }

        if (node.getMaiorSection() != null) {
            node.getMaiorSection().accept(this);
        }

        ir.emit(new Return());
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
        return null;
    }

    @Override
    public Void visit(AccessorNodePigLatin node) {
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
        ValueType vType = declaredType != null ? declaredValueType(declaredType) : ValueType.INT;

        boolean isObject = declaredType != null && declaredType.isCustom() && !"String".equals(declaredType.getCustomName());
        boolean isStruct = false;
        if (isObject) {
            Symbol sym = findTypeSymbolGlobal(declaredType.getCustomName());
            if (sym != null && sym.getKind() == SymbolKind.STRUCT) {
                isStruct = true;
                isObject = false;
            }
        }

        if (isObject) {
            objectClassMap.put(name, declaredType.getCustomName());
            Cell cell = frame.declare(name, ValueType.INT);
            if (node.getInitializer() != null) {
                Value initVal = eval(node.getInitializer());
                values.store(initVal, cell);
            }
            return null;
        }

        if (isStruct) {
            String structTypeName = declaredType.getCustomName();
            List<String> fields = structFields(structTypeName);
            int numFields = fields != null ? fields.size() : 1;
            int base = frame.allocate(numFields);
            frame.registerStruct(name, new StructInfo(structTypeName, base, false));
            frame.declare(name, ValueType.INT);

            if (node.getInitializer() instanceof StructLiteralExpressionNodePigLatin lit) {
                populateStructLiteral(base, fields, lit);
            } else if (node.getInitializer() != null) {
                Value initVal = eval(node.getInitializer());
                values.store(initVal, frame.lookup(name));
            }
            return null;
        }

        Cell cell = frame.declare(name, vType);
        if (node.getInitializer() != null) {
            Value initVal = eval(node.getInitializer());
            values.store(initVal, cell);
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

        int base = frame.allocate(totalSize);
        TypeKind elementKind = mapTypeNodeToType(node.getDataType()).getKind();
        if (elementKind == TypeKind.CUSTOM) elementKind = TypeKind.INT;
        ValueType elementType = IntermediateTypes.of(elementKind);

        frame.registerArray(node.getIdentifier(), new ArrayInfo(base, elementKind, totalSize, false));
        frame.declare(node.getIdentifier(), ValueType.INT);

        if (node.getInitializer() != null && node.getInitializer().getElements() != null) {
            List<ExpressionNodePigLatin> valuesList = node.getInitializer().getElements();
            for (int i = 0; i < valuesList.size() && i < totalSize; i++) {
                Value elemVal = eval(valuesList.get(i));
                Cell targetCell = new Cell(elementType, new Frame(base + i));
                values.store(elemVal, targetCell);
            }
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        String name = node.getIdentifier();
        String structType = node.getStructType();
        List<String> fields = structFields(structType);
        int numFields = fields != null ? fields.size() : 0;

        int base = frame.allocate(numFields);
        frame.registerStruct(name, new StructInfo(structType, base, false));
        frame.declare(name, ValueType.INT);

        if (node.getLiteral() != null) {
            populateStructLiteral(base, fields, node.getLiteral());
        }
        return null;
    }

    private void populateStructLiteral(int baseOffset, List<String> fields, StructLiteralExpressionNodePigLatin lit) {
        if (lit.getProperties() == null || fields == null) return;
        List<StructPropertyNodePigLatin> props = lit.getProperties();
        int count = Math.min(props.size(), fields.size());
        for (int i = 0; i < count; i++) {
            StructPropertyNodePigLatin prop = props.get(i);
            if (prop.getValue() == null) continue;
            Value val = eval(prop.getValue());
            Cell targetCell = new Cell(val.type(), new Frame(baseOffset + i));
            values.store(val, targetCell);
        }
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        String name = node.getId();
        Type declaredType = mapTypeNodeToType(node.getType());
        ValueType vType = declaredType != null ? declaredValueType(declaredType) : ValueType.INT;
        Cell cell = frame.declare(name, vType);
        if (node.getExpr() != null) {
            Value initVal = eval(node.getExpr());
            values.store(initVal, cell);
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        if (node.getId() != null && node.getExpr() != null) {
            Cell cell = frame.lookup(node.getId());
            if (cell != null) {
                Value val = eval(node.getExpr());
                values.store(val, cell);
            }
        }
        return null;
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
        switch (node.getOperator()) {
            case INCREMENT, PREFIX_INCREMENT -> values.incDec(eval(node.getTarget()), BinaryOperations.ADD);
            case DECREMENT, PREFIX_DECREMENT -> values.incDec(eval(node.getTarget()), BinaryOperations.SUB);
            case ASSIGN -> {
                if (node.getValue() != null) {
                    assign(node.getTarget(), eval(node.getValue()));
                }
            }
        }
        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        assign(node.getIdentifier(), eval(node.getExpressionNode()));
        return null;
    }

    private void assign(ExpressionNodePigLatin target, Value value) {
        if (target instanceof IdentifierExpressionNodePigLatin id) {
            Cell cell = frame.lookup(id.getIdentifier());
            if (cell == null) {
                throw new IllegalStateException("Variable no declarada: " + id.getIdentifier());
            }
            values.store(value, cell);
            return;
        }

        if (target instanceof PropertyAccessExpressionNodePigLatin prop) {
            assignProperty(prop, value);
            return;
        }

        if (target instanceof MemberArrayAccessExpressionNodePigLatin memberArr) {
            assignArrayElement(memberArr.getTarget(), memberArr.getIndex(), value);
            return;
        }

        if (target instanceof ArrayCallExpressionNodePigLatin arrCall) {
            ArrayInfo info = frame.arrayOf(arrCall.getArrayName());
            if (info != null) {
                assignArrayElementByName(info, arrCall.getIndexExpression(), value);
            }
            return;
        }

        throw new IllegalStateException("Destino de asignación no soportado: " + target);
    }

    private void assignProperty(PropertyAccessExpressionNodePigLatin prop, Value value) {
        ExpressionNodePigLatin targetExpr = prop.getTarget();
        String propName = prop.getPropertyName();

        if (targetExpr instanceof IdentifierExpressionNodePigLatin id) {
            StructInfo sinfo = frame.structOf(id.getIdentifier());
            if (sinfo != null) {
                List<String> layout = structFields(sinfo.getStructTypeName());
                int offset = layout != null ? layout.indexOf(propName) : -1;
                if (offset >= 0) {
                    Cell cell = new Cell(value.type(), new Frame(sinfo.getBaseOffset() + offset));
                    values.store(value, cell);
                    return;
                }
            }
        }

        Value objVal = eval(targetExpr);
        Symbol cls = classSymbolOf(targetExpr);
        if (cls != null) {
            Symbol field = findFieldSymbol(cls, propName);
            storeFieldToHeap(objVal, field, value);
            return;
        }

        throw new IllegalStateException("Propiedad no resuelta: " + propName);
    }

    private void assignArrayElement(ExpressionNodePigLatin target, ExpressionNodePigLatin indexExpr, Value value) {
        if (target instanceof IdentifierExpressionNodePigLatin id) {
            ArrayInfo info = frame.arrayOf(id.getIdentifier());
            if (info != null) {
                assignArrayElementByName(info, indexExpr, value);
                return;
            }
        }
        if (target instanceof PropertyAccessExpressionNodePigLatin prop) {
            if (prop.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
                StructInfo sinfo = frame.structOf(id.getIdentifier());
                if (sinfo != null) {
                    List<String> layout = structFields(sinfo.getStructTypeName());
                    int offset = layout != null ? layout.indexOf(prop.getPropertyName()) : -1;
                    if (offset >= 0) {
                        Value indexVal = eval(indexExpr);
                        Register idx = Register.ax(ValueType.INT);
                        values.loadCoerced(indexVal, idx);
                        Register regValue = Register.cx(value.type());
                        values.loadCoerced(value, regValue);

                        if (sinfo.isReference()) {
                            Register ptr = Register.bx(ValueType.INT);
                            ir.emit(new Load(MemorySpace.STACK, new Frame(sinfo.getBaseOffset()), ptr));
                            if (offset > 0) {
                                Register offsetReg = Register.ax(ValueType.INT);
                                ir.emit(new Move(new com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate(String.valueOf(offset), ValueType.INT), offsetReg));
                                ir.emit(new BinaryOperation(BinaryOperations.ADD, ptr, offsetReg, ptr));
                                values.loadCoerced(indexVal, idx);
                            }
                            ir.emit(new IndexAddress(ptr, idx, ptr));
                            ir.emit(new Store(MemorySpace.STACK, new Indirect(ptr, 0), regValue));
                        } else {
                            int base = sinfo.getBaseOffset() + offset;
                            ir.emit(new StoreIndexed(new Frame(base), idx, regValue));
                        }
                        return;
                    }
                }
            }
        }
        throw new IllegalStateException("Asignación a arreglo no soportada para: " + target);
    }

    private void assignArrayElementByName(ArrayInfo info, ExpressionNodePigLatin indexExpr, Value value) {
        ValueType element = IntermediateTypes.of(info.getElementType());
        Register index = Register.ax(ValueType.INT);
        values.load(eval(indexExpr), index);
        Register regValue = Register.cx(element);
        values.loadCoerced(value, regValue);

        if (info.isHeap()) {
            Register pointer = Register.bx(ValueType.INT);
            ir.emit(new Load(MemorySpace.STACK, new Frame(info.getBaseOffset()), pointer));
            ir.emit(new IndexAddress(pointer, index, pointer));
            ir.emit(new Store(MemorySpace.STACK, new Indirect(pointer, 0), regValue));
        } else {
            ir.emit(new StoreIndexed(new Frame(info.getBaseOffset()), index, regValue));
        }
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
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
    public Void visit(IncrementStatementNodePigLatin node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.ADD);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.SUB);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.ADD);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        values.incDec(eval(node.getTargetVariable()), BinaryOperations.SUB);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        if (node.getExpressionList() == null || node.getExpressionList().isEmpty()) {
            Register empty = Register.cx(ValueType.STRING);
            ir.emit(new Move(new StringRef(ir.intern("")), empty));
            ir.emit(new Print(empty, true));
            return null;
        }

        Value accumulated = null;
        for (ExpressionNodePigLatin expr : node.getExpressionList()) {
            Value v = eval(expr);
            accumulated = (accumulated == null) ? v : concat(accumulated, v);
        }

        Register reg = Register.ax(ValueType.STRING);
        values.load(accumulated, reg);
        ir.emit(new Print(reg, true));
        return null;
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        if (node.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
            Cell cell = frame.lookup(id.getIdentifier());
            if (cell != null) {
                ir.emit(new Read(cell.type(), cell.getAddress()));
            }
        } else {
            Cell temp = frame.temp(ValueType.STRING);
            ir.emit(new Read(ValueType.STRING, temp.getAddress()));
        }
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
        ir.emit(new Return());
        return null;
    }

    @Override
    public Void visit(BreakStatementNodePigLatin node) {
        if (!breakLabels.isEmpty()) {
            ir.emit(new Jump(breakLabels.peek()));
        }
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodePigLatin node) {
        if (!continueLabels.isEmpty()) {
            ir.emit(new Jump(continueLabels.peek()));
        }
        return null;
    }

    private void branch(ExpressionNodePigLatin condition, boolean jumpWhen, String label) {
        Register reg = Register.ax(ValueType.BOOLEAN);
        values.load(eval(condition), reg);
        ir.emit(new BranchIf(reg, jumpWhen, label));
    }

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        String endLabel = labels.nextLabel();
        String nextLabel = (node.getElseIfs() != null && !node.getElseIfs().isEmpty()) || node.getElseBlockNode() != null
                ? labels.nextLabel() : endLabel;

        branch(node.getCondition(), false, nextLabel);

        if (node.getThenBody() != null) {
            for (PigLatinAstNode s : node.getThenBody()) if (s != null) s.accept(this);
        }

        if (nextLabel != endLabel) {
            ir.emit(new Jump(endLabel));
            ir.emit(new MarkLabel(nextLabel));

            if (node.getElseIfs() != null) {
                for (ElseIfNodePigLatin elseIf : node.getElseIfs()) {
                    if (elseIf == null) continue;
                    String elseIfNext = labels.nextLabel();
                    branch(elseIf.getCondition(), false, elseIfNext);

                    if (elseIf.getBody() != null) {
                        for (PigLatinAstNode s : elseIf.getBody()) if (s != null) s.accept(this);
                    }
                    ir.emit(new Jump(endLabel));
                    ir.emit(new MarkLabel(elseIfNext));
                }
            }

            if (node.getElseBlockNode() != null && node.getElseBlockNode().getBody() != null) {
                for (PigLatinAstNode s : node.getElseBlockNode().getBody()) {
                    if (s != null) s.accept(this);
                }
            }
        }

        ir.emit(new MarkLabel(endLabel));
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
        String startLabel = labels.nextLabel();
        String endLabel = labels.nextLabel();

        ir.emit(new MarkLabel(startLabel));
        branch(node.getCondition(), false, endLabel);

        breakLabels.push(endLabel);
        continueLabels.push(startLabel);
        if (node.getBody() != null) node.getBody().accept(this);
        continueLabels.pop();
        breakLabels.pop();

        ir.emit(new Jump(startLabel));
        ir.emit(new MarkLabel(endLabel));
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        String startLabel = labels.nextLabel();
        String condLabel = labels.nextLabel();
        String endLabel = labels.nextLabel();

        ir.emit(new MarkLabel(startLabel));
        breakLabels.push(endLabel);
        continueLabels.push(condLabel);
        if (node.getBody() != null) node.getBody().accept(this);
        continueLabels.pop();
        breakLabels.pop();

        ir.emit(new MarkLabel(condLabel));
        branch(node.getCondition(), true, startLabel);
        ir.emit(new MarkLabel(endLabel));
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        String startLabel = labels.nextLabel();
        String updateLabel = labels.nextLabel();
        String endLabel = labels.nextLabel();

        if (node.getInit() != null) node.getInit().accept(this);

        ir.emit(new MarkLabel(startLabel));
        if (node.getCondition() != null) {
            branch(node.getCondition(), false, endLabel);
        }

        breakLabels.push(endLabel);
        continueLabels.push(updateLabel);
        if (node.getBody() != null) node.getBody().accept(this);
        continueLabels.pop();
        breakLabels.pop();

        ir.emit(new MarkLabel(updateLabel));
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        ir.emit(new Jump(startLabel));
        ir.emit(new MarkLabel(endLabel));
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
            last = new Text(ir.intern(String.valueOf(value)));
            return null;
        }
        if (t != null && t.getKind() == TypeKind.BOOLEAN) {
            last = new Constant(Boolean.TRUE.equals(value) ? "1" : "0", ValueType.BOOLEAN);
            return null;
        }
        if (t != null && t.getKind() == TypeKind.NULL) {
            last = new Constant("0", ValueType.INT);
            return null;
        }

        if (value == null) {
            last = switch (node.getValueType()) {
                case DECIMAL -> new Constant("0.0", ValueType.FLOAT);
                case CHAR -> new Constant("0", ValueType.CHAR);
                case STRING -> new Text(ir.intern(""));
                case BOOLEAN -> new Constant("0", ValueType.BOOLEAN);
                default -> new Constant("0", ValueType.INT);
            };
            return null;
        }

        // At this point value is guaranteed non-null
        last = switch (node.getValueType()) {
            case DECIMAL -> new Constant(String.valueOf(value), ValueType.FLOAT);
            case CHAR -> new Constant(charCode(value), ValueType.CHAR);
            case STRING -> new Text(ir.intern(String.valueOf(value)));
            case BOOLEAN -> new Constant(Boolean.TRUE.equals(value) ? "1" : "0", ValueType.BOOLEAN);
            default -> {
                String lit = String.valueOf(value);
                // Defensive: if somehow value became null at this point, default to 0
                yield new Constant(lit.equals("null") ? "0" : lit, ValueType.INT);
            }
        };
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        Cell cell = frame.lookup(node.getIdentifier());
        if (cell == null) {
            last = new Constant("0", ValueType.INT);
            return null;
        }
        last = cell;
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());
        BinaryOperations op = binaryOpToIntermediate(node.getOperator());
        Type resultTypeAnn = typeAnnotations.get(node);
        ValueType annotated = resultTypeAnn != null ? declaredValueType(resultTypeAnn) : null;

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
    public Void visit(UnaryExpressionNodePigLatin node) {
        Value operand = eval(node.getExpressionNode());
        UnaryOperations op = unaryOpToIntermediate(node.getOperator());
        ValueType type = op == UnaryOperations.NOT ? ValueType.BOOLEAN
                : (operand.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT);
        Register a = Register.ax(type), c = Register.cx(type);
        values.load(operand, a);
        ir.emit(new UnaryOperation(op, a, c));
        last = values.spill(c);
        return null;
    }

    // ============================================================
    // OBJECTS (Z), FUNCTIONS (Y) & STRUCTS
    // ============================================================

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        String className = node.getClassName();

        if ("String".equals(className)) {
            if (node.getArguments() != null && !node.getArguments().isEmpty()) {
                last = eval(node.getArguments().get(0));
            } else {
                last = new Text(ir.intern(""));
            }
            return null;
        }

        emitObjectCreation(className, node.getArguments(), node);
        return null;
    }

    private void emitObjectCreation(String className, List<ExpressionNodePigLatin> args, AstNode callNode) {
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
            for (ExpressionNodePigLatin arg : args) pushArgument(arg);
        }

        String ctorLabel = NameMangler.codeLabel(ctor);
        ir.emit(new Call(ctorLabel));

        int totalArgs = 1 + (args != null ? args.size() : 0);
        ir.emit(new AdjustStackTop(-(totalArgs + CALL_AREA)));

        last = savedObj;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {
        boolean isMethodCall = node.getTarget() != null;
        List<ExpressionNodePigLatin> args = node.getArguments() != null ? node.getArguments() : List.of();

        if (isMethodCall) {
            emitMethodCall(node, args);
        } else {
            emitFunctionCall(node, args);
        }
        return null;
    }

    private void emitMethodCall(FunctionCallExpressionNodePigLatin node, List<ExpressionNodePigLatin> args) {
        Value selfVal = eval(node.getTarget());
        Cell preservedSelf;
        if (selfVal instanceof Cell c) {
            preservedSelf = c;
        } else {
            preservedSelf = frame.temp(selfVal.type());
            values.store(selfVal, preservedSelf);
        }
        Register selfReg = Register.ax(ValueType.INT);
        values.load(preservedSelf, selfReg);

        Symbol targetMethod = resolvedCalls.get(node);
        if (targetMethod == null) {
            Symbol targetClass = classSymbolOf(node.getTarget());
            if (targetClass != null) {
                targetMethod = findMethodInClass(targetClass, node.getFunctionName(), args.size());
            }
        }

        if (targetMethod == null) {
            throw new IllegalStateException("Método no resuelto para la llamada: " + node.getFunctionName() + " en línea " + node.getLine());
        }

        ir.emit(new AdjustStackTop(CALL_AREA));
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), selfReg));
        ir.emit(new AdjustStackTop(1));

        for (ExpressionNodePigLatin arg : args) pushArgument(arg);

        int totalArgs = 1 + args.size();

        if (!targetMethod.isVirtual()) {
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
    }

    private void emitFunctionCall(FunctionCallExpressionNodePigLatin node, List<ExpressionNodePigLatin> args) {
        Symbol targetFn = resolvedCalls.get(node);
        if (targetFn == null) {
            targetFn = findFunctionByName(node.getFunctionName(), args.size());
        }

        int n = args.size();
        ir.emit(new AdjustStackTop(CALL_AREA));
        for (ExpressionNodePigLatin arg : args) pushArgument(arg);

        String callLabel = targetFn != null ? NameMangler.resolveCallLabel(targetFn) : node.getFunctionName();
        ir.emit(new Call(callLabel));

        Type retTypeAnn = typeAnnotations.get(node);
        ValueType retType = retTypeAnn != null ? declaredValueType(retTypeAnn) : (targetFn != null ? returnTypeOf(targetFn) : ValueType.INT);

        if (retTypeAnn == null || retTypeAnn.getKind() != TypeKind.VOID) {
            Register result = Register.cx(retType);
            ir.emit(new Load(MemorySpace.STACK, new StackTop(-(n + 1)), result));
            last = values.spill(result);
        } else {
            last = null;
        }

        ir.emit(new AdjustStackTop(-(n + CALL_AREA)));
    }

    @Override
    public Void visit(PropertyAccessExpressionNodePigLatin node) {
        String prop = node.getPropertyName();

        if (node.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
            StructInfo sinfo = frame.structOf(id.getIdentifier());
            if (sinfo != null) {
                List<String> layout = structFields(sinfo.getStructTypeName());
                int offset = layout != null ? layout.indexOf(prop) : -1;
                if (offset >= 0) {
                    Type fieldType = typeAnnotations.get(node);
                    ValueType vType = fieldType != null ? declaredValueType(fieldType) : ValueType.INT;
                    if (sinfo.isReference()) {
                        Register pointer = Register.ax(ValueType.INT);
                        Register result = Register.cx(vType);
                        ir.emit(new Load(MemorySpace.STACK, new Frame(sinfo.getBaseOffset()), pointer));
                        ir.emit(new Load(MemorySpace.STACK, new Indirect(pointer, offset), result));
                        last = values.spill(result);
                    } else {
                        last = new Cell(vType, new Frame(sinfo.getBaseOffset() + offset));
                    }
                    return null;
                }
            }
        }

        Value targetVal = eval(node.getTarget());
        Symbol targetClass = classSymbolOf(node.getTarget());
        Symbol field = findFieldSymbol(targetClass, prop);
        last = loadFieldFromHeap(targetVal, field);
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodePigLatin node) {
        if (node.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
            ArrayInfo info = frame.arrayOf(id.getIdentifier());
            if (info != null) {
                loadArrayElement(info, node.getIndex());
                return null;
            }
        }
        if (node.getTarget() instanceof PropertyAccessExpressionNodePigLatin prop) {
            if (prop.getTarget() instanceof IdentifierExpressionNodePigLatin id) {
                StructInfo sinfo = frame.structOf(id.getIdentifier());
                if (sinfo != null) {
                    List<String> layout = structFields(sinfo.getStructTypeName());
                    int offset = layout != null ? layout.indexOf(prop.getPropertyName()) : -1;
                    if (offset >= 0) {
                        ValueType elemType = ValueType.INT;
                        Value indexVal = eval(node.getIndex());
                        Register idx = Register.ax(ValueType.INT);
                        values.loadCoerced(indexVal, idx);
                        Register result = Register.cx(elemType);

                        if (sinfo.isReference()) {
                            Register ptr = Register.bx(ValueType.INT);
                            ir.emit(new Load(MemorySpace.STACK, new Frame(sinfo.getBaseOffset()), ptr));
                            if (offset > 0) {
                                Register offsetReg = Register.ax(ValueType.INT);
                                ir.emit(new Move(new com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate(String.valueOf(offset), ValueType.INT), offsetReg));
                                ir.emit(new BinaryOperation(BinaryOperations.ADD, ptr, offsetReg, ptr));
                                values.loadCoerced(indexVal, idx);
                            }
                            ir.emit(new IndexAddress(ptr, idx, ptr));
                            ir.emit(new Load(MemorySpace.STACK, new Indirect(ptr, 0), result));
                        } else {
                            int base = sinfo.getBaseOffset() + offset;
                            ir.emit(new LoadIndexed(new Frame(base), idx, result));
                        }
                        last = values.spill(result);
                        return null;
                    }
                }
            }
        }
        last = new Constant("0", ValueType.INT);
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodePigLatin node) {
        ArrayInfo info = frame.arrayOf(node.getArrayName());
        if (info != null) {
            loadArrayElement(info, node.getIndexExpression());
            return null;
        }
        last = new Constant("0", ValueType.INT);
        return null;
    }

    private void loadArrayElement(ArrayInfo info, ExpressionNodePigLatin indexExpr) {
        ValueType element = IntermediateTypes.of(info.getElementType());
        Register index = Register.ax(ValueType.INT);
        Register result = Register.cx(element);

        values.load(eval(indexExpr), index);
        if (info.isHeap()) {
            Register pointer = Register.bx(ValueType.INT);
            ir.emit(new Load(MemorySpace.STACK, new Frame(info.getBaseOffset()), pointer));
            ir.emit(new IndexAddress(pointer, index, pointer));
            ir.emit(new Load(MemorySpace.STACK, new Indirect(pointer, 0), result));
        } else {
            ir.emit(new LoadIndexed(new Frame(info.getBaseOffset()), index, result));
        }
        last = values.spill(result);
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

    // ============================================================
    // HEAP / FIELD ACCESS HELPERS
    // ============================================================

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

    private void pushArgument(ExpressionNodePigLatin arg) {
        if (arg instanceof IdentifierExpressionNodePigLatin id) {
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
        Value val = eval(arg);
        Register reg = Register.ax(val.type());
        values.loadCoerced(val, reg);
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), reg));
        ir.emit(new AdjustStackTop(1));
    }

    private void pushReference(boolean alreadyReference, int baseOffset) {
        Register reg = Register.ax(ValueType.INT);
        if (alreadyReference) ir.emit(new Load(MemorySpace.STACK, new Frame(baseOffset), reg));
        else ir.emit(new LoadAddress(new Frame(baseOffset), reg));
        ir.emit(new Store(MemorySpace.STACK, new StackTop(0), reg));
        ir.emit(new AdjustStackTop(1));
    }

    // ============================================================
    // EVALUATION & TYPE HELPERS
    // ============================================================

    private Value eval(ExpressionNodePigLatin expr) {
        if (expr == null) return new Constant("0", ValueType.INT);
        last = null;
        expr.accept(this);
        if (last == null) {
            return new Constant("0", ValueType.INT);
        }
        return last;
    }

    private Symbol classSymbolOf(ExpressionNodePigLatin expr) {
        Type t = typeAnnotations.get(expr);
        if (t != null && t.isCustom()) {
            return findClassSymbol(t.getCustomName());
        }
        if (expr instanceof IdentifierExpressionNodePigLatin id) {
            String className = objectClassMap.get(id.getIdentifier());
            if (className != null) return findClassSymbol(className);
        }
        return null;
    }

    private Symbol findFieldSymbol(Symbol classSymbol, String fieldName) {
        if (classSymbol == null) return null;
        inheritance.link(classSymbol);
        if (classSymbol.getMembers() != null) {
            for (Symbol m : classSymbol.getMembers()) {
                if (m.getKind() == SymbolKind.ATTRIBUTE && m.getName().equals(fieldName)) {
                    return m;
                }
            }
        }
        return null;
    }

    private Symbol findClassSymbol(String name) {
        if (name == null) return null;
        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol s : bucket) {
                    if (s.getKind() == SymbolKind.CLASS && s.getName().equals(name)) return s;
                }
            }
        }
        for (List<Symbol> bucket : table.getGlobalScope().getSymbols().values()) {
            for (Symbol s : bucket) {
                if (s.getKind() == SymbolKind.CLASS && s.getName().equals(name)) return s;
            }
        }
        return null;
    }

    private Symbol findConstructorByParams(Symbol classSymbol, List<? extends AstNode> args) {
        if (classSymbol == null) return null;
        inheritance.link(classSymbol);
        int argCount = args != null ? args.size() : 0;
        Symbol fallback = null;
        if (classSymbol.getMembers() != null) {
            for (Symbol m : classSymbol.getMembers()) {
                if (m.getKind() == SymbolKind.CONSTRUCTOR) {
                    if (m.getParameterTypes().size() == argCount) return m;
                    fallback = m;
                }
            }
        }
        return fallback;
    }

    private Symbol findMethodInClass(Symbol classSymbol, String methodName, int argCount) {
        if (classSymbol == null) return null;
        inheritance.link(classSymbol);
        if (classSymbol.getMembers() != null) {
            for (Symbol m : classSymbol.getMembers()) {
                if (m.getKind() == SymbolKind.METHOD && m.getName().equals(methodName)) {
                    if (m.getParameterTypes().size() == argCount) return m;
                }
            }
        }
        return null;
    }

    private Symbol findFunctionByName(String name, int argCount) {
        List<Symbol> found = table.resolveByName(name);
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.FUNCTION) {
                if (s.getParameterTypes() != null && s.getParameterTypes().size() == argCount) {
                    return s;
                }
            }
        }
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.FUNCTION) return s;
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
        return null;
    }

    private List<String> structFields(String structName) {
        if (structFieldLayouts == null) {
            structFieldLayouts = new HashMap<>();
            for (Symbol s : table.getAllSymbols()) {
                if (s.getKind() == SymbolKind.STRUCT && s.getMembers() != null) {
                    structFieldLayouts.putIfAbsent(s.getName(),
                            s.getMembers().stream().map(Symbol::getName).collect(Collectors.toList()));
                }
            }
        }
        return structFieldLayouts.get(structName);
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

    private ValueType declaredValueType(Type type) {
        if (type == null) return ValueType.INT;
        return switch (type.getKind()) {
            case STRING -> ValueType.STRING;
            case FLOAT -> ValueType.FLOAT;
            case CHAR -> ValueType.CHAR;
            case BOOLEAN -> ValueType.BOOLEAN;
            case VOID -> ValueType.INT;
            default -> ValueType.INT;
        };
    }

    private ValueType declaredType(String typeName) {
        if (typeName == null) return ValueType.INT;
        return switch (typeName.toLowerCase()) {
            case "int" -> ValueType.INT;
            case "float", "decimal" -> ValueType.FLOAT;
            case "string" -> ValueType.STRING;
            case "char" -> ValueType.CHAR;
            case "boolean", "bool" -> ValueType.BOOLEAN;
            default -> ValueType.INT;
        };
    }

    private ValueType returnTypeOf(Symbol method) {
        return declaredType(method.getReturnType());
    }

    private static ValueType operandTypeOf(Value left, Value right) {
        if (left.type() == ValueType.STRING || right.type() == ValueType.STRING) return ValueType.STRING;
        if (left.type() == ValueType.FLOAT || right.type() == ValueType.FLOAT) return ValueType.FLOAT;
        return ValueType.INT;
    }

    private BinaryOperations binaryOpToIntermediate(BinaryOperator op) {
        return switch (op) {
            case PLUS -> BinaryOperations.ADD;
            case MINUS -> BinaryOperations.SUB;
            case MULTIPLICATION -> BinaryOperations.MUL;
            case DIVIDE -> BinaryOperations.DIV;
            case MODULE -> BinaryOperations.MOD;
            case EQUALS -> BinaryOperations.EQ;
            case DIFFERENT -> BinaryOperations.NE;
            case LESS -> BinaryOperations.LT;
            case LESS_EQUALS -> BinaryOperations.LE;
            case GREATER -> BinaryOperations.GT;
            case GREATER_EQUALS -> BinaryOperations.GE;
            case AND -> BinaryOperations.AND;
            case OR -> BinaryOperations.OR;
        };
    }


    private UnaryOperations unaryOpToIntermediate(UnaryOperator op) {
        return switch (op) {
            case NEGATE -> UnaryOperations.NEG;
            case NOT -> UnaryOperations.NOT;
        };
    }

    private String charCode(Object value) {
        if (value instanceof Character c) return String.valueOf((int) c);
        if (value instanceof Number n) return String.valueOf(n.intValue());
        String s = String.valueOf(value);
        return s.isEmpty() ? "0" : String.valueOf((int) s.charAt(0));
    }

    private Integer tryExtractIntLiteral(ExpressionNodePigLatin expr) {
        if (expr instanceof LiteralExpressionNodePigLatin lit) {
            Object v = lit.getDataValue();
            if (v instanceof Integer i) return i;
            if (v instanceof Number n) return n.intValue();
        }
        return null;
    }
}