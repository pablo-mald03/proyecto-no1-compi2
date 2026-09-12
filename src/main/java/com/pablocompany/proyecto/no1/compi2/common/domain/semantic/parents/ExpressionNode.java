package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;

//This class represents all the expression nodes like values
public abstract class ExpressionNode extends AstNode {
    public ExpressionNode(int line, int column) {
        super(line, column);
    }
}
