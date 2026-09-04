package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.loops;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal do while respresentation class
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
