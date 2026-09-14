package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal array instance node
 *
 */
@Getter
public class ArrayInstantiationNodeZ extends ExpressionNodeZ {

    private final TypeNodeZ type;
    private final List<ExpressionNodeZ> dimensions;

    public ArrayInstantiationNodeZ(int line, int column, TypeNodeZ type, List<ExpressionNodeZ> dimensions) {
        super(line, column);
        this.type = type;
        this.dimensions = dimensions;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
