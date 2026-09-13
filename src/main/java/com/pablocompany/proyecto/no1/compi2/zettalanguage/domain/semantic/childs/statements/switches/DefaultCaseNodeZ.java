package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents the default branch of a switch statement.
 *
 */
@Getter
public class DefaultCaseNodeZ extends ZAstNode {

    private final List<StatementNodeZ> body;

    public DefaultCaseNodeZ(int line, int column, List<StatementNodeZ> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}