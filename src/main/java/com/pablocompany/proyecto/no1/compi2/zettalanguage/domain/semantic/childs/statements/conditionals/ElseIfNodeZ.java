package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else if node
@Getter
public class ElseIfNodeZ extends StatementNodeZ {

    private final ExpressionNodeZ condition;
    private final List<ZAstNode> body;

    public ElseIfNodeZ(int line, int column, ExpressionNodeZ condition, List<ZAstNode> body) {
        super(line, column);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
