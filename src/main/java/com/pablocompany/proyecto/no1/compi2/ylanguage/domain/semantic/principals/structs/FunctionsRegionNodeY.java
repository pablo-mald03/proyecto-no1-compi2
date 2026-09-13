package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class FunctionsRegionNodeY extends YAstNode {

    private final List<FunctionDeclarationNodeY> functions;

    public FunctionsRegionNodeY(int line, int column, List<FunctionDeclarationNodeY> functions) {
        super(line, column);
        this.functions = functions;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
