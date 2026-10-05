package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Principal type checker for visitor
 *
 */
@Getter
public class YTypeCheckerVisitor implements YAstVisitor<Type> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;

    private final YSemanticErrorReporter reporter;
    private final YTypeMapperService mapper;
    private final YSymbolLookupService lookup;
    private final YTypeCompatibilityService compat;
    private final YCallResolutionService calls;
    private final YScopeService scopes;

    private Type currentSwitchSelectorType;
    private Type currentReturnType;

    public YTypeCheckerVisitor(GlobalSymbolTable table,
                               EditorContext context,
                               Map<AstNode, Type> typeAnnotations) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;

        this.reporter = new YSemanticErrorReporter(context);
        this.mapper = new YTypeMapperService();
        this.lookup = new YSymbolLookupService(table, context);
        this.compat = new YTypeCompatibilityService(mapper);
        this.calls = new YCallResolutionService(lookup, compat, reporter);
        this.scopes = new YScopeService(table, context);
    }

    private void annotate(AstNode node, Type type) {
        typeAnnotations.put(node, type);
    }

    // -------- TOP-LEVEL --------

    @Override
    public Type visit(ProgramNodeY node) {
        if (node.getStructures() != null) node.getStructures().accept(this);
        if (node.getFunctions() != null) node.getFunctions().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY s : node.getStructs()) if (s != null) s.accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (YAstNode f : node.getFunctions()) if (f != null) f.accept(this);
        }
        return Type.voidType();
    }

    // -------- STRUCTS --------

    @Override
    public Type visit(StructDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                node.getBody().accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(StructBodyNodeY node) {
        if (node.getAttributes() != null) {
            for (StructAttributeNodeY a : node.getAttributes()) {
                if (a != null) a.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructAttributeNodeY node) {
        TypeNodeY typeNode = node.getType();
        if (typeNode != null && typeNode.getDataType() == YDataType.CUSTOM) {
            String customName = typeNode.getCustomTypeName();
            if (customName != null && lookup.findType(customName) == null) {
                reporter.reportTypeError(node.getIdentifier(),
                        "El tipo '" + customName + "' del atributo no existe", node);
            }
        }

        Type type = mapper.mapTypeNode(typeNode);
        if (node.isArray()) {
            int dims = node.getDimensions() != null ? node.getDimensions().size() : 1;
            type = Type.arrayType(type, dims);
        }
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(StructPropertyNodeY node) {
        if (node.getValue() != null) {
            Type t = node.getValue().accept(this);
            annotate(node, t);
            return t;
        }
        return Type.unknown();
    }

    @Override
    public Type visit(StructLiteralExpressionNodeY node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodeY p : node.getProperties()) if (p != null) p.accept(this);
        }
        return Type.unknown();
    }

    @Override
    public Type visit(StructInstanceNodeY node) {
        String structTypeName = node.getStructType();
        Symbol structSymbol = lookup.findStruct(structTypeName);
        if (structSymbol == null) return Type.unknown();

        Type structType = Type.customType(structTypeName);
        annotate(node, structType);

        List<Symbol> members = structSymbol.getMembers();
        if (members == null) members = new ArrayList<>();

        if (node.getLiteral() != null) {
            List<StructPropertyNodeY> properties = node.getLiteral().getProperties();
            if (properties == null) properties = new ArrayList<>();

            if (properties.size() != members.size()) {
                reporter.reportTypeError(structTypeName,
                        "El struct " + structTypeName + " espera " + members.size()
                                + " valores, pero se dieron " + properties.size(), node);
            }

            int n = Math.min(properties.size(), members.size());
            for (int i = 0; i < n; i++) {
                StructPropertyNodeY prop = properties.get(i);
                Symbol member = members.get(i);
                Type memberType = mapper.mapSymbolToType(member);
                Type valueType = prop.getValue().accept(this);
                if (!valueType.isAssignableTo(memberType)) {
                    reporter.reportTypeError(structTypeName,
                            "El valor en posicion " + i + " del struct " + structTypeName
                                    + " deberia ser " + memberType + ", pero es " + valueType, prop);
                }
            }
        }

        return structType;
    }

    // -------- FUNCTIONS / PROCEDURES --------

    @Override
    public Type visit(FunctionDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            Type previousReturn = currentReturnType;
            currentReturnType = node.getReturnType() != null
                    ? mapper.mapTypeNode(node.getReturnType())
                    : Type.voidType();

            if (node.getReturnType() != null
                    && node.getReturnType().getDataType() == YDataType.CUSTOM) {
                String customName = node.getReturnType().getCustomTypeName();
                if (customName != null && lookup.findStruct(customName) == null) {
                    reporter.reportTypeError(customName,
                            "El tipo de retorno '" + customName + "' no existe", node);
                }
            }

            if (node.getParameters() != null) {
                for (ParameterNodeY p : node.getParameters()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }

            currentReturnType = previousReturn;
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ProcedureDeclarationNodeY node) {
        scopes.withScope(node, () -> {
            Type previousReturn = currentReturnType;
            currentReturnType = null;
            if (node.getParameters() != null) {
                for (ParameterNodeY p : node.getParameters()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
            currentReturnType = previousReturn;
        });
        return Type.voidType();
    }

    @Override
    public Type visit(StructParameterNodeY node) {
        TypeNodeY typeNode = node.getDataType();
        if (typeNode == null) return Type.unknown();

        if (typeNode.getDataType() == YDataType.CUSTOM) {
            String customName = typeNode.getCustomTypeName();
            if (customName == null) {
                reporter.reportTypeError(node.getIdentifier(),
                        "El parametro '" + node.getIdentifier() + "' tiene un tipo struct sin nombre", node);
                return Type.unknown();
            }
            if (lookup.findStruct(customName) == null) {
                reporter.reportTypeError(node.getIdentifier(),
                        "El tipo struct '" + customName + "' no existe o no es accesible", node);
                return Type.unknown();
            }
        }

        Type base = mapper.mapTypeNode(typeNode);
        if (node.isArray()) base = Type.arrayType(base, node.getDimensions());
        annotate(node, base);
        return base;
    }

    @Override
    public Type visit(PrimitiveParameterNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(ArrayParameterNodeY node) {
        TypeNodeY typeNode = node.getElementType();
        if (typeNode == null) return Type.unknown();

        if (typeNode.getDataType() == YDataType.CUSTOM) {
            String customName = typeNode.getCustomTypeName();
            if (customName != null && lookup.findStruct(customName) == null) {
                reporter.reportTypeError(node.getIdentifier(),
                        "El tipo struct '" + customName + "' no existe o no es accesible", node);
                return Type.unknown();
            }
        }

        Type element = mapper.mapTypeNode(typeNode);
        Type arrayType = Type.arrayType(element, node.getDimensions());
        annotate(node, arrayType);
        return arrayType;
    }

    // -------- VARIABLES --------

    @Override
    public Type visit(VariableDeclarationNodeY node) {
        Type declaredType = mapper.mapTypeNode(node.getDataType());
        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reporter.reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a variable de tipo " + declaredType, node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ArrayDeclarationNodeY node) {
        Type elementType = mapper.mapTypeNode(node.getDataType());
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 1;
        Type arrayType = Type.arrayType(elementType, dims);

        if (node.getDimensions() != null) {
            for (ExpressionNodeY dimExpr : node.getDimensions()) {
                if (dimExpr == null) continue;
                Type dimType = dimExpr.accept(this);
                if (!compat.isIntLike(dimType) && !dimType.isUnknown()) {
                    reporter.reportTypeError(node.getIdentifier(),
                            "Las dimensiones del arreglo deben ser enteras", node);
                }
            }
        }

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(arrayType)) {
                reporter.reportTypeError(node.getIdentifier(),
                        "No se puede asignar " + initType + " a arreglo de tipo " + arrayType, node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForInitDeclarationNodeY node) {
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
    public Type visit(ForInitAssignmentNodeY node) {
        Type targetType = node.getId() != null ? node.getId().accept(this) : Type.unknown();
        Type valueType = node.getExpr() != null ? node.getExpr().accept(this) : Type.unknown();
        if (!valueType.isAssignableTo(targetType)) {
            reporter.reportTypeError(targetType.getKind().getTranslation() + " = "
                            + valueType.getKind().getTranslation(),
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForUpdateNodeY node) {
        Type targetType = node.getTarget().accept(this);
        switch (node.getOperator()) {
            case INCREMENT:
            case DECREMENT:
            case PREFIX_INCREMENT:
            case PREFIX_DECREMENT:
                if (!targetType.isNumeric() && !targetType.isUnknown()) {
                    reporter.reportTypeError(targetType.getKind().getTranslation(),
                            "El operador requiere un operando numerico", node);
                }
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    Type valueType = node.getValue().accept(this);
                    if (!valueType.isAssignableTo(targetType)) {
                        reporter.reportTypeError(targetType.getKind().getTranslation() + " = "
                                        + valueType.getKind().getTranslation(),
                                "No se puede asignar " + valueType + " a " + targetType, node);
                    }
                }
                break;
        }
        return Type.voidType();
    }

    // -------- STATEMENTS --------

    @Override
    public Type visit(VariableAssignmentNodeY node) {
        Type targetType = node.getIdentifier() != null ? node.getIdentifier().accept(this) : Type.unknown();
        Type valueType = node.getExpressionNode() != null ? node.getExpressionNode().accept(this) : Type.unknown();
        if (!valueType.isAssignableTo(targetType)) {
            reporter.reportTypeError(targetType.getKind().getTranslation() + " = "
                            + valueType.getKind().getTranslation(),
                    "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ShortlyOperationNodeY node) {
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
                            "Operador '" + opLexeme + "' incompatible entre " + targetType + " y " + valueType, node);
                }
                break;
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.getKind().getTranslation(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.getKind().getTranslation(),
                        "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.getKind().getTranslation(),
                        "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type t = node.getTargetVariable().accept(this);
            if (!t.isNumeric() && !t.isUnknown()) {
                reporter.reportTypeError(t.getKind().getTranslation(),
                        "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(PrintStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(ReadStatementNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(ReturnStatementNodeY node) {
        if (currentReturnType == null) {
            reporter.reportTypeError("retornar",
                    "Un procedimiento no puede tener una instruccion 'retornar'", node);
            if (node.getValue() != null) node.getValue().accept(this);
            return Type.voidType();
        }
        Type valueType = node.getValue() != null ? node.getValue().accept(this) : Type.voidType();
        if (!valueType.isAssignableTo(currentReturnType)) {
            reporter.reportTypeError(valueType.getKind().getTranslation(),
                    "El tipo de retorno " + valueType
                            + " no coincide con el tipo declarado " + currentReturnType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(BreakStatementNodeY node) {
        return Type.voidType();
    }

    @Override
    public Type visit(ContinueStatementNodeY node) {
        return Type.voidType();
    }

    // -------- CONTROL FLOW --------

    @Override
    public Type visit(IfStatementNodeY node) {
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.getKind().getTranslation(),
                        "La condicion del 'if' debe ser booleana", node);
            }
            if (node.getThenBody() != null) {
                for (StatementNodeY s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeY e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfNodeY node) {
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.getKind().getTranslation(),
                        "La condicion del 'else if' debe ser booleana", node);
            }
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseBlockNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfListNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(WhileStatementNodeY node) {
        scopes.withScope(node, () -> {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.getKind().getTranslation(),
                        "La condicion del 'while' debe ser booleana", node);
            }
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(DoWhileStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reporter.reportTypeError(condType.getKind().getTranslation(),
                        "La condicion del 'do-while' debe ser booleana", node);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(ForStatementNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) {
                Type condType = node.getCondition().accept(this);
                if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                    reporter.reportTypeError(condType.getKind().getTranslation(),
                            "La condicion del 'for' debe ser booleana", node);
                }
            }
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchStatementNodeY node) {
        scopes.withScope(node, () -> {
            Type selectorType = node.getSelector().accept(this);
            TypeKind k = selectorType.getKind();
            if (k != TypeKind.INT && k != TypeKind.CHAR && k != TypeKind.STRING && !selectorType.isUnknown()) {
                reporter.reportTypeError("switch",
                        "El selector del 'switch' debe ser entero, caracter o cadena, pero es " + selectorType,
                        node);
            }
            Type previousSelector = currentSwitchSelectorType;
            currentSwitchSelectorType = selectorType;
            if (node.getCases() != null) {
                for (SwitchCaseNodeY c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
            currentSwitchSelectorType = previousSelector;
        });
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchCaseNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getValue() != null) {
                Type caseValueType = node.getValue().accept(this);
                if (currentSwitchSelectorType != null
                        && !currentSwitchSelectorType.isUnknown()
                        && !caseValueType.isUnknown()
                        && !caseValueType.isAssignableTo(currentSwitchSelectorType)) {
                    reporter.reportTypeError("case",
                            "El valor del 'case' tiene tipo " + caseValueType
                                    + ", incompatible con el selector " + currentSwitchSelectorType,
                            node);
                }
            }
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    @Override
    public Type visit(DefaultCaseNodeY node) {
        scopes.withScope(node, () -> {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return Type.voidType();
    }

    // -------- EXPRESSIONS --------

    @Override
    public Type visit(ExpressionNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(LiteralExpressionNodeY node) {
        Type t = mapper.mapYDataType(node.getValueType(), null);
        annotate(node, t);
        return t;
    }

    @Override
    public Type visit(IdentifierExpressionNodeY node) {
        List<Symbol> found = lookup.resolveByName(node.getIdentifier());
        if (found.isEmpty()) return Type.unknown();

        Type t = mapper.mapSymbolToType(found.get(0));
        annotate(node, t);
        return t;
    }

    @Override
    public Type visit(BinaryExpressionNodeY node) {
        Type left = node.getLeft().accept(this);
        Type right = node.getRight().accept(this);
        Type result = compat.inferBinaryType(left, right, node.getOperator(), reporter, node);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(UnaryExpressionNodeY node) {
        Type operandType = node.getExpressionNode().accept(this);
        UnaryOperator op = node.getOperator();
        Type result;
        switch (op) {
            case NEGATE:
                if (!operandType.isNumeric() && !operandType.isUnknown()) {
                    reporter.reportTypeError(op.getValue() + " " + operandType.getKind().getTranslation(),
                            "El operador '-' requiere un operando numerico", node);
                    result = Type.unknown();
                } else result = operandType;
                break;
            case NOT:
                if (operandType.getKind() != TypeKind.BOOLEAN && !operandType.isUnknown()) {
                    reporter.reportTypeError(op.getValue() + " " + operandType.getKind().getTranslation(),
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
    public Type visit(FunctionCallExpressionNodeY node) {
        List<Type> argTypes = new ArrayList<>();
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                argTypes.add(arg != null ? arg.accept(this) : Type.unknown());
            }
        }
        Type result = calls.resolve(node, argTypes);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayCallExpressionNodeY node) {
        List<Symbol> found = lookup.resolveByName(node.getArrayName());
        if (found.isEmpty()) return Type.unknown();

        Type arrayType = mapper.mapSymbolToType(found.get(0));
        if (!arrayType.isArray()) {
            reporter.reportTypeError(node.getArrayName(),
                    "'" + node.getArrayName() + "' no es un arreglo", node);
            return Type.unknown();
        }

        if (node.getIndexExpression() != null) {
            Type indexType = node.getIndexExpression().accept(this);
            if (!compat.isIntLike(indexType) && !indexType.isUnknown()) {
                reporter.reportTypeError(node.getArrayName(),
                        "El indice de un arreglo debe ser entero", node);
            }
        }

        Type elementType = arrayType.getElementType();
        int dims = arrayType.getDimensions() - 1;
        Type result = dims > 0 ? Type.arrayType(elementType, dims) : elementType;
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayInitExpressionNodeY node) {
        if (node.getElements() == null || node.getElements().isEmpty()) return Type.unknown();

        Type firstType = node.getElements().get(0).accept(this);
        if (firstType.isUnknown()) {
            for (int i = 1; i < node.getElements().size(); i++) node.getElements().get(i).accept(this);
            return Type.unknown();
        }
        for (int i = 1; i < node.getElements().size(); i++) {
            Type elemType = node.getElements().get(i).accept(this);
            if (!elemType.isAssignableTo(firstType) && !elemType.isUnknown()) {
                reporter.reportTypeError("",
                        "El elemento en posicion " + i + " tiene tipo " + elemType
                                + ", incompatible con el primer elemento " + firstType, node);
            }
        }
        Type result = Type.arrayType(firstType, 1);
        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayValuesNodeY node) {
        if (node.getValues() != null) {
            for (ExpressionNodeY v : node.getValues()) if (v != null) v.accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(PropertyAccessExpressionNodeY node) {
        if (node.getTarget() == null) return Type.unknown();

        Type targetType = node.getTarget().accept(this);
        if (targetType.isUnknown()) return Type.unknown();

        if (!targetType.isCustom()) {
            reporter.reportTypeError(node.getPropertyName(),
                    "El target de '" + node.getPropertyName() + "' no es un struct", node);
            return Type.unknown();
        }

        Symbol member = lookup.findMemberInStruct(targetType, node.getPropertyName());
        if (member == null) {
            reporter.reportTypeError(node.getPropertyName(),
                    "El struct " + targetType.getCustomName()
                            + " no tiene un atributo '" + node.getPropertyName() + "'", node);
            return Type.unknown();
        }

        Type memberType = mapper.mapSymbolToType(member);
        annotate(node, memberType);
        return memberType;
    }

    @Override
    public Type visit(MemberArrayAccessExpressionNodeY node) {
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
    public Type visit(ArgumentsNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) if (arg != null) arg.accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(TypeNodeY node) {
        return Type.unknown();
    }
}