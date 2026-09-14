package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

//This is the principal representation for all the structure control, declaration and definitions
public abstract class StatementNodePigLatin extends PigLatinAstNode {

    public StatementNodePigLatin(int line, int column) {
        super(line, column);
    }

}
