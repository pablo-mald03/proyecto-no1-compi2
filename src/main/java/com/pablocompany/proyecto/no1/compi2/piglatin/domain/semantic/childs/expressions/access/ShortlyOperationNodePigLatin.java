package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.enums.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * Class to represents a short operation
 *
 */
@Getter
public class ShortlyOperationNodePigLatin extends ExpressionNodePigLatin {

    private final ExpressionNodePigLatin target;
    private final ExpressionNodePigLatin value;
    private final ShortlyOperator operator;

    public ShortlyOperationNodePigLatin(int line, int column,
                                        ExpressionNodePigLatin target,
                                        ExpressionNodePigLatin value,
                                        ShortlyOperator operator) {
        super(line, column);
        this.target = target;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}