package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Class to manage the init assignment node
 *
 */
@Getter
public class ForInitAssignmentNodeZ extends StatementNodeZ {


    private final ExpressionNodeZ id;
    private final ExpressionNodeZ expr;

    public ForInitAssignmentNodeZ(int line, int column, ExpressionNodeZ id, ExpressionNodeZ expr) {
        super(line, column);
        this.id = id;
        this.expr = expr;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
