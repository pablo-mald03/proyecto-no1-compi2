package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This is the principal read statement node
@Getter
public class ReadStatementNodeZ extends StatementNodeZ {


    public ReadStatementNodeZ(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
