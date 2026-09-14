package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

//This class is the principal of the family nodes of the AST for pig latin parser
@Getter
public abstract class YAstNode extends AstNode {

    public YAstNode(int line, int column) {
        super(line, column);
    }

    //This is the principal dispatcher method to generate the compiled code
    public abstract <T> T accept(YAstVisitor<T> visitor);

}
