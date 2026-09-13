package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.CodeBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;


//This class is the principal munera section code
@Getter
public class MaiorSectionNodeY extends YAstNode {

    private final CodeBodyNodeY statements;

    public MaiorSectionNodeY(int line, int column, CodeBodyNodeY statements) {
        super(line, column);
        this.statements = statements;
    }


    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
