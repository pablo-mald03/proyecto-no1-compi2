package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class is the principal who represents an identifier expression
@Getter
@Setter
public class IdentifierExpressionNodeZ extends ExpressionNodeZ {

    private final String identifier;

    public IdentifierExpressionNodeZ(int line, int column, String identifier) {
        super(line, column);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
