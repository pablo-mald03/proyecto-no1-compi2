package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class for list of parameters in a function
 *
 */
@Getter
public class ParameterListNodeZ extends ZAstNode {

    private final List<ParameterNodeZ> parameters;

    public ParameterListNodeZ(int line, int column, List<ParameterNodeZ> parameters) {
        super(line, column);
        this.parameters = parameters;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return null;
    }
}
