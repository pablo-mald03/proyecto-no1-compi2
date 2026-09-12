package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class is the principal who represents an identifier expression
@Getter
@Setter
public class IdentifierExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final String identifier;

    private TypeNodePigLatin inferredType;


    public IdentifierExpressionNodePigLatin(int line, int column, String identifier) {
        super(line, column);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
