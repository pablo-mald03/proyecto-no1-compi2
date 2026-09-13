package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.functions;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class FunctionsRegionNodeZ extends ZAstNode {

    private final List<FunctionDeclarationNodeZ> functions;

    public FunctionsRegionNodeZ(int line, int column, List<FunctionDeclarationNodeZ> functions) {
        super(line, column);
        this.functions = functions;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
