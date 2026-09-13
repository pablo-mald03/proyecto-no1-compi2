package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal read statement node
@Getter
public class ReadStatementNodeY extends StatementNodeY {

    //When its null it wait for any key
    private final ExpressionNodeY target;

    public ReadStatementNodeY(int line, int column, ExpressionNodeY target) {
        super(line, column);
        this.target = target;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
