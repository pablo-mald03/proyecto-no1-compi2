package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals;


import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the prncipal statement node
@Getter
public class IfStatementNodeY extends StatementNodeY {
    private final ExpressionNodeY condition;
    private final List<YAstNode> thenBody;
    private final List<ElseIfNodeY> elseIfs;
    private final ElseBlockNodeY elseBlockNode;

    public IfStatementNodeY(int line, int column, ExpressionNodeY condition, List<YAstNode> thenBody, List<ElseIfNodeY> elseIfs, ElseBlockNodeY elseBlockNode) {
        super(line, column);
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseIfs = elseIfs;
        this.elseBlockNode = elseBlockNode;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}