package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.declaration;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class representation for the struct body
 *
 */
@Getter
public class StructBodyNodeZ extends ZAstNode {

    private final List<StructAttributeNodeZ> attributes;

    public StructBodyNodeZ(int line, int column, List<StructAttributeNodeZ> attributes) {
        super(line, column);
        this.attributes = attributes;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
