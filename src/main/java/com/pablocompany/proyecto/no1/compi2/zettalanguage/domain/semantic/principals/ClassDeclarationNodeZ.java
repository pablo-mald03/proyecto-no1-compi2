package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class ClassDeclarationNodeZ extends ZAstNode {

    private final String className;
    private final List<ZAstNode> members;

    public ClassDeclarationNodeZ(int line, int column, String className, List<ZAstNode> members) {
        super(line, column);
        this.className = className;
        this.members = members;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
