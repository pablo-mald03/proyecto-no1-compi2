package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to represents the else if list
 *
 */
@Getter
public class ElseIfListNodeZ extends StatementNodeZ {
    private final List<ElseIfNodeZ> clauses;

    public ElseIfListNodeZ(int line, int column, List<ElseIfNodeZ> clauses) {
        super(line, column);
        this.clauses = clauses;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return null;
    }
}
