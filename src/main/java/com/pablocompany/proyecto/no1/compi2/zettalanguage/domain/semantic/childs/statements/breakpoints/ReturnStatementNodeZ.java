package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This is the principal class to represents a return node
@Getter
public class ReturnStatementNodeZ extends StatementNodeZ {
    private final ExpressionNodeZ value; // could be null to return void


    public ReturnStatementNodeZ(int line, int column, ExpressionNodeZ value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
