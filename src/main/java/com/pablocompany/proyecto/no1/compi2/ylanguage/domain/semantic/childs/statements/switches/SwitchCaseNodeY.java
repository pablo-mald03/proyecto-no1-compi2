package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents a single case inside a switch statement.
 *
 */
@Getter
public class SwitchCaseNodeY extends YAstNode {

    private final ExpressionNodeY value;
    private final List<StatementNodeY> body;

    public SwitchCaseNodeY(int line, int column,
                           ExpressionNodeY value,
                           List<StatementNodeY> body) {
        super(line, column);
        this.value = value;
        this.body = body;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}