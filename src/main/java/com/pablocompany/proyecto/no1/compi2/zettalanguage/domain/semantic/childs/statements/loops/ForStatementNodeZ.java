package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal class to represents the for statement
@Getter
public class ForStatementNodeZ extends StatementNodeZ {
    private final ZAstNode init; //Could be a variable declaration or assignment node
    private final ExpressionNodeZ condition;
    private final ZAstNode update; //Could be an assigment or incrementable variable
    private final List<ZAstNode> body;

    public ForStatementNodeZ(int line, int column, ZAstNode init, ExpressionNodeZ condition, ZAstNode update, List<ZAstNode> body) {
        super(line, column);
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
