package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal parameters args node
@Getter
public class ParameterNodeY extends YAstNode {

    private final String name;
    private final TypeNodeY type;
    private final boolean isArray;


    public ParameterNodeY(int line, int column, boolean isArray, String name, TypeNodeY type) {
        super(line, column);
        this.isArray = isArray;
        this.name = name;
        this.type = type;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
