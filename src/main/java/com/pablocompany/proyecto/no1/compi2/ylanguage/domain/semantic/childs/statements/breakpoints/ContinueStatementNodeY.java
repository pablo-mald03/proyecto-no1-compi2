package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;

//This is the principal continue representation
public class ContinueStatementNodeY extends StatementNodeY {

    public ContinueStatementNodeY(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
