package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 *
 *
 */
@Getter
public class CodeBodyNodeZ extends StatementNodeZ {

    private final List<ZAstNode> statements;

    public CodeBodyNodeZ(int line, int column, List<ZAstNode> statements) {
        super(line, column);
        this.statements = statements;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);

    }
}
