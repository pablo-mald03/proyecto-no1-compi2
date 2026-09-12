package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

//This class is the principal of the family nodes of the AST for pig latin parser
@Getter
public abstract class PigLatinAstNode extends AstNode {

    public PigLatinAstNode(int line, int column) {
        super(line, column);
    }

    //This is the principal dispatcher method to generate the compiled code
    public abstract <T> T accept(PigLatinAstVisitor<T> visitor);

}
