package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to represents the else if list
 *
 */
@Getter
public class ElseIfListNodeY extends StatementNodeY {
    private final List<ElseIfNodeY> clauses;

    public ElseIfListNodeY(int line, int column, List<ElseIfNodeY> clauses) {
        super(line, column);
        this.clauses = clauses;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return null;
    }
}
