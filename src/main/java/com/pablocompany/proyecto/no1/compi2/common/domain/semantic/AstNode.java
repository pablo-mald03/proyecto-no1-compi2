package com.pablocompany.proyecto.no1.compi2.common.domain.semantic;

import lombok.AllArgsConstructor;
import lombok.Getter;

//This sclass is the principal of the family nodes of the AST
@Getter
@AllArgsConstructor
public abstract class AstNode {

    private final int line;
    private final int column;

}
