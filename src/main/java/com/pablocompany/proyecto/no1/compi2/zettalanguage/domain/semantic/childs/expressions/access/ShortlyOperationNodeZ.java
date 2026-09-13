package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Class to represents a short operation
 *
 */
@Getter
public class ShortlyOperationNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ target;
    private final ExpressionNodeZ value;
    private final ShortlyOperator operator;

    public ShortlyOperationNodeZ(int line, int column,
                                 ExpressionNodeZ target,
                                 ExpressionNodeZ value,
                                 ShortlyOperator operator) {
        super(line, column);
        this.target = target;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}