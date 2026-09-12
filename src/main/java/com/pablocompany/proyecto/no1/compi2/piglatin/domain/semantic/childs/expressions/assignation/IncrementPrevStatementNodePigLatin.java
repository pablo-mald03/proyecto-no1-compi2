package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.enums.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class is the principal to represents an increment operation
@Getter
public class IncrementPrevStatementNodePigLatin extends ExpressionNodePigLatin {
    private final ExpressionNodePigLatin targetVariable;
    private final AbreviationOperator abreviationOperator;

    public IncrementPrevStatementNodePigLatin(int line, int column, AbreviationOperator abreviationOperator, ExpressionNodePigLatin targetVariable) {
        super(line, column);
        this.abreviationOperator = abreviationOperator;
        this.targetVariable = targetVariable;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
