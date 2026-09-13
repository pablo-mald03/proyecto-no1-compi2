package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal class to represents the for statement
@Getter
public class ForStatementNodeY extends StatementNodeY {
    private final YAstNode init; //Could be a variable declaration or assignment node
    private final ExpressionNodeY condition;
    private final YAstNode update; //Could be an assigment or incrementable variable
    private final List<StatementNodeY> body;

    public ForStatementNodeY(int line, int column, List<StatementNodeY> body, YAstNode init, ExpressionNodeY condition, YAstNode update) {
        super(line, column);
        this.body = body;
        this.init = init;
        this.condition = condition;
        this.update = update;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
