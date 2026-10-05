package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.AccessModifierZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * Principal field declaration node for Z language
 *
 */
@Getter
public class FieldDeclarationNodeZ extends ZAstNode {

    private final AccessModifierZ modifier;
    private final TypeNodeZ type;
    private final int dimensions;
    private final String name;
    private final ExpressionNodeZ initializer;

    public FieldDeclarationNodeZ(int line, int column, AccessModifierZ modifier, TypeNodeZ type,
                                 int dimensions, String name, ExpressionNodeZ initializer) {
        super(line, column);
        this.modifier = modifier;
        this.type = type;
        this.dimensions = dimensions;
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
