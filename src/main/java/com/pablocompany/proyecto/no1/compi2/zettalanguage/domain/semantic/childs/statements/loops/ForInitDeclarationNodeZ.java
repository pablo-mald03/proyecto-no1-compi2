package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Principal class to define the for init representation
 *
 */
@Getter
public class ForInitDeclarationNodeZ extends StatementNodeZ {

    private final String id;
    private final TypeNodeZ type;
    private final ExpressionNodeZ expr;

    public ForInitDeclarationNodeZ(int line, int column, String id, TypeNodeZ type, ExpressionNodeZ expr) {
        super(line, column);
        this.id = id;
        this.type = type;
        this.expr = expr;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
