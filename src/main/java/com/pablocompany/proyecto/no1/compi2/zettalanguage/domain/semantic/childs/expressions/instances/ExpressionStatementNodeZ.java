package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Represents a statement that only evaluates an expression.
 */
@Getter
public class ExpressionStatementNodeZ extends StatementNodeZ {

    private final ExpressionNodeZ expression;

    public ExpressionStatementNodeZ(int line, int column, ExpressionNodeZ expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}