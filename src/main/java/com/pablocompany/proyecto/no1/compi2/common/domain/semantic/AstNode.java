package com.pablocompany.practica.no1.compi2.domain.semantic;

import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//This sclass is the principal of the family nodes of the AST
@Getter
@AllArgsConstructor
public abstract class AstNode {

    private final int line;
    private final int column;

    //This is the principal dispatcher method to generate the compiled code
    public abstract <T> T accept(AstVisitor<T> visitor);

}
