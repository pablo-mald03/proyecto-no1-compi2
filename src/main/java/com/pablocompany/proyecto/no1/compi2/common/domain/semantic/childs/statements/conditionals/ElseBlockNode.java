package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else block node
@Getter
public class ElseBlockNode extends StatementNode {
    private final List<AstNode> body;

    public ElseBlockNode(int line, int column, List<AstNode> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}