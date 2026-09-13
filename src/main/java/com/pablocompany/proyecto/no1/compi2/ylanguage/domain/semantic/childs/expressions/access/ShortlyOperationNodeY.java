package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.enums.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Class to represents a short operation
 *
 */
@Getter
public class ShortlyOperationNodeY extends ExpressionNodeY {

    private final ExpressionNodeY target;
    private final ExpressionNodeY value;
    private final ShortlyOperator operator;

    public ShortlyOperationNodeY(int line, int column,
                                 ExpressionNodeY target,
                                 ExpressionNodeY value,
                                 ShortlyOperator operator) {
        super(line, column);
        this.target = target;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}