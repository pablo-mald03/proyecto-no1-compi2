package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Method declaration class
 *
 */
@Getter
public class MethodDeclarationNodeZ extends ZAstNode {

    private final String name;
    private final TypeNodeZ type;
    private final List<ParameterNodeZ> params;
    private final List<ZAstNode> body;

    //Return dimensions
    private final int returnDimensions;

    public MethodDeclarationNodeZ(int line, int column, String name, TypeNodeZ type, List<ParameterNodeZ> params, List<ZAstNode> body, int returnDimensions) {
        super(line, column);
        this.name = name;
        this.type = type;
        this.params = params;
        this.body = body;
        this.returnDimensions = returnDimensions;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
