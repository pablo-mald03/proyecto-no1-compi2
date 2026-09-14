package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class to define the arguments node
 *
 */
@Getter
public class ArgumentsNodePigLatin extends PigLatinAstNode {
    private final List<ExpressionNodePigLatin> arguments;

    public ArgumentsNodePigLatin(int line, int column, List<ExpressionNodePigLatin> arguments) {
        super(line, column);
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
