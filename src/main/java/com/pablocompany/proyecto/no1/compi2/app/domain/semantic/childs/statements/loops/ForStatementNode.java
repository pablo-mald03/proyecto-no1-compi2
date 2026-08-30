package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.loops;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal class to represents the for statement
@Getter
public class ForStatementNode extends StatementNode {
    private final AstNode init; //Could be a variabledeclaration or assingment node
    private final ExpressionNode condition;
    private final AstNode update; //Could be an assigment or incrementable variable
    private final List<AstNode> body;

    public ForStatementNode(int line, int column, List<AstNode> body, AstNode init, ExpressionNode condition, AstNode update) {
        super(line, column);
        this.body = body;
        this.init = init;
        this.condition = condition;
        this.update = update;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
