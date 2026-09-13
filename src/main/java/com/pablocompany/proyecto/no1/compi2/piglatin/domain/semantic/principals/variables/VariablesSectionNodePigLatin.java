package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class is the principal variable seciton node
@Getter
public class VariablesSectionNodePigLatin extends PigLatinAstNode {

    private final VariablesBodyNodePigLatin declarations;

    public VariablesSectionNodePigLatin(int line, int column, VariablesBodyNodePigLatin declarations) {
        super(line, column);
        this.declarations = declarations;
    }


    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
