package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents a property of an struct
@Getter
public class StructPropertyNodeY extends YAstNode {
    private final String propertyName;
    private final ExpressionNodeY value;

    public StructPropertyNodeY(int line, int column, String propertyName, ExpressionNodeY value) {
        super(line, column);
        this.propertyName = propertyName;
        this.value = value;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}