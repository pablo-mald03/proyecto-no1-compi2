package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops.enums.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Class to represent the updata node when the loop for is assignated
 *
 */
@Getter
public class ForUpdateNodeY extends YAstNode {

    private final ExpressionNodeY target;
    private final ExpressionNodeY value;
    private final ForUpdateOperator operator;

    public ForUpdateNodeY(int line, int column,
                          ExpressionNodeY target,
                          ExpressionNodeY value,
                          ForUpdateOperator operator) {
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