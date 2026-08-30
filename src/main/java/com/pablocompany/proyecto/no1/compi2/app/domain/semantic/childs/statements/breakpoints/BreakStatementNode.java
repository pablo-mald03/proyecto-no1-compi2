package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.breakpoints;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;


//This is the principal representation for a break statement
public class BreakStatementNode extends StatementNode {

    public BreakStatementNode(int line, int column) {
        super(line, column);
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
