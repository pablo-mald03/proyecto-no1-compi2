package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.functions.FunctionsRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.StructuresRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;

/**
 * Principal visitor implementation for all methods but can help the code generation
 *
 */
public class YNoOperatorVisitor implements YAstVisitor<Void> {
    @Override
    public Void visit(ProgramNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(IfStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(PrimitiveParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        return null;
    }
}
