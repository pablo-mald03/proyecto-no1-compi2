package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.instances;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Represents a statement that only evaluates an expression.
 */
@Getter
public class ExpressionStatementNodeY extends StatementNodeY {

    private final ExpressionNodeY expression;

    public ExpressionStatementNodeY(int line, int column, ExpressionNodeY expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}