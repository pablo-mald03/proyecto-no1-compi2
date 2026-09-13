package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents a variable declaration
@Getter
public class VariableDeclarationNodeY extends StatementNodeY {

    private final String identifier;
    //If type is null this is an object
    private final TypeNodeY dataType;
    private final ExpressionNodeY initializer;

    private final boolean isObject;

    public VariableDeclarationNodeY(int line, int column, TypeNodeY dataType, String identifier, ExpressionNodeY initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.initializer = initializer;
        this.isObject = dataType == null;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
