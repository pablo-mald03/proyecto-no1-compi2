package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFG;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFGNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.NodeType;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.InstanceCreationExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.ShortlyOperationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.AccessorNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.instances.ExpressionStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.StructInstanceNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructPropertyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.VariableDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.BreakStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ContinueStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.breakpoints.ReturnStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseBlockNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfListNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.IfStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.PrintStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.iostreams.ReadStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.MaiorSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Pig latin CFG builder visitor
 *
 */
@Getter
public class PigLatinCFGBuilderVisitor implements PigLatinAstVisitor<Void> {

    private final CFG cfg;
    private final EditorContext context;

    private final Deque<List<CFGNode>> pendingExitsStack = new ArrayDeque<>();
    private List<CFGNode> currentPendingExits = new ArrayList<>();

    private final Deque<CFGNode> breakTargets = new ArrayDeque<>();
    private final Deque<CFGNode> continueTargets = new ArrayDeque<>();

    private CFGNode programExit;

    public PigLatinCFGBuilderVisitor(CFG cfg, EditorContext context) {
        this.cfg = cfg;
        this.context = context;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private CFGNode createStatementNode(String label, NodeType type, PigLatinAstNode ast) {
        return cfg.createNode(label, type, ast);
    }

    private void connectPendingExitsTo(CFGNode target) {
        for (CFGNode pending : currentPendingExits) {
            cfg.addEdge(pending, target);
        }
        currentPendingExits = new ArrayList<>();
    }

    private void addPendingExit(CFGNode node) {
        currentPendingExits.add(node);
    }

    private void pushPendingExits() {
        pendingExitsStack.push(new ArrayList<>(currentPendingExits));
        currentPendingExits = new ArrayList<>();
    }

    private void popPendingExits() {
        currentPendingExits = pendingExitsStack.pop();
    }

    /**
     * Simple node evaluation
     */
    private Void simpleStatement(String label, NodeType type, PigLatinAstNode node) {
        CFGNode n = createStatementNode(label, type, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    private void visitAll(List<? extends PigLatinAstNode> nodes) {
        if (nodes == null) return;
        for (PigLatinAstNode n : nodes) {
            if (n != null) n.accept(this);
        }
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodePigLatin node) {
        CFGNode entry = cfg.createNode("INICIO", NodeType.ENTRY, node);
        cfg.setEntryId(entry.getId());
        currentPendingExits.add(entry);

        programExit = cfg.createNode("FIN", NodeType.EXIT, node);
        cfg.setExitId(programExit.getId());

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        connectPendingExitsTo(programExit);
        return null;
    }

    @Override
    public Void visit(BodyNodePigLatin node) {
        if (node.getVariablesSection() != null) node.getVariablesSection().accept(this);
        if (node.getMaiorSection() != null) node.getMaiorSection().accept(this);
        return null;
    }

    @Override
    public Void visit(CodeBodyNodePigLatin node) {
        visitAll(node.getStatements());
        return null;
    }

    @Override
    public Void visit(VariablesBodyNodePigLatin node) {
        visitAll(node.getDeclarations());
        return null;
    }

    @Override
    public Void visit(MaiorSectionNodePigLatin node) {
        node.getStatements().accept(this);
        return null;
    }

    @Override
    public Void visit(VariablesSectionNodePigLatin node) {
        node.getDeclarations().accept(this);
        return null;
    }

    // ============================================================
    // NO-OP
    // ============================================================

    @Override
    public Void visit(ImportNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(AccessorNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructBodyNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructDeclarationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructAttributeNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(TypeNodePigLatin node) {
        return null;
    }

    // ============================================================
    // SIMPLE DECLARATIONS AND SENTENCES
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodePigLatin node) {
        return simpleStatement("declaracion " + node.getIdentifier(), NodeType.DECLARATION, node);
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        return simpleStatement("declaracion arreglo " + node.getIdentifier(), NodeType.DECLARATION, node);
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        return simpleStatement("instancia struct " + node.getIdentifier(), NodeType.DECLARATION, node);
    }

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        return simpleStatement("asignacion", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
        return simpleStatement("operacion abreviada", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(IncrementStatementNodePigLatin node) {
        return simpleStatement("incremento", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        return simpleStatement("decremento", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        return simpleStatement("pre-incremento", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        return simpleStatement("pre-decremento", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        return simpleStatement("expresion", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        return simpleStatement("imprimir", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        return simpleStatement("leer", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        return simpleStatement("asignacion inicial del for", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        return simpleStatement("asignacion inicial del for", NodeType.STATEMENT, node);
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
        // El nodo de actualizacion lo crea visit(ForStatementNodePigLatin)
        return null;
    }

    // ============================================================
    // RETURN / BREAK / CONTINUE
    // ============================================================

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
        CFGNode n = createStatementNode("return", NodeType.RETURN, node);
        connectPendingExitsTo(n);
        if (programExit != null) {
            cfg.addEdge(n, programExit);
        }
        return null;
    }

    @Override
    public Void visit(BreakStatementNodePigLatin node) {
        CFGNode n = createStatementNode("break", NodeType.BREAK, node);
        connectPendingExitsTo(n);
        if (!breakTargets.isEmpty()) {
            cfg.addEdge(n, breakTargets.peek());
        }
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodePigLatin node) {
        CFGNode n = createStatementNode("continue", NodeType.CONTINUE, node);
        connectPendingExitsTo(n);
        if (!continueTargets.isEmpty()) {
            cfg.addEdge(n, continueTargets.peek());
        }
        return null;
    }

    // ============================================================
    // IF
    // ============================================================

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        CFGNode cond = createStatementNode("condicion si", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode merge = cfg.createNode("union si", NodeType.MERGE, node);

        // THEN
        List<CFGNode> thenExits = new ArrayList<>();
        if (node.getThenBody() != null) {
            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(cond);
            visitAll(node.getThenBody());
            thenExits = new ArrayList<>(currentPendingExits);
        } else {
            thenExits.add(cond);
        }

        // ELSE IFs
        List<List<CFGNode>> elseIfExits = new ArrayList<>();
        if (node.getElseIfs() != null) {
            for (ElseIfNodePigLatin elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;
                currentPendingExits = new ArrayList<>();
                currentPendingExits.add(cond);
                visitAll(elseIf.getBody());
                elseIfExits.add(new ArrayList<>(currentPendingExits));
            }
        }

        // ELSE
        List<CFGNode> elseExits = new ArrayList<>();
        if (node.getElseBlockNode() != null) {
            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(cond);
            visitAll(node.getElseBlockNode().getBody());
            elseExits = new ArrayList<>(currentPendingExits);
        } else {
            elseExits.add(cond); // camino falso implicito
        }

        for (CFGNode e : thenExits) cfg.addEdge(e, merge);
        for (List<CFGNode> exits : elseIfExits) {
            for (CFGNode e : exits) cfg.addEdge(e, merge);
        }
        for (CFGNode e : elseExits) cfg.addEdge(e, merge);

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(merge);
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodePigLatin node) {
        return null;
    }

    // ============================================================
    // WHILE
    // ============================================================

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        CFGNode cond = createStatementNode("condicion mientras", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode exit = cfg.createNode("salida mientras", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        breakTargets.push(exit);
        continueTargets.push(cond);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(cond);


        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        for (CFGNode e : currentPendingExits) {
            cfg.addEdge(e, cond);
        }

        popPendingExits();
        breakTargets.pop();
        continueTargets.pop();

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(exit);
        return null;
    }

    // ============================================================
    // DO-WHILE
    // ============================================================

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        CFGNode bodyStart = cfg.createNode("cuerpo hacer", NodeType.LOOP_HEADER, node);
        connectPendingExitsTo(bodyStart);

        CFGNode cond = createStatementNode("condicion hacer-mientras", NodeType.CONDITION, node);
        CFGNode exit = cfg.createNode("salida hacer-mientras", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        breakTargets.push(exit);
        continueTargets.push(cond);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(bodyStart);


        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        for (CFGNode e : currentPendingExits) {
            cfg.addEdge(e, cond);
        }

        popPendingExits();
        cfg.addEdge(cond, bodyStart);
        breakTargets.pop();
        continueTargets.pop();

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(exit);
        return null;
    }

    // ============================================================
    // FOR
    // ============================================================

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        if (node.getInit() != null) {
            node.getInit().accept(this);
        }

        CFGNode cond = createStatementNode("condicion para", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode exit = cfg.createNode("salida para", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        CFGNode update = cfg.createNode("actualizacion para", NodeType.STATEMENT, node);

        breakTargets.push(exit);
        continueTargets.push(update);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(cond);


        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        for (CFGNode e : currentPendingExits) {
            cfg.addEdge(e, update);
        }

        popPendingExits();
        cfg.addEdge(update, cond);
        breakTargets.pop();
        continueTargets.pop();

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(exit);
        return null;
    }

    // ============================================================
    // EXPRESIONES (no-op)
    // ============================================================

    @Override
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        return null;
    }
}