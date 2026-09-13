package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents the acess to an array nested value
@Getter
public class MemberArrayAccessExpressionNodeY extends ExpressionNodeY {

    private final ExpressionNodeY target;
    private final ExpressionNodeY index;

    public MemberArrayAccessExpressionNodeY(int line, int column, ExpressionNodeY index, ExpressionNodeY target) {
        super(line, column);
        this.index = index;
        this.target = target;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
