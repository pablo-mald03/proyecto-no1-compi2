package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.operators.enums.UnaryOperator;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This is the principal class to represents a unary expression
@Getter
public class UnaryExpressionNode extends ExpressionNode {

    private final ExpressionNode expressionNode;
    private final UnaryOperator operator;

    public UnaryExpressionNode(int line, int column, ExpressionNode expressionNode, UnaryOperator operator) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.operator = operator;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
