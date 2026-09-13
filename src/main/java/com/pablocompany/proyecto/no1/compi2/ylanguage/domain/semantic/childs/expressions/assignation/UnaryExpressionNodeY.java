package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.operators.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal class to represents a unary expression
@Getter
public class UnaryExpressionNodeY extends ExpressionNodeY {

    private final ExpressionNodeY expressionNode;
    private final UnaryOperator operator;

    public UnaryExpressionNodeY(int line, int column, ExpressionNodeY expressionNode, UnaryOperator operator) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.operator = operator;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
