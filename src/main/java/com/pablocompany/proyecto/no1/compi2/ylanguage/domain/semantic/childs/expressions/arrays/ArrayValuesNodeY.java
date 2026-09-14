package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Wrapper node that holds a list of expressions from an array literal.
 */
@Getter
public class ArrayValuesNodeY extends YAstNode {

    private final List<ExpressionNodeY> values;

    public ArrayValuesNodeY(int line, int column, List<ExpressionNodeY> values) {
        super(line, column);
        this.values = values;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}