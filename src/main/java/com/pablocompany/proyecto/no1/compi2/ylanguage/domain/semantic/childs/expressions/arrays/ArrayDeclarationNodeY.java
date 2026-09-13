package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class ArrayDeclarationNodeY extends StatementNodeY {

    private final String identifier;
    private final TypeNodeY dataType;
    private final List<ExpressionNodeY> dimensions;
    private final ExpressionNodeY initializer;


    public ArrayDeclarationNodeY(int line, int column, String identifier, TypeNodeY dataType, List<ExpressionNodeY> dimensions, ExpressionNodeY initializer) {
        super(line, column);
        this.identifier = identifier;
        this.dataType = dataType;
        this.dimensions = dimensions;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
