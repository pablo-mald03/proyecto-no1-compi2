package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
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
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class PigLatinTypeCheckerVisitor implements PigLatinAstVisitor<Type> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;

    private Type currentSwitchSelectorType;
    private Type currentReturnType;

    public PigLatinTypeCheckerVisitor(GlobalSymbolTable table,
                                      EditorContext context,
                                      Map<AstNode, Type> typeAnnotations) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
    }

    private void annotate(AstNode node, Type type) {
        typeAnnotations.put(node, type);
    }

    private SymbolScope lookupRegisteredScope(PigLatinAstNode node) {
        String key = GlobalSymbolTable.buildScopeKey(
                context.getFilePath(),
                node.getClass().getSimpleName(),
                node.getLine(),
                node.getColumn()
        );
        return table.getRegisteredScope(key);
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Type visit(ProgramNodePigLatin node) {
        if (node.getBody() != null) node.getBody().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(BodyNodePigLatin node) {
        if (node.getVariablesSection() != null) node.getVariablesSection().accept(this);
        if (node.getMaiorSection() != null) node.getMaiorSection().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(MaiorSectionNodePigLatin node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        if (node.getStatements() != null) {
            node.getStatements().accept(this);
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(CodeBodyNodePigLatin node) {
        if (node.getStatements() != null) {
            for (PigLatinAstNode statement : node.getStatements()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(VariablesSectionNodePigLatin node) {
        if (node.getDeclarations() != null) {
            node.getDeclarations().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(VariablesBodyNodePigLatin node) {
        if (node.getDeclarations() != null) {
            for (PigLatinAstNode declaration : node.getDeclarations()) {
                if (declaration != null) declaration.accept(this);
            }
        }
        return Type.voidType();
    }

    // ============================================================
    // IMPORTS (nothing to type-check)
    // ============================================================

    @Override
    public Type visit(ImportNodePigLatin node) {
        return Type.voidType();
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Type visit(VariableDeclarationNodePigLatin node) {
        Type declaredType = mapTypeNode(node.getDataType());

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a variable de tipo " + declaredType,
                        node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ArrayDeclarationNodePigLatin node) {
        Type elementType = mapTypeNode(node.getDataType());
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 1;
        Type arrayType = Type.arrayType(elementType, dims);

        // Validate dimensions are integer-like.
        if (node.getDimensions() != null) {
            for (ExpressionNodePigLatin dimExpr : node.getDimensions()) {
                if (dimExpr != null) {
                    Type dimType = dimExpr.accept(this);
                    if (!isIntLike(dimType) && !dimType.isUnknown()) {
                        reportTypeError(node.getIdentifier(),
                                "Las dimensiones del arreglo deben ser enteras", node);
                    }
                }
            }
        }

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(arrayType)) {
                reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a arreglo de tipo " + arrayType,
                        node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructInstanceNodePigLatin node) {
        String structTypeName = node.getStructType();
        Symbol structSymbol = findTypeSymbolGlobal(structTypeName);

        if (structSymbol == null || structSymbol.getKind() != SymbolKind.STRUCT) {
            // Resolver already reported.
            return Type.unknown();
        }

        Type structType = Type.customType(structTypeName);
        annotate(node, structType);

        List<Symbol> members = structSymbol.getMembers();
        if (members == null) members = new ArrayList<>();

        if (node.getLiteral() != null) {
            List<StructPropertyNodePigLatin> properties = node.getLiteral().getProperties();
            if (properties == null) properties = new ArrayList<>();

            if (properties.size() != members.size()) {
                reportTypeError(structTypeName,
                        "El struct " + structTypeName + " espera " + members.size()
                                + " valores, pero se dieron " + properties.size(),
                        node);
            }

            int minCount = Math.min(properties.size(), members.size());
            for (int i = 0; i < minCount; i++) {
                StructPropertyNodePigLatin prop = properties.get(i);
                Symbol member = members.get(i);

                Type memberType = mapSymbolToType(member);
                Type valueType = prop.getValue().accept(this);

                if (!valueType.isAssignableTo(memberType)) {
                    reportTypeError(structTypeName,
                            "El valor en posicion " + i + " del struct " + structTypeName
                                    + " deberia ser " + memberType + ", pero es " + valueType,
                            prop);
                }
            }
        }

        return structType;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Type visit(VariableAssignmentNodePigLatin node) {
        Type targetType = node.getIdentifier() != null
                ? node.getIdentifier().accept(this)
                : Type.unknown();
        Type valueType = node.getExpressionNode() != null
                ? node.getExpressionNode().accept(this)
                : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reportTypeError(targetType + " = " + valueType,
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ShortlyOperationNodePigLatin node) {
        Type targetType = node.getTarget().accept(this);
        Type valueType = node.getValue().accept(this);

        if (targetType.isUnknown() || valueType.isUnknown()) {
            return Type.voidType();
        }

        String opLexeme = node.getOperator().getValue();

        switch (node.getOperator()) {
            case PLUS_ASSIGN:
                if (targetType.getKind() == TypeKind.STRING && valueType.getKind() == TypeKind.STRING) break;
                if (targetType.getKind() == TypeKind.STRING && isNumericOrPromotable(valueType)) break;
                if (isNumericOrPromotable(targetType) && isNumericOrPromotable(valueType)) break;
                reportTypeError(opLexeme,
                        "Operador '+=' incompatible entre " + targetType + " y " + valueType, node);
                break;
            case MINUS_ASSIGN:
            case MULTIPLY_ASSIGN:
            case DIVIDE_ASSIGN:
            case MODULO_ASSIGN:
                if (!isNumericOrPromotable(targetType) || !isNumericOrPromotable(valueType)) {
                    reportTypeError(opLexeme,
                            "Operador '" + opLexeme + "' incompatible entre " + targetType + " y " + valueType,
                            node);
                }
                break;
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reportTypeError(t.toString(), "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reportTypeError(t.toString(), "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reportTypeError(t.toString(), "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reportTypeError(t.toString(), "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ExpressionStatementNodePigLatin node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(PrintStatementNodePigLatin node) {
        if (node.getExpressionList() != null) {
            for (ExpressionNodePigLatin expr : node.getExpressionList()) {
                if (expr != null) expr.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ReadStatementNodePigLatin node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(ReturnStatementNodePigLatin node) {
        // In .pig, return only makes sense inside a function... but .pig has no functions.
        // It only has the main section. So return at top-level is meaningless.
        // We'll just visit the expression.
        if (node.getValue() != null) node.getValue().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(BreakStatementNodePigLatin node) {
        return Type.voidType();
    }

    @Override
    public Type visit(ContinueStatementNodePigLatin node) {
        return Type.voidType();
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Type visit(IfStatementNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(), "La condicion del 'if' debe ser booleana", node);
        }
        if (node.getThenBody() != null) {
            for (PigLatinAstNode s : node.getThenBody()) if (s != null) s.accept(this);
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodePigLatin e : node.getElseIfs()) if (e != null) e.accept(this);
        }
        if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(), "La condicion del 'else if' debe ser booleana", node);
        }
        if (node.getBody() != null) {
            for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
        }

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseBlockNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        if (node.getBody() != null) {
            for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
        }

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfListNodePigLatin node) {
        return Type.voidType();
    }

    @Override
    public Type visit(WhileStatementNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(), "La condicion del 'while' debe ser booleana", node);
        }
        if (node.getBody() != null) node.getBody().accept(this);

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(DoWhileStatementNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        if (node.getBody() != null) node.getBody().accept(this);
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(), "La condicion del 'do-while' debe ser booleana", node);
        }

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(ForStatementNodePigLatin node) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);

        if (node.getInit() != null) node.getInit().accept(this);
        if (node.getCondition() != null) {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reportTypeError(condType.toString(), "La condicion del 'for' debe ser booleana", node);
            }
        }
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        if (node.getBody() != null) node.getBody().accept(this);

        table.setCurrentScope(previous);
        return Type.voidType();
    }

    @Override
    public Type visit(ForInitDeclarationNodePigLatin node) {
        Type declaredType = mapTypeNode(node.getType());
        if (node.getExpr() != null) {
            Type initType = node.getExpr().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reportTypeError(node.getId(),
                        "No se puede asignar " + initType + " a " + declaredType, node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForInitAssignmentNodePigLatin node) {
        String name = node.getId();
        List<Symbol> found = table.resolveByName(name);
        Type targetType = found.isEmpty() ? Type.unknown() : mapSymbolToType(found.get(0));
        Type valueType = node.getExpr() != null ? node.getExpr().accept(this) : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reportTypeError(name,
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForUpdateNodePigLatin node) {
        Type targetType = node.getTarget() != null
                ? node.getTarget().accept(this)
                : Type.unknown();

        switch (node.getOperator()) {
            case INCREMENT:
            case DECREMENT:
            case PREFIX_INCREMENT:
            case PREFIX_DECREMENT:
                if (!targetType.isNumeric() && !targetType.isUnknown()) {
                    reportTypeError(targetType.toString(),
                            "El operador requiere un operando numerico", node);
                }
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    Type valueType = node.getValue().accept(this);
                    if (!valueType.isAssignableTo(targetType)) {
                        reportTypeError(targetType + " = " + valueType,
                                "No se puede asignar " + valueType + " a " + targetType, node);
                    }
                }
                break;
        }
        return Type.voidType();
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================

    @Override
    public Type visit(ExpressionNodePigLatin node) {
        return Type.unknown();
    }

    @Override
    public Type visit(LiteralExpressionNodePigLatin node) {
        Type type = mapPigDataType(node.getValueType(), null);
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(IdentifierExpressionNodePigLatin node) {
        String name = node.getIdentifier();
        List<Symbol> found = table.resolveByName(name);
        if (found.isEmpty()) return Type.unknown();

        Symbol symbol = found.get(0);
        Type type = mapSymbolToType(symbol);
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(BinaryExpressionNodePigLatin node) {
        Type left = node.getLeft().accept(this);
        Type right = node.getRight().accept(this);
        Type result = inferBinaryType(left, right, node.getOperator(), node);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(UnaryExpressionNodePigLatin node) {
        Type operandType = node.getExpressionNode().accept(this);
        UnaryOperator op = node.getOperator();

        Type result;
        switch (op) {
            case NEGATE:
                if (!operandType.isNumeric() && !operandType.isUnknown()) {
                    reportTypeError(op.getValue() + " " + operandType,
                            "El operador '-' requiere un operando numerico", node);
                    result = Type.unknown();
                } else {
                    result = operandType;
                }
                break;
            case NOT:
                if (operandType.getKind() != TypeKind.BOOLEAN && !operandType.isUnknown()) {
                    reportTypeError(op.getValue() + " " + operandType,
                            "El operador '!' requiere un operando booleano", node);
                    result = Type.unknown();
                } else {
                    result = Type.booleanType();
                }
                break;
            default:
                result = Type.unknown();
        }
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(FunctionCallExpressionNodePigLatin node) {
        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }

        String name = node.getFunctionName();

        // Case 1: with target - method call on an instance.
        if (node.getTarget() != null) {
            Type targetType = node.getTarget().accept(this);
            if (targetType.isUnknown() || !targetType.isCustom()) {
                return Type.unknown();
            }
            Symbol classSymbol = findTypeSymbolGlobal(targetType.getCustomName());
            if (classSymbol == null) return Type.unknown();

            List<Symbol> methods = new ArrayList<>();
            for (Symbol m : classSymbol.getMembers()) {
                if (m.getKind() == SymbolKind.METHOD && m.getName().equals(name)) {
                    methods.add(m);
                }
            }

            if (methods.isEmpty()) {
                reportTypeError(name,
                        "La clase " + classSymbol.getName() + " no tiene un metodo '" + name + "'",
                        node);
                return Type.unknown();
            }

            Symbol chosen = resolveOverload(methods, argTypes, name, node);
            if (chosen == null) return Type.unknown();

            Type returnType = resolveSymbolReturnType(chosen);
            annotate(node, returnType);
            return returnType;
        }

        // Case 2: direct call - function from an imported .y.
        List<Symbol> found = table.resolveByName(name);
        List<Symbol> functions = new ArrayList<>();
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.FUNCTION) {
                functions.add(s);
            }
        }

        if (functions.isEmpty()) {
            // Resolver already reported.
            return Type.unknown();
        }

        Symbol chosen = resolveOverload(functions, argTypes, name, node);
        if (chosen == null) return Type.unknown();

        Type returnType = resolveSymbolReturnType(chosen);
        annotate(node, returnType);
        return returnType;
    }

    @Override
    public Type visit(PropertyAccessExpressionNodePigLatin node) {
        if (node.getTarget() == null) return Type.unknown();

        Type targetType = node.getTarget().accept(this);
        if (targetType.isUnknown()) return Type.unknown();

        if (!targetType.isCustom()) {
            reportTypeError(node.getPropertyName(),
                    "El target de '" + node.getPropertyName() + "' no es una clase o struct", node);
            return Type.unknown();
        }

        Symbol member = findMemberInType(targetType, node.getPropertyName());
        if (member == null) {
            reportTypeError(node.getPropertyName(),
                    "El tipo " + targetType.getCustomName()
                            + " no tiene un atributo '" + node.getPropertyName() + "'", node);
            return Type.unknown();
        }

        if (member.getKind() != SymbolKind.ATTRIBUTE) {
            reportTypeError(node.getPropertyName(),
                    "'" + node.getPropertyName() + "' no es un atributo", node);
            return Type.unknown();
        }

        Type memberType = mapSymbolToType(member);
        annotate(node, memberType);
        return memberType;
    }

    @Override
    public Type visit(MemberArrayAccessExpressionNodePigLatin node) {
        Type targetType = node.getTarget().accept(this);

        if (!targetType.isArray()) {
            if (!targetType.isUnknown()) {
                reportTypeError("[]",
                        "El target del acceso por indice no es un arreglo", node);
            }
            return Type.unknown();
        }

        if (node.getIndex() != null) {
            Type indexType = node.getIndex().accept(this);
            if (!isIntLike(indexType) && !indexType.isUnknown()) {
                reportTypeError("[]", "El indice de un arreglo debe ser entero", node);
            }
        }

        Type elementType = targetType.getElementType();
        int dims = targetType.getDimensions() - 1;
        Type result = dims > 0 ? Type.arrayType(elementType, dims) : elementType;

        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayCallExpressionNodePigLatin node) {
        String arrayName = node.getArrayName();
        List<Symbol> found = table.resolveByName(arrayName);
        if (found.isEmpty()) return Type.unknown();

        Type arrayType = mapSymbolToType(found.get(0));
        if (!arrayType.isArray()) {
            reportTypeError(arrayName, "'" + arrayName + "' no es un arreglo", node);
            return Type.unknown();
        }

        if (node.getIndexExpression() != null) {
            Type indexType = node.getIndexExpression().accept(this);
            if (!isIntLike(indexType) && !indexType.isUnknown()) {
                reportTypeError(arrayName, "El indice de un arreglo debe ser entero", node);
            }
        }

        Type elementType = arrayType.getElementType();
        int dims = arrayType.getDimensions() - 1;
        Type result = dims > 0 ? Type.arrayType(elementType, dims) : elementType;

        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(InstanceCreationExpressionNodePigLatin node) {
        String className = node.getClassName();
        Symbol classSymbol = findTypeSymbolGlobal(className);

        if (classSymbol == null || classSymbol.getKind() != SymbolKind.CLASS) {
            reportTypeError(className,
                    "La clase '" + className + "' no existe", node);
            return Type.unknown();
        }

        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }

        // Special case: String's constructor is implicit; no need to look up.
        if ("String".equals(className)) {
            Type classType = Type.stringType();
            annotate(node, classType);
            return classType;
        }

        List<Symbol> constructors = new ArrayList<>();
        for (Symbol m : classSymbol.getMembers()) {
            if (m.getKind() == SymbolKind.CONSTRUCTOR) {
                constructors.add(m);
            }
        }

        Symbol chosen = resolveOverload(constructors, argTypes, className, node);
        if (chosen == null) return Type.unknown();

        Type classType = Type.customType(className);
        annotate(node, classType);
        return classType;
    }

    @Override
    public Type visit(ArrayInitExpressionNodePigLatin node) {
        if (node.getElements() == null || node.getElements().isEmpty()) {
            return Type.unknown();
        }

        Type firstType = node.getElements().get(0).accept(this);
        if (firstType.isUnknown()) {
            for (int i = 1; i < node.getElements().size(); i++) {
                node.getElements().get(i).accept(this);
            }
            return Type.unknown();
        }

        int extraDims = 1;
        Type baseType = firstType;
        if (firstType.isArray()) {
            extraDims = firstType.getDimensions() + 1;
            baseType = firstType.getElementType();
        }

        for (int i = 1; i < node.getElements().size(); i++) {
            Type elemType = node.getElements().get(i).accept(this);
            if (!elemType.isAssignableTo(firstType) && !elemType.isUnknown()) {
                reportTypeError(firstType.toString(),
                        "El elemento en posicion " + i + " tiene tipo " + elemType
                                + ", incompatible con el primer elemento " + firstType, node);
            }
        }

        Type result = Type.arrayType(baseType, extraDims);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(StructLiteralExpressionNodePigLatin node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodePigLatin prop : node.getProperties()) {
                if (prop != null) prop.accept(this);
            }
        }
        return Type.unknown();
    }

    @Override
    public Type visit(StructPropertyNodePigLatin node) {
        if (node.getValue() != null) {
            return node.getValue().accept(this);
        }
        return Type.unknown();
    }

    @Override
    public Type visit(ArgumentsNodePigLatin node) {
        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                if (arg != null) arg.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(TypeNodePigLatin node) {
        return Type.unknown();
    }

    // ============================================================
    // NO-OP
    // ============================================================

    @Override
    public Type visit(StructBodyNodePigLatin node) {
        return Type.voidType();
    }

    @Override
    public Type visit(StructDeclarationNodePigLatin node) {
        return Type.voidType();
    }

    @Override
    public Type visit(StructAttributeNodePigLatin node) {
        return Type.voidType();
    }

    @Override
    public Type visit(AccessorNodePigLatin node) {
        return Type.voidType();
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private Type mapSymbolToType(Symbol symbol) {
        if (symbol == null) return Type.unknown();
        String typeName = symbol.getType();
        if (typeName == null) return Type.unknown();

        Type base = resolveTypeName(typeName);
        if (base == null) return Type.unknown();

        int dims = symbol.getDimensions();
        if (dims > 0) return Type.arrayType(base, dims);
        return base;
    }

    private Type resolveTypeName(String typeName) {
        if (typeName == null) return Type.unknown();

        int dims = 0;
        String baseName = typeName;
        while (baseName.endsWith("[]")) {
            dims++;
            baseName = baseName.substring(0, baseName.length() - 2);
        }

        Type base = resolveBaseTypeName(baseName);
        if (dims > 0) return Type.arrayType(base, dims);
        return base;
    }

    private Type resolveBaseTypeName(String typeName) {
        if (typeName == null) return Type.unknown();
        return switch (typeName) {
            case "numerus" -> Type.intType();
            case "decimalis" -> Type.floatType();
            case "textum" -> Type.stringType();
            case "littera" -> Type.charType();

            case "entero" -> Type.intType();
            case "flotante" -> Type.floatType();
            case "cadena" -> Type.stringType();
            case "caracter" -> Type.charType();
            case "bool" -> Type.booleanType();

            case "int" -> Type.intType();
            case "double" -> Type.floatType();
            case "char" -> Type.charType();
            case "boolean" -> Type.booleanType();
            case "String" -> Type.stringType();

            case "void" -> Type.voidType();
            default -> Type.customType(typeName);
        };
    }

    private Type mapPigDataType(DataType dt, String customName) {
        if (dt == null) return Type.unknown();
        return switch (dt) {
            case INT -> Type.intType();
            case DECIMAL -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case CUSTOM -> "String".equals(customName)
                    ? Type.stringType()
                    : Type.customType(customName);
            default -> Type.unknown();
        };
    }

    private Type mapTypeNode(TypeNodePigLatin typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapPigDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    private Type inferBinaryType(Type left, Type right, BinaryOperator op, BinaryExpressionNodePigLatin node) {
        if (left.isUnknown() || right.isUnknown()) return Type.unknown();

        String opLexeme = op.getValue();

        switch (op) {
            case PLUS:
                if (left.getKind() == TypeKind.STRING && right.getKind() == TypeKind.STRING) return Type.stringType();
                if (left.getKind() == TypeKind.STRING && isNumericOrPromotable(right)) return Type.stringType();
                if (isNumericOrPromotable(left) && right.getKind() == TypeKind.STRING) return Type.stringType();
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) return promoteNumeric(left, right);
                reportTypeError(opLexeme,
                        "Operador '+' incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case MINUS:
            case MULTIPLICATION:
            case DIVIDE:
            case MODULE:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) return promoteNumeric(left, right);
                reportTypeError(opLexeme,
                        "Operador aritmetico incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case LESS:
            case GREATER:
            case LESS_EQUALS:
            case GREATER_EQUALS:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) return Type.booleanType();
                reportTypeError(opLexeme,
                        "Operador relacional incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case EQUALS:
            case DIFFERENT:
                if (left.getKind() == TypeKind.NULL && (right.isCustom() || right.isArray() || right.getKind() == TypeKind.STRING))
                    return Type.booleanType();
                if (right.getKind() == TypeKind.NULL && (left.isCustom() || left.isArray() || left.getKind() == TypeKind.STRING))
                    return Type.booleanType();
                if (left.getKind() == TypeKind.NULL && right.getKind() == TypeKind.NULL) return Type.booleanType();
                if (left.isCompatibleWith(right) || (isNumericOrPromotable(left) && isNumericOrPromotable(right)))
                    return Type.booleanType();
                reportTypeError(opLexeme,
                        "Operador de igualdad incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case AND:
            case OR:
                if (left.getKind() == TypeKind.BOOLEAN && right.getKind() == TypeKind.BOOLEAN)
                    return Type.booleanType();
                reportTypeError(opLexeme,
                        "Operador logico incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            default:
                return Type.unknown();
        }
    }

    private boolean isNumericOrPromotable(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT || k == TypeKind.FLOAT || k == TypeKind.CHAR || k == TypeKind.BOOLEAN;
    }

    private boolean isIntLike(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT || k == TypeKind.CHAR || k == TypeKind.BOOLEAN;
    }

    private Type promoteNumeric(Type a, Type b) {
        if (a.getKind() == TypeKind.FLOAT || b.getKind() == TypeKind.FLOAT) return Type.floatType();
        return Type.intType();
    }

    private boolean isCallCompatible(Symbol function, List<Type> argTypes) {
        List<String> paramTypes = function.getParameterTypes();
        if (paramTypes.size() != argTypes.size()) return false;

        for (int i = 0; i < paramTypes.size(); i++) {
            Type paramType = resolveTypeName(paramTypes.get(i));
            Type argType = argTypes.get(i);
            if (argType.isUnknown()) continue;
            if (!argType.isAssignableTo(paramType)) return false;
        }
        return true;
    }

    private Symbol resolveOverload(List<Symbol> candidates, List<Type> argTypes,
                                   String name, PigLatinAstNode node) {
        List<Symbol> arityMatches = new ArrayList<>();
        for (Symbol s : candidates) {
            if (s.getParameterTypes().size() == argTypes.size()) arityMatches.add(s);
        }

        if (arityMatches.isEmpty()) {
            reportTypeError(name,
                    "No existe una version de '" + name + "' con " + argTypes.size()
                            + " argumento(s)", node);
            return null;
        }

        List<Symbol> compatible = new ArrayList<>();
        for (Symbol s : arityMatches) {
            if (isCallCompatible(s, argTypes)) compatible.add(s);
        }

        if (compatible.size() == 1) return compatible.get(0);
        if (compatible.size() > 1) {
            reportTypeError(name, "Llamada ambigua a '" + name + "'", node);
            return null;
        }

        reportTypeError(name,
                "No existe una version de '" + name + "' compatible con los argumentos", node);
        return null;
    }

    private Type resolveSymbolReturnType(Symbol fn) {
        String rt = fn.getReturnType();
        if (rt == null || "void".equals(rt)) return Type.voidType();
        return resolveTypeName(rt);
    }

    private Symbol findTypeSymbolGlobal(String typeName) {
        if (typeName == null) return null;

        // 1. Current file
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), typeName);
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.CLASS
                    || s.getKind() == SymbolKind.STRUCT) {
                return s;
            }
        }

        // 2. All file scopes
        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol symbol : bucket) {
                    if ((symbol.getKind() == SymbolKind.CLASS
                            || symbol.getKind() == SymbolKind.STRUCT)
                            && symbol.getName().equals(typeName)) {
                        return symbol;
                    }
                }
            }
        }

        // 3. Global scope (for built-in classes like String)
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

    private Symbol findMemberInType(Type customType, String memberName) {
        if (customType == null || !customType.isCustom()) return null;
        if (memberName == null) return null;

        Symbol typeSymbol = findTypeSymbolGlobal(customType.getCustomName());
        if (typeSymbol == null) return null;

        List<Symbol> members = typeSymbol.getMembers();
        if (members == null) return null;

        for (Symbol m : members) {
            if (m.getName().equals(memberName)) return m;
        }
        return null;
    }

    private void reportTypeError(String lexeme, String description, PigLatinAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(lexeme);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription(description);
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }
}