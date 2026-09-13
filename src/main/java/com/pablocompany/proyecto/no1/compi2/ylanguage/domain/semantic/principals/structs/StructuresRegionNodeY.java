package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

/**
 * Variables body representation class
 *
 */
@Getter
public class StructuresRegionNodeY extends YAstNode {

    private final List<StructDeclarationNodeY> structs;

    public StructuresRegionNodeY(int line, int column, List<StructDeclarationNodeY> structs) {
        super(line, column);
        this.structs = structs;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
