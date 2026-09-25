package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Principal pig latin ast resolver visitor
 *
 */
public class PigLatinReferenceResolverVisitor implements PigLatinAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    public PigLatinReferenceResolverVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;
    }

    // ============================================================
    // TOP-LEVEL
    // ============================================================

    @Override
    public Void visit(ProgramNodePigLatin node) {
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BodyNodePigLatin node) {
        if (node.getVariablesSection() != null) {
            node.getVariablesSection().accept(this);
        }
        if (node.getMaiorSection() != null) {
            node.getMaiorSection().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MaiorSectionNodePigLatin node) {
        if (node.getStatements() != null) {
            node.getStatements().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VariablesSectionNodePigLatin node) {
        if (node.getDeclarations() != null) {
            node.getDeclarations().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VariablesBodyNodePigLatin node) {
        if (node.getDeclarations() != null) {
            for (PigLatinAstNode declaration : node.getDeclarations()) {
                if (declaration != null) {
                    declaration.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(CodeBodyNodePigLatin node) {
        if (node.getStatements() != null) {
            for (PigLatinAstNode statement : node.getStatements()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        return null;
    }

    // ============================================================
    // IMPORTS (nothing to resolve: already validated in phase 1)
    // ============================================================

    @Override
    public Void visit(ImportNodePigLatin node) {
        return null;
    }

    // ============================================================
    // EXPRESSIONS (references)
    // ============================================================

    @Override
    public Void visit(IdentifierExpressionNodePigLatin node) {
        String name = node.getIdentifier();
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
        if (found.isEmpty()) {
            reportUndeclared(name, node);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodePigLatin node) {
        if (node.getTarget() != null) {
            // Instance call: p.calcular() or Persona.calcular()
            Symbol importTarget = resolveImportTarget(node.getTarget());
            if (importTarget != null) {
                // Persona.calcular(): validate that the function exists in the imported file.
                validateMemberOfImport(importTarget, node.getFunctionName(), node);
            } else {
                // p.calcular(): only resolve the target. The member is validated in TypeChecker.
                node.getTarget().accept(this);
            }
        } else {
            // Direct call: method(). Search in all imported .y files.
            validateDirectCallInImports(node.getFunctionName(), node);
        }

        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(PropertyAccessExpressionNodePigLatin node) {
        if (node.getTarget() != null) {
            Symbol importTarget = resolveImportTarget(node.getTarget());
            if (importTarget != null) {
                // Persona.atributo: validate the member exists in the imported file.
                validateMemberOfImport(importTarget, node.getPropertyName(), node);
            } else {
                // p.atributo: only resolve the target.
                node.getTarget().accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(MemberArrayAccessExpressionNodePigLatin node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getIndex() != null) {
            node.getIndex().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayCallExpressionNodePigLatin node) {
        String name = node.getArrayName();
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
        if (found.isEmpty()) {
            reportUndeclared(name, node);
        }
        if (node.getIndexExpression() != null) {
            node.getIndexExpression().accept(this);
        }
        return null;
    }
    
    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodePigLatin node) {
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(LiteralExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodePigLatin node) {
        if (node.getElements() != null) {

            for (ExpressionNodePigLatin expressionNodePigLatin : node.getElements()) {
                expressionNodePigLatin.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodePigLatin node) {
        if (node.getProperties() != null) {
            for (StructPropertyNodePigLatin property : node.getProperties()) {
                if (property != null) {
                    property.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(StructPropertyNodePigLatin node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InstanceCreationExpressionNodePigLatin node) {
        validateImportExists(node.getClassName(), node);

        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArgumentsNodePigLatin node) {
        if (node.getArguments() != null) {
            for (ExpressionNodePigLatin arg : node.getArguments()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }
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

    // ============================================================
    // STATEMENTS
    // ============================================================

    @Override
    public Void visit(VariableDeclarationNodePigLatin node) {
        // The initializer is a reference.
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        if (node.getDimensions() != null) {
            for (ExpressionNodePigLatin dim : node.getDimensions()) {
                if (dim != null) {
                    dim.accept(this);
                }
            }
        }
        if (node.getInitializer() != null) {
            node.getInitializer().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        // The struct type must be an import of the .pig.
        validateImportExists(node.getStructType(), node);

        if (node.getLiteral() != null) {
            node.getLiteral().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        if (node.getIdentifier() != null) {
            node.getIdentifier().accept(this);
        }
        if (node.getExpressionNode() != null) {
            node.getExpressionNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodePigLatin node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodePigLatin node) {
        if (node.getTargetVariable() != null) {
            node.getTargetVariable().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodePigLatin node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(PrintStatementNodePigLatin node) {
        if (node.getExpressionList() != null) {

            for (ExpressionNodePigLatin nodePigLatin : node.getExpressionList()) {
                nodePigLatin.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ReadStatementNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodePigLatin node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
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
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodePigLatin node) {
        String name = node.getId();
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
        if (found.isEmpty()) {
            reportUndeclared(name, node);
        }
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        }
        return null;
    }


    @Override
    public Void visit(ForUpdateNodePigLatin node) {
        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    // ============================================================
    // CONTROL FLOW
    // ============================================================

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBody() != null) {
            for (PigLatinAstNode statement : node.getThenBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        if (node.getElseIfs() != null) {
            for (ElseIfNodePigLatin elseIf : node.getElseIfs()) {
                if (elseIf != null) {
                    elseIf.accept(this);
                }
            }
        }
        if (node.getElseBlockNode() != null) {
            node.getElseBlockNode().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            for (PigLatinAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        if (node.getBody() != null) {
            for (PigLatinAstNode statement : node.getBody()) {
                if (statement != null) {
                    statement.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        if (node.getInit() != null) {
            node.getInit().accept(this);
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getUpdate() != null) {
            node.getUpdate().accept(this);
        }
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        return null;
    }

    // ============================================================
    // NO-OP NODES
    // ============================================================

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

    // ============================================================
    // HELPERS
    // ============================================================

    /**
     * If the target expression is an identifier that resolves to an IMPORT symbol,
     * returns that symbol. Otherwise returns null.
     */
    private Symbol resolveImportTarget(ExpressionNodePigLatin target) {
        if (!(target instanceof IdentifierExpressionNodePigLatin idNode)) {
            return null;
        }
        String name = idNode.getIdentifier();
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), name);
        for (Symbol symbol : found) {
            if (symbol.getKind() == SymbolKind.IMPORT) {
                return symbol;
            }
        }
        return null;
    }

    /**
     * Validates that a member exists inside the file referenced by an IMPORT symbol.
     */
    private void validateMemberOfImport(Symbol importSymbol, String memberName, PigLatinAstNode node) {
        String targetFilePath = importSymbol.getType();
        if (targetFilePath == null) {
            return;
        }
        SymbolScope targetFileScope = table.getFileScope(targetFilePath);
        if (targetFileScope == null) {
            return;
        }
        List<Symbol> found = targetFileScope.resolveDeepByName(memberName);
        if (found.isEmpty()) {
            reportUndeclared(memberName, node);
        }
    }

    /**
     * Validates that a direct call (no target) can be found in any imported .y file.
     */
    private void validateDirectCallInImports(String functionName, PigLatinAstNode node) {
        List<Symbol> allInFile = table.resolveDeepInFile(context.getFilePath(), functionName);
        for (Symbol symbol : allInFile) {
            if (symbol.getKind() == SymbolKind.IMPORT) {
                continue;
            }
            // Found something with that name in the current file.
            return;
        }

        // Search in all .y imports.
        List<Symbol> imports = table.resolveDeepInFile(context.getFilePath(), functionName);
        List<Symbol> importedFiles = findImportSymbols();

        for (Symbol importedFile : importedFiles) {
            String path = importedFile.getType();
            if (path == null || !path.endsWith(".y")) {
                continue;
            }
            SymbolScope targetScope = table.getFileScope(path);
            if (targetScope == null) {
                continue;
            }
            List<Symbol> found = targetScope.resolveDeepByName(functionName);
            if (!found.isEmpty()) {
                return;
            }
        }

        reportUndeclared(functionName, node);
    }

    /**
     * Returns all IMPORT symbols declared in the current file.
     */
    private List<Symbol> findImportSymbols() {
        List<Symbol> result = new ArrayList<>();
        SymbolScope fileScope = table.getFileScope(context.getFilePath());
        if (fileScope == null) {
            return result;
        }
        for (Symbol symbol : collectAllSymbols(fileScope)) {
            if (symbol.getKind() == SymbolKind.IMPORT) {
                result.add(symbol);
            }
        }
        return result;
    }

    /**
     * Recursively collects all symbols from a scope and its descendants.
     */
    private List<Symbol> collectAllSymbols(SymbolScope scope) {
        List<Symbol> result = new ArrayList<>();
        for (List<Symbol> bucket : scope.getSymbols().values()) {
            result.addAll(bucket);
        }
        for (SymbolScope child : scope.getChildren()) {
            result.addAll(collectAllSymbols(child));
        }
        return result;
    }

    /**
     * Validates that a class or struct name exists as an import.
     */
    private void validateImportExists(String typeName, PigLatinAstNode node) {
        List<Symbol> found = table.resolveDeepInFile(context.getFilePath(), typeName);
        for (Symbol symbol : found) {
            if (symbol.getKind() == SymbolKind.IMPORT) {
                return;
            }
        }
        reportUndeclared(typeName, node);
    }

    private void reportUndeclared(String name, PigLatinAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(name);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("El simbolo '" + name + "' no esta declarado en este ambito");
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }

}