package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNodeY extends YAstNode {

    private final ExpressionNodeY identifier;
    private final ExpressionNodeY expressionNode;

    private final boolean isAccessProperty;

    //Is a normal assignation
    public VariableAssignmentNodeY(int line, int column, ExpressionNodeY expressionNode, ExpressionNodeY identifier) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = false;
    }

    //Is an Assignment with properties
    public VariableAssignmentNodeY(int line, int column, ExpressionNodeY expressionNode, ExpressionNodeY identifier, boolean isAccessProperty) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
