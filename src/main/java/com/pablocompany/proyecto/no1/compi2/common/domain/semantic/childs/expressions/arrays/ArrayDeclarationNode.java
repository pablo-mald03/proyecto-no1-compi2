package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.arrays;

import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.ExpressionNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.StatementNode;
import lombok.Getter;

@Getter
public class ArrayDeclarationNode extends StatementNode {

    private final String identifier;
    private final ExpressionNode size;
    private final TypeNode dataType;
    private final ArrayInitExpressionNode initializer;


    public ArrayDeclarationNode(int line, int column, TypeNode dataType, String identifier, ExpressionNode size, ArrayInitExpressionNode initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.size = size;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
