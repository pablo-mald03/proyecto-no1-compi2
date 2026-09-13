package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Class to represent the updata node when the loop for is assignated
 *
 */
@Getter
public class ForUpdateNodeZ extends ZAstNode {

    private final ExpressionNodeZ target;
    private final ExpressionNodeZ value;
    private final ForUpdateOperator operator;

    public ForUpdateNodeZ(int line, int column, ExpressionNodeZ target, ExpressionNodeZ value, ForUpdateOperator operator) {
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