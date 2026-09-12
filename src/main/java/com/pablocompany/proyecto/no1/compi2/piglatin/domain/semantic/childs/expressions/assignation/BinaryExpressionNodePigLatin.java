package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.operators.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class is the principal representation of an operation expression
@Getter
public class BinaryExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final ExpressionNodePigLatin left;
    private final ExpressionNodePigLatin right;
    private final BinaryOperator operator;

    public BinaryExpressionNodePigLatin(int line, int column, ExpressionNodePigLatin left, ExpressionNodePigLatin right, BinaryOperator operator) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
