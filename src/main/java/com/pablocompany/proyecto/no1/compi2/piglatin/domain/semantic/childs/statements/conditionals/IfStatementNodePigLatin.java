package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the prncipal statement node
@Getter
public class IfStatementNodePigLatin extends StatementNodePigLatin {
    private final ExpressionNodePigLatin condition;
    private final List<PigLatinAstNode> thenBody;
    private final List<ElseIfNodePigLatin> elseIfs;
    private final ElseBlockNodePigLatin elseBlockNode;

    public IfStatementNodePigLatin(int line, int column, ExpressionNodePigLatin condition, List<PigLatinAstNode> thenBody, List<ElseIfNodePigLatin> elseIfs, ElseBlockNodePigLatin elseBlockNode) {
        super(line, column);
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseIfs = elseIfs;
        this.elseBlockNode = elseBlockNode;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}