package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * Class to manage the init assignment node
 * */
@Getter
public class ForInitAssignmentNodePigLatin extends StatementNodePigLatin {


    private final String id;
    private final ExpressionNodePigLatin expr;

    public ForInitAssignmentNodePigLatin(int line, int column, String id, ExpressionNodePigLatin expr) {
        super(line, column);
        this.id = id;
        this.expr = expr;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
