package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else block node
@Getter
public class ElseBlockNodeZ extends StatementNodeZ {
    private final List<ZAstNode> body;

    public ElseBlockNodeZ(int line, int column, List<ZAstNode> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}