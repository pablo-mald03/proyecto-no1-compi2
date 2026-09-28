package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.StructInstanceNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.properties.StructPropertyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.VariableDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.ExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.parents.StatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.functions.FunctionsRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.principals.structs.StructuresRegionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Principal CFG builder class
 *
 */
public class YCFGBuilderVisitor implements YAstVisitor<Void> {

    private final CFG cfg;
    private final EditorContext context;

    private final Deque<List<CFGNode>> pendingExitsStack = new ArrayDeque<>();
    private List<CFGNode> currentPendingExits = new ArrayList<>();

    private final Deque<CFGNode> breakTargets = new ArrayDeque<>();
    private final Deque<CFGNode> continueTargets = new ArrayDeque<>();

    private CFGNode functionEntry;
    private CFGNode functionExit;

    public YCFGBuilderVisitor(CFG cfg, EditorContext context) {
        this.cfg = cfg;
        this.context = context;
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private CFGNode createStatementNode(String label, NodeType type, YAstNode ast) {
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
    public Void visit(ProgramNodeY node) {
        CFGNode entry = cfg.createNode("INICIO", NodeType.ENTRY, node);
        cfg.setEntryId(entry.getId());
        currentPendingExits.add(entry);

        if (node.getStructures() != null) {
            node.getStructures().accept(this);
        }
        if (node.getFunctions() != null) {
            node.getFunctions().accept(this);
        }

        CFGNode exit = cfg.createNode("FIN", NodeType.EXIT, node);
        cfg.setExitId(exit.getId());
        connectPendingExitsTo(exit);

        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY s : node.getStructs()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (YAstNode fn : node.getFunctions()) {
                if (fn != null) fn.accept(this);
            }
        }
        return null;
    }

    // ============================================================
    // STRUCTS (no-op para el CFG: no tienen cuerpo ejecutable)
    // ============================================================

    @Override
    public Void visit(StructDeclarationNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        return null;
    }

    // ============================================================
    // FUNCTIONS AND PROCEDURES
    // ============================================================

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        CFGNode fnEntry = cfg.createNode(
                "funcion " + node.getName(),
                NodeType.FUNCTION_ENTRY,
                node);

        CFGNode globalEntry = cfg.getNodes().get(cfg.getEntryId());
        if (globalEntry != null) {
            cfg.addEdge(globalEntry, fnEntry);
        }

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(fnEntry);

        CFGNode previousFunctionEntry = functionEntry;
        CFGNode previousFunctionExit = functionExit;
        functionEntry = fnEntry;

        CFGNode fnExit = cfg.createNode(
                "fin funcion " + node.getName(),
                NodeType.FUNCTION_EXIT,
                node);
        functionExit = fnExit;

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        connectPendingExitsTo(fnExit);

        functionEntry = previousFunctionEntry;
        functionExit = previousFunctionExit;
        popPendingExits();

        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        CFGNode procEntry = cfg.createNode(
                "procedimiento " + node.getName(),
                NodeType.FUNCTION_ENTRY,
                node);

        CFGNode globalEntry = cfg.getNodes().get(cfg.getEntryId());
        if (globalEntry != null) {
            cfg.addEdge(globalEntry, procEntry);
        }

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(procEntry);

        CFGNode previousFunctionEntry = functionEntry;
        CFGNode previousFunctionExit = functionExit;
        functionEntry = procEntry;

        CFGNode procExit = cfg.createNode(
                "fin procedimiento " + node.getName(),
                NodeType.FUNCTION_EXIT,
                node);
        functionExit = procExit;

        if (node.getBody() != null) {
            for (YAstNode s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }

        connectPendingExitsTo(procExit);

        functionEntry = previousFunctionEntry;
        functionExit = previousFunctionExit;
        popPendingExits();

        return null;
    }

    @Override
    public Void visit(StructParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(PrimitiveParameterNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayParameterNodeY node) {
        return null;
    }

    // ============================================================
    // VARIABLE DECLARATIONS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        CFGNode n = createStatementNode(
                "declaracion " + node.getIdentifier(),
                NodeType.DECLARATION,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        CFGNode n = createStatementNode(
                "declaracion arreglo " + node.getIdentifier(),
                NodeType.DECLARATION,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        CFGNode n = createStatementNode(
                "instancia struct " + node.getIdentifier(),
                NodeType.DECLARATION,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        CFGNode n = createStatementNode(
                "asignacion inicial del for",
                NodeType.STATEMENT,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        CFGNode n = createStatementNode(
                "asignacion inicial del for",
                NodeType.STATEMENT,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        CFGNode n = createStatementNode(
                "actualizacion del for",
                NodeType.STATEMENT,
                node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        CFGNode n = createStatementNode("asignacion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        CFGNode n = createStatementNode("operacion abreviada", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        CFGNode n = createStatementNode("incremento", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        CFGNode n = createStatementNode("decremento", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        CFGNode n = createStatementNode("pre-incremento", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        CFGNode n = createStatementNode("pre-decremento", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        CFGNode n = createStatementNode("expresion", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodeY node) {
        CFGNode n = createStatementNode("imprimir", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        CFGNode n = createStatementNode("leer", NodeType.STATEMENT, node);
        connectPendingExitsTo(n);
        addPendingExit(n);
        return null;
    }

    // ============================================================
    // RETURN / BREAK / CONTINUE
    // ============================================================

    @Override
    public Void visit(ReturnStatementNodeY node) {
        CFGNode n = createStatementNode("return", NodeType.RETURN, node);
        connectPendingExitsTo(n);
        if (functionExit != null) {
            cfg.addEdge(n, functionExit);
        }
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        CFGNode n = createStatementNode("break", NodeType.BREAK, node);
        connectPendingExitsTo(n);
        if (!breakTargets.isEmpty()) {
            cfg.addEdge(n, breakTargets.peek());
        }
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
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
    public Void visit(IfStatementNodeY node) {
        CFGNode cond = createStatementNode("condicion si", NodeType.CONDITION, node);
        connectPendingExitsTo(cond);

        CFGNode merge = cfg.createNode("union si", NodeType.MERGE, node);

        List<CFGNode> thenExits = new ArrayList<>();
        if (node.getThenBody() != null) {
            currentPendingExits = new ArrayList<>();
            currentPendingExits.add(cond);
            for (StatementNodeY s : node.getThenBody()) {
                if (s != null) s.accept(this);
            }
            thenExits = new ArrayList<>(currentPendingExits);
        } else {
            thenExits.add(cond);
        }

        List<List<CFGNode>> elseIfExits = new ArrayList<>();
        if (node.getElseIfs() != null) {
            for (ElseIfNodeY elseIf : node.getElseIfs()) {
                if (elseIf == null) continue;
                currentPendingExits = new ArrayList<>();
                currentPendingExits.add(cond);
                if (elseIf.getBody() != null) {
                    for (StatementNodeY s : elseIf.getBody()) {
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
                for (StatementNodeY s : node.getElseBlockNode().getBody()) {
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
    public Void visit(ElseIfNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    // ============================================================
    // WHILE
    // ============================================================

    @Override
    public Void visit(WhileStatementNodeY node) {
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
            for (StatementNodeY s : node.getBody()) {
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
    public Void visit(DoWhileStatementNodeY node) {
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
            for (StatementNodeY s : node.getBody()) {
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
    public Void visit(ForStatementNodeY node) {
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
            for (StatementNodeY s : node.getBody()) {
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
    public Void visit(SwitchStatementNodeY node) {
        CFGNode sw = cfg.createNode("elegir", NodeType.SWITCH, node);
        connectPendingExitsTo(sw);

        CFGNode exit = cfg.createNode("salida elegir", NodeType.MERGE, node);
        breakTargets.push(exit);

        pushPendingExits();
        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(sw);

        if (node.getCases() != null) {
            for (SwitchCaseNodeY c : node.getCases()) {
                if (c != null) c.accept(this);
            }
        }
        if (node.getDefaultCase() != null) {
            node.getDefaultCase().accept(this);
        }

        popPendingExits();
        breakTargets.pop();

        for (CFGNode e : currentPendingExits) {
            cfg.addEdge(e, exit);
        }

        currentPendingExits = new ArrayList<>();
        currentPendingExits.add(exit);
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        CFGNode c = cfg.createNode("caso", NodeType.CASE, node);
        connectPendingExitsTo(c);
        addPendingExit(c);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        CFGNode c = cfg.createNode("siempre", NodeType.CASE, node);
        connectPendingExitsTo(c);
        addPendingExit(c);

        if (node.getBody() != null) {
            for (StatementNodeY s : node.getBody()) {
                if (s != null) s.accept(this);
            }
        }
        return null;
    }

    // ============================================================
    // EXPRESSIONS (no-op)
    // ============================================================

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }
}