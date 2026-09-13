package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.imports.AccessorNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.imports.ImportNodeY;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ParameterNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ProcedureDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.BodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.CodeBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.MaiorSectionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.variables.VariablesBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.variables.VariablesSectionNodeY;

/**
 * This interface is the principal to generate the different compiler phases
 */
public interface YAstVisitor<T> {


    //======Top node values
    T visit(ProgramNodeY node);

    T visit(BodyNodeY node);

    T visit(CodeBodyNodeY node);

    T visit(VariablesBodyNodeY node);


    //=======Principal sections

    T visit(MaiorSectionNodeY node);

    T visit(VariableAssignmentNodeY node);


    //=======Variables
    T visit(VariableDeclarationNodeY node);

    T visit(BinaryExpressionNodeY node);

    T visit(TypeNodeY node);

    T visit(UnaryExpressionNodeY node);

    //=======Values

    T visit(LiteralExpressionNodeY node);

    T visit(IdentifierExpressionNodeY node);

    T visit(ArrayCallExpressionNodeY node);

    T visit(FunctionCallExpressionNodeY node);


    T visit(ArrayInitExpressionNodeY node);

    T visit(ArrayDeclarationNodeY node);

    //======Struct values and eclarations

    T visit(StructBodyNodeY node);

    T visit(StructDeclarationNodeY node);


    T visit(StructAttributeNodeY node);

    T visit(StructPropertyNodeY node);

    T visit(StructLiteralExpressionNodeY node);

    T visit(StructInstanceNodeY node);

    //Nested and properties

    T visit(PropertyAccessExpressionNodeY node);

    T visit(MemberArrayAccessExpressionNodeY node);

    T visit(VariablesSectionNodeY node);

    T visit(ShortlyOperationNodeY node);

    T visit(ExpressionNodeY node);

    T visit(ImportNodeY node);

    T visit(AccessorNodeY node);

    T visit(ExpressionStatementNodeY node);

    T visit(ElseIfListNodeY node);

    //Abbreviation value variables
    T visit(IncrementStatementNodeY node);

    T visit(DecrementStatementNodeY node);

    //Abbreviation value variables
    T visit(IncrementPrevStatementNodeY node);

    T visit(DecrementPrevStatementNodeY node);

    //Conditionals
    T visit(IfStatementNodeY node);

    T visit(ElseIfNodeY node);

    T visit(ElseBlockNodeY node);


    //Loops
    T visit(WhileStatementNodeY node);

    T visit(DoWhileStatementNodeY node);

    T visit(ForStatementNodeY node);

    T visit(ForInitDeclarationNodeY node);

    T visit(ForInitAssignmentNodeY node);

    T visit(ForUpdateNodeY node);

    T visit(FunctionDeclarationNodeY node);

    T visit(ProcedureDeclarationNodeY node);

    T visit(ParameterNodeY node);


    //IO statements
    T visit(PrintStatementNodeY node);

    T visit(ReadStatementNodeY node);


    //Break points control flux
    T visit(ReturnStatementNodeY node);

    T visit(BreakStatementNodeY node);

    T visit(ContinueStatementNodeY node);

    T visit(ArgumentsNodeY node);

}
