package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents all operator types
@Getter
@Setter
public class TypeNodePigLatin extends PigLatinAstNode {
    private final DataType dataType;
    private final String customTypeName;


    // Constructor for structs
    public TypeNodePigLatin(int line, int column, DataType dataType, String customTypeName) {
        super(line, column);
        this.dataType = dataType;
        this.customTypeName = customTypeName;
    }


    public TypeNodePigLatin(int line, int column, DataType dataType) {
        this(line, column, dataType, null);
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
