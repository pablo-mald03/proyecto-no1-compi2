package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
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