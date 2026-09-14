package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This is the principal struct literal expression, the list objects of expression
@Getter
@Setter
public class StructLiteralExpressionNodeY extends ExpressionNodeY {
    private final List<StructPropertyNodeY> properties;

    public StructLiteralExpressionNodeY(int line, int column, List<StructPropertyNodeY> properties) {
        super(line, column);
        this.properties = properties;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}