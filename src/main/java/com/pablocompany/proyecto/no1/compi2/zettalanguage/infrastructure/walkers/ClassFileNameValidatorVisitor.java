package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
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
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Validates that the declared class name matches the file name in .z files.
 * Rule: file "Persona.z" must declare class "Persona".
 */
@Getter
public class ClassFileNameValidatorVisitor implements ZAstVisitor<Void> {

    private final String fileName;
    private final String filePath;
    private final List<CompilerError> errors;

    public ClassFileNameValidatorVisitor(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.errors = new ArrayList<>();
    }


    @Override
    public Void visit(ProgramNodeZ node) {
        if (node.getClassNode() != null) {
            ClassDeclarationNodeZ classNode = node.getClassNode();
            classNode.accept(this);

        }
        return null;
    }

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        String className = node.getClassName();
        String expectedFileName = className + ".z";

        if (!expectedFileName.equals(fileName)) {
            CompilerError error = new CompilerError();
            error.setLexeme(className);
            error.setLine(node.getLine());
            error.setColumn(node.getColumn());
            error.setErrorType(ErrorType.SEMANTIC);
            error.setDescription(
                    "El nombre de la clase '" + className +
                            "' no coincide con el nombre del archivo '" + fileName + "'"
            );
            error.setFilePath(filePath);
            error.setFileName(fileName);
            errors.add(error);
        }

        return null;
    }

    @Override
    public Void visit(CodeBodyNodeZ node) {
        return null;
    }

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        return null;
    }

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeZ node) {
        return null;
    }
    
    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeZ node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        return null;
    }


    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IfStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        return null;
    }
    

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        return null;
    }

}