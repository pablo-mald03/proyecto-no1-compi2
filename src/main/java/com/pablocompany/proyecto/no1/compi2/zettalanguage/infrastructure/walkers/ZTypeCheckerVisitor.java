package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.ZDataType;
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
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class ZTypeCheckerVisitor implements ZAstVisitor<Type> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;

    private Type currentSwitchSelectorType;
    private Type currentReturnType;

    public ZTypeCheckerVisitor(GlobalSymbolTable table,
                               EditorContext context,
                               Map<AstNode, Type> typeAnnotations) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
    }

    private void annotate(AstNode node, Type type) {
        typeAnnotations.put(node, type);
    }

    private SymbolScope lookupRegisteredScope(ZAstNode node) {
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
    public Type visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) {
            node.getClassNode().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ClassDeclarationNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member != null) {
                    member.accept(this);
                }
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    // ============================================================
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Type visit(MethodDeclarationNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type previousReturn = currentReturnType;
        currentReturnType = node.getType() != null
                ? mapTypeNode(node.getType())
                : Type.voidType();

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) param.accept(this);
            }
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        currentReturnType = previousReturn;
        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ConstructorDeclarationNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type previousReturn = currentReturnType;
        currentReturnType = null;

        if (node.getParams() != null) {
            for (ParameterNodeZ param : node.getParams()) {
                if (param != null) param.accept(this);
            }
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        currentReturnType = previousReturn;
        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ParameterNodeZ node) {
        // Parameters are already declared in the table.
        return Type.unknown();
    }

    // ============================================================
    // CODE BODY
    // ============================================================

    @Override
    public Type visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode statement : node.getStatements()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Type visit(VariableDeclarationNodeZ node) {
        Type declaredType = mapTypeNode(node.getDataType());

        // If dimensions > 0, it's an array.
        if (node.getDimensions() > 0) {
            declaredType = Type.arrayType(declaredType, node.getDimensions());
        }

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
    public Type visit(ArrayDeclarationNodeZ node) {
        Type elementType = mapTypeNode(node.getDataType());
        Type arrayType = Type.arrayType(elementType, node.getDimensions().size());

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
    public Type visit(ForInitDeclarationNodeZ node) {
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
    public Type visit(ForInitAssignmentNodeZ node) {
        Type targetType = node.getId() != null
                ? node.getId().accept(this)
                : Type.unknown();
        Type valueType = node.getExpr() != null
                ? node.getExpr().accept(this)
                : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reportTypeError(targetType + " = " + valueType,
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForUpdateNodeZ node) {
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
    // STATEMENTS
    // ============================================================

    @Override
    public Type visit(VariableAssignmentNodeZ node) {
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
    public Type visit(ShortlyOperationNodeZ node) {
        Type targetType = node.getTarget().accept(this);
        Type valueType = node.getValue().accept(this);

        if (targetType.isUnknown() || valueType.isUnknown()) {
            return Type.voidType();
        }

        String opLexeme = node.getOperator().getValue();

        switch (node.getOperator()) {
            case PLUS_ASSIGN:
                if (targetType.getKind() == TypeKind.STRING && valueType.getKind() == TypeKind.STRING) {
                    break;
                }
                if (!isNumericOrPromotable(targetType) || !isNumericOrPromotable(valueType)) {
                    reportTypeError(opLexeme,
                            "Operador '+=' incompatible entre " + targetType + " y " + valueType, node);
                }
                break;
            case MINUS_ASSIGN:
            case MULTIPLY_ASSIGN:
            case DIVIDE_ASSIGN:
            case MODULO_ASSIGN:
                if (!isNumericOrPromotable(targetType) || !isNumericOrPromotable(valueType)) {
                    reportTypeError(opLexeme,
                            "Operador '" + opLexeme + "' incompatible entre " + targetType + " y " + valueType, node);
                }
                break;
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.toString(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.toString(),
                        "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.toString(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.toString(),
                        "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ExpressionStatementNodeZ node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(PrintStatementNodeZ node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(ReadStatementNodeZ node) {
        return Type.unknown();
    }

    @Override
    public Type visit(ReturnStatementNodeZ node) {
        if (currentReturnType == null) {
            reportTypeError("return",
                    "Un constructor no puede tener una instruccion 'return'", node);
            if (node.getValue() != null) node.getValue().accept(this);
            return Type.voidType();
        }

        Type valueType = node.getValue() != null
                ? node.getValue().accept(this)
                : Type.voidType();

        if (!valueType.isAssignableTo(currentReturnType)) {
            reportTypeError(valueType.toString(),
                    "El tipo de retorno " + valueType
                            + " no coincide con el tipo declarado " + currentReturnType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(BreakStatementNodeZ node) {
        return Type.voidType();
    }

    @Override
    public Type visit(ContinueStatementNodeZ node) {
        return Type.voidType();
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Type visit(IfStatementNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(),
                    "La condicion del 'if' debe ser booleana", node);
        }
        if (node.getThenBody() != null) {
            for (ZAstNode statement : node.getThenBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodeZ elseIf : node.getElseIfs()) {
                if (elseIf != null) elseIf.accept(this);
            }
        }
        if (node.getElseBlockNode() != null) {
            node.getElseBlockNode().accept(this);
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(),
                    "La condicion del 'else if' debe ser booleana", node);
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseBlockNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfListNodeZ node) {
        return Type.unknown();
    }

    @Override
    public Type visit(WhileStatementNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(),
                    "La condicion del 'while' debe ser booleana", node);
        }
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(DoWhileStatementNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(),
                    "La condicion del 'do-while' debe ser booleana", node);
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(ForStatementNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getInit() != null) node.getInit().accept(this);
        if (node.getCondition() != null) {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reportTypeError(condType.toString(),
                        "La condicion del 'for' debe ser booleana", node);
            }
        }
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchStatementNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        Type selectorType = node.getSelector().accept(this);
        TypeKind k = selectorType.getKind();

        if (k != TypeKind.INT
                && k != TypeKind.CHAR
                && k != TypeKind.STRING
                && !selectorType.isUnknown()) {
            reportTypeError("switch",
                    "El selector del 'switch' debe ser entero, caracter o cadena, pero es " + selectorType,
                    node);
        }

        Type previousSelector = currentSwitchSelectorType;
        currentSwitchSelectorType = selectorType;

        if (node.getCases() != null) {
            for (SwitchCaseNodeZ caseNode : node.getCases()) {
                if (caseNode != null) caseNode.accept(this);
            }
        }
        if (node.getDefaultCase() != null) {
            node.getDefaultCase().accept(this);
        }

        currentSwitchSelectorType = previousSelector;
        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchCaseNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getValue() != null) {
            Type caseValueType = node.getValue().accept(this);
            if (currentSwitchSelectorType != null
                    && !currentSwitchSelectorType.isUnknown()
                    && !caseValueType.isUnknown()) {
                if (!caseValueType.isAssignableTo(currentSwitchSelectorType)) {
                    reportTypeError("case",
                            "El valor del 'case' tiene tipo " + caseValueType
                                    + ", incompatible con el selector " + currentSwitchSelectorType,
                            node);
                }
            }
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    @Override
    public Type visit(DefaultCaseNodeZ node) {
        SymbolScope previousScope = table.getCurrentScope();
        SymbolScope scope = lookupRegisteredScope(node);
        if (scope != null) {
            table.setCurrentScope(scope);
        }

        if (node.getBody() != null) {
            for (ZAstNode statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }

        table.setCurrentScope(previousScope);
        return Type.voidType();
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================

    @Override
    public Type visit(ExpressionNodeZ node) {
        return Type.unknown();
    }

    @Override
    public Type visit(LiteralExpressionNodeZ node) {
        System.out.println("LITERAL: dt=" + node.getValueType());
        Type type = mapZDataType(node.getValueType(), null);
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(IdentifierExpressionNodeZ node) {
        System.out.println("IDENTIFIER: " + node.getIdentifier());
        String name = node.getIdentifier();
        List<Symbol> found = table.resolveByName(name);
        if (found.isEmpty()) {
            return Type.unknown();
        }

        Symbol symbol = found.get(0);
        Type type = mapSymbolToType(symbol);
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(BinaryExpressionNodeZ node) {
        Type left = node.getLeft().accept(this);
        Type right = node.getRight().accept(this);
        Type result = inferBinaryType(left, right, node.getOperator(), node);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(UnaryExpressionNodeZ node) {
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
    public Type visit(TernaryExpressionNodeZ node) {
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.toString(),
                    "La condicion del operador ternario debe ser booleana", node);
        }

        Type thenType = node.getThenExpr().accept(this);
        Type elseType = node.getElseExpr().accept(this);

        Type result;
        if (thenType.isAssignableTo(elseType)) {
            result = elseType;
        } else if (elseType.isAssignableTo(thenType)) {
            result = thenType;
        } else if (isNumericOrPromotable(thenType) && isNumericOrPromotable(elseType)) {
            result = promoteNumeric(thenType, elseType);
        } else {
            reportTypeError(thenType + " : " + elseType,
                    "Las ramas del operador ternario tienen tipos incompatibles", node);
            result = Type.unknown();
        }

        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(FunctionCallExpressionNodeZ node) {
        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }

        String methodName = node.getFunctionName();

        Symbol classSymbol;
        if (node.getTarget() != null) {
            Type targetType = node.getTarget().accept(this);
            if (targetType.isUnknown() || !targetType.isCustom()) {
                return Type.unknown();
            }
            classSymbol = findTypeSymbolGlobal(targetType.getCustomName());
        } else {
            classSymbol = getCurrentClassSymbol();
        }

        if (classSymbol == null) return Type.unknown();

        List<Symbol> methods = new ArrayList<>();
        for (Symbol member : classSymbol.getMembers()) {
            if (member.getKind() == SymbolKind.METHOD
                    && member.getName().equals(methodName)) {
                methods.add(member);
            }
        }

        if (methods.isEmpty()) {
            reportTypeError(methodName,
                    "La clase " + classSymbol.getName() + " no tiene un metodo '" + methodName + "'",
                    node);
            return Type.unknown();
        }

        Symbol chosen = resolveOverload(methods, argTypes, methodName, node);
        if (chosen == null) return Type.unknown();

        Type returnType = resolveSymbolReturnType(chosen);
        annotate(node, returnType);
        return returnType;
    }

    @Override
    public Type visit(PropertyAccessExpressionNodeZ node) {
        if (node.getTarget() == null) return Type.unknown();

        Type targetType = node.getTarget().accept(this);
        if (targetType.isUnknown()) return Type.unknown();

        if (!targetType.isCustom()) {
            reportTypeError(node.getPropertyName(),
                    "El target de '" + node.getPropertyName() + "' no es una clase", node);
            return Type.unknown();
        }

        Symbol member = findMemberInClass(targetType, node.getPropertyName());
        if (member == null) {
            reportTypeError(node.getPropertyName(),
                    "La clase " + targetType.getCustomName()
                            + " no tiene un miembro '" + node.getPropertyName() + "'", node);
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
    public Type visit(MemberArrayAccessExpressionNodeZ node) {
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
                reportTypeError("[]",
                        "El indice de un arreglo debe ser entero", node);
            }
        }

        Type elementType = targetType.getElementType();
        int dims = targetType.getDimensions() - 1;
        Type result = dims > 0
                ? Type.arrayType(elementType, dims)
                : elementType;

        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ObjectInstantiationNodeZ node) {
        TypeNodeZ typeNode = node.getType();
        if (typeNode == null) return Type.unknown();

        String className = typeNode.getCustomTypeName();
        if (className == null) return Type.unknown();

        Symbol classSymbol = findTypeSymbolGlobal(className);
        if (classSymbol == null || classSymbol.getKind() != SymbolKind.CLASS) {
            reportTypeError(className,
                    "La clase '" + className + "' no existe", node);
            return Type.unknown();
        }

        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }

        List<Symbol> constructors = new ArrayList<>();
        for (Symbol member : classSymbol.getMembers()) {
            if (member.getKind() == SymbolKind.CONSTRUCTOR) {
                constructors.add(member);
            }
        }

        Symbol chosen = resolveOverload(constructors, argTypes, className, node);
        if (chosen == null) return Type.unknown();

        Type classType = Type.customType(className);
        annotate(node, classType);
        return classType;
    }

    @Override
    public Type visit(ArrayInstantiationNodeZ node) {
        Type elementType = mapTypeNode(node.getType());
        Type arrayType = Type.arrayType(elementType, node.getDimensions().size());

        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dimExpr : node.getDimensions()) {
                if (dimExpr != null) {
                    Type dimType = dimExpr.accept(this);
                    if (!isIntLike(dimType) && !dimType.isUnknown()) {
                        reportTypeError(node.getType().getCustomTypeName(),
                                "Las dimensiones del arreglo deben ser enteras", node);
                    }
                }
            }
        }

        annotate(node, arrayType);
        return arrayType;
    }

    @Override
    public Type visit(ArrayInitExpressionNodeZ node) {
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

        for (int i = 1; i < node.getElements().size(); i++) {
            Type elemType = node.getElements().get(i).accept(this);
            if (!elemType.isAssignableTo(firstType) && !elemType.isUnknown()) {
                reportTypeError(firstType.toString(),
                        "El elemento en posicion " + i + " tiene tipo " + elemType
                                + ", incompatible con el primer elemento " + firstType, node);
            }
        }

        Type result = Type.arrayType(firstType, 1);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayValuesNodeZ node) {
        if (node.getValues() != null) {
            for (ExpressionNodeZ value : node.getValues()) {
                if (value != null) value.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ArgumentsNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                if (arg != null) arg.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(TypeNodeZ node) {
        return Type.unknown();
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
        if (dims > 0) {
            return Type.arrayType(base, dims);
        }
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
        if (dims > 0) {
            return Type.arrayType(base, dims);
        }
        return base;
    }

    private Type resolveBaseTypeName(String typeName) {
        if (typeName == null) return Type.unknown();
        return switch (typeName) {
            case "int" -> Type.intType();
            case "double" -> Type.floatType();
            case "char" -> Type.charType();
            case "boolean" -> Type.booleanType();
            case "void" -> Type.voidType();
            case "String" -> Type.stringType();
            case "null" -> Type.nullType();
            default -> Type.customType(typeName);
        };
    }

    private Type mapZDataType(ZDataType dt, String customName) {
        if (dt == null) return Type.unknown();
        return switch (dt) {
            case INT -> Type.intType();
            case DOUBLE -> Type.floatType();
            case STRING -> Type.stringType();
            case CHAR -> Type.charType();
            case BOOLEAN -> Type.booleanType();
            case VOID -> Type.voidType();
            case NULL -> Type.nullType();
            case CLASS -> "String".equals(customName)
                    ? Type.stringType()
                    : Type.customType(customName);
        };
    }

    private Type mapTypeNode(TypeNodeZ typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapZDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    private Type inferBinaryType(Type left, Type right, BinaryOperator op, BinaryExpressionNodeZ node) {
        if (left.isUnknown() || right.isUnknown()) {
            return Type.unknown();
        }

        String opLexeme = op.getValue();

        switch (op) {
            case PLUS:
                if (left.getKind() == TypeKind.STRING && right.getKind() == TypeKind.STRING) {
                    return Type.stringType();
                }
                if (left.getKind() == TypeKind.STRING && isNumericOrPromotable(right)) {
                    return Type.stringType();
                }
                if (isNumericOrPromotable(left) && right.getKind() == TypeKind.STRING) {
                    return Type.stringType();
                }
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return promoteNumeric(left, right);
                }
                reportTypeError(opLexeme,
                        "Operador '+' incompatible entre " + left + " y " + right, node);
                return Type.unknown();
            case MINUS:
            case MULTIPLICATION:
            case DIVIDE:
            case MODULE:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return promoteNumeric(left, right);
                }
                reportTypeError(opLexeme,
                        "Operador aritmetico incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case LESS:
            case GREATER:
            case LESS_EQUALS:
            case GREATER_EQUALS:
                if (isNumericOrPromotable(left) && isNumericOrPromotable(right)) {
                    return Type.booleanType();
                }
                reportTypeError(opLexeme,
                        "Operador relacional incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case EQUALS:
            case DIFFERENT:
                if (left.getKind() == TypeKind.NULL && (right.isCustom() || right.isArray() || right.getKind() == TypeKind.STRING)) {
                    return Type.booleanType();
                }
                if (right.getKind() == TypeKind.NULL && (left.isCustom() || left.isArray() || left.getKind() == TypeKind.STRING)) {
                    return Type.booleanType();
                }
                if (left.getKind() == TypeKind.NULL && right.getKind() == TypeKind.NULL) {
                    return Type.booleanType();
                }
                if (left.isCompatibleWith(right)
                        || (isNumericOrPromotable(left) && isNumericOrPromotable(right))) {
                    return Type.booleanType();
                }
                reportTypeError(opLexeme,
                        "Operador de igualdad incompatible entre " + left + " y " + right, node);
                return Type.unknown();

            case AND:
            case OR:
                if (left.getKind() == TypeKind.BOOLEAN && right.getKind() == TypeKind.BOOLEAN) {
                    return Type.booleanType();
                }
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
        if (a.getKind() == TypeKind.FLOAT || b.getKind() == TypeKind.FLOAT) {
            return Type.floatType();
        }
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
                                   String name, ZAstNode node) {
        List<Symbol> arityMatches = new ArrayList<>();
        for (Symbol s : candidates) {
            if (s.getParameterTypes().size() == argTypes.size()) {
                arityMatches.add(s);
            }
        }

        if (arityMatches.isEmpty()) {
            reportTypeError(name,
                    "No existe una version de '" + name + "' con " + argTypes.size()
                            + " argumento(s)", node);
            return null;
        }

        List<Symbol> compatible = new ArrayList<>();
        for (Symbol s : arityMatches) {
            if (isCallCompatible(s, argTypes)) {
                compatible.add(s);
            }
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

    private Type resolveSymbolReturnType(Symbol method) {
        String rt = method.getReturnType();
        if (rt == null || "void".equals(rt)) return Type.voidType();
        return resolveTypeName(rt);
    }

    private Symbol findTypeSymbolGlobal(String typeName) {
        if (typeName == null) return null;

        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), typeName);
        for (Symbol s : found) {
            if (s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT) {
                return s;
            }
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

    private Symbol findMemberInClass(Type classType, String memberName) {
        if (classType == null || !classType.isCustom()) return null;
        if (memberName == null) return null;

        Symbol classSymbol = findTypeSymbolGlobal(classType.getCustomName());
        if (classSymbol == null) return null;

        List<Symbol> members = classSymbol.getMembers();
        if (members == null) return null;

        for (Symbol member : members) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        return null;
    }

    private Symbol getCurrentClassSymbol() {
        SymbolScope fileScope = table.getFileScope(context.getFilePath());
        if (fileScope == null) return null;
        for (List<Symbol> bucket : fileScope.getSymbols().values()) {
            for (Symbol s : bucket) {
                if (s.getKind() == SymbolKind.CLASS) {
                    return s;
                }
            }
        }
        return null;
    }

    private void reportTypeError(String lexeme, String description, ZAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(lexeme);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        String descriptionNew = description.replace("float", "double");
        error.setDescription(descriptionNew);
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }
}