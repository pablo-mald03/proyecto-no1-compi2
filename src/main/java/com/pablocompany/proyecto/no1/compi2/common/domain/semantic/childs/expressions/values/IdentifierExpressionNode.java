package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.values;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class is the principal who represents an identifier expression
@Getter
@Setter
public class IdentifierExpressionNode extends ExpressionNode {

    private final String identifier;

    private TypeNode inferredType;


    public IdentifierExpressionNode(int line, int column, String identifier) {
        super(line, column);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
