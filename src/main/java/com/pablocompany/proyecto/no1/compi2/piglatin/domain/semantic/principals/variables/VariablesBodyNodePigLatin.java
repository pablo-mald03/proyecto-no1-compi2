package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Variables body representation class
 *
 */
@Getter
public class VariablesBodyNodePigLatin extends PigLatinAstNode {

    private final List<PigLatinAstNode> declarations;

    public VariablesBodyNodePigLatin(int line, int column, List<PigLatinAstNode> declarations) {
        super(line, column);
        this.declarations = declarations;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
