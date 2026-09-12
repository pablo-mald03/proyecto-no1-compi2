package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;

//This class represents all the expression nodes like values
public abstract class ExpressionNodePigLatin extends PigLatinAstNode {
    public ExpressionNodePigLatin(int line, int column) {
        super(line, column);
    }
}
