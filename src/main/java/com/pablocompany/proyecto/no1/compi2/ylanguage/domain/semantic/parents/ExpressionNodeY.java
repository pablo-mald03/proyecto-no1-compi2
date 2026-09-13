package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;

//This class represents all the expression nodes like values
public abstract class ExpressionNodeY extends YAstNode {
    public ExpressionNodeY(int line, int column) {
        super(line, column);
    }
}
