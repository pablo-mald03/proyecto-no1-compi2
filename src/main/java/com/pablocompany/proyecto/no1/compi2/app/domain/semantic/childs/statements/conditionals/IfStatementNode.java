package com.pablocompany.practica.no1.compi2.domain.semantic.childs.statements.conditionals;

import com.pablocompany.practica.no1.compi2.domain.semantic.AstNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.ExpressionNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.parents.StatementNode;
import com.pablocompany.practica.no1.compi2.domain.visitors.AstVisitor;
import lombok.Getter;

import java.util.List;

//This class is the prncipal statement node
@Getter
public class IfStatementNode extends StatementNode {
    private final ExpressionNode condition;
    private final List<AstNode> thenBody;
    private final List<ElseIfNode> elseIfs;
    private final ElseBlockNode elseBlockNode;

    public IfStatementNode(int line, int column, ExpressionNode condition, List<AstNode> thenBody, List<ElseIfNode> elseIfs, ElseBlockNode elseBlockNode) {
        super(line, column);
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseIfs = elseIfs;
        this.elseBlockNode = elseBlockNode;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}