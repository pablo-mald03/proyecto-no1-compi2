package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal body node
@Getter
public class BodyNodePigLatin extends PigLatinAstNode {

    private final List<ImportNodePigLatin> imports;
    private final PigLatinAstNode variablesSection;
    private final PigLatinAstNode maiorSection;

    public BodyNodePigLatin(int line, int column, List<ImportNodePigLatin> imports, PigLatinAstNode variablesSection,
                            PigLatinAstNode maiorSection) {
        super(line, column);
        this.imports = imports;
        this.variablesSection = variablesSection;
        this.maiorSection = maiorSection;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}