package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This class represents a declaration structure
@Getter
public class StructDeclarationNodeZ extends StatementNodeZ {
    private final String structName;
    private final StructBodyNodeZ attributes;

    public StructDeclarationNodeZ(int line, int column, String structName, StructBodyNodeZ attributes) {
        super(line, column);
        this.structName = structName;
        this.attributes = attributes;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}