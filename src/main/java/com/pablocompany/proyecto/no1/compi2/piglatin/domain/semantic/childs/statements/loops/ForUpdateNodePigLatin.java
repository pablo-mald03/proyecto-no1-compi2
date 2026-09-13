package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops.enums.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * Class to represent the updata node when the loop for is assignated
 *
 */
@Getter
public class ForUpdateNodePigLatin extends PigLatinAstNode {

    private final ExpressionNodePigLatin target;
    private final ExpressionNodePigLatin value;
    private final ForUpdateOperator operator;

    public ForUpdateNodePigLatin(int line, int column,
                                 ExpressionNodePigLatin target,
                                 ExpressionNodePigLatin value,
                                 ForUpdateOperator operator) {
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