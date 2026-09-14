package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

//This is the principal representation for all the structure control, declaration and definitions
public abstract class StatementNodeZ extends ZAstNode {

    public StatementNodeZ(int line, int column) {
        super(line, column);
    }

}
