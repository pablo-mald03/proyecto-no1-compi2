package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal procedure declaration node
@Getter
public class ProcedureDeclarationNode extends StatementNode {

    private final String name;
    private final List<ParameterNode> parameters;
    private final List<AstNode> localVariables;
    private final List<AstNode> body;

    public ProcedureDeclarationNode(int line, int column, List<AstNode> body, String name, List<ParameterNode> parameters, List<AstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
