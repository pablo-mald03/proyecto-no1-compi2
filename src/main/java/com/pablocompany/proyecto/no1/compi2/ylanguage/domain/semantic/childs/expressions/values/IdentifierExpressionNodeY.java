package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class is the principal who represents an identifier expression
@Getter
@Setter
public class IdentifierExpressionNodeY extends ExpressionNodeY {

    private final String identifier;

    public IdentifierExpressionNodeY(int line, int column, String identifier) {
        super(line, column);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
