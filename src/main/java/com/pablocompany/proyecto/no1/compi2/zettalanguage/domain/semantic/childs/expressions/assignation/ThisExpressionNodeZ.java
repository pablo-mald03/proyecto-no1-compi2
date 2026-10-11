package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

/**
 * Node to represents this pointer
 *
 */
@Getter
public class ThisExpressionNodeZ extends ExpressionNodeZ {

    @Setter
    private String enclosingClass;

    public ThisExpressionNodeZ(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
