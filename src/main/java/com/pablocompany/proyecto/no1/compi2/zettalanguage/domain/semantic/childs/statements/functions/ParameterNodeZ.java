package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This is the principal parameters args node
@Getter
public class ParameterNodeZ extends ZAstNode {

    private final String structName;
    private final TypeNodeZ type;
    private final boolean isArray;

    private final ParameterKind kind;

    public ParameterNodeZ(int line, int column, String structName, TypeNodeZ type, boolean isArray, ParameterKind kind) {
        super(line, column);
        this.structName = structName;
        this.type = type;
        this.isArray = isArray;
        this.kind = kind;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
