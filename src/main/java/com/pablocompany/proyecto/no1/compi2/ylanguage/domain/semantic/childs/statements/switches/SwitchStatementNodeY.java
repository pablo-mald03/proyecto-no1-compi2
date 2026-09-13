package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents a switch statement with cases and an optional default.
 *
 */
@Getter
public class SwitchStatementNodeY extends StatementNodeY {

    private final ExpressionNodeY selector;
    private final List<SwitchCaseNodeY> cases;
    private final DefaultCaseNodeY defaultCase;   // nullable

    public SwitchStatementNodeY(int line, int column,
                                ExpressionNodeY selector,
                                List<SwitchCaseNodeY> cases,
                                DefaultCaseNodeY defaultCase) {
        super(line, column);
        this.selector = selector;
        this.cases = cases;
        this.defaultCase = defaultCase;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}