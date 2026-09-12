package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNodePigLatin extends PigLatinAstNode {

    private final ExpressionNodePigLatin identifier;
    private final ExpressionNodePigLatin expressionNode;

    private final boolean isAccessProperty;

    //Is a normal assignation
    public VariableAssignmentNodePigLatin(int line, int column, ExpressionNodePigLatin expressionNode, ExpressionNodePigLatin identifier) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = false;
    }

    //Is an Assignment with properties
    public VariableAssignmentNodePigLatin(int line, int column, ExpressionNodePigLatin expressionNode, ExpressionNodePigLatin identifier, boolean isAccessProperty) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
