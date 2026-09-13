package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.enums.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal to represents an abreaviated decrement operation
@Getter
public class DecrementPrevStatementNodeY extends ExpressionNodeY {
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
