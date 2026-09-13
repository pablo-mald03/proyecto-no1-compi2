package com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.VariableDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.BreakStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ContinueStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ReturnStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseBlockNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfListNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.IfStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions.FunctionDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions.ParameterNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions.ProcedureDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.PrintStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.ReadStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.MaiorSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesSectionNodePigLatin;

/**
 * This interface is the principal to generate the different compiler phases
 */
public interface PigLatinAstVisitor<T> {


    //======Top node values
    T visit(ProgramNodePigLatin node);

    T visit(BodyNodePigLatin node);

    T visit(CodeBodyNodePigLatin node);

    T visit(VariablesBodyNodePigLatin node);


    //=======Principal sections

    T visit(MaiorSectionNodePigLatin node);

    T visit(VariableAssignmentNodePigLatin node);


    //=======Variables
    T visit(VariableDeclarationNodePigLatin node);

    T visit(BinaryExpressionNodePigLatin node);

    T visit(TypeNodePigLatin node);

    T visit(UnaryExpressionNodePigLatin node);

    //=======Values

    T visit(LiteralExpressionNodePigLatin node);

    T visit(IdentifierExpressionNodePigLatin node);

    T visit(ArrayCallExpressionNodePigLatin node);

    T visit(FunctionCallExpressionNodePigLatin node);


    T visit(ArrayInitExpressionNodePigLatin node);

    T visit(ArrayDeclarationNodePigLatin node);

    //======Struct values and eclarations

    T visit(StructBodyNodePigLatin node);

    T visit(StructDeclarationNodePigLatin node);


    T visit(StructAttributeNodePigLatin node);

    T visit(StructPropertyNodePigLatin node);

    T visit(StructLiteralExpressionNodePigLatin node);

    T visit(StructInstanceNodePigLatin node);

    //Nested and properties

    T visit(PropertyAccessExpressionNodePigLatin node);

    T visit(MemberArrayAccessExpressionNodePigLatin node);

    T visit(VariablesSectionNodePigLatin node);

    T visit(ShortlyOperationNodePigLatin node);

    T visit(ExpressionNodePigLatin node);

    T visit(ImportNodePigLatin node);

    T visit(AccessorNodePigLatin node);

    T visit(ExpressionStatementNodePigLatin node);

    T visit(ElseIfListNodePigLatin node);

    //Abbreviation value variables
    T visit(IncrementStatementNodePigLatin node);

    T visit(DecrementStatementNodePigLatin node);

    //Abbreviation value variables
    T visit(IncrementPrevStatementNodePigLatin node);

    T visit(DecrementPrevStatementNodePigLatin node);

    //Conditionals
    T visit(IfStatementNodePigLatin node);

    T visit(ElseIfNodePigLatin node);

    T visit(ElseBlockNodePigLatin node);


    //Loops
    T visit(WhileStatementNodePigLatin node);

    T visit(DoWhileStatementNodePigLatin node);

    T visit(ForStatementNodePigLatin node);

    T visit(ForInitDeclarationNodePigLatin node);

    T visit(ForInitAssignmentNodePigLatin node);

    T visit(ForUpdateNodePigLatin node);


    //IO stetements
    T visit(PrintStatementNodePigLatin node);

    T visit(ReadStatementNodePigLatin node);


    //Break points control flux
    T visit(ReturnStatementNodePigLatin node);

    T visit(BreakStatementNodePigLatin node);

    T visit(ContinueStatementNodePigLatin node);

    //Functions
    T visit(FunctionDeclarationNodePigLatin node);

    T visit(ProcedureDeclarationNodePigLatin node);

    T visit(ArgumentsNodePigLatin node);

    T visit(ParameterNodePigLatin node);

}
