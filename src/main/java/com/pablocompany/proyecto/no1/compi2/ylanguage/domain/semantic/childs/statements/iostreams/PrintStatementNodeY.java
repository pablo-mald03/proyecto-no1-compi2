package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal print statement
@Getter
public class PrintStatementNodeY extends StatementNodeY {

    private final List<ExpressionNodeY> expressionList;

    public PrintStatementNodeY(int line, int column, List<ExpressionNodeY> expressionList) {
        super(line, column);
        this.expressionList = expressionList;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
