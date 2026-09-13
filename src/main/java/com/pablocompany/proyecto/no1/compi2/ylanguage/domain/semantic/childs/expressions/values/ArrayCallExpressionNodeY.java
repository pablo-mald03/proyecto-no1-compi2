package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents an array call
@Getter
@Setter
public class ArrayCallExpressionNodeY extends ExpressionNodeY {

    private final String arrayName;
    private final ExpressionNodeY indexExpression;

    private TypeNodeY inferredType;

    //This property is used to disctinct if the arrayCall is an struct instance value
    private boolean isDeclaration;

    public ArrayCallExpressionNodeY(int line, int column, String arrayName, ExpressionNodeY indexExpression) {
        super(line, column);
        this.arrayName = arrayName;
        this.indexExpression = indexExpression;
        this.isDeclaration = false;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
