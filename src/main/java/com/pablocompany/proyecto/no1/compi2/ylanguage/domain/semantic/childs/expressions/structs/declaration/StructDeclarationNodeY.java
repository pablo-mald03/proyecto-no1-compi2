package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents a declaration structure
@Getter
public class StructDeclarationNodeY extends StatementNodeY {
    private final String structName;
    private final StructBodyNodeY attributes;

    public StructDeclarationNodeY(int line, int column, StructBodyNodeY attributes, String structName) {
        super(line, column);
        this.attributes = attributes;
        this.structName = structName;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}