package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Class to manage the init assignment node
 *
 */
@Getter
public class ForInitAssignmentNodeY extends StatementNodeY {


    private final String id;
    private final ExpressionNodeY expr;

    public ForInitAssignmentNodeY(int line, int column, String id, ExpressionNodeY expr) {
        super(line, column);
        this.id = id;
        this.expr = expr;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
