package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;

//This is the principal representation for all the structure control, declaration and definitions
public abstract class StatementNode extends AstNode {

    public StatementNode(int line, int column) {
        super(line, column);
    }

}
