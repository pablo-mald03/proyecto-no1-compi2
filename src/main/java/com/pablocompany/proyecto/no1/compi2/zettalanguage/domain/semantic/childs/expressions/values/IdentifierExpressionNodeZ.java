package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class is the principal who represents an identifier expression
@Getter
@Setter
public class IdentifierExpressionNodeZ extends ExpressionNodeY {

    private final String identifier;

    public IdentifierExpressionNodeZ(int line, int column, String identifier) {
        super(line, column);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
