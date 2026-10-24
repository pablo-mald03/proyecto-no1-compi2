package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

/**
 * Principal super expression node class
 *
 */
@Getter
public class SuperExpressionNodeZ extends ExpressionNodeZ {

    /**
     * Class where the super statement is declared.
     */
    @Setter
    private String enclosingClass;

    /**
     * Parent class
     */
    @Setter
    private String parentClass;

    public SuperExpressionNodeZ(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}