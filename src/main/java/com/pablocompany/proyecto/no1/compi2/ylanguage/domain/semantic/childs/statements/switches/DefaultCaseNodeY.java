package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Represents the default branch of a switch statement.
 * */
@Getter
public class DefaultCaseNodeY extends YAstNode {

    private final List<StatementNodeY> body;

    public DefaultCaseNodeY(int line, int column, List<StatementNodeY> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}