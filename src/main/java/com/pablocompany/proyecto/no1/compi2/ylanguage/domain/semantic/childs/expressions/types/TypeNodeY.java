package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents all operator types
@Getter
@Setter
public class TypeNodeY extends YAstNode {
    private final YDataType dataType;
    private final String customTypeName;


    // Constructor for structs
    public TypeNodeY(int line, int column, YDataType YDataType, String customTypeName) {
        super(line, column);
        this.dataType = YDataType;
        this.customTypeName = customTypeName;
    }


    public TypeNodeY(int line, int column, YDataType YDataType) {
        this(line, column, YDataType, null);
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
