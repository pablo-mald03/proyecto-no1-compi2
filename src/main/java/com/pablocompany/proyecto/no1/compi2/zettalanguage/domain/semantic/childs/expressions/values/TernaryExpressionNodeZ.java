package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Principal ternary expression node
 *
 */
@Getter
public class TernaryExpressionNodeZ extends ExpressionNodeZ {


    private final ExpressionNodeZ condition;
    private final ExpressionNodeZ thenExpr;
    private final ExpressionNodeZ elseExpr;

    public TernaryExpressionNodeZ(int line, int column, ExpressionNodeZ condition, ExpressionNodeZ thenExpr, ExpressionNodeZ elseExpr) {
        super(line, column);
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }


    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
