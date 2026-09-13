package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal do while representation class
@Getter
public class DoWhileStatementNodeY extends StatementNodeY {
    private final ExpressionNodeY condion;
    private final List<YAstNode> body;

    public DoWhileStatementNodeY(int line, int column, List<YAstNode> body, ExpressionNodeY condion) {
        super(line, column);
        this.body = body;
        this.condion = condion;
    }


    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
