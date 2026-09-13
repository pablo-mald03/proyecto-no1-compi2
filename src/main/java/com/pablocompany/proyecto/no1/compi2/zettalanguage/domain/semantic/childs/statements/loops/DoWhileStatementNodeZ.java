package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal do while representation class
@Getter
public class DoWhileStatementNodeZ extends StatementNodeZ {
    private final ExpressionNodeZ condion;
    private final List<ZAstNode> body;


    public DoWhileStatementNodeZ(int line, int column, ExpressionNodeZ condion, List<ZAstNode> body) {
        super(line, column);
        this.condion = condion;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
