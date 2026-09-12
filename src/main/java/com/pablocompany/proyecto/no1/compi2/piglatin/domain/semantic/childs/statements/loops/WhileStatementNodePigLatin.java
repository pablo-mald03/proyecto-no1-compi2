package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal while statement representation
@Getter
public class WhileStatementNodePigLatin extends StatementNodePigLatin {

    private final ExpressionNodePigLatin condition;
    private final List<PigLatinAstNode> body;

    public WhileStatementNodePigLatin(int line, int column, List<PigLatinAstNode> body, ExpressionNodePigLatin condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
