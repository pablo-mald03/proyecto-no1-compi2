package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.properties;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//This is the principal struct literal expression, the list objects of expression
@Getter
@Setter
public class StructLiteralExpressionNode extends ExpressionNode {
    private final List<StructPropertyNode> properties;

    public StructLiteralExpressionNode(int line, int column, List<StructPropertyNode> properties) {
        super(line, column);
        this.properties = properties;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}