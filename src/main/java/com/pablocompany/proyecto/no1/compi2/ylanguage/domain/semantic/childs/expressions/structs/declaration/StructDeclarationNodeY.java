package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class represents a declaration structure
@Getter
public class StructDeclarationNodeY extends YAstNode {
    private final String structName;
    private final StructBodyNodeY body;

    public StructDeclarationNodeY(int line, int column, StructBodyNodeY body, String structName) {
        super(line, column);
        this.body = body;
        this.structName = structName;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}