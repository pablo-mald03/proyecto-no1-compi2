package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents an array call
@Getter
@Setter
public class ArrayCallExpressionNode extends ExpressionNode {

    private final String arrayName;
    private final ExpressionNode indexExpression;

    private TypeNode inferredType;

    //This property is used to disctinct if the arrayCall is an struct instance value
    private boolean isDeclaration;

    public ArrayCallExpressionNode(int line, int column, String arrayName, ExpressionNode indexExpression) {
        super(line, column);
        this.arrayName = arrayName;
        this.indexExpression = indexExpression;
        this.isDeclaration = false;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
