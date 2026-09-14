package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents an initial expression values of an array
@Getter
public class ArrayInitExpressionNodeZ extends ExpressionNodeZ {

    private final List<ExpressionNodeZ> elements;

    public ArrayInitExpressionNodeZ(int line, int column, List<ExpressionNodeZ> elements) {
        super(line, column);
        this.elements = elements;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
