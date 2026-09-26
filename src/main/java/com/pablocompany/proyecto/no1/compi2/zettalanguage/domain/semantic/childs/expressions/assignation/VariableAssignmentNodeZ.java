package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

@Getter
public class VariableAssignmentNodeZ extends StatementNodeZ {

    private final ExpressionNodeZ identifier;
    private final ExpressionNodeZ expressionNode;

    private final boolean isAccessProperty;

    //Is a normal assignation
    public VariableAssignmentNodeZ(int line, int column, ExpressionNodeZ identifier,       // ← target (LHS)
                                   ExpressionNodeZ expressionNode) { // ← value (RHS)
        super(line, column);
        this.identifier = identifier;
        this.expressionNode = expressionNode;
        this.isAccessProperty = false;
    }

    public VariableAssignmentNodeZ(int line, int column, ExpressionNodeZ identifier, ExpressionNodeZ expressionNode, boolean isAccessProperty) {
        super(line, column);
        this.identifier = identifier;
        this.expressionNode = expressionNode;
        this.isAccessProperty = isAccessProperty;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
