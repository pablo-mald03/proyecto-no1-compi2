package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * This is the principal node that defines the program structure
 */
@Getter
public class ProgramNodeZ extends ZAstNode {

    private final ClassDeclarationNodeZ classNode;

    public ProgramNodeZ(int line, int column, ClassDeclarationNodeZ classNode) {
        super(line, column);
        this.classNode = classNode;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
