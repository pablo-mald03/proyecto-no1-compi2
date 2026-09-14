package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal class to represents the for statement
@Getter
public class ForStatementNodePigLatin extends StatementNodePigLatin {
    private final PigLatinAstNode init; //Could be a variable declaration or assignment node
    private final ExpressionNodePigLatin condition;
    private final PigLatinAstNode update; //Could be an assigment or incrementable variable
    private final CodeBodyNodePigLatin body;

    public ForStatementNodePigLatin(int line, int column, CodeBodyNodePigLatin body, PigLatinAstNode init, ExpressionNodePigLatin condition, PigLatinAstNode update) {
        super(line, column);
        this.body = body;
        this.init = init;
        this.condition = condition;
        this.update = update;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
