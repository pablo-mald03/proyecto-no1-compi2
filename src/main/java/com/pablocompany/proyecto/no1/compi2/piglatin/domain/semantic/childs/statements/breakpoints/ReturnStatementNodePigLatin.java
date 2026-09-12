package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal class to represents a return node
@Getter
public class ReturnStatementNodePigLatin extends StatementNodePigLatin {
    private final ExpressionNodePigLatin value; // could be null to return void

    public ReturnStatementNodePigLatin(int line, int column, ExpressionNodePigLatin value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
