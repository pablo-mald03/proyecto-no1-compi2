package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.operators.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal class to represents a unary expression
@Getter
public class UnaryExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final ExpressionNodePigLatin expressionNode;
    private final UnaryOperator operator;

    public UnaryExpressionNodePigLatin(int line, int column, ExpressionNodePigLatin expressionNode, UnaryOperator operator) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.operator = operator;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
