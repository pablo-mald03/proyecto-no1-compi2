package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This class is the principal funcion call representation
@Getter
@Setter
public class FunctionCallExpressionNode extends ExpressionNode {

    private final String functionName;

    private final List<ExpressionNode> arguments;

    private TypeNode inferredType;

    public FunctionCallExpressionNode(int line, int column, String functionName, List<ExpressionNode> arguments) {
        super(line, column);
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
