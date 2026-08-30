package com.pablocompany.practica.no1.compi2.domain.semantic.parents;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;

//This is the principal representation for all the structure control, declaration and definitions
public abstract class StatementNode extends AstNode {

    public StatementNode(int line, int column) {
        super(line, column);
    }

}
