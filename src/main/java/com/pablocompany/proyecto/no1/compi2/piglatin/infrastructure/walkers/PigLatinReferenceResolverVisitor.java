package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.ImportPigResolutionService;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.ScopePigResolutionService;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.SemanticPigErrorReporterService;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.SymbolPigLookupService;
import lombok.Getter;

import java.util.List;

/**
 * Principal pig latin ast resolver visitor
 *
 */
@Getter
public class PigLatinReferenceResolverVisitor implements PigLatinAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    private final ScopePigResolutionService scopes;
    private final SemanticPigErrorReporterService reporter;
    private final SymbolPigLookupService lookup;
    private final ImportPigResolutionService imports;

    public PigLatinReferenceResolverVisitor(GlobalSymbolTable table,
                                            EditorContext context) {
        this.table = table;
        this.context = context;

        this.reporter = new SemanticPigErrorReporterService(context);
        this.scopes = new ScopePigResolutionService(table, context);
        this.lookup = new SymbolPigLookupService(table);
        this.imports = new ImportPigResolutionService(table, context, reporter, lookup);
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
        if (node.getImports() != null) {
            for (ImportNodePigLatin i : node.getImports()) if (i != null) i.accept(this);
        }
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

    @Override
    public Void visit(ImportNodePigLatin node) {
        return null;
    }

    // ---------------- EXPRESIONES ----------------

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        if (lookup.resolveByName(node.getIdentifier()).isEmpty()) {
            reporter.reportUndeclared(node.getIdentifier(), node);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {
        if (node.getTarget() != null) {
            resolveTargetOrMember(node.getTarget(), node.getFunctionName(), node);
        } else {
            imports.validateDirectCall(node.getFunctionName(), node);
        }
        visitArgs(node.getArguments());
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodePigLatin node) {
        if (node.getTarget() != null) {
            resolveTargetOrMember(node.getTarget(), node.getPropertyName(), node);
        }
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodePigLatin node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getIndex() != null) node.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodePigLatin node) {
        if (lookup.resolveByName(node.getArrayName()).isEmpty()) {
            reporter.reportUndeclared(node.getArrayName(), node);
        }
        if (node.getIndexExpression() != null) node.getIndexExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodePigLatin node) {
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodePigLatin node) {
        if (node.getElements() != null) {
            for (ExpressionNodePigLatin e : node.getElements()) if (e != null) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodePigLatin node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodePigLatin p : node.getProperties()) if (p != null) p.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructPropertyNodePigLatin node) {
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        if (!imports.typeExists(node.getClassName(), node)) {
            reporter.reportUnknownType(node.getClassName(), node);
        }
        visitArgs(node.getArguments());
        return null;
    }

    @Override
    public Void visit(ArgumentsNodePigLatin node) {
        visitArgs(node.getArguments());
        return null;
    }

    @Override
    public Void visit(TypeNodePigLatin node) {
        if (node.getDataType() == DataType.CUSTOM && node.getCustomTypeName() != null) {
            if (!imports.typeExists(node.getCustomTypeName(), node)) {
                reporter.reportUnknownType(node.getCustomTypeName(), node);
            }
        }
        return null;
    }

    @Override
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    // ---------------- STATEMENTS ----------------

    @Override
    public Void visit(VariableDeclarationNodePigLatin node) {
        if (node.getInitializer() != null) node.getInitializer().accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        if (node.getDimensions() != null) {
            for (ExpressionNodePigLatin d : node.getDimensions()) if (d != null) d.accept(this);
        }
        if (node.getInitializer() != null) node.getInitializer().accept(this);
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        if (!imports.typeExists(node.getStructType(), node)) {
            reporter.reportUnknownType(node.getStructType(), node);
        }
        if (node.getLiteral() != null) node.getLiteral().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        if (node.getIdentifier() != null) node.getIdentifier().accept(this);
        if (node.getExpressionNode() != null) node.getExpressionNode().accept(this);
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) node.getTargetVariable().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        if (node.getExpressionList() != null) {
            for (ExpressionNodePigLatin e : node.getExpressionList()) e.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
        if (node.getValue() != null) node.getValue().accept(this);
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
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        if (lookup.resolveByName(node.getId()).isEmpty()) {
            reporter.reportUndeclared(node.getId(), node);
        }
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
        if (node.getTarget() != null) node.getTarget().accept(this);
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    // ---------------- CONTROL FLOW ----------------

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getCondition() != null) node.getCondition().accept(this);
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
            if (node.getCondition() != null) node.getCondition().accept(this);
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
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getBody() != null) node.getBody().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
        });
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        withScope(node, () -> {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) node.getBody().accept(this);
        });
        return null;
    }

    // ---------------- NO-OP ----------------

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

    private void resolveTargetOrMember(ExpressionNodePigLatin target,
                                       String memberName,
                                       PigLatinAstNode node) {
        if (target instanceof IdentifierExpressionNodePigLatin id) {
            Symbol importSym = imports.resolveImportTarget(id.getIdentifier());
            if (importSym != null) {
                imports.validateMemberOfImport(importSym, memberName, node);
                return;
            }
        }
        target.accept(this);
    }

    private void visitArgs(List<ExpressionNodePigLatin> args) {
        if (args == null) return;
        for (ExpressionNodePigLatin a : args) if (a != null) a.accept(this);
    }
}