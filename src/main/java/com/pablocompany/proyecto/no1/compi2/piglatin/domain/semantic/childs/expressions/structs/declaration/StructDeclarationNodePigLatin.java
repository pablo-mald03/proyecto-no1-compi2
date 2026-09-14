package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents a declaration structure
@Getter
public class StructDeclarationNodePigLatin extends StatementNodePigLatin {
    private final String structName;
    private final StructBodyNodePigLatin attributes;

    public StructDeclarationNodePigLatin(int line, int column, StructBodyNodePigLatin attributes, String structName) {
        super(line, column);
        this.attributes = attributes;
        this.structName = structName;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}