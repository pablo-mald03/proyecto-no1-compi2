package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the representation for a function
@Getter
public class FunctionDeclarationNodeZ extends StatementNodeZ {


    private final String name;
    private final TypeNodeZ returnType;
    private final List<ParameterNodeZ> parameters;
    private final List<ZAstNode> body;

    public FunctionDeclarationNodeZ(int line, int column, String name, TypeNodeZ returnType, List<ParameterNodeZ> parameters, List<ZAstNode> body) {
        super(line, column);
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
