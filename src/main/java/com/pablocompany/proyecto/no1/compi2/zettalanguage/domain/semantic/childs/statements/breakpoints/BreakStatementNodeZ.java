package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;

//This is the principal representation for a break statement
public class BreakStatementNodeZ extends StatementNodeZ {

    public BreakStatementNodeZ(int line, int column) {
        super(line, column);
    }


    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
