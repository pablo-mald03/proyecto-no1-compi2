package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the representation for a function
@Getter
public class FunctionDeclarationNodePigLatin extends StatementNodePigLatin {


    private final String name;
    private final TypeNodePigLatin returnType;
    private final List<ParameterNodePigLatin> parameters;
    private final List<PigLatinAstNode> localVariables;
    private final List<PigLatinAstNode> body;

    public FunctionDeclarationNodePigLatin(int line, int column, List<PigLatinAstNode> body, String name, TypeNodePigLatin returnType, List<ParameterNodePigLatin> parameters, List<PigLatinAstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
