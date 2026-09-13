package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else if node
@Getter
public class ElseIfNodeY extends StatementNodeY {

    private final ExpressionNodeY condition;
    private final List<YAstNode> body;

    public ElseIfNodeY(int line, int column, List<YAstNode> body, ExpressionNodeY condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
