package com.pablocompany.practica.no1.compi2.domain.semantic.parents;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;

//This class represents all the expression nodes like values
public abstract class ExpressionNode extends AstNode {
    public ExpressionNode(int line, int column) {
        super(line, column);
    }
}
