package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.statements.functions;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

//This is the principal parameters args node
@Getter
public class ParameterNode extends AstNode {

    private final String name;
    private final TypeNode type;
    private final boolean isArray;


    public ParameterNode(int line, int column, boolean isArray, String name, TypeNode type) {
        super(line, column);
        this.isArray = isArray;
        this.name = name;
        this.type = type;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
