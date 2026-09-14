package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Constructor declaration class
 *
 */
@Getter
public class ConstructorDeclarationNodeZ extends ZAstNode {

    private final String name;
    private final List<ParameterNodeZ> params;
    private final List<ZAstNode> body;

    public ConstructorDeclarationNodeZ(int line, int column, String name, List<ParameterNodeZ> params, List<ZAstNode> body) {
        super(line, column);
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
