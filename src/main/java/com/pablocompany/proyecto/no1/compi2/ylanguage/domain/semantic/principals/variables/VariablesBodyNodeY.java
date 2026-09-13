package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.variables;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Variables body representation class
 *
 */
@Getter
public class VariablesBodyNodeY extends YAstNode {

    private final List<AstNode> declarations;

    public VariablesBodyNodeY(int line, int column, List<AstNode> declarations) {
        super(line, column);
        this.declarations = declarations;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
