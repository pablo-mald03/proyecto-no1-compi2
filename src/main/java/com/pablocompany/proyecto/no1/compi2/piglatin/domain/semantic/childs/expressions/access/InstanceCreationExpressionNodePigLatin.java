package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

@Getter
public class InstanceCreationExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final String className;
    private final List<ExpressionNodePigLatin> arguments;

    public InstanceCreationExpressionNodePigLatin(int line, int column,
                                                  String className,
                                                  List<ExpressionNodePigLatin> arguments) {
        super(line, column);
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}