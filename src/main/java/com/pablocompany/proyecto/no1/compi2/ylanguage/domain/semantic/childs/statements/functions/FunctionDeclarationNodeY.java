package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the representation for a function
@Getter
public class FunctionDeclarationNodeY extends StatementNodeY {


    private final String name;
    private final TypeNodeY returnType;
    private final List<ParameterNodeY> parameters;
    private final List<YAstNode> localVariables;
    private final List<YAstNode> body;

    public FunctionDeclarationNodeY(int line, int column, List<YAstNode> body, String name, TypeNodeY returnType, List<ParameterNodeY> parameters, List<YAstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
