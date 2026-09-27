package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class ArrayDeclarationNodePigLatin extends StatementNodePigLatin {

    private final String identifier;
    // order = declaration order [0]: 0 position
    private final List<ExpressionNodePigLatin> dimensions;
    private final TypeNodePigLatin dataType;                // BASE type (the element)
    private final ArrayInitExpressionNodePigLatin initializer;

    public ArrayDeclarationNodePigLatin(int line, int column, TypeNodePigLatin dataType, String identifier,
                                        List<ExpressionNodePigLatin> dimensions,
                                        ArrayInitExpressionNodePigLatin initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.dimensions = dimensions;
        this.initializer = initializer;
    }

    public int getDimensionCount() {
        return dimensions.size();
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}