package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
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
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class YTypeCheckerVisitor implements YAstVisitor<Type> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<AstNode, Type> typeAnnotations;


    private Type currentReturnType;

    public YTypeCheckerVisitor(GlobalSymbolTable table,
                               EditorContext context,
                               Map<AstNode, Type> typeAnnotations) {
        this.table = table;
        this.context = context;
        this.typeAnnotations = typeAnnotations;
    }

    private void annotate(AstNode node, Type type) {
        typeAnnotations.put(node, type);
    }

    // ============================================================
    // STUBS — all return unknown for now.
    // ============================================================

    @Override
    public Type visit(ProgramNodeY node) {
        if (node.getStructures() != null) {
            node.getStructures().accept(this);
        }
        if (node.getFunctions() != null) {
            node.getFunctions().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY struct : node.getStructs()) {
                if (struct != null) {
                    struct.accept(this);
                }
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (FunctionDeclarationNodeY function : node.getFunctions()) {
                if (function != null) {
                    function.accept(this);
                }
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructDeclarationNodeY node) {
        if (node.getAttributes() != null) {
            node.getAttributes().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructBodyNodeY node) {
        if (node.getAttributes() != null) {
            for (StructAttributeNodeY attribute : node.getAttributes()) {
                if (attribute != null) {
                    attribute.accept(this);
                }
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(StructAttributeNodeY node) {
        Type type = mapTypeNode(node.getType());
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
            Type valueType = node.getValue().accept(this);
            annotate(node, valueType);
            return valueType;
        }
        return Type.unknown();
    }

    @Override
    public Type visit(StructLiteralExpressionNodeY node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodeY property : node.getProperties()) {
                if (property != null) {
                    property.accept(this);
                }
            }
        }
        return Type.unknown();
    }

    @Override
    public Type visit(StructInstanceNodeY node) {
        String structTypeName = node.getStructType();

        Symbol structSymbol = findStructSymbol(structTypeName);
        if (structSymbol == null) {
            return Type.unknown();
        }

        Type structType = Type.customType(structTypeName);
        annotate(node, structType);

        List<Symbol> members = structSymbol.getMembers();
        if (members == null) members = new ArrayList<>();

        if (node.getLiteral() != null) {
            List<StructPropertyNodeY> properties = node.getLiteral().getProperties();
            if (properties == null) properties = new ArrayList<>();

            if (properties.size() != members.size()) {
                reportTypeError(
                        structTypeName,
                        "El struct " + structTypeName + " espera " + members.size()
                                + " valores, pero se dieron " + properties.size(),
                        node
                );
            }

            int minCount = Math.min(properties.size(), members.size());
            for (int i = 0; i < minCount; i++) {
                StructPropertyNodeY prop = properties.get(i);
                Symbol member = members.get(i);

                Type memberType = mapSymbolToType(member);
                Type valueType = prop.getValue().accept(this);

                if (!valueType.isAssignableTo(memberType)) {
                    reportTypeError(
                            structTypeName,
                            "El valor en posicion " + i + " del struct " + structTypeName
                                    + " deberia ser " + memberType + ", pero es " + valueType,
                            prop
                    );
                }
            }
        }

        return structType;
    }

    @Override
    public Type visit(FunctionDeclarationNodeY node) {
        Type previousReturn = currentReturnType;
        currentReturnType = node.getReturnType() != null
                ? mapTypeNode(node.getReturnType())
                : Type.voidType();

        if (node.getReturnType() != null
                && node.getReturnType().getDataType() == YDataType.CUSTOM) {
            String customName = node.getReturnType().getCustomTypeName();
            if (customName != null && findStructSymbol(customName) == null) {
                reportTypeError(customName,
                        "El tipo de retorno '" + customName + "' no existe", node);
            }
        }

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        currentReturnType = previousReturn;
        return Type.voidType();
    }

    @Override
    public Type visit(ProcedureDeclarationNodeY node) {
        Type previousReturn = currentReturnType;
        currentReturnType = Type.voidType();

        if (node.getParameters() != null) {
            for (ParameterNodeY param : node.getParameters()) {
                if (param != null) {
                    param.accept(this);
                }
            }
        }

        if (node.getBody() != null) {
            for (YAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }

        currentReturnType = previousReturn;
        return Type.voidType();
    }

    @Override
    public Type visit(StructParameterNodeY node) {
        TypeNodeY typeNode = node.getDataType();
        if (typeNode == null) {
            return Type.unknown();
        }

        if (typeNode.getDataType() == YDataType.CUSTOM) {
            String customName = typeNode.getCustomTypeName();
            if (customName == null) {
                reportTypeError(node.getIdentifier(),
                        "El parametro '" + node.getIdentifier() + "' tiene un tipo struct sin nombre", node);
                return Type.unknown();
            }

            Symbol structSymbol = findStructSymbol(customName);
            if (structSymbol == null) {
                reportTypeError(node.getIdentifier(),
                        "El tipo struct '" + customName + "' no existe o no es accesible", node);
                return Type.unknown();
            }
        }

        Type base = mapTypeNode(typeNode);
        if (node.isArray()) {
            base = Type.arrayType(base, node.getDimensions());
        }

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
        if (typeNode == null) {
            return Type.unknown();
        }

        if (typeNode.getDataType() == YDataType.CUSTOM) {
            String customName = typeNode.getCustomTypeName();
            if (customName != null) {
                Symbol structSymbol = findStructSymbol(customName);
                if (structSymbol == null) {
                    reportTypeError(node.getIdentifier(),
                            "El tipo struct '" + customName + "' no existe o no es accesible", node);
                    return Type.unknown();
                }
            }
        }

        Type element = mapTypeNode(typeNode);
        Type arrayType = Type.arrayType(element, node.getDimensions());
        annotate(node, arrayType);
        return arrayType;
    }

    @Override
    public Type visit(VariableDeclarationNodeY node) {
        Type declaredType = mapTypeNode(node.getDataType());

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reportTypeError(node.getIdentifier(), "No se puede asignar " + initType + " a variable de tipo " + declaredType, node);
            }
        }

        return Type.voidType();
    }

    @Override
    public Type visit(ArrayDeclarationNodeY node) {
        Type elementType = mapTypeNode(node.getDataType());
        Type arrayType = Type.arrayType(elementType, node.getDimensions().size());

        if (node.getInitializer() != null) {
            Type initType = node.getInitializer().accept(this);
            if (!initType.isAssignableTo(arrayType)) {
                reportTypeError(node.getIdentifier(), "No se puede asignar " + initType + " a arreglo de tipo " + arrayType, node);
            }
        }

        return Type.voidType();
    }

    @Override
    public Type visit(ForInitDeclarationNodeY node) {
        Type declaredType = mapTypeNode(node.getType());

        if (node.getExpr() != null) {
            Type initType = node.getExpr().accept(this);
            if (!initType.isAssignableTo(declaredType)) {
                reportTypeError(node.getId(), "No se puede asignar " + initType + " a " + declaredType, node);
            }
        }

        return Type.voidType();
    }


    @Override
    public Type visit(ForInitAssignmentNodeY node) {
        Type targetType = node.getId() != null
                ? node.getId().accept(this)
                : Type.unknown();

        Type valueType = node.getExpr() != null
                ? node.getExpr().accept(this)
                : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reportTypeError(targetType.getKind().getTranslation() + " = " + valueType.getKind().getTranslation(), "No se puede asignar " + valueType + " a " + targetType, node);
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
                    reportTypeError(targetType.getKind().getTranslation(), "El operador requiere un operando numerico", node);
                }
                break;
            case ASSIGN:
                if (node.getValue() != null) {
                    Type valueType = node.getValue().accept(this);
                    if (!valueType.isAssignableTo(targetType)) {
                        reportTypeError(targetType.getKind().getTranslation() + " = " + valueType.getKind().getTranslation(), "No se puede asignar " + valueType + " a " + targetType, node);
                    }
                }
                break;
        }

        return Type.voidType();
    }

    @Override
    public Type visit(VariableAssignmentNodeY node) {
        Type targetType = node.getIdentifier() != null
                ? node.getIdentifier().accept(this)
                : Type.unknown();
        Type valueType = node.getExpressionNode() != null
                ? node.getExpressionNode().accept(this)
                : Type.unknown();

        if (!valueType.isAssignableTo(targetType)) {
            reportTypeError(targetType.getKind().getTranslation() + " = " + valueType.getKind().getTranslation(), "No se puede asignar " + valueType + " a " + targetType, node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ShortlyOperationNodeY node) {
        Type targetType = node.getTarget().accept(this);
        Type valueType = node.getValue().accept(this);

        if (targetType.isUnknown() || valueType.isUnknown()) {
            return Type.voidType();
        }

        String opLexeme = node.getOperator().getValue();

        switch (node.getOperator()) {
            case PLUS_ASSIGN:
                if (targetType.getKind() == TypeKind.STRING && valueType.getKind() == TypeKind.STRING) {
                    return Type.voidType();
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
    public Type visit(IncrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.getKind().getTranslation(), "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.getKind().getTranslation(), "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IncrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.getKind().getTranslation(), "El operador '++' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DecrementPrevStatementNodeY node) {
        if (node.getTargetVariable() != null) {
            Type targetType = node.getTargetVariable().accept(this);
            if (!targetType.isNumeric() && !targetType.isUnknown()) {
                reportTypeError(targetType.getKind().getTranslation(), "El operador '--' requiere un operando numerico", node);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(IfStatementNodeY node) {
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.getKind().getTranslation(), "La condicion del 'if' debe ser booleana", node);
        }
        if (node.getThenBody() != null) {
            for (StatementNodeY statement : node.getThenBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodeY elseIf : node.getElseIfs()) {
                if (elseIf != null) elseIf.accept(this);
            }
        }
        if (node.getElseBlockNode() != null) {
            node.getElseBlockNode().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ElseIfNodeY node) {
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.getKind().getTranslation(), "La condicion del 'else if' debe ser booleana", node);
        }
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ElseBlockNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }


    @Override
    public Type visit(ElseIfListNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(WhileStatementNodeY node) {
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.getKind().getTranslation(), "La condicion del 'while' debe ser booleana", node);
        }
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DoWhileStatementNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        Type condType = node.getCondition().accept(this);
        if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
            reportTypeError(condType.getKind().getTranslation(), "La condicion del 'do-while' debe ser booleana", node);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ForStatementNodeY node) {
        if (node.getInit() != null) node.getInit().accept(this);
        if (node.getCondition() != null) {
            Type condType = node.getCondition().accept(this);
            if (condType.getKind() != TypeKind.BOOLEAN && !condType.isUnknown()) {
                reportTypeError(condType.getKind().getTranslation(), "La condicion del 'for' debe ser booleana", node);
            }
        }
        if (node.getUpdate() != null) node.getUpdate().accept(this);
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }


    @Override
    public Type visit(SwitchStatementNodeY node) {

        Type selectorType = node.getSelector().accept(this);
        TypeKind k = selectorType.getKind();
        if (k != TypeKind.INT
                && k != TypeKind.CHAR
                && k != TypeKind.STRING
                && !selectorType.isUnknown()) {
            reportTypeError("switch",
                    "El selector del 'switch' debe ser entero, caracter o cadena", node);
        }

        if (node.getCases() != null) {
            for (SwitchCaseNodeY caseNode : node.getCases()) {
                if (caseNode != null) caseNode.accept(this);
            }
        }
        if (node.getDefaultCase() != null) {
            node.getDefaultCase().accept(this);
        }
        return Type.voidType();
    }

    @Override
    public Type visit(SwitchCaseNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(DefaultCaseNodeY node) {
        if (node.getBody() != null) {
            for (StatementNodeY statement : node.getBody()) {
                if (statement != null) statement.accept(this);
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(ReturnStatementNodeY node) {
        Type valueType = node.getValue() != null
                ? node.getValue().accept(this)
                : Type.voidType();

        if (currentReturnType != null) {
            if (!valueType.isAssignableTo(currentReturnType)) {
                reportTypeError(valueType.getKind().getTranslation(), "El tipo de retorno " + valueType
                        + " no coincide con el tipo declarado " + currentReturnType, node);
            }
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
    public Type visit(ExpressionStatementNodeY node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return Type.voidType();
    }

    @Override
    public Type visit(ExpressionNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(LiteralExpressionNodeY node) {
        Type type = mapYDataType(node.getValueType(), null);
        annotate(node, type);
        return type;
    }

    @Override
    public Type visit(IdentifierExpressionNodeY node) {
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
    public Type visit(BinaryExpressionNodeY node) {
        Type left = node.getLeft().accept(this);
        Type right = node.getRight().accept(this);
        BinaryOperator op = node.getOperator();

        Type result = inferBinaryType(left, right, op, node);
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
                    reportTypeError(op.getValue() + " " + operandType.getKind().getTranslation(), "El operador '-' requiere un operando numerico", node);
                    result = Type.unknown();
                } else {
                    result = operandType;
                }
                break;
            case NOT:
                if (operandType.getKind() != TypeKind.BOOLEAN && !operandType.isUnknown()) {
                    reportTypeError(op.getValue() + " " + operandType.getKind().getTranslation(), "El operador '!' requiere un operando booleano", node);
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
    public Type visit(FunctionCallExpressionNodeY node) {
        return Type.unknown();
    }

    @Override
    public Type visit(ArrayCallExpressionNodeY node) {
        String arrayName = node.getArrayName();
        List<Symbol> found = table.resolveByName(arrayName);
        if (found.isEmpty()) {
            return Type.unknown();
        }

        Type arrayType = mapSymbolToType(found.get(0));
        if (!arrayType.isArray()) {
            reportTypeError(arrayName,
                    "'" + arrayName + "' no es un arreglo", node);
            return Type.unknown();
        }

        if (node.getIndexExpression() != null) {
            Type indexType = node.getIndexExpression().accept(this);
            if (!indexType.isNumeric() && !indexType.isUnknown()) {
                reportTypeError(arrayName,
                        "El indice de un arreglo debe ser numerico", node);
            }
        }

        Type elementType = arrayType.getElementType();
        int dims = arrayType.getDimensions() - 1;
        Type result = dims > 0
                ? Type.arrayType(elementType, dims)
                : elementType;

        annotate(node, result);
        return result;
    }

    @Override
    public Type visit(ArrayInitExpressionNodeY node) {
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
                reportTypeError("",
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
            for (ExpressionNodeY value : node.getValues()) {
                if (value != null) {
                    value.accept(this);
                }
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(PropertyAccessExpressionNodeY node) {
        if (node.getTarget() == null) {
            return Type.unknown();
        }

        Type targetType = node.getTarget().accept(this);

        if (targetType.isUnknown()) {
            return Type.unknown();
        }

        if (!targetType.isCustom()) {
            reportTypeError(node.getPropertyName(),
                    "El target de '" + node.getPropertyName() + "' no es un struct", node);
            return Type.unknown();
        }

        Symbol member = findMemberInStruct(targetType, node.getPropertyName());
        if (member == null) {
            reportTypeError(node.getPropertyName(),
                    "El struct " + targetType.getCustomName()
                            + " no tiene un atributo '" + node.getPropertyName() + "'", node);
            return Type.unknown();
        }

        Type memberType = mapSymbolToType(member);
        annotate(node, memberType);
        return memberType;
    }

    @Override
    public Type visit(MemberArrayAccessExpressionNodeY node) {
        Type targetType = node.getTarget().accept(this);

        String arrayName = targetType.getCustomName();
        if (!targetType.isArray()) {
            if (!targetType.isUnknown()) {
                reportTypeError("", "El target del acceso por indice no es un arreglo", node);
            }
            return Type.unknown();
        }

        if (node.getIndex() != null) {
            Type indexType = node.getIndex().accept(this);
            if (!indexType.isNumeric() && !indexType.isUnknown()) {
                reportTypeError(arrayName, "El indice de un arreglo debe ser numerico", node);
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
    public Type visit(ArgumentsNodeY node) {
        if (node.getArguments() != null) {
            for (ExpressionNodeY arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return Type.voidType();
    }

    @Override
    public Type visit(TypeNodeY node) {
        return Type.unknown();
    }


    /**
     * Helper for resolve symbol
     *
     */
    private Type mapSymbolToType(Symbol symbol) {
        if (symbol == null) return Type.unknown();

        String typeName = symbol.getType();
        if (typeName == null) {
            return Type.unknown();
        }

        Type base = resolveTypeName(typeName);
        if (base == null) {
            return Type.unknown();
        }

        int dims = symbol.getDimensions();
        if (dims > 0) {
            return Type.arrayType(base, dims);
        }
        return base;
    }


    /**
     * Helper to resolve typename
     *
     */
    private Type resolveTypeName(String typeName) {
        if (typeName == null) return Type.unknown();
        return switch (typeName) {
            case "entero" -> Type.intType();
            case "flotante" -> Type.floatType();
            case "cadena" -> Type.stringType();
            case "caracter" -> Type.charType();
            case "bool" -> Type.booleanType();
            default -> Type.customType(typeName);
        };
    }

    /**
     * Helper to report a new error
     *
     */
    private void reportTypeError(String lexeme, String description, YAstNode node) {
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


    /**
     * Inferrer helper method
     *
     */

    private Type inferBinaryType(Type left, Type right, BinaryOperator op, BinaryExpressionNodeY node) {
        if (left.isUnknown() || right.isUnknown()) {
            return Type.unknown();
        }

        String opLexeme = op.toString();

        switch (op) {
            case PLUS:
                if (left.getKind() == TypeKind.STRING && right.getKind() == TypeKind.STRING) {
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

    /**
     * Principal mapper for data type
     *
     */
    private Type mapYDataType(YDataType dt, String customName) {
        if (dt == null) return Type.unknown();
        switch (dt) {
            case INT:
                return Type.intType();
            case FLOAT:
                return Type.floatType();
            case STRING:
                return Type.stringType();
            case CHAR:
                return Type.charType();
            case BOOLEAN:
                return Type.booleanType();
            case CUSTOM:
                return Type.customType(customName);
            default:
                return Type.unknown();
        }
    }

    /**
     * Helper for typenode
     *
     */
    private Type mapTypeNode(TypeNodeY typeNode) {
        if (typeNode == null) return Type.unknown();
        return mapYDataType(typeNode.getDataType(), typeNode.getCustomTypeName());
    }

    /**
     * Helper to find the struct symbol
     *
     */

    private Symbol findStructSymbol(String structName) {
        if (structName == null) return null;
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), structName);
        for (Symbol symbol : found) {
            if (symbol.getKind() == SymbolKind.STRUCT) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol findMemberInStruct(Type structType, String memberName) {
        if (structType == null || !structType.isCustom()) return null;
        if (memberName == null) return null;

        Symbol structSymbol = findStructSymbol(structType.getCustomName());
        if (structSymbol == null) return null;

        List<Symbol> members = structSymbol.getMembers();
        if (members == null) return null;

        for (Symbol member : members) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Method to verify if tis numeric
     *
     */
    private boolean isNumericOrPromotable(Type t) {
        if (t == null) return false;
        TypeKind k = t.getKind();
        return k == TypeKind.INT
                || k == TypeKind.FLOAT
                || k == TypeKind.CHAR
                || k == TypeKind.BOOLEAN;
    }

    /**
     * Helper to promote the numeric expressions
     *
     */
    private Type promoteNumeric(Type a, Type b) {
        if (a.getKind() == TypeKind.FLOAT || b.getKind() == TypeKind.FLOAT) {
            return Type.floatType();
        }
        return Type.intType();
    }
}