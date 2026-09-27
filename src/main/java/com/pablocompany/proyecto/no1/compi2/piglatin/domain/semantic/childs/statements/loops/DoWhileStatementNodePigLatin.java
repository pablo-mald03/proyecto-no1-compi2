package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal do while representation class
@Getter
public class DoWhileStatementNodePigLatin extends StatementNodePigLatin {
    private final ExpressionNodePigLatin condition;
    private final CodeBodyNodePigLatin body;

    public DoWhileStatementNodePigLatin(int line, int column, CodeBodyNodePigLatin body, ExpressionNodePigLatin condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
