package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

@Getter
public class StructInstanceNodeY extends StatementNodeY {
    private final String identifier;
    private final String structType;
    private final StructLiteralExpressionNodeY literal;

    public StructInstanceNodeY(int line, int column, String identifier, String structType, StructLiteralExpressionNodeY literal) {
        super(line, column);
        this.identifier = identifier;
        this.structType = structType;
        this.literal = literal;
    }

    @Override
    public <T> T accept( YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
