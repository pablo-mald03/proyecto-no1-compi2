package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class is the principal representation of an operation expression
@Getter
public class BinaryExpressionNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ left;
    private final ExpressionNodeZ right;
    private final BinaryOperator operator;

    public BinaryExpressionNodeZ(int line, int column, ExpressionNodeZ left, ExpressionNodeZ right, BinaryOperator operator) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
