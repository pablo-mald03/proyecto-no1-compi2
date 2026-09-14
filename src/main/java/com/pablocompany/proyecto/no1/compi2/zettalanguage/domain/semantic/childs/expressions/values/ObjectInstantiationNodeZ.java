package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to define the object instance
 *
 */
@Getter
public class ObjectInstantiationNodeZ extends ExpressionNodeZ {
    private final TypeNodeZ type;

    private final List<ExpressionNodeZ> arguments;

    public ObjectInstantiationNodeZ(int line, int column, TypeNodeZ type, List<ExpressionNodeZ> arguments) {
        super(line, column);
        this.type = type;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
