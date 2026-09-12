package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;
/**
 * Principal class to represents the else if list
 * */
@Getter
public class ElseIfListNodePigLatin extends StatementNodePigLatin {
    private final List<ElseIfNodePigLatin> clauses;

    public ElseIfListNodePigLatin(int line, int column, List<ElseIfNodePigLatin> clauses) {
        super(line, column);
        this.clauses = clauses;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return null;
    }
}
