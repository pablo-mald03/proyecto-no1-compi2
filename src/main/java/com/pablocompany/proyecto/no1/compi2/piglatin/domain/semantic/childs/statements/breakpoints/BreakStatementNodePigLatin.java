package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;

//This is the principal representation for a break statement
public class BreakStatementNodePigLatin extends StatementNodePigLatin {

    public BreakStatementNodePigLatin(int line, int column) {
        super(line, column);
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
