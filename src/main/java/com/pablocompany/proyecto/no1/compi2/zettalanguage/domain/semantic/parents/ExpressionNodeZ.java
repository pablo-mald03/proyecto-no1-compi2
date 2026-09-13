package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

//This class represents all the expression nodes like values
public abstract class ExpressionNodeZ extends ZAstNode {
    public ExpressionNodeZ(int line, int column) {
        super(line, column);
    }
}
