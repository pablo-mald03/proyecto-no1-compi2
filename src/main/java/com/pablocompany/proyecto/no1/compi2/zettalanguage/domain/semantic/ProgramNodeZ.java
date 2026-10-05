package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * This is the principal node that defines the program structure
 */
@Getter
public class ProgramNodeZ extends ZAstNode {

    private final List<ClassDeclarationNodeZ> classesNode;

    public ProgramNodeZ(int line, int column, List<ClassDeclarationNodeZ> classesNode) {
        super(line, column);
        this.classesNode = classesNode;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
