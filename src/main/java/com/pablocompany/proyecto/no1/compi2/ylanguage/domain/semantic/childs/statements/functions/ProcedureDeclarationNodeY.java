package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal procedure declaration node
@Getter
public class ProcedureDeclarationNodeY extends StatementNodeY {

    private final String name;
    private final List<ParameterNodeY> parameters;
    private final List<YAstNode> localVariables;
    private final List<YAstNode> body;

    public ProcedureDeclarationNodeY(int line, int column, List<YAstNode> body, String name, List<ParameterNodeY> parameters, List<YAstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
