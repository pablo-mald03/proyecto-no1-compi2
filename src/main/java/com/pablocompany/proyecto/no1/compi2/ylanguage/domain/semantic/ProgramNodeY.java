package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.FunctionsRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.StructuresRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

/**
 * This is the principal node that defines the program structure
 */
@Getter
public class ProgramNodeY extends YAstNode {

    private final StructuresRegionNodeY structures;
    private final FunctionsRegionNodeY functions;

    public ProgramNodeY(int line, int column, StructuresRegionNodeY structures, FunctionsRegionNodeY functions) {
        super(line, column);
        this.structures = structures;
        this.functions = functions;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
