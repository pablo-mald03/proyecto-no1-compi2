package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to define the arguments node
 *
 */
@Getter
public class ArgumentsNodeZ extends ZAstNode {
    private final List<ExpressionNodeZ> arguments;

    public ArgumentsNodeZ(int line, int column, List<ExpressionNodeZ> arguments) {
        super(line, column);
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
