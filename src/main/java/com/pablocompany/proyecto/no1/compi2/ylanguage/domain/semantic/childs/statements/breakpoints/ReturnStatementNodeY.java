package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal class to represents a return node
@Getter
public class ReturnStatementNodeY extends StatementNodeY {
    private final ExpressionNodeY value; // could be null to return void

    public ReturnStatementNodeY(int line, int column, ExpressionNodeY value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
