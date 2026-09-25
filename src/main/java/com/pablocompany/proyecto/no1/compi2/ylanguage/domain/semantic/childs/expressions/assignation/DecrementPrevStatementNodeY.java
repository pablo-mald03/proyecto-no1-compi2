package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal to represents an abbreviated decrement operation
@Getter
public class DecrementPrevStatementNodeY extends StatementNodeY {
    private final ExpressionNodeY targetVariable;
    private final AbreviationOperator abreviationOperator;

    public DecrementPrevStatementNodeY(int line, int column, AbreviationOperator abreviationOperator, ExpressionNodeY targetVariable) {
        super(line, column);
        this.abreviationOperator = abreviationOperator;
        this.targetVariable = targetVariable;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
