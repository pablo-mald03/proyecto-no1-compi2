package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

/**
 * Principal class to define the for init representation
 *
 */
@Getter
public class ForInitDeclarationNodePigLatin extends StatementNodePigLatin {

    private final String id;
    private final TypeNodePigLatin type;
    private final ExpressionNodePigLatin expr;

    public ForInitDeclarationNodePigLatin(int line, int column, String id, TypeNodePigLatin type, ExpressionNodePigLatin expr) {
        super(line, column);
        this.id = id;
        this.type = type;
        this.expr = expr;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
