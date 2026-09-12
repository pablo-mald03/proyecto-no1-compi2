package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents an access property (or nested values)
@Getter
public class PropertyAccessExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final ExpressionNodePigLatin target;
    private final String propertyName;

    public PropertyAccessExpressionNodePigLatin(int line, int column, ExpressionNodePigLatin target, String propertyName) {
        super(line, column);
        this.target = target;
        this.propertyName = propertyName;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
