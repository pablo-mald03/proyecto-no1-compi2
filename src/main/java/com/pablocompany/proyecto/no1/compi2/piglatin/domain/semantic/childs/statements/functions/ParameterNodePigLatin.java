package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal parameters args node
@Getter
public class ParameterNodePigLatin extends PigLatinAstNode {

    private final String name;
    private final TypeNodePigLatin type;
    private final boolean isArray;


    public ParameterNodePigLatin(int line, int column, boolean isArray, String name, TypeNodePigLatin type) {
        super(line, column);
        this.isArray = isArray;
        this.name = name;
        this.type = type;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
