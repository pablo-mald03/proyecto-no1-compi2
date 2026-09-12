package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal print statement
@Getter
public class PrintStatementNodePigLatin extends StatementNodePigLatin {

    private final List<ExpressionNodePigLatin> expressionList;

    public PrintStatementNodePigLatin(int line, int column, List<ExpressionNodePigLatin> expressionList) {
        super(line, column);
        this.expressionList = expressionList;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
