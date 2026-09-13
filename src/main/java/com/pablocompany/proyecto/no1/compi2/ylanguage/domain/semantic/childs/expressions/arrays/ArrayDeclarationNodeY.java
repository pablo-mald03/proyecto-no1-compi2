package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

@Getter
public class ArrayDeclarationNodeY extends StatementNodeY {

    private final String identifier;
    private final ExpressionNodeY size;
    private final TypeNodeY dataType;
    private final ArrayInitExpressionNodeY initializer;


    public ArrayDeclarationNodeY(int line, int column, TypeNodeY dataType, String identifier, ExpressionNodeY size, ArrayInitExpressionNodeY initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.size = size;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
