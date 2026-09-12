package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This is the principal else block node
@Getter
public class ElseBlockNodePigLatin extends StatementNodePigLatin {
    private final List<PigLatinAstNode> body;

    public ElseBlockNodePigLatin(int line, int column, List<PigLatinAstNode> body) {
        super(line, column);
        this.body = body;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}