package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else if node
@Getter
public class ElseIfNode extends StatementNode {

    private final ExpressionNode condition;
    private final List<AstNode> body;

    public ElseIfNode(int line, int column, List<AstNode> body, ExpressionNode condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
