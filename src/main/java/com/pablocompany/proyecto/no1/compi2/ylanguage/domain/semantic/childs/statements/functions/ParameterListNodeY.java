package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class for list of parameters in a function
 *
 */
@Getter
public class ParameterListNodeY extends YAstNode {

    private final List<ParameterNodeY> parameters;

    public ParameterListNodeY(int line, int column, List<ParameterNodeY> parameters) {
        super(line, column);
        this.parameters = parameters;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return null;
    }
}
