package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

@Getter
public class StructInstanceNodeZ extends StatementNodeZ {
    private final String identifier;
    private final String structType;
    private final StructLiteralExpressionNodeZ literal;


    public StructInstanceNodeZ(int line, int column, String identifier, String structType, StructLiteralExpressionNodeZ literal) {
        super(line, column);
        this.identifier = identifier;
        this.structType = structType;
        this.literal = literal;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
