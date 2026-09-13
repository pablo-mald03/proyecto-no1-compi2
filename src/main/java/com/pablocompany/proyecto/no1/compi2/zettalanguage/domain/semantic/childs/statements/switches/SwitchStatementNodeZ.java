package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents a switch statement with cases and an optional default.
 *
 */
@Getter
public class SwitchStatementNodeZ extends StatementNodeZ {

    private final ExpressionNodeZ selector;
    private final List<SwitchCaseNodeZ> cases;
    private final DefaultCaseNodeZ defaultCase;   // nullable

    public SwitchStatementNodeZ(int line, int column, ExpressionNodeZ selector, List<SwitchCaseNodeZ> cases, DefaultCaseNodeZ defaultCase) {
        super(line, column);
        this.selector = selector;
        this.cases = cases;
        this.defaultCase = defaultCase;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}