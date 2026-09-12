package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.instances;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * Represents a statement that only evaluates an expression.
 */
@Getter
public class ExpressionStatementNodePigLatin extends StatementNodePigLatin {

    private final ExpressionNodePigLatin expression;

    public ExpressionStatementNodePigLatin(int line, int column, ExpressionNodePigLatin expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}