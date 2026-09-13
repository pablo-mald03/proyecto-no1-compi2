package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.CodeBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal while statement representation
@Getter
public class WhileStatementNodeY extends StatementNodeY {

    private final ExpressionNodeY condition;
    private final CodeBodyNodeY body;

    public WhileStatementNodeY(int line, int column, CodeBodyNodeY body, ExpressionNodeY condition) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }


    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
