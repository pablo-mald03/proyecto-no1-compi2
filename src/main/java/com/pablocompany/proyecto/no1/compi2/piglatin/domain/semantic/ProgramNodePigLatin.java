package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal node that defines the program structure
@Getter
public class ProgramNodePigLatin extends PigLatinAstNode {
    private final BodyNodePigLatin body;

    public ProgramNodePigLatin(int line, int column, BodyNodePigLatin body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
