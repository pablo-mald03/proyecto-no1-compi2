package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents the struct attributes declaration
@Getter
public class StructAttributeNodePigLatin extends PigLatinAstNode {

    private final String identifier;
    private final TypeNodePigLatin type;
    private final boolean isArray;

    public StructAttributeNodePigLatin(int line, int column, String identifier, TypeNodePigLatin type, boolean isArray) {
        super(line, column);
        this.identifier = identifier;
        this.type = type;
        this.isArray = isArray;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
