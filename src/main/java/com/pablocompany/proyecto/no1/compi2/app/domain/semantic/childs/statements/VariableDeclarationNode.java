package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This class represents a variable declaration
@Getter
public class VariableDeclarationNode extends StatementNode {

    private final String identifier;
    private final TypeNode dataType;
    private final ExpressionNode initializer;

    public VariableDeclarationNode(int line, int column, TypeNode dataType, String identifier, ExpressionNode initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.initializer = initializer;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
