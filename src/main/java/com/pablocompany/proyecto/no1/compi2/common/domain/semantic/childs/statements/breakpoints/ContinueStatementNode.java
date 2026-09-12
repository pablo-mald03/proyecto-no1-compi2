package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;

//This is the principal continue representation
public class ContinueStatementNode extends StatementNode {

    public ContinueStatementNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
