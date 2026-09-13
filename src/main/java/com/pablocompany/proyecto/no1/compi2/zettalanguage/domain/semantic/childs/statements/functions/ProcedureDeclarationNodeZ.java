package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal procedure declaration node
@Getter
public class ProcedureDeclarationNodeZ extends StatementNodeZ {

    private final String name;
    private final List<ParameterNodeZ> parameters;
    private final List<ZAstNode> localVariables;
    private final List<ZAstNode> body;

    public ProcedureDeclarationNodeZ(int line, int column, String name, List<ParameterNodeZ> parameters, List<ZAstNode> localVariables, List<ZAstNode> body) {
        super(line, column);
        this.name = name;
        this.parameters = parameters;
        this.localVariables = localVariables;
        this.body = body;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
