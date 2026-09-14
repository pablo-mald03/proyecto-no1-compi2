package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents an access property (or nested values)
@Getter
public class PropertyAccessExpressionNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ target;
    private final String propertyName;

    public PropertyAccessExpressionNodeZ(int line, int column, ExpressionNodeZ target, String propertyName) {
        super(line, column);
        this.target = target;
        this.propertyName = propertyName;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
