package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This is the principal class to represents a unary expression
@Getter
public class UnaryExpressionNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ expressionNode;
    private final UnaryOperator operator;

    public UnaryExpressionNodeZ(int line, int column, ExpressionNodeZ expressionNode, UnaryOperator operator) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.operator = operator;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
