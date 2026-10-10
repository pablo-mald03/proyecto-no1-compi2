package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.MemberLookupResult;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Principal type checker visitor class
 *
 */
@Getter
public class ZTypeCheckerVisitor implements ZAstVisitor<Type> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;

    private final ZSemanticErrorReporter reporter;
    private final ZTypeMapperService mapper;
    private final ZSymbolLookupService lookup;
    private final ZTypeCompatibilityService compat;
    private final ZCallResolutionService calls;
    private final ZScopeService scopes;
    private final ZOverrideService overrides;
    private final ZAccessControlService access;

    private Type currentSwitchSelectorType;
    private Type currentReturnType;
    private Symbol currentClass;

    public ZTypeCheckerVisitor(GlobalSymbolTable table,
                               EditorContext context,
                               Map<AstNode, Type> typeAnnotations) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;

        this.reporter = new ZSemanticErrorReporter(context);
        this.mapper = new ZTypeMapperService();
        this.access = new ZAccessControlService(context);
        this.lookup = new ZSymbolLookupService(table, context, access);
        this.compat = new ZTypeCompatibilityService(mapper);
        this.calls = new ZCallResolutionService(compat, reporter);
        this.scopes = new ZScopeService(table, context);
        this.overrides = new ZOverrideService(reporter);
    }

    private void annotate(AstNode node, Type type) {
        typeAnnotations.put(node, type);
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
        Symbol previousClass = currentClass;
        currentClass = lookup.findType(node.getClassName());
        Symbol parent = null;
        String parentName = node.getParentName();

        if (parentName != null && !parentName.isBlank()) {
            parent = lookup.findType(parentName);
            if (parent == null || parent.getKind() != SymbolKind.CLASS) {
                reporter.reportTypeError(parentName,
                        "La superclase '" + parentName + "' no esta declarada", node);
            }
        }

        scopes.withScope(node, () -> {
            if (node.getMembers() != null) {
                for (ZAstNode m : node.getMembers()) if (m != null) m.accept(this);
            }
        });

        currentClass = previousClass;
        return Type.voidType();
    }

    // ============================================================
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Type visit(MethodDeclarationNodeZ node) {
        Symbol parent = currentClass != null && currentClass.getParentName() != null
                ? lookup.findType(currentClass.getParentName())
                : null;
        overrides.validate(node, parent, currentClass);

        scopes.withScope(node, () -> {
            Type previousReturn = currentReturnType;
            currentReturnType = node.getType() != null
                    ? mapper.mapTypeNode(node.getType())
                    : Type.voidType();
            if (node.getReturnDimensions() > 0) {
                currentReturnType = Type.arrayType(currentReturnType, node.getReturnDimensions());
            }

            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }

            currentReturnType = previousReturn;
        });

        Type returnType = node.getType() != null
                ? mapper.mapTypeNode(node.getType())
                : Type.voidType();
        if (node.getReturnDimensions() > 0) {
            returnType = Type.arrayType(returnType, node.getReturnDimensions());
        }
        annotate(node, returnType);
        return returnType;
    }

    @Override
    public Type visit(ConstructorDeclarationNodeZ node) {
        scopes.withScope(node, () -> {
            Type previousReturn = currentReturnType;
            currentReturnType = null;
            if (node.getParams() != null) {
                for (ParameterNodeZ p : node.getParams()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
            currentReturnType = previousReturn;
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ParameterNodeZ node) {
        return Type.unknown();
    }

    // ============================================================
    // CODE BODY
    // ============================================================

    @Override
    public Type visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode s : node.getStatements()) if (s != null) s.accept(this);
        }
        return Type.voidType();
    }

    // ============================================================
    // DECLARATIONS
    // ============================================================

    @Override
    public Type visit(VariableDeclarationNodeZ node) {
        Type declaredType = mapper.mapTypeNode(node.getDataType());
        if (node.getDimensions() > 0) {
            declaredType = Type.arrayType(declaredType, node.getDimensions());
        }
        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reporter.reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a variable de tipo " + declaredType,
                        node);
            }
        }
        annotate(node, declaredType);
        return declaredType;
    }

    @Override
    public Type visit(FieldDeclarationNodeZ node) {
        Type declaredType = mapper.mapTypeNode(node.getType());
        if (node.getDimensions() > 0) {
            declaredType = Type.arrayType(declaredType, node.getDimensions());
        }
        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reporter.reportTypeError(node.getName(),
                        "No se puede asignar " + initType + " a atributo de tipo " + declaredType,
                        node);
            }
        }
        annotate(node, declaredType);
        return declaredType;
    }

    @Override
    public Type visit(ThisExpressionNodeZ node) {
        if (currentClass == null) {
            reporter.reportTypeError("this",
                    "'this' solo puede usarse dentro de una clase", node);
            return Type.unknown();
        }

        node.setEnclosingClass(currentClass.getName());
        Type t = Type.customType(currentClass.getName());
        annotate(node, t);
        return t;
    }

    @Override
    public Type visit(ArrayDeclarationNodeZ node) {
        Type elementType = mapper.mapTypeNode(node.getDataType());
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 1;
        Type arrayType = Type.arrayType(elementType, dims);

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(arrayType)) {
                reporter.reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a arreglo de tipo " + arrayType,
                        node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForInitDeclarationNodeZ node) {
        Type declaredType = mapper.mapTypeNode(node.getType());
        if (node.getExpr() != null) {
            Type initType = node.getExpr().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reporter.reportTypeError(node.getId(),
                        "No se puede asignar " + initType + " a " + declaredType, node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForInitAssignmentNodeZ node) {
        Type targetType = node.getId() != null ? node.getId().accept(this) : Type.unknown();
        Type valueType = node.getExpr() != null ? node.getExpr().accept(this) : Type.unknown();
        if (!valueType.isAssignableTo(targetType)) {
            reporter.reportTypeError(targetType + " = " + valueType,
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForUpdateNodeZ node) {
        Type targetType = node.getTarget() != null ? node.getTarget().accept(this) : Type.unknown();
        switch (node.getOperator()) {
            case INCREMENT:
            case DECREMENT:
            case PREFIX_INCREMENT:
            case PREFIX_DECREMENT:
                if (!targetType.isNumeric() && !targetType.isUnknown()) {
                    reporter.reportTypeError(targetType.toString(),
                            "El operador requiere un operando numerico", node);
                }
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    Type valueType = node.getValue().accept(this);
                    if (!valueType.isAssignableTo(targetType)) {
                        reporter.reportTypeError(targetType + " = " + valueType,
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
                ? node.getIdentifier().accept(this) : Type.unknown();
        Type valueType = node.getExpressionNode() != null
                ? node.getExpressionNode().accept(this) : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reporter.reportTypeError(targetType + " = " + valueType,
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ShortlyOperationNodeZ node) {
        Type targetType = node.getTarget().accept(this);
        Type valueType = node.getValue().accept(this);

        if (targetType.isUnknown() || valueType.isUnknown()) return Type.voidType();

        String opLexeme = node.getOperator().getValue();
        switch (node.getOperator()) {
            case PLUS_ASSIGN:
                if (targetType.getKind() == TypeKind.STRING && valueType.getKind() == TypeKind.STRING) break;
                if (!compat.isNumericOrPromotable(targetType) || !compat.isNumericOrPromotable(valueType)) {
                    reporter.reportTypeError(opLexeme,
                            "Operador '+=' incompatible entre " + targetType + " y " + valueType, node);
                }
                break;
            case MINUS_ASSIGN:
            case MULTIPLY_ASSIGN:
            case DIVIDE_ASSIGN:
            case MODULO_ASSIGN:
                if (!compat.isNumericOrPromotable(targetType) || !compat.isNumericOrPromotable(valueType)) {
                    reporter.reportTypeError(opLexeme,
                            "Operador '" + opLexeme + "' incompatible entre "
                                    + targetType + " y " + valueType, node);
                }
                break;
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.toString(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.toString(),
                        "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.toString(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementPrevStatementNodeZ node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.toString(),
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

    /**
     * Return statement. Handles three cases:
     * - Inside a constructor (currentReturnType == null): 'return' with a value is an error.
     * - Inside a void method: 'return;' is fine; 'return expr;' is an error.
     * - Inside a typed method: the value must be assignable to the return type.
     * <p>
     * The original bug ("void is not assignable to void") came from treating
     * the void case via isAssignableTo. We handle it explicitly here.
     */
    @Override
    public Type visit(ReturnStatementNodeZ node) {
        // Case 1: constructor
        if (currentReturnType == null) {
            reporter.reportTypeError("return",
                    "Un constructor no puede tener una instruccion 'return'", node);
            if (node.getValue() != null) node.getValue().accept(this);
            return Type.voidType();
        }

        // Case 2: void method
        if (currentReturnType.getKind() == TypeKind.VOID) {
            if (node.getValue() != null) {
                Type valueType = node.getValue().accept(this);
                reporter.reportTypeError(valueType.toString(),
                        "Un metodo void no puede retornar un valor de tipo " + valueType, node);
            }
            return Type.voidType();
        }

        // Case 3: typed method
        Type valueType = node.getValue() != null
                ? node.getValue().accept(this)
                : Type.voidType();

        if (!valueType.isAssignableTo(currentReturnType)) {
            reporter.reportTypeError(valueType.toString(),
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
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.toString(),
                        "La condicion del 'if' debe ser booleana", node);
            }
            if (node.getThenBody() != null) {
                for (ZAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeZ e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfNodeZ node) {
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.toString(),
                        "La condicion del 'else if' debe ser booleana", node);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseBlockNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfListNodeZ node) {
        return Type.unknown();
    }

    @Override
    public Type visit(WhileStatementNodeZ node) {
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.toString(),
                        "La condicion del 'while' debe ser booleana", node);
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(DoWhileStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.toString(),
                        "La condicion del 'do-while' debe ser booleana", node);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ForStatementNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) {
                Type condType = node.getCondition().accept(this);
                if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                    reporter.reportTypeError(condType.toString(),
                            "La condicion del 'for' debe ser booleana", node);
                }
            }
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchStatementNodeZ node) {
        scopes.withScope(node, () -> {
            Type selectorType = node.getSelector().accept(this);
            TypeKind k = selectorType.getKind();
            if (k != TypeKind.INT && k != TypeKind.CHAR
                    && k != TypeKind.STRING && !selectorType.isUnknown()) {
                reporter.reportTypeError("switch",
                        "El selector del 'switch' debe ser entero, caracter o cadena, pero es "
                                + selectorType, node);
            }
            Type previousSelector = currentSwitchSelectorType;
            currentSwitchSelectorType = selectorType;

            if (node.getCases() != null) {
                for (SwitchCaseNodeZ c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);

            currentSwitchSelectorType = previousSelector;
        });
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchCaseNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getValue() != null) {
                Type caseValueType = node.getValue().accept(this);
                if (currentSwitchSelectorType != null
                        && !currentSwitchSelectorType.isUnknown()
                        && !caseValueType.isUnknown()
                        && !caseValueType.isAssignableTo(currentSwitchSelectorType)) {
                    reporter.reportTypeError("case",
                            "El valor del 'case' tiene tipo " + caseValueType
                                    + ", incompatible con el selector "
                                    + currentSwitchSelectorType, node);
                }
            }
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(DefaultCaseNodeZ node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (ZAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================
    @Override
    public Type visit(LiteralExpressionNodeZ node) {
        Type t = mapper.mapZDataType(node.getValueType(), null);
        annotate(node, t);
        return t;
    }

    @Override
    public Type visit(IdentifierExpressionNodeZ node) {
        List<Symbol> found = lookup.resolveByName(node.getIdentifier());
        if (found.isEmpty()) return Type.unknown();
        Type t = mapper.mapSymbolToType(found.get(0));
        annotate(node, t);
        return t;
    }

    @Override
    public Type visit(BinaryExpressionNodeZ node) {
        Type left = node.getLeft().accept(this);
        Type right = node.getRight().accept(this);
        Type result = compat.inferBinaryType(left, right, node.getOperator(), reporter, node);
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
                    reporter.reportTypeError(op.getValue() + " " + operandType,
                            "El operador '-' requiere un operando numerico", node);
                    result = Type.unknown();
                } else result = operandType;
                break;
            case NOT:
                if (operandType.getKind() != TypeKind.BOOLEAN && !operandType.isUnknown()) {
                    reporter.reportTypeError(op.getValue() + " " + operandType,
                            "El operador '!' requiere un operando booleano", node);
                    result = Type.unknown();
                } else result = Type.booleanType();
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
            reporter.reportTypeError(condType.toString(),
                    "La condicion del operador ternario debe ser booleana", node);
        }

        Type thenType = node.getThenExpr().accept(this);
        Type elseType = node.getElseExpr().accept(this);

        Type result;
        if (thenType.isAssignableTo(elseType)) result = elseType;
        else if (elseType.isAssignableTo(thenType)) result = thenType;
        else if (compat.isNumericOrPromotable(thenType) && compat.isNumericOrPromotable(elseType)) {
            result = compat.promoteNumeric(thenType, elseType);
        } else {
            reporter.reportTypeError(thenType + " : " + elseType,
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
            if (targetType.isUnknown() || !targetType.isCustom()) return Type.unknown();
            classSymbol = lookup.findType(targetType.getCustomName());
        } else {
            classSymbol = currentClass;
        }

        if (classSymbol == null) return Type.unknown();

        List<Symbol> methods = new ArrayList<>();
        for (Symbol m : lookup.findMethodsInClass(classSymbol, methodName)) {
            if (access.isAccessible(m, currentClass)) methods.add(m);
        }

        if (methods.isEmpty()) {
            List<Symbol> all = lookup.findMethodsInClass(classSymbol, methodName);
            if (!all.isEmpty()) {
                reporter.reportTypeError(methodName,
                        "El metodo '" + methodName + "' de la clase "
                                + classSymbol.getName() + " no es accesible desde este contexto",
                        node);
            } else {
                reporter.reportTypeError(methodName,
                        "La clase " + classSymbol.getName()
                                + " no tiene un metodo '" + methodName + "'", node);
            }
            return Type.unknown();
        }

        Symbol chosen = calls.resolveOverload(methods, argTypes, methodName, node);
        if (chosen == null) return Type.unknown();

        Type returnType = compat.resolveSymbolReturnType(chosen);
        annotate(node, returnType);
        return returnType;
    }

    @Override
    public Type visit(PropertyAccessExpressionNodeZ node) {
        if (node.getTarget() == null) return Type.unknown();

        Type targetType = node.getTarget().accept(this);
        if (targetType.isUnknown()) return Type.unknown();

        if (!targetType.isCustom()) {
            reporter.reportTypeError(node.getPropertyName(),
                    "El target de '" + node.getPropertyName() + "' no es una clase", node);
            return Type.unknown();
        }

        MemberLookupResult result = lookup.findMemberInType(
                targetType, node.getPropertyName(), currentClass);

        if (result.isInaccessible()) {
            reporter.reportTypeError(node.getPropertyName(),
                    "El miembro '" + node.getPropertyName() + "' de la clase "
                            + targetType.getCustomName() + " no es accesible desde este contexto",
                    node);
            return Type.unknown();
        }

        if (!result.isFound()) {
            reporter.reportTypeError(node.getPropertyName(),
                    "La clase " + targetType.getCustomName()
                            + " no tiene un miembro '" + node.getPropertyName() + "'", node);
            return Type.unknown();
        }

        Symbol member = result.getMember();
        if (member.getKind() != SymbolKind.ATTRIBUTE) {
            reporter.reportTypeError(node.getPropertyName(),
                    "'" + node.getPropertyName() + "' no es un atributo", node);
            return Type.unknown();
        }

        Type memberType = mapper.mapSymbolToType(member);
        annotate(node, memberType);
        return memberType;
    }

    @Override
    public Type visit(MemberArrayAccessExpressionNodeZ node) {
        Type targetType = node.getTarget().accept(this);

        if (!targetType.isArray()) {
            if (!targetType.isUnknown()) {
                reporter.reportTypeError("[]",
                        "El target del acceso por indice no es un arreglo", node);
            }
            return Type.unknown();
        }

        if (node.getIndex() != null) {
            Type indexType = node.getIndex().accept(this);
            if (!compat.isIntLike(indexType) && !indexType.isUnknown()) {
                reporter.reportTypeError("[]",
                        "El indice de un arreglo debe ser entero", node);
            }
        }

        Type elementType = targetType.getElementType();
        int dims = targetType.getDimensions() - 1;
        Type result = dims > 0 ? Type.arrayType(elementType, dims) : elementType;
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ObjectInstantiationNodeZ node) {
        TypeNodeZ typeNode = node.getType();
        if (typeNode == null) return Type.unknown();

        String className = typeNode.getCustomTypeName();
        if (className == null) return Type.unknown();

        Symbol classSymbol = lookup.findType(className);
        if (classSymbol == null || classSymbol.getKind() != SymbolKind.CLASS) {
            reporter.reportTypeError(className,
                    "La clase '" + className + "' no existe", node);
            return Type.unknown();
        }

        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }

        List<Symbol> constructors = lookup.findConstructors(classSymbol);
        Symbol chosen = calls.resolveOverload(constructors, argTypes, className, node);
        if (chosen == null) return Type.unknown();

        Type classType = Type.customType(className);
        annotate(node, classType);
        return classType;
    }

    @Override
    public Type visit(ArrayInstantiationNodeZ node) {
        Type elementType = mapper.mapTypeNode(node.getType());
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 1;
        Type arrayType = Type.arrayType(elementType, dims);

        if (node.getDimensions() != null) {
            for (ExpressionNodeZ dimExpr : node.getDimensions()) {
                if (dimExpr == null) continue;
                Type dimType = dimExpr.accept(this);
                if (!compat.isIntLike(dimType) && !dimType.isUnknown()) {
                    reporter.reportTypeError(node.getType().getCustomTypeName(),
                            "Las dimensiones del arreglo deben ser enteras", node);
                }
            }
        }
        annotate(node, arrayType);
        return arrayType;
    }

    @Override
    public Type visit(InstanceCreationExpressionNodeZ node) {
        return null;
    }

    @Override
    public Type visit(ArrayInitExpressionNodeZ node) {
        if (node.getElements() == null || node.getElements().isEmpty()) return Type.unknown();

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
                reporter.reportTypeError(firstType.toString(),
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
            for (ExpressionNodeZ v : node.getValues()) if (v != null) v.accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ArgumentsNodeZ node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeZ arg : node.getArguments()) if (arg != null) arg.accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(TypeNodeZ node) {
        return Type.unknown();
    }
}