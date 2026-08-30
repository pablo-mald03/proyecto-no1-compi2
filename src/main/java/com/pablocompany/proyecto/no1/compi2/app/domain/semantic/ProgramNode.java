package com.pablocompany.practica.no1.compi2.domain.semantic;

import com.pablocompany.practica.no1.compi2.domain.semantic.parents.BodyNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
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
