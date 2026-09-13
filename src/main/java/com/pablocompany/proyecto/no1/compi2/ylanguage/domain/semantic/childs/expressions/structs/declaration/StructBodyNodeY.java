package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class representation for the struct body
 *
 */
@Getter
public class StructBodyNodeY extends YAstNode {

    private final List<StructAttributeNodeY> attributes;

    public StructBodyNodeY(int line, int column, List<StructAttributeNodeY> attributes) {
        super(line, column);
        this.attributes = attributes;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
