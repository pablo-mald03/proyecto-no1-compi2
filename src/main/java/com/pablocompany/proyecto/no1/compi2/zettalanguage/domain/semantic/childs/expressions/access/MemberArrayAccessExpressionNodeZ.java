package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents the acess to an array nested value
@Getter
public class MemberArrayAccessExpressionNodeZ extends ExpressionNodeZ {

    private final ExpressionNodeZ target;
    private final ExpressionNodeZ index;

    public MemberArrayAccessExpressionNodeZ(int line, int column, ExpressionNodeZ index, ExpressionNodeZ target) {
        super(line, column);
        this.index = index;
        this.target = target;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
