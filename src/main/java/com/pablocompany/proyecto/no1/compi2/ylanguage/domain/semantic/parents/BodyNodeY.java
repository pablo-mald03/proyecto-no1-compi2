package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.imports.ImportNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal body node
@Getter
public class BodyNodeY extends YAstNode {

    private final List<ImportNodeY> imports;
    private final YAstNode variablesSection;
    private final YAstNode maiorSection;

    public BodyNodeY(int line, int column, List<ImportNodeY> imports, YAstNode variablesSection,
                     YAstNode maiorSection) {
        super(line, column);
        this.imports = imports;
        this.variablesSection = variablesSection;
        this.maiorSection = maiorSection;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}