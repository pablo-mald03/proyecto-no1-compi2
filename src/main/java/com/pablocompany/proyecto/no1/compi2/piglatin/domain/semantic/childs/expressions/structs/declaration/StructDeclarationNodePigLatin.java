package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents a declaration structure
@Getter
public class StructDeclarationNodePigLatin extends StatementNodePigLatin {
    private final String structName;
    private final List<StructAttributeNodePigLatin> attributes;

    private final boolean hasCommas;

    public StructDeclarationNodePigLatin(int line, int column, List<StructAttributeNodePigLatin> attributes, String structName, boolean hasCommas) {
        super(line, column);
        this.attributes = attributes;
        this.structName = structName;
        this.hasCommas = hasCommas;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}