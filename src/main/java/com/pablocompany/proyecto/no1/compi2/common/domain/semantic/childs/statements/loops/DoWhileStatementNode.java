package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.ExpressionNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal do while representation class
@Getter
public class DoWhileStatementNode extends StatementNode {
    private final ExpressionNode condion;
    private final List<AstNode> body;

    public DoWhileStatementNode(int line, int column, List<AstNode> body, ExpressionNode condion) {
        super(line, column);
        this.body = body;
        this.condion = condion;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
