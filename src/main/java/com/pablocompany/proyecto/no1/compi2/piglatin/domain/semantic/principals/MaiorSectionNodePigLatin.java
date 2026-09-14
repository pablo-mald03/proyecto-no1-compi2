package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;


//This class is the principal munera section code
@Getter
public class MaiorSectionNodePigLatin extends PigLatinAstNode {

    private final CodeBodyNodePigLatin statements;

    public MaiorSectionNodePigLatin(int line, int column, CodeBodyNodePigLatin statements) {
        super(line, column);
        this.statements = statements;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
