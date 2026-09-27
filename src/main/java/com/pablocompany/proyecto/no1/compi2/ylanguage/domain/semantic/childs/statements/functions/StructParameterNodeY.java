package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * Principal parameter  for struct
 *
 */
@Getter
public class StructParameterNodeY extends ParameterNodeY {
    private final TypeNodeY dataType;

    public StructParameterNodeY(int line, int column, String identifier, int dimensions, TypeNodeY type, boolean isArray, ParameterKind kind, TypeNodeY dataType) {
        super(line, column, identifier, dimensions, type, isArray, kind);
        this.dataType = dataType;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}