package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.breakpoints;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This is the principal class to represents a return node
@Getter
public class ReturnStatementNode extends StatementNode {
    private final ExpressionNode value; // could be null to return void

    public ReturnStatementNode(int line, int column, ExpressionNode value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
