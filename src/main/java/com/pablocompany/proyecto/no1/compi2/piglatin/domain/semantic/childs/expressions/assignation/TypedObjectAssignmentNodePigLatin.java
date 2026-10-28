package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import lombok.Getter;

/**
 * Object assignment
 *
 */
@Getter
public class TypedObjectAssignmentNodePigLatin extends VariableAssignmentNodePigLatin {

    private final TypeNodePigLatin annotatedType;

    public TypedObjectAssignmentNodePigLatin(int line, int column,
                                             ExpressionNodePigLatin target,
                                             ExpressionNodePigLatin value,
                                             TypeNodePigLatin annotatedType) {
        super(line, column, target, value, true);
        this.annotatedType = annotatedType;
    }

}