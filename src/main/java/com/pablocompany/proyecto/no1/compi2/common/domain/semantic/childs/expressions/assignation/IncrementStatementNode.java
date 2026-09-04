package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation.enums.AbreviationOperator;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This class is the principal to represents an increment operation
@Getter
public class IncrementStatementNode extends ExpressionNode {
    private final ExpressionNode targetVariable;
    private final AbreviationOperator abreviationOperator;

    public IncrementStatementNode(int line, int column, AbreviationOperator abreviationOperator, ExpressionNode targetVariable) {
        super(line, column);
        this.abreviationOperator = abreviationOperator;
        this.targetVariable = targetVariable;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
