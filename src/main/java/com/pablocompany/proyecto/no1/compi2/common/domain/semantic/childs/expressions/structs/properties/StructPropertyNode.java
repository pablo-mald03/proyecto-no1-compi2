package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.structs.properties;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.ExpressionNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

//This class represents a property of an struct
@Getter
public class StructPropertyNode extends AstNode {
    private final String propertyName;
    private final ExpressionNode value;

    public StructPropertyNode(int line, int column, String propertyName, ExpressionNode value) {
        super(line, column);
        this.propertyName = propertyName;
        this.value = value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}