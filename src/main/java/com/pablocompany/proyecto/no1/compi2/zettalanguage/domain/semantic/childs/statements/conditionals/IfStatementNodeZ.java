package com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals;


import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.StatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the prncipal statement node
@Getter
public class IfStatementNodeZ extends StatementNodeZ {
    private final ExpressionNodeZ condition;
    private final List<ZAstNode> thenBody;
    private final List<ElseIfNodeZ> elseIfs;
    private final ElseBlockNodeZ elseBlockNode;

    public IfStatementNodeZ(int line, int column, ExpressionNodeZ condition, List<ZAstNode> thenBody, List<ElseIfNodeZ> elseIfs, ElseBlockNodeZ elseBlockNode) {
        super(line, column);
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseIfs = elseIfs;
        this.elseBlockNode = elseBlockNode;
    }

    @Override
    public <T> T accept(ZAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}