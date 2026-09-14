package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class represents a property of an struct
@Getter
public class StructPropertyNodePigLatin extends PigLatinAstNode {
    private final String propertyName;
    private final ExpressionNodePigLatin value;

    public StructPropertyNodePigLatin(int line, int column, String propertyName, ExpressionNodePigLatin value) {
        super(line, column);
        this.propertyName = propertyName;
        this.value = value;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}