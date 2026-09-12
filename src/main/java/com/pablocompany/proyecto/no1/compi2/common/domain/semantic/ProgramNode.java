package com.pablocompany.proyecto.no1.compi2.common.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents.BodyNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal node that defines the program structure
@Getter
public class ProgramNode extends AstNode{
    private final List<BodyNode> bodies;

    public ProgramNode(int line, int column, List<BodyNode> bodies) {
        super(line, column);
        this.bodies = bodies;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}
