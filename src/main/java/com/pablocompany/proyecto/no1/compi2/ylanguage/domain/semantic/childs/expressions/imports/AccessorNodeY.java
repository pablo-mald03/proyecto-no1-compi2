package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.imports;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * This class is the principal representacion for the different types of paths
 *
 */
@Getter
public class AccessorNodeY extends YAstNode {

    private final String path;

    public AccessorNodeY(int line, int column, String path) {
        super(line, column);
        this.path = path;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
