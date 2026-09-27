package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNodeY extends StatementNodeY {
    private final ExpressionNodeY identifier;
    private final ExpressionNodeY expressionNode;

    private final boolean isAccessProperty;

    // Is a normal assignation
    public VariableAssignmentNodeY(int line, int column, ExpressionNodeY identifier, ExpressionNodeY expressionNode) {
        super(line, column);
        this.identifier = identifier;
        this.expressionNode = expressionNode;
        this.isAccessProperty = false;
    }

    // Is an Assignment with properties
    public VariableAssignmentNodeY(int line, int column, ExpressionNodeY identifier, ExpressionNodeY expressionNode, boolean isAccessProperty) {
        super(line, column);
        this.identifier = identifier;
        this.expressionNode = expressionNode;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
