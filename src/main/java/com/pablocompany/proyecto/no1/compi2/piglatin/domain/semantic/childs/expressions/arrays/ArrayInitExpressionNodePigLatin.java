package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents an initial expression values of an array
@Getter
public class ArrayInitExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final List<ExpressionNodePigLatin> elements;

    public ArrayInitExpressionNodePigLatin(int line, int column, List<ExpressionNodePigLatin> elements) {
        super(line, column);
        this.elements = elements;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
