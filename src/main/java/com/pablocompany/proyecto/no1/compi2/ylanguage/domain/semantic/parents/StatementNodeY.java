package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;

//This is the principal representation for all the structure control, declaration and definitions
public abstract class StatementNodeY extends YAstNode {

    public StatementNodeY(int line, int column) {
        super(line, column);
    }

}
