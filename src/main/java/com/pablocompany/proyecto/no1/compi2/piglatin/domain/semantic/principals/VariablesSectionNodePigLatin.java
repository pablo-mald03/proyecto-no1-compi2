package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class VariablesSectionNodePigLatin extends PigLatinAstNode {

    private final List<PigLatinAstNode> declarations;

    public VariablesSectionNodePigLatin(int line, int column, List<PigLatinAstNode> declarations) {
        super(line, column);
        this.declarations = declarations;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
