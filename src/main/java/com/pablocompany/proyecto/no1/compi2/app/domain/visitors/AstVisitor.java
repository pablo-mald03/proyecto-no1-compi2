package com.pablocompany.practica.no1.compi2.domain.visitors;

import com.pablocompany.practica.no1.compi2.domain.semantic.ProgramNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.access.PropertyAccessExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.arrays.ArrayDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.StructInstanceNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.declaration.StructAttributeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.properties.StructPropertyNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values.ArrayCallExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values.FunctionCallExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values.IdentifierExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values.LiteralExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.VariableDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.breakpoints.BreakStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.breakpoints.ContinueStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.breakpoints.ReturnStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals.ElseBlockNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals.ElseIfNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals.IfStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.functions.FunctionDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.functions.ParameterNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.functions.ProcedureDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.iostreams.PrintStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.iostreams.ReadStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.loops.DoWhileStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.loops.ForStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.loops.WhileStatementNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.BodyNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.principals.MaiorSectionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.principals.MuneraSectionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.principals.VariablesSectionNode;

//This interface is the principal to generate the diferent compiler phases
public interface AstVisitor<T> {


    //======Top node values
    T visit(ProgramNode node);

    T visit(BodyNode node);


    //=======Principal sections
    T visit(MuneraSectionNode node);

    T visit(MaiorSectionNode node);

    T visit(VariableAssignmentNode node);


    //=======Variables
    T visit(VariableDeclarationNode node);

    T visit(BinaryExpressionNode node);

    T visit(TypeNode node);

    T visit(UnaryExpressionNode node);

    //=======Values

    T visit(LiteralExpressionNode node);

    T visit(IdentifierExpressionNode node);

    T visit(ArrayCallExpressionNode node);

    T visit(FunctionCallExpressionNode node);


    T visit(ArrayInitExpressionNode node);

    T visit(ArrayDeclarationNode node);

    //======Struct values and eclarations

    T visit(StructDeclarationNode node);

    T visit(StructAttributeNode node);

    T visit(StructPropertyNode node);

    T visit(StructLiteralExpressionNode node);

    T visit(StructInstanceNode node);

    //Nested and properties

    T visit(PropertyAccessExpressionNode node);

    T visit(MemberArrayAccessExpressionNode node);

    T visit(VariablesSectionNode node);


    //Abbreviation value variables
    T visit(IncrementStatementNode node);

    T visit(DecrementStatementNode node);

    //Abbreviation value variables
    T visit(IncrementPrevStatementNode node);

    T visit(DecrementPrevStatementNode node);

    //Conditionals
    T visit(IfStatementNode node);

    T visit(ElseIfNode node);

    T visit(ElseBlockNode node);


    //Loops
    T visit(WhileStatementNode node);

    T visit(DoWhileStatementNode node);

    T visit(ForStatementNode node);

    //IO stetements
    T visit(PrintStatementNode node);

    T visit(ReadStatementNode node);


    //Break points control flux
    T visit(ReturnStatementNode node);

    T visit(BreakStatementNode node);

    T visit(ContinueStatementNode node);

    //Functions
    T visit(FunctionDeclarationNode node);

    T visit(ProcedureDeclarationNode node);

    T visit(ParameterNode node);

}
