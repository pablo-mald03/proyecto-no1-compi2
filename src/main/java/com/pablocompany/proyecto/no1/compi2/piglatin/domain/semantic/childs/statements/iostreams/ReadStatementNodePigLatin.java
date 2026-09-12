package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal read statement node
@Getter
public class ReadStatementNodePigLatin extends StatementNodePigLatin {

    private final ExpressionNodePigLatin target;

    public ReadStatementNodePigLatin(int line, int column, ExpressionNodePigLatin target) {
        super(line, column);
        this.target = target;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
