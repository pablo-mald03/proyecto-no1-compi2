package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import lombok.Getter;

//This is the principal parameters args node
@Getter
public abstract class ParameterNodeY extends YAstNode {

    private final String identifier;
    private final int dimensions;
    private final TypeNodeY type;
    private final boolean isArray;

    private final ParameterKind kind;

    public ParameterNodeY(int line, int column, String identifier, int dimensions, TypeNodeY type, boolean isArray, ParameterKind kind) {
        super(line, column);
        this.identifier = identifier;
        this.dimensions = dimensions;
        this.type = type;
        this.isArray = isArray;
        this.kind = kind;
    }
}
