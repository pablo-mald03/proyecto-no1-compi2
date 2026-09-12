package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This class is the principal funcion call representation
@Getter
@Setter
public class FunctionCallExpressionNodePigLatin extends ExpressionNodePigLatin {

    private final String functionName;

    private final List<ExpressionNodePigLatin> arguments;

    private TypeNodePigLatin inferredType;

    public FunctionCallExpressionNodePigLatin(int line, int column, String functionName, List<ExpressionNodePigLatin> arguments) {
        super(line, column);
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
