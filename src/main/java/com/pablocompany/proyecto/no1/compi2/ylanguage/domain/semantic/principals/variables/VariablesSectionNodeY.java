package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.variables;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal variable seciton node
@Getter
public class VariablesSectionNodeY extends YAstNode {

    private final VariablesBodyNodeY declarations;

    public VariablesSectionNodeY(int line, int column, VariablesBodyNodeY declarations) {
        super(line, column);
        this.declarations = declarations;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
