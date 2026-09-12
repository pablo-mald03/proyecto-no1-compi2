package com.pablocompany.proyecto.no1.compi2.common.domain.semantic.principals;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;


//This class is the principal munera section code
@Getter
public class MaiorSectionNode extends AstNode {

    private final List<AstNode> statements;

    public MaiorSectionNode(int line, int column, List<AstNode> statements) {
        super(line, column);
        this.statements = statements;
    }


    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
