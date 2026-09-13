package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else block node
@Getter
public class ElseBlockNodeY extends StatementNodeY {
    private final List<YAstNode> body;

    public ElseBlockNodeY(int line, int column, List<YAstNode> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}