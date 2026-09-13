package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This is the principal struct literal expression, the list objects of expression
@Getter
@Setter
public class StructLiteralExpressionNodeZ extends ExpressionNodeZ {
    private final List<StructPropertyNodeZ> properties;

    public StructLiteralExpressionNodeZ(int line, int column, List<StructPropertyNodeZ> properties) {
        super(line, column);
        this.properties = properties;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}