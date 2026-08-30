package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This class is the principal representation of a literal
@Getter
public class LiteralExpressionNode extends ExpressionNode {

    private final String value;
    private final DataType valueType;

    //This is the original value of the literal
    private final Object dataValue;


    public LiteralExpressionNode(int line, int column, String value, DataType valueType,Object dataValue) {
        super(line, column);
        this.dataValue = dataValue;
        this.value = value;
        this.valueType = valueType;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
