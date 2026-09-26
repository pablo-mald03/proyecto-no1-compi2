package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal funcion call representation
@Getter
public class FunctionCallExpressionNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ target;

    private final String functionName;

    private final List<ExpressionNodeZ> arguments;

    public FunctionCallExpressionNodeZ(int line, int column,
                                       ExpressionNodeZ target,
                                       String functionName,
                                       List<ExpressionNodeZ> arguments) {
        super(line, column);
        this.target = target;
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
