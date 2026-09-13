package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal print statement
@Getter
public class PrintStatementNodeY extends StatementNodeY {

    private final ExpressionNodeY expression;

    public PrintStatementNodeY(int line, int column, ExpressionNodeY expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
