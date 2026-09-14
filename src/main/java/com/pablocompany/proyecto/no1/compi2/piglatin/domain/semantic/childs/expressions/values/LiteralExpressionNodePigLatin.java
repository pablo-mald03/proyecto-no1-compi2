package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class is the principal representation of a literal
@Getter
public class LiteralExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final DataType valueType;

    //This is the original value of the literal
    private final Object dataValue;


    public LiteralExpressionNodePigLatin(int line, int column, DataType valueType, Object dataValue) {
        super(line, column);
        this.dataValue = dataValue;
        this.valueType = valueType;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
