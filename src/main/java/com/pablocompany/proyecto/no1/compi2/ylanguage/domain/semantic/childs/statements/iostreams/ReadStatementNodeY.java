package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal read statement node
@Getter
public class ReadStatementNodeY extends ExpressionNodeY {


    public ReadStatementNodeY(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
