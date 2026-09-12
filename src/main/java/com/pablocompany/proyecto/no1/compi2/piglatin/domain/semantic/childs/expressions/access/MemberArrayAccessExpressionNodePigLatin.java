package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents the acess to an array nested value
@Getter
public class MemberArrayAccessExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final ExpressionNodePigLatin target;
    private final ExpressionNodePigLatin index;

    public MemberArrayAccessExpressionNodePigLatin(int line, int column, ExpressionNodePigLatin index, ExpressionNodePigLatin target) {
        super(line, column);
        this.index = index;
        this.target = target;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
