package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

//This is the principal body node
@Getter
public class BodyNodeZ extends ZAstNode {


    private final ZAstNode variablesSection;
    private final ZAstNode maiorSection;

    public BodyNodeZ(int line, int column, ZAstNode variablesSection, ZAstNode maiorSection) {
        super(line, column);
        this.variablesSection = variablesSection;
        this.maiorSection = maiorSection;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}