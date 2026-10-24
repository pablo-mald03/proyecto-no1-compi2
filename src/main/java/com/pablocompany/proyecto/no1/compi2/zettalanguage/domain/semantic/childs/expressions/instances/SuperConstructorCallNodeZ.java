package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Principal super constructor call node class
 *
 */
@Getter
public class SuperConstructorCallNodeZ extends ZAstNode {

    private final List<ExpressionNodeZ> arguments;

    /**
     * Parent class.
     */
    @Setter
    private String parentClass;

    public SuperConstructorCallNodeZ(int line, int column, List<ExpressionNodeZ> arguments) {
        super(line, column);
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}