package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This is the principal body node
@Getter
public class BodyNodePigLatin extends PigLatinAstNode {
    private final PigLatinAstNode variablesSection;
    private final PigLatinAstNode muneraSection;
    private final PigLatinAstNode maiorSection;

    public BodyNodePigLatin(int line, int column, PigLatinAstNode variablesSection, PigLatinAstNode muneraSection, PigLatinAstNode maiorSection) {
        super(line, column);
        this.variablesSection = variablesSection;
        this.muneraSection = muneraSection;
        this.maiorSection = maiorSection;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}