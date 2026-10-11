package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFG;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.CFGNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.cfg.NodeType;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.InstanceCreationExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.FieldDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.VariableDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.ConstructorDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.CodeBodyNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.visitor.ZAstVisitor;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Principal CFG builder visitor
 *
 */
@Getter
public class ZCFGBuilderVisitor implements ZAstVisitor<Void> {

    private final CFG cfg;
    private final EditorContext context;

    private final Deque<List<CFGNode>> pendingExitsStack = new ArrayDeque<>();
    private List<CFGNode> currentPendingExits = new ArrayList<>();

    private final Deque<CFGNode> breakTargets = new ArrayDeque<>();
    private final Deque<CFGNode> continueTargets = new ArrayDeque<>();

    private CFGNode functionEntry;
    private CFGNode functionExit;

    public ZCFGBuilderVisitor(CFG cfg, EditorContext context) {
        this.cfg = cfg;
        this.context = context;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private CFGNode createStatementNode(String label, NodeType type, ZAstNode ast) {
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

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodeZ node) {
        CFGNode entry = cfg.createNode("ENTRY", NodeType.ENTRY, node);
        cfg.setEntryId(entry.getId());
        currentPendingExits.add(entry);

        if (node.getClassNode() != null) {
            node.getClassNode().accept(this);
        }

        CFGNode exit = cfg.createNode("EXIT", NodeType.EXIT, node);
        cfg.setExitId(exit.getId());
        connectPendingExitsTo(exit);

        return null;
    }

    @Override
    public Void visit(ClassDeclarationNodeZ node) {
        if (node.getMembers() != null) {
            for (ZAstNode member : node.getMembers()) {
                if (member != null) member.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(CodeBodyNodeZ node) {
        if (node.getStatements() != null) {
            for (ZAstNode s : node.getStatements()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    // ============================================================
    // METHODS AND CONSTRUCTORS
    // ============================================================

    @Override
    public Void visit(MethodDeclarationNodeZ node) {
        CFGNode methodEntry = cfg.createNode(
                "metodo " + node.getName(),
                NodeType.FUNCTION_ENTRY,
                node);

        CFGNode globalEntry = cfg.getNodes().get(cfg.getEntryId());
        if (globalEntry != null) {
            cfg.addEdge(globalEntry, methodEntry);
        }

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(methodEntry);

        CFGNode previousFunctionEntry = functionEntry;
        CFGNode previousFunctionExit = functionExit;
        functionEntry = methodEntry;

        CFGNode methodExit = cfg.createNode(
                "final " + node.getName(),
                NodeType.FUNCTION_EXIT,
                node);
        functionExit = methodExit;

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        connectPendingExitsTo(methodExit);

        functionEntry = previousFunctionEntry;
        functionExit = previousFunctionExit;
        popPendingExits();

        return null;
    }

    @Override
    public Void visit(ConstructorDeclarationNodeZ node) {
        CFGNode ctorEntry = cfg.createNode(
                "ctor " + node.getName(),
                NodeType.FUNCTION_ENTRY,
                node);

        CFGNode globalEntry = cfg.getNodes().get(cfg.getEntryId());
        if (globalEntry != null) {
            cfg.addEdge(globalEntry, ctorEntry);
        }

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(ctorEntry);

        CFGNode previousFunctionEntry = functionEntry;
        CFGNode previousFunctionExit = functionExit;
        functionEntry = ctorEntry;

        CFGNode ctorExit = cfg.createNode(
                "end ctor " + node.getName(),
                NodeType.FUNCTION_EXIT,
                node);
        functionExit = ctorExit;

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        connectPendingExitsTo(ctorExit);

        functionEntry = previousFunctionEntry;
        functionExit = previousFunctionExit;
        popPendingExits();

        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeZ node) {
        CFGNode n = createStatementNode(
                "declaracion " + node.getIdentifier(),
                NodeType.DECLARATION,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(FieldDeclarationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ThisExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeZ node) {
        CFGNode n = createStatementNode(
                "declaracion de arreglo " + node.getIdentifier(),
                NodeType.DECLARATION,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodeZ node) {
        CFGNode n = createStatementNode("asignacion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeZ node) {
        CFGNode n = createStatementNode("abreviacion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeZ node) {
        CFGNode n = createStatementNode("++", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeZ node) {
        CFGNode n = createStatementNode("--", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeZ node) {
        CFGNode n = createStatementNode("++", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeZ node) {
        CFGNode n = createStatementNode("--", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeZ node) {
        CFGNode n = createStatementNode("expresion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeZ node) {
        CFGNode n = createStatementNode("print", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeZ node) {
        CFGNode n = createStatementNode("read", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    // ============================================================
    // RETURN / BREAK / CONTINUE
    // ============================================================

    @Override
    public Void visit(ReturnStatementNodeZ node) {
        CFGNode n = createStatementNode("return", NodeType.RETURN, node);
        connectPendingExitsTo(n);
        // Connect the return to the current function's exit so the exit is reachable.
        if (functionExit != null) {
            cfg.addEdge(n, functionExit);
        }
        // No pending exit: the flow stops here.
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeZ node) {
        CFGNode n = createStatementNode("break", NodeType.BREAK, node);
        connectPendingExitsTo(n);
        if (!breakTargets.isEmpty()) {
            cfg.addEdge(n, breakTargets.peek());
        }
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeZ node) {
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
    public Void visit(IfStatementNodeZ node) {
        CFGNode cond = createStatementNode("condicion del if", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode merge = cfg.createNode("union del if", NodeType.MERGE, node);

        List<CFGNode> thenExits = new ArrayList<>();
        if (node.getThenBody() != null) {
            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(cond);
            for (ZAstNode s : node.getThenBody()) {
                if (s != null) s.accept(this);
            }
            thenExits = new ArrayList<>(currentPendingExits);
        } else {
            thenExits.add(cond);
        }

        List<List<CFGNode>> elseIfExits = new ArrayList<>();
        if (node.getElseIfs() != null) {
            for (ElseIfNodeZ elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;
                currentPendingExits = new ArrayList<>();
                currentPendingExits.add(cond);
                if (elseIf.getBody() != null) {
                    for (ZAstNode s : elseIf.getBody()) {
                        if (s != null) s.accept(this);
                    }
                }
                elseIfExits.add(new ArrayList<>(currentPendingExits));
            }
        }

        List<CFGNode> elseExits = new ArrayList<>();
        if (node.getElseBlockNode() != null) {
            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(cond);
            if (node.getElseBlockNode().getBody() != null) {
                for (ZAstNode s : node.getElseBlockNode().getBody()) {
                    if (s != null) s.accept(this);
                }
            }
            elseExits = new ArrayList<>(currentPendingExits);
        } else if (elseIfExits.isEmpty()) {
            elseExits.add(cond);
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
    public Void visit(ElseIfNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeZ node) {
        return null;
    }

    // ============================================================
    // WHILE
    // ============================================================

    @Override
    public Void visit(WhileStatementNodeZ node) {
        CFGNode cond = createStatementNode("condicion de while", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode exit = cfg.createNode("salida de while", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        breakTargets.push(exit);
        continueTargets.push(cond);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(cond);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
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
    public Void visit(DoWhileStatementNodeZ node) {
        CFGNode bodyStart = cfg.createNode("cuerpo de do-while", NodeType.LOOP_HEADER, node);
        connectPendingExitsTo(bodyStart);

        CFGNode cond = createStatementNode("condicion de do-while", NodeType.CONDITION, node);
        CFGNode exit = cfg.createNode("salida de do-while", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        breakTargets.push(exit);
        continueTargets.push(cond);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(bodyStart);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
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
    public Void visit(ForStatementNodeZ node) {
        if (node.getInit() != null) {
            node.getInit().accept(this);
        }

        CFGNode cond = createStatementNode("condicion de for", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode exit = cfg.createNode("salida del for", NodeType.LOOP_EXIT, node);
        cfg.addEdge(cond, exit);

        CFGNode update = cfg.createNode("actualizacion del for", NodeType.STATEMENT, node);

        breakTargets.push(exit);
        continueTargets.push(update);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(cond);

        if (node.getBody() != null) {
            for (ZAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
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
    // SWITCH
    // ============================================================

    @Override
    public Void visit(SwitchStatementNodeZ node) {
        CFGNode sw = cfg.createNode("switch", NodeType.SWITCH, node);
        connectPendingExitsTo(sw);

        CFGNode exit = cfg.createNode("salida del switch", NodeType.MERGE, node);
        breakTargets.push(exit);

        pushPendingExits();

        List<CFGNode> branchExits = new ArrayList<>();

        if (node.getCases() != null) {
            for (SwitchCaseNodeZ c : node.getCases()) {
                if (c == null) continue;
                CFGNode caseNode = cfg.createNode("case", NodeType.CASE, c);
                cfg.addEdge(sw, caseNode);

                currentPendingExits = new ArrayList<>();
                currentPendingExits.add(caseNode);

                if (c.getBody() != null) {
                    for (ZAstNode s : c.getBody()) {
                        if (s != null) s.accept(this);
                    }
                }

                branchExits.addAll(currentPendingExits);
            }
        }

        if (node.getDefaultCase() != null) {
            DefaultCaseNodeZ d = node.getDefaultCase();
            CFGNode defNode = cfg.createNode("default", NodeType.CASE, d);
            cfg.addEdge(sw, defNode);

            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(defNode);

            if (d.getBody() != null) {
                for (ZAstNode s : d.getBody()) {
                    if (s != null) s.accept(this);
                }
            }

            branchExits.addAll(currentPendingExits);
        }

        for (CFGNode e : branchExits) {
            cfg.addEdge(e, exit);
        }

        breakTargets.pop();
        popPendingExits();

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(exit);
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeZ node) {
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeZ node) {
        return null;
    }

    // ============================================================
    // DECLARATION OF FOR-INIT
    // ============================================================

    @Override
    public Void visit(ForInitDeclarationNodeZ node) {
        CFGNode n = createStatementNode("for inicializacion", NodeType.DECLARATION, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeZ node) {
        CFGNode n = createStatementNode("for asingacion inicial", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeZ node) {
        CFGNode n = createStatementNode("for actualizacion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    // ============================================================
    // EXPRESSIONS (no-op)
    // ============================================================
    @Override
    public Void visit(LiteralExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TernaryExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ObjectInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInstantiationNodeZ node) {
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeZ node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeZ node) {
        return null;
    }

    @Override
    public Void visit(ParameterNodeZ node) {
        return null;
    }
}