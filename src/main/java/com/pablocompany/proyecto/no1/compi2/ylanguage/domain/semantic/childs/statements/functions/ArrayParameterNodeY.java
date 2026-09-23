package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Principal class for array parameter node
 *
 */
@Getter
public class ArrayParameterNodeY extends ParameterNodeY {
    private final TypeNodeY elementType;

    public ArrayParameterNodeY(int line, int column, String identifier, int dimensions, TypeNodeY type, boolean isArray, ParameterKind kind, TypeNodeY elementType) {
        super(line, column, identifier, dimensions, type, isArray, kind);
        this.elementType = elementType;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
