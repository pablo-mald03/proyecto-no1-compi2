package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class InstanceCreationExpressionNodeZ extends ExpressionNodeZ {

    private final String className;
    private final List<ExpressionNodeZ> arguments;

    public InstanceCreationExpressionNodeZ(int line, int column,
                                           String className,
                                           List<ExpressionNodeZ> arguments) {
        super(line, column);
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}