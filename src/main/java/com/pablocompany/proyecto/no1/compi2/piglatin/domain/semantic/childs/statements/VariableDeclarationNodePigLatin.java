package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents a variable declaration
@Getter
public class VariableDeclarationNodePigLatin extends StatementNodePigLatin {

    private final String identifier;
    //If type is null this is an object
    private final TypeNodePigLatin dataType;
    private final ExpressionNodePigLatin initializer;

    private final boolean isObject;

    public VariableDeclarationNodePigLatin(int line, int column, TypeNodePigLatin dataType, String identifier, ExpressionNodePigLatin initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.initializer = initializer;
        this.isObject = dataType == null;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
