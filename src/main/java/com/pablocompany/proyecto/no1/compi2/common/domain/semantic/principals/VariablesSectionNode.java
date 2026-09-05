package com.pablocompany.practica.no1.compi2.domain.semantic.principals;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the principal variable seciton node
@Getter
public class VariablesSectionNode extends AstNode {

    private final List<AstNode> declarations;

    public VariablesSectionNode(int line, int column, List<AstNode> declarations) {
        super(line, column);
        this.declarations = declarations;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
