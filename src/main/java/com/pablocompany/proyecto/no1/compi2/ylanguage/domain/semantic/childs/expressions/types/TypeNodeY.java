package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents all operator types
@Getter
@Setter
public class TypeNodeY extends YAstNode {
    private final DataType dataType;
    private final String customTypeName;


    // Constructor for structs
    public TypeNodeY(int line, int column, DataType dataType, String customTypeName) {
        super(line, column);
        this.dataType = dataType;
        this.customTypeName = customTypeName;
    }


    public TypeNodeY(int line, int column, DataType dataType) {
        this(line, column, dataType, null);
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
