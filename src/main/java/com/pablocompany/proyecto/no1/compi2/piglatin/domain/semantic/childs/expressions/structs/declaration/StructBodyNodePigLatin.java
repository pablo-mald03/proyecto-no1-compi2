package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Principal class representation for the struct body
 *
 */
@Getter
public class StructBodyNodePigLatin extends PigLatinAstNode {

    private final List<StructAttributeNodePigLatin> attributes;

    public StructBodyNodePigLatin(int line, int column, List<StructAttributeNodePigLatin> attributes) {
        super(line, column);
        this.attributes = attributes;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
