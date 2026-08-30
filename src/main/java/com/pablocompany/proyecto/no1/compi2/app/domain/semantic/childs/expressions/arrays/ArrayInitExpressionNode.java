package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.arrays;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents an initial expression values of an array
@Getter
public class ArrayInitExpressionNode  extends ExpressionNode {

    private final List<ExpressionNode> elements;

    public ArrayInitExpressionNode(int line, int column, List<ExpressionNode> elements) {
        super(line, column);
        this.elements = elements;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
