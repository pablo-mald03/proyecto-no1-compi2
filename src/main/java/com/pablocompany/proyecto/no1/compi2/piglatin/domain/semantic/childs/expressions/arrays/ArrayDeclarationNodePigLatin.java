package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

@Getter
public class ArrayDeclarationNodePigLatin extends StatementNodePigLatin {

    private final String identifier;
    private final ExpressionNodePigLatin size;
    private final TypeNodePigLatin dataType;
    private final ArrayInitExpressionNodePigLatin initializer;


    public ArrayDeclarationNodePigLatin(int line, int column, TypeNodePigLatin dataType, String identifier, ExpressionNodePigLatin size, ArrayInitExpressionNodePigLatin initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.size = size;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
