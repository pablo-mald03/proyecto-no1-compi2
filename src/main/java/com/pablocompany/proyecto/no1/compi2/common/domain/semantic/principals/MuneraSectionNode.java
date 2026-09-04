package com.pablocompany.practica.no1.compi2.domain.semantic.principals;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;


//This class is the principal munera section code
@Getter
public class MuneraSectionNode extends AstNode {

    private final List<AstNode> functions;


    public MuneraSectionNode(int line, int column, List<AstNode> functions) {
        super(line, column);
        this.functions = functions;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
