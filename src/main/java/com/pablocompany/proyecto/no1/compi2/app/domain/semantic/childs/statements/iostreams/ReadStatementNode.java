package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.iostreams;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This is the principal read statement node
@Getter
public class ReadStatementNode extends StatementNode {

    private final ExpressionNode target;

    public ReadStatementNode(int line, int column, ExpressionNode target) {
        super(line, column);
        this.target = target;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
