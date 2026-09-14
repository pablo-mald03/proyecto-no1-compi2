package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Principal class to define the for init representation
 *
 */
@Getter
public class ForInitDeclarationNodeY extends StatementNodeY {

    private final String id;
    private final TypeNodeY type;
    private final ExpressionNodeY expr;

    public ForInitDeclarationNodeY(int line, int column, String id, TypeNodeY type, ExpressionNodeY expr) {
        super(line, column);
        this.id = id;
        this.type = type;
        this.expr = expr;
    }

    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
