package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents a variable declaration
@Getter
public class VariableDeclarationNodeZ extends StatementNodeZ {

    private final String identifier;
    //If type is null this is an object
    private final TypeNodeZ dataType;
    private final ExpressionNodeZ initializer;

    private final boolean isObject;

    public VariableDeclarationNodeZ(int line, int column, String identifier, TypeNodeZ dataType, ExpressionNodeZ initializer, boolean isObject) {
        super(line, column);
        this.identifier = identifier;
        this.dataType = dataType;
        this.initializer = initializer;
        this.isObject = isObject;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
