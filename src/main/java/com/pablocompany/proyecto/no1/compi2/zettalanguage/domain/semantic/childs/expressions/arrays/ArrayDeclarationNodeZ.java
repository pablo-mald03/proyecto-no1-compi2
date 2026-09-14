package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class ArrayDeclarationNodeZ extends StatementNodeZ {

    private final String identifier;
    private final TypeNodeZ dataType;
    private final List<ExpressionNodeZ> dimensions;
    private final ExpressionNodeY initializer;


    public ArrayDeclarationNodeZ(int line, int column, String identifier, TypeNodeZ dataType, List<ExpressionNodeZ> dimensions, ExpressionNodeY initializer) {
        super(line, column);
        this.identifier = identifier;
        this.dataType = dataType;
        this.dimensions = dimensions;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
