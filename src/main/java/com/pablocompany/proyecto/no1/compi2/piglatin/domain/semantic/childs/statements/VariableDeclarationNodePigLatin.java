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
    private final TypeNodePigLatin dataType;
    private final ExpressionNodePigLatin initializer;

    public VariableDeclarationNodePigLatin(int line, int column, TypeNodePigLatin dataType, String identifier, ExpressionNodePigLatin initializer) {
        super(line, column);
        this.dataType = dataType;
        this.identifier = identifier;
        this.initializer = initializer;
    }

    //This is the principal generate the final code
    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
