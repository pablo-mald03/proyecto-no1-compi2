package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.functions;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.VariableDeclarationNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import javax.swing.plaf.nimbus.State;
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
