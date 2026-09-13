package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class is the principal to represents an abreaviated decrement operation
@Getter
public class DecrementPrevStatementNodeZ extends ExpressionNodeZ {
    private final ExpressionNodeZ targetVariable;
    private final AbreviationOperator abreviationOperator;

    public DecrementPrevStatementNodeZ(int line, int column, AbreviationOperator abreviationOperator, ExpressionNodeZ targetVariable) {
        super(line, column);
        this.abreviationOperator = abreviationOperator;
        this.targetVariable = targetVariable;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
