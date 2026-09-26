package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeZ;
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

/**
 * This interface is the principal to generate the different compiler phases
 */
public interface ZAstVisitor<T> {


    //======Top node values
    T visit(ProgramNodeZ node);
    
    T visit(CodeBodyNodeZ node);


    T visit(MethodDeclarationNodeZ node);

    T visit(ConstructorDeclarationNodeZ node);

    T visit(ObjectInstantiationNodeZ node);

    T visit(ArrayInstantiationNodeZ node);

    T visit(TernaryExpressionNodeZ node);


    //=======Principal sections

    T visit(VariableAssignmentNodeZ node);


    //=======Variables
    T visit(VariableDeclarationNodeZ node);

    T visit(BinaryExpressionNodeZ node);

    T visit(TypeNodeZ node);

    T visit(UnaryExpressionNodeZ node);

    //=======Values

    T visit(LiteralExpressionNodeZ node);

    T visit(IdentifierExpressionNodeZ node);

    T visit(FunctionCallExpressionNodeZ node);


    T visit(ArrayInitExpressionNodeZ node);

    T visit(ArrayDeclarationNodeZ node);

    T visit(ArrayValuesNodeZ node);


    //Nested and properties

    T visit(PropertyAccessExpressionNodeZ node);

    T visit(MemberArrayAccessExpressionNodeZ node);

    T visit(ClassDeclarationNodeZ node);

    T visit(ShortlyOperationNodeZ node);

    T visit(ExpressionNodeZ node);


    T visit(ExpressionStatementNodeZ node);

    T visit(ElseIfListNodeZ node);

    //Abbreviation value variables
    T visit(IncrementStatementNodeZ node);

    T visit(DecrementStatementNodeZ node);

    //Abbreviation value variables
    T visit(IncrementPrevStatementNodeZ node);

    T visit(DecrementPrevStatementNodeZ node);

    //Conditionals
    T visit(IfStatementNodeZ node);

    T visit(ElseIfNodeZ node);

    T visit(ElseBlockNodeZ node);

    //Switch

    T visit(SwitchStatementNodeZ node);

    T visit(SwitchCaseNodeZ node);

    T visit(DefaultCaseNodeZ node);


    //Loops
    T visit(WhileStatementNodeZ node);

    T visit(DoWhileStatementNodeZ node);

    T visit(ForStatementNodeZ node);

    T visit(ForInitDeclarationNodeZ node);

    T visit(ForInitAssignmentNodeZ node);

    T visit(ForUpdateNodeZ node);
    
    T visit(ParameterNodeZ node);


    //IO statements
    T visit(PrintStatementNodeZ node);

    T visit(ReadStatementNodeZ node);


    //Break points control flux
    T visit(ReturnStatementNodeZ node);

    T visit(BreakStatementNodeZ node);

    T visit(ContinueStatementNodeZ node);

    T visit(ArgumentsNodeZ node);

}
