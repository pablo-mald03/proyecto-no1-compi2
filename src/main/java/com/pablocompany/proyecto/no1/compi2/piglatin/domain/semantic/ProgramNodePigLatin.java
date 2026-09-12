package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal node that defines the program structure
@Getter
public class ProgramNodePigLatin extends PigLatinAstNode {
    private final List<BodyNodePigLatin> bodies;

    public ProgramNodePigLatin(int line, int column, List<BodyNodePigLatin> bodies) {
        super(line, column);
        this.bodies = bodies;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
