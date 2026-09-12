package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;


//This class is the principal munera section code
@Getter
public class MaiorSectionNodePigLatin extends PigLatinAstNode {

    private final List<PigLatinAstNode> statements;

    public MaiorSectionNodePigLatin(int line, int column, List<PigLatinAstNode> statements) {
        super(line, column);
        this.statements = statements;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
