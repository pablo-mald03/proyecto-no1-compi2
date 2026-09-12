package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This is the principal struct literal expression, the list objects of expression
@Getter
@Setter
public class StructLiteralExpressionNodePigLatin extends ExpressionNodePigLatin {
    private final List<StructPropertyNodePigLatin> properties;

    public StructLiteralExpressionNodePigLatin(int line, int column, List<StructPropertyNodePigLatin> properties) {
        super(line, column);
        this.properties = properties;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}