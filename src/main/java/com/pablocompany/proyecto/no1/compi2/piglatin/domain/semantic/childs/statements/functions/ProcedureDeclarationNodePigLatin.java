package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal procedure declaration node
@Getter
public class ProcedureDeclarationNodePigLatin extends StatementNodePigLatin {

    private final String name;
    private final List<ParameterNodePigLatin> parameters;
    private final List<PigLatinAstNode> localVariables;
    private final List<PigLatinAstNode> body;

    public ProcedureDeclarationNodePigLatin(int line, int column, List<PigLatinAstNode> body, String name, List<ParameterNodePigLatin> parameters, List<PigLatinAstNode> localVariables) {
        super(line, column);
        this.body = body;
        this.name = name;
        this.parameters = parameters;
        this.localVariables = localVariables;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
