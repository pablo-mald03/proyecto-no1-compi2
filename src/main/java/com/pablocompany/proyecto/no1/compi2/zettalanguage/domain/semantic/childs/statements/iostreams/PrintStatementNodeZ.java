package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class is the principal print statement
@Getter
public class PrintStatementNodeZ extends StatementNodeZ {

    private final ExpressionNodeZ expression;
    //IF ITS TRUE IS PRINTLN
    private final boolean isEndless;

    public PrintStatementNodeZ(int line, int column, ExpressionNodeZ expression, boolean isEndless) {
        super(line, column);
        this.expression = expression;
        this.isEndless = isEndless;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
