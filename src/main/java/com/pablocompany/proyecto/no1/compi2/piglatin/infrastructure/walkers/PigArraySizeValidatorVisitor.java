package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.PigArraySizeEvaluatorService;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.ScopePigResolutionService;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.SemanticPigErrorReporterService;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * Visitor who walks the PigLatin AST and validates the size expressions of every
 */
public class PigArraySizeValidatorVisitor implements PigLatinAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    private final PigArraySizeEvaluatorService evaluator;
    private final SemanticPigErrorReporterService reporter;
    private final ScopePigResolutionService scopes;

    public PigArraySizeValidatorVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
        this.evaluator = new PigArraySizeEvaluatorService();
        this.reporter = new SemanticPigErrorReporterService(context);
        this.scopes = new ScopePigResolutionService(table, context);
    }

    // ---------------- TOP LEVEL ----------------

    @Override
    public Void visit(ProgramNodePigLatin node) {
        SymbolScope fileScope = table.getFileScope(context.getFilePath());
        if (fileScope != null) table.setCurrentScope(fileScope);
        if (node.getBody() != null) node.getBody().accept(this);
        table.resetToGlobal();
        return null;
    }

    @Override
    public Void visit(BodyNodePigLatin node) {
        if (node.getVariablesSection() != null) node.getVariablesSection().accept(this);
        if (node.getMaiorSection() != null) node.getMaiorSection().accept(this);
        return null;
    }

    @Override
    public Void visit(MaiorSectionNodePigLatin node) {
        withScope(node, () -> {
            if (node.getStatements() != null) node.getStatements().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(VariablesSectionNodePigLatin node) {
        if (node.getDeclarations() != null) node.getDeclarations().accept(this);
        return null;
    }

    @Override
    public Void visit(VariablesBodyNodePigLatin node) {
        if (node.getDeclarations() != null) {
            for (PigLatinAstNode d : node.getDeclarations()) if (d != null) d.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CodeBodyNodePigLatin node) {
        if (node.getStatements() != null) {
            for (PigLatinAstNode s : node.getStatements()) if (s != null) s.accept(this);
        }
        return null;
    }

    // ---------------- THE ACTUAL CHECKS ----------------

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        if (node.getDimensions() != null) {
            for (ExpressionNodePigLatin dim : node.getDimensions()) {
                validateSize(dim, node.getIdentifier(), node);
            }
        }
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
            checkInitShape(node);
        }
        return null;
    }

    /**
     * Method to evaluate if the expression is evaluable to a constant, it must be >= 0.
     */
    private void validateSize(ExpressionNodePigLatin expr, String arrayName, PigLatinAstNode errorNode) {
        if (expr == null) return;

        OptionalInt size = evaluator.evaluate(expr);
        if (size.isEmpty()) return;

        if (size.getAsInt() < 0) {
            reporter.reportTypeError(arrayName, "El tamano del arreglo '" + arrayName + "' no puede ser negativo: " + size.getAsInt(), errorNode);
        }
    }

    // ---------------- CONTROL FLOW (scope traversal) ----------------

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getThenBody() != null) {
                for (PigLatinAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodePigLatin e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        withScope(node, () -> {
            if (node.getBody() != null) {
                for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        withScope(node, () -> {
            if (node.getBody() != null) {
                for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        });
        return null;
    }

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    // ---------------- ALL OTHER NODES: no-op ----------------
    @Override
    public Void visit(ImportNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {
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
    public Void visit(ArrayCallExpressionNodePigLatin node) {
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
    public Void visit(ArrayInitExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructPropertyNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(TypeNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(VariableDeclarationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
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
    public Void visit(AccessorNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodePigLatin node) {
        return null;
    }

    // ---------------- HELPERS ----------------

    /**
     * Helper to validate the scope of the symbol
     *
     */
    private void withScope(PigLatinAstNode node, Runnable body) {
        SymbolScope previous = table.getCurrentScope();
        SymbolScope scope = scopes.lookupRegisteredScope(node);
        if (scope != null) table.setCurrentScope(scope);
        try {
            body.run();
        } finally {
            table.setCurrentScope(previous);
        }
    }

    /**
     * Validates that the initializer shape matches the declared dimensions.
     */
    private void checkInitShape(ArrayDeclarationNodePigLatin node) {
        if (node.getInitializer() == null) return;
        if (node.getDimensions() == null || node.getDimensions().isEmpty()) return;

        List<Integer> dims = new ArrayList<>();
        for (ExpressionNodePigLatin dim : node.getDimensions()) {
            OptionalInt size = evaluator.evaluate(dim);
            if (size.isEmpty()) return;
            dims.add(size.getAsInt());
        }

        if (!(node.getInitializer() instanceof ArrayInitExpressionNodePigLatin init)) {
            return;
        }

        validateInitShapeRecursive(init, dims, 0, node.getIdentifier(), node);
    }

    /**
     * Recursive shape validation: for array indexes
     */
    private void validateInitShapeRecursive(ArrayInitExpressionNodePigLatin init, List<Integer> dims, int dimIndex, String arrayName, PigLatinAstNode errorNode) {
        if (dimIndex >= dims.size()) return;

        int expected = dims.get(dimIndex);
        List<ExpressionNodePigLatin> elements = init.getElements();
        int actual = elements != null ? elements.size() : 0;

        if (actual != expected) {
            reporter.reportTypeError(arrayName, "El arreglo '" + arrayName + "' espera " + expected + " elemento(s) en la dimension " + (dimIndex + 1) + ", pero se dieron " + actual, errorNode);
            return;
        }

        if (dimIndex + 1 < dims.size()) {
            for (int i = 0; i < actual; i++) {
                ExpressionNodePigLatin elem = elements.get(i);
                if (elem instanceof ArrayInitExpressionNodePigLatin nested) {
                    validateInitShapeRecursive(nested, dims, dimIndex + 1, arrayName, errorNode);
                } else {
                    reporter.reportTypeError(arrayName,
                            "El arreglo '" + arrayName + "' es multidimensional ("
                                    + dims.size() + "D) pero el elemento " + i
                                    + " de la dimension " + (dimIndex + 1)
                                    + " no es un arreglo anidado",
                            errorNode);
                    return;
                }
            }
        }
    }
}