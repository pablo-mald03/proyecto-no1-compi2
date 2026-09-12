package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * This class is the principal representacion for the different types of paths
 *
 */
@Getter
public class AccessorNodePigLatin extends PigLatinAstNode {

    private final String path;

    public AccessorNodePigLatin(int line, int column, String path) {
        super(line, column);
        this.path = path;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
