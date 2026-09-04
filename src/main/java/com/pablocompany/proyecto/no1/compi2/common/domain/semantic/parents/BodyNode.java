package com.pablocompany.practica.no1.compi2.domain.semantic.parents;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

//This is the principal body node
@Getter
public class BodyNode extends AstNode {
    private final AstNode variablesSection;
    private final AstNode muneraSection;
    private final AstNode maiorSection;

    public BodyNode(int line, int column, AstNode variablesSection, AstNode muneraSection, AstNode maiorSection) {
        super(line, column);
        this.variablesSection = variablesSection;
        this.muneraSection = muneraSection;
        this.maiorSection = maiorSection;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) { return visitor.visit(this); }
}