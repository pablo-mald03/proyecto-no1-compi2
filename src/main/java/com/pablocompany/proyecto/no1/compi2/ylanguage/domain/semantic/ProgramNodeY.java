package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.BodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This is the principal node that defines the program structure
@Getter
public class ProgramNodeY extends YAstNode {
    private final BodyNodeY body;

    public ProgramNodeY(int line, int column, BodyNodeY body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
