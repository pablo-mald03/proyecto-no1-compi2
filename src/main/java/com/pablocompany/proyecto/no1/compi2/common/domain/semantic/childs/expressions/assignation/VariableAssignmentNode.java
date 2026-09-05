package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.assignation;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNode extends AstNode {

    private final ExpressionNode identifier;
    private final ExpressionNode expressionNode;

    private final boolean isAccessProperty;

    //Is a normal assignation
    public VariableAssignmentNode(int line, int column, ExpressionNode expressionNode, ExpressionNode identifier) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = false;
    }

    //Is an Assignment with properties
    public VariableAssignmentNode(int line, int column, ExpressionNode expressionNode, ExpressionNode identifier, boolean isAccessProperty) {
        super(line, column);
        this.expressionNode = expressionNode;
        this.identifier = identifier;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
