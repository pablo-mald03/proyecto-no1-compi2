package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNodePigLatin extends StatementNodePigLatin {

    private final ExpressionNodePigLatin identifier;
    private final ExpressionNodePigLatin expressionNode;

    private final boolean isAccessProperty;

    public VariableAssignmentNodePigLatin(int line, int column, ExpressionNodePigLatin identifier, ExpressionNodePigLatin expressionNode, boolean isAccessProperty) {
        super(line, column);
        this.identifier = identifier;
        this.expressionNode = expressionNode;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
