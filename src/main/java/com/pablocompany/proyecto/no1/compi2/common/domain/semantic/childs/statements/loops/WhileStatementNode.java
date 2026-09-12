package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.ExpressionNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal while statement representation
@Getter
public class WhileStatementNode extends StatementNode {

    private final ExpressionNode condition;
    private final List<AstNode> body;

    public WhileStatementNode(int line, int column, List<AstNode> body, ExpressionNode condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
