package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;

//This is the principal representation for a break statement
public class BreakStatementNodeY extends StatementNodeY {

    public BreakStatementNodeY(int line, int column) {
        super(line, column);
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
