package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

@Getter
public class StructInstanceNodePigLatin extends StatementNodePigLatin {
    private final String identifier;
    private final String structType;
    private final StructLiteralExpressionNodePigLatin literal;

    public StructInstanceNodePigLatin(int line, int column, String identifier, String structType, StructLiteralExpressionNodePigLatin literal) {
        super(line, column);
        this.identifier = identifier;
        this.structType = structType;
        this.literal = literal;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
