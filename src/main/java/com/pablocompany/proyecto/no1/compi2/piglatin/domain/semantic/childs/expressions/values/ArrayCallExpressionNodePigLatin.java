package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents an array call
@Getter
@Setter
public class ArrayCallExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final String arrayName;
    private final ExpressionNodePigLatin indexExpression;

    private TypeNodePigLatin inferredType;

    //This property is used to disctinct if the arrayCall is an struct instance value
    private boolean isDeclaration;

    public ArrayCallExpressionNodePigLatin(int line, int column, String arrayName, ExpressionNodePigLatin indexExpression) {
        super(line, column);
        this.arrayName = arrayName;
        this.indexExpression = indexExpression;
        this.isDeclaration = false;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
