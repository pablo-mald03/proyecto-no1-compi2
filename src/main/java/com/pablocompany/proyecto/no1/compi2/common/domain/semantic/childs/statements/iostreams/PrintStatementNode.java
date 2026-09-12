package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.iostreams;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.ExpressionNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal print statement
@Getter
public class PrintStatementNode extends StatementNode {

    private final List<ExpressionNode> expressionList;

    public PrintStatementNode(int line, int column, List<ExpressionNode> expressionList) {
        super(line, column);
        this.expressionList = expressionList;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
