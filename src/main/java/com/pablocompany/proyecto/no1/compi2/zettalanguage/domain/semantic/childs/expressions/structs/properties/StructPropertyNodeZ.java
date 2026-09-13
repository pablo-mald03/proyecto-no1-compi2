package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents a property of any struct
@Getter
public class StructPropertyNodeZ extends ZAstNode {
    private final String propertyName;
    private final ExpressionNodeZ value;

    public StructPropertyNodeZ(int line, int column, String propertyName, ExpressionNodeZ value) {
        super(line, column);
        this.propertyName = propertyName;
        this.value = value;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}