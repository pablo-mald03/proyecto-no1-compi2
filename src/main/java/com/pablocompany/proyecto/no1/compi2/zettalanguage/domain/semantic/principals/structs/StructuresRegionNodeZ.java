package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.structs;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Variables body representation class
 *
 */
@Getter
public class StructuresRegionNodeZ extends ZAstNode {

    private final List<StructDeclarationNodeZ> structs;


    public StructuresRegionNodeZ(int line, int column, List<StructDeclarationNodeZ> structs) {
        super(line, column);
        this.structs = structs;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
