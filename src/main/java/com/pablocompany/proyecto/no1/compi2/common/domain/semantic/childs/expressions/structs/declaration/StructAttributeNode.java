package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

//This class represents the struct attributes declaration
@Getter
public class StructAttributeNode extends AstNode {

    private final String identifier;
    private final TypeNode type;
    private final boolean isArray;

    public StructAttributeNode(int line, int column, String identifier, TypeNode type, boolean isArray) {
        super(line, column);
        this.identifier = identifier;
        this.type = type;
        this.isArray = isArray;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}
