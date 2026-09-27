package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.functions;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class FunctionsRegionNodeY extends YAstNode {

    private final List<StatementNodeY> functions;

    public FunctionsRegionNodeY(int line, int column, List<StatementNodeY> functions) {
        super(line, column);
        this.functions = functions;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
