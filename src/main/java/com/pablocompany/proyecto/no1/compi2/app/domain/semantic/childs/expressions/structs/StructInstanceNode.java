package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

@Getter
public class StructInstanceNode extends StatementNode {
    private final String identifier;
    private final String structType;
    private final StructLiteralExpressionNode literal;

    public StructInstanceNode(int line, int column, String identifier, String structType, StructLiteralExpressionNode literal) {
        super(line, column);
        this.identifier = identifier;
        this.structType = structType;
        this.literal = literal;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}
