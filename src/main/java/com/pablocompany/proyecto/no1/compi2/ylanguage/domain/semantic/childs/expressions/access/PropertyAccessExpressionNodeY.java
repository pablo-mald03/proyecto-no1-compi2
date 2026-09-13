package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents an access property (or nested values)
@Getter
public class PropertyAccessExpressionNodeY extends ExpressionNodeY {

    private final ExpressionNodeY target;
    private final String propertyName;

    public PropertyAccessExpressionNodeY(int line, int column, ExpressionNodeY target, String propertyName) {
        super(line, column);
        this.target = target;
        this.propertyName = propertyName;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
