package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.operators.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal representation of an operation expression
@Getter
public class BinaryExpressionNodeY extends ExpressionNodeY {

    private final ExpressionNodeY left;
    private final ExpressionNodeY right;
    private final BinaryOperator operator;

    public BinaryExpressionNodeY(int line, int column, ExpressionNodeY left, ExpressionNodeY right, BinaryOperator operator) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
