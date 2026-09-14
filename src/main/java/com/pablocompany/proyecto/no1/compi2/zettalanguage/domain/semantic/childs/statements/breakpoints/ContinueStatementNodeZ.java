package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;

//This is the principal continue representation
public class ContinueStatementNodeZ extends StatementNodeZ {

    public ContinueStatementNodeZ(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
