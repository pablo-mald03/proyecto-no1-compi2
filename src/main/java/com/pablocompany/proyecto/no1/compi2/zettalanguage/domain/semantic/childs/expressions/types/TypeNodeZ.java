package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;
import lombok.Setter;

//This class represents all operator types
@Getter
@Setter
public class TypeNodeZ extends ZAstNode {
    private final YDataType dataType;
    private final String customTypeName;


    // Constructor for structs
    public TypeNodeZ(int line, int column, YDataType YDataType, String customTypeName) {
        super(line, column);
        this.dataType = YDataType;
        this.customTypeName = customTypeName;
    }


    public TypeNodeZ(int line, int column, YDataType YDataType) {
        this(line, column, YDataType, null);
    }


    @Override
    public <T> T accept(ZAstVisitor<T> visitor)  {
        return visitor.visit(this);
    }
}
