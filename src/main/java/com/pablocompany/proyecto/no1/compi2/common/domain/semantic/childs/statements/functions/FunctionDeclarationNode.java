package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the representation for a function
@Getter
public class FunctionDeclarationNode extends StatementNode {


    private final String name;
    private final TypeNode returnType;
    private final List<ParameterNode> parameters;
    private final List<AstNode> localVariables;
    private final List<AstNode> body;

    public FunctionDeclarationNode(int line, int column, List<AstNode> body, String name, TypeNode returnType, List<ParameterNode> parameters, List<AstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
