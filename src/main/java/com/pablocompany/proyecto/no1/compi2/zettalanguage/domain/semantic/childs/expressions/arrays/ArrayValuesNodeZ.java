package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Wrapper node that holds a list of expressions from an array literal.
 */
@Getter
public class ArrayValuesNodeZ extends ZAstNode {

    private final List<ExpressionNodeZ> values;

    public ArrayValuesNodeZ(int line, int column, List<ExpressionNodeZ> values) {
        super(line, column);
        this.values = values;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}