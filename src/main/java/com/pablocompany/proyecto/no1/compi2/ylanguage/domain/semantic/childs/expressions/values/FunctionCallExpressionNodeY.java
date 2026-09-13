package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This class is the principal funcion call representation
@Getter
@Setter
public class FunctionCallExpressionNodeY extends ExpressionNodeY {

    private final ExpressionNodeY target;

    private final String functionName;

    private final List<ExpressionNodeY> arguments;

    private TypeNodeY inferredType;

    public FunctionCallExpressionNodeY(int line, int column,
                                       ExpressionNodeY target,
                                       String functionName,
                                       List<ExpressionNodeY> arguments) {
        super(line, column);
        this.target = target;
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
