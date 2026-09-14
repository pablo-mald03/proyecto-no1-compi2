package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents an initial expression values of an array
@Getter
public class ArrayInitExpressionNodeY extends ExpressionNodeY {

    private final List<ExpressionNodeY> elements;

    public ArrayInitExpressionNodeY(int line, int column, List<ExpressionNodeY> elements) {
        super(line, column);
        this.elements = elements;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
