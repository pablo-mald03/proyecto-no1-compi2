package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services.*;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * Principal symbol collector visitor
 *
 */
@Getter
public class PigLatinSymbolCollectorVisitor implements PigLatinAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final Map<String, String> importResolutionMap;

    private final ScopePigResolutionService scopes;
    private final TypePigResolutionService types;
    private final SemanticPigErrorReporterService reporter;
    private final SymbolPigDeclarationService declarations;
    private final SymbolPigMemberCollectorService members;
    private final ImportPigResolutionService imports;

    public PigLatinSymbolCollectorVisitor(GlobalSymbolTable table,
                                          EditorContext context,
                                          Map<String, String> importResolutionMap) {
        this.table = table;
        this.context = context;
        this.importResolutionMap = importResolutionMap;

        this.reporter = new SemanticPigErrorReporterService(context);
        this.types = new TypePigResolutionService();
        this.scopes = new ScopePigResolutionService(table, context);
        this.members = new SymbolPigMemberCollectorService(context, types);
        this.declarations = new SymbolPigDeclarationService(table, context, reporter, types);
        this.imports = new ImportPigResolutionService(
                table, context, reporter, new SymbolPigLookupService(table));
    }

    // ---------------- TOP LEVEL ----------------

    @Override
    public Void visit(ProgramNodePigLatin node) {
        SymbolScope fileScope = table.getOrCreateFileScope(context.getFilePath());
        table.setCurrentScope(fileScope);
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
        scopes.registerScope(node, SymbolScopeKind.FUNCTION);
        try {
            if (node.getStatements() != null) node.getStatements().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    // ---------------- IMPORTS ----------------

    @Override
    public Void visit(ImportNodePigLatin node) {
        String rawPath = node.getImportPath();
        String logicalName = imports.extractLogicalName(rawPath);
        String resolvedPath = importResolutionMap != null
                ? importResolutionMap.get(rawPath) : null;

        declarations.declareImport(logicalName, resolvedPath, node);
        imports.bringImportedSymbols(resolvedPath, node);
        return null;
    }

    // ---------------- VARIABLES SECTION ----------------

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
    public Void visit(VariableDeclarationNodePigLatin node) {
        declarations.declareVariable(node.getIdentifier(), node.getDataType(), node);
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 0;
        declarations.declareArray(node.getIdentifier(), node.getDataType(), dims, node);
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        declarations.declareStructInstance(node.getIdentifier(), node.getStructType(), node);
        return null;
    }

    // ---------------- CODE BLOCKS ----------------

    @Override
    public Void visit(CodeBodyNodePigLatin node) {
        if (node.getStatements() != null) {
            for (PigLatinAstNode s : node.getStatements()) if (s != null) s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getThenBody() != null) {
                for (PigLatinAstNode s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodePigLatin e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) {
                for (PigLatinAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) node.getBody().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getBody() != null) node.getBody().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);
        try {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) node.getBody().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        declarations.declareForVariable(node.getId(), node.getType(), node);
        return null;
    }

    // ---------------- STRUCT ----------------

    @Override
    public Void visit(StructDeclarationNodePigLatin node) {
        List<Symbol> memberSymbols = members.collectFromBody(node.getAttributes());
        declarations.declareStruct(node.getStructName(), node, memberSymbols);
        return null;
    }

    // ---------------- NO-DECLARING ----------------

    @Override
    public Void visit(StructBodyNodePigLatin node) {
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
    public Void visit(StructPropertyNodePigLatin node) {
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
    public Void visit(ShortlyOperationNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
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
    public Void visit(TypeNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodePigLatin node) {
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
    public Void visit(ForInitAssignmentNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodePigLatin node) {
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
    public Void visit(ArgumentsNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        return null;
    }
}