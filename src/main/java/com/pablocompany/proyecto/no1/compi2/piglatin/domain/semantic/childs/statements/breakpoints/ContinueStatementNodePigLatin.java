package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;

//This is the principal continue representation
public class ContinueStatementNodePigLatin extends StatementNodePigLatin {

    public ContinueStatementNodePigLatin(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
