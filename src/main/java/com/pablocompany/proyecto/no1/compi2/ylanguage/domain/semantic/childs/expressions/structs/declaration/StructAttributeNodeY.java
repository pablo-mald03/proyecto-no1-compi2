package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents the struct attributes declaration
@Getter
public class StructAttributeNodeY extends YAstNode {

    private final String identifier;
    private final TypeNodeY type;
    private final boolean isArray;

    public StructAttributeNodeY(int line, int column, String identifier, TypeNodeY type, boolean isArray) {
        super(line, column);
        this.identifier = identifier;
        this.type = type;
        this.isArray = isArray;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
