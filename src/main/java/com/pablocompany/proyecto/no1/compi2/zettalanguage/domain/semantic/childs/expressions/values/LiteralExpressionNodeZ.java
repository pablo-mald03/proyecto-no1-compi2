package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.ZDataType;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class is the principal representation of a literal
@Getter
public class LiteralExpressionNodeZ extends ExpressionNodeZ {

    private final ZDataType valueType;

    //This is the original value of the literal
    private final Object dataValue;

    public LiteralExpressionNodeZ(int line, int column, ZDataType valueType, Object dataValue) {
        super(line, column);
        this.valueType = valueType;
        this.dataValue = dataValue;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
