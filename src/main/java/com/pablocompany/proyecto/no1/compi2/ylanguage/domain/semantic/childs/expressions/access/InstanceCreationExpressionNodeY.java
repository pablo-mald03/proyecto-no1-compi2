package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class InstanceCreationExpressionNodeY extends ExpressionNodeY {

    private final String className;
    private final List<ExpressionNodeY> arguments;

    public InstanceCreationExpressionNodeY(int line, int column,
                                           String className,
                                           List<ExpressionNodeY> arguments) {
        super(line, column);
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}