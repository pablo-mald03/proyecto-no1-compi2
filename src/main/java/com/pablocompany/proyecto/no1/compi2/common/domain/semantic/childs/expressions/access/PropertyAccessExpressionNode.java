package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.access;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This class represents an access property (or nested values)
@Getter
public class PropertyAccessExpressionNode extends ExpressionNode {

    private final ExpressionNode target;
    private final String propertyName;

    public PropertyAccessExpressionNode(int line, int column, ExpressionNode target, String propertyName) {
        super(line, column);
        this.target = target;
        this.propertyName = propertyName;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
