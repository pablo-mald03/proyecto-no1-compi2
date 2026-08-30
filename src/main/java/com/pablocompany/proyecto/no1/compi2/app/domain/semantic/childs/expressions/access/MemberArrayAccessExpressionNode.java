package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.access;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This class represents the acess to an array nested value
@Getter
public class MemberArrayAccessExpressionNode extends ExpressionNode {

    private final ExpressionNode target;
    private final ExpressionNode index;

    public MemberArrayAccessExpressionNode(int line, int column, ExpressionNode index, ExpressionNode target) {
        super(line, column);
        this.index = index;
        this.target = target;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
