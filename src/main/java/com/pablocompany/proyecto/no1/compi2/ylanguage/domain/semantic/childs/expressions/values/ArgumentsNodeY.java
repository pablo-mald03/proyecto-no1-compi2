package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to define the arguments node
 *
 */
@Getter
public class ArgumentsNodeY extends YAstNode {
    private final List<ExpressionNodeY> arguments;

    public ArgumentsNodeY(int line, int column, List<ExpressionNodeY> arguments) {
        super(line, column);
        this.arguments = arguments;
    }

    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
