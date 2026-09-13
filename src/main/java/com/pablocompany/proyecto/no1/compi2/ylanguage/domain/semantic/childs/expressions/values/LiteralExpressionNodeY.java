package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal representation of a literal
@Getter
public class LiteralExpressionNodeY extends ExpressionNodeY {

    private final DataType valueType;

    //This is the original value of the literal
    private final Object dataValue;


    public LiteralExpressionNodeY(int line, int column, DataType valueType, Object dataValue) {
        super(line, column);
        this.dataValue = dataValue;
        this.valueType = valueType;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
