package com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.structs.declaration;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This class represents a declaration structure
@Getter
public class StructDeclarationNode extends StatementNode {
    private final String structName;
    private final List<StructAttributeNode> attributes;

    private final boolean hasCommas;

    public StructDeclarationNode(int line, int column, List<StructAttributeNode> attributes, String structName, boolean hasCommas) {
        super(line, column);
        this.attributes = attributes;
        this.structName = structName;
        this.hasCommas = hasCommas;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}