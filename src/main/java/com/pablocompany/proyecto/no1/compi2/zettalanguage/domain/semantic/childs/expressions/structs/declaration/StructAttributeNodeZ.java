package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents the struct attributes declaration
@Getter
public class StructAttributeNodeZ extends ZAstNode {

    private final String identifier;
    private final TypeNodeZ type;
    private final boolean isArray;

    private final ExpressionNodeZ dimension;

    public StructAttributeNodeZ(int line, int column, String identifier, TypeNodeZ type, boolean isArray, ExpressionNodeZ dimension) {
        super(line, column);
        this.identifier = identifier;
        this.type = type;
        this.isArray = isArray;
        this.dimension = dimension;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
