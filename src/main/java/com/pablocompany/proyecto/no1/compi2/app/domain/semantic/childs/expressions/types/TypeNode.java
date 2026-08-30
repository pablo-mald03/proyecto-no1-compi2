package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.declaration.StructAttributeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//This class represents all operator types
@Getter
@Setter
public class TypeNode extends AstNode {
    private final DataType dataType;
    private final String customTypeName;


    // Constructor for structs
    public TypeNode(int line, int column, DataType dataType, String customTypeName) {
        super(line, column);
        this.dataType = dataType;
        this.customTypeName = customTypeName;
    }


    public TypeNode(int line, int column, DataType dataType) {
        this(line, column, dataType, null);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
