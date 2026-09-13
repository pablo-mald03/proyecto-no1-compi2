package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.functions.FunctionsRegionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.structs.StructuresRegionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

/**
 * This is the principal node that defines the program structure
 */
@Getter
public class ProgramNodeZ extends ZAstNode {

    private final StructuresRegionNodeZ structures;
    private final FunctionsRegionNodeZ functions;

    public ProgramNodeZ(int line, int column, StructuresRegionNodeZ structures, FunctionsRegionNodeZ functions) {
        super(line, column);
        this.structures = structures;
        this.functions = functions;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
