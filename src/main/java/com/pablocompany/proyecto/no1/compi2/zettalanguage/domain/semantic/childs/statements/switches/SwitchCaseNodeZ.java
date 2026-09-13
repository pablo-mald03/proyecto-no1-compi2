package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents a single case inside a switch statement.
 *
 */
@Getter
public class SwitchCaseNodeZ extends ZAstNode {

    private final ExpressionNodeZ value;
    private final List<StatementNodeZ> body;

    public SwitchCaseNodeZ(int line, int column, ExpressionNodeZ value, List<StatementNodeZ> body) {
        super(line, column);
        this.value = value;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}