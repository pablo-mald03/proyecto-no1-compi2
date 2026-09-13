package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 *
 *
 */
@Getter
public class CodeBodyNodeY extends YAstNode {

    private final List<YAstNode> statements;

    public CodeBodyNodeY(int line, int column, List<YAstNode> statements) {
        super(line, column);
        this.statements = statements;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);

    }
}
