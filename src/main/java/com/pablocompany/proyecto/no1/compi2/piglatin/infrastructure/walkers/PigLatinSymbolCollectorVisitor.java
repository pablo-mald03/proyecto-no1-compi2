package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
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

    public PigLatinSymbolCollectorVisitor(GlobalSymbolTable table,
                                          EditorContext context,
                                          Map<String, String> importResolutionMap) {
        this.table = table;
        this.context = context;
        this.importResolutionMap = importResolutionMap;
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
        if (node.getImports() != null) {
            for (ImportNodePigLatin importNode : node.getImports()) {
                if (importNode != null) {
                    importNode.accept(this);
                }
            }
        }
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
        table.enterScope(SymbolScopeKind.FUNCTION, context.getFilePath());

        if (node.getStatements() != null) {
            node.getStatements().accept(this);
        }

        table.exitScope();
        return null;
    }

    // ============================================================
    // IMPORTS
    // ============================================================

    @Override
    public Void visit(ImportNodePigLatin node) {
        String rawPath = node.getImportPath();
        String logicalName = extractLogicalName(rawPath);
        String resolvedPath = importResolutionMap != null
                ? importResolutionMap.get(rawPath)
                : null;

        Symbol importSymbol = buildSymbol(
                logicalName,
                SymbolKind.IMPORT,
                resolvedPath,
                node
        );
        importSymbol.setQualifiedName(resolvedPath);

        if (!table.declare(importSymbol)) {
            reportDuplicate(logicalName, "import", node);
        }
        return null;
    }

    /**
     * Extracts the logical name from an import path.
     */
    private String extractLogicalName(String rawPath) {
        if (rawPath == null) return null;

        int lastDot = rawPath.lastIndexOf('.');
        String withoutExtension = lastDot != -1
                ? rawPath.substring(0, lastDot)
                : rawPath;

        int lastSeparator = withoutExtension.lastIndexOf('.');
        return lastSeparator != -1
                ? withoutExtension.substring(lastSeparator + 1)
                : withoutExtension;
    }

    // ============================================================
    // VARIABLES SECTION
    // ============================================================

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
    public Void visit(VariableDeclarationNodePigLatin node) {
        String typeName = resolveTypeName(node.getDataType());

        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.FILE
                ? SymbolKind.GLOBAL_VARIABLE
                : SymbolKind.LOCAL_VARIABLE;

        Symbol variable = buildSymbol(
                node.getIdentifier(),
                kind,
                typeName,
                node
        );

        if (!table.declare(variable)) {
            String label = kind == SymbolKind.GLOBAL_VARIABLE ? "variable global" : "variable";
            reportDuplicate(node.getIdentifier(), label, node);
        }
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodePigLatin node) {
        String typeName = resolveTypeName(node.getDataType());

        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.FILE
                ? SymbolKind.GLOBAL_VARIABLE
                : SymbolKind.LOCAL_VARIABLE;

        Symbol array = buildSymbol(
                node.getIdentifier(),
                kind,
                typeName,
                node
        );

        if (node.getDimensions() != null) {
            array.setDimensions(node.getDimensions().size());
        }
        array.setArray(true);

        if (!table.declare(array)) {
            reportDuplicate(node.getIdentifier(), "arreglo", node);
        }
        return null;
    }

    @Override
    public Void visit(StructInstanceNodePigLatin node) {
        
        SymbolKind kind = table.getCurrentScope().getKind() == SymbolScopeKind.FILE
                ? SymbolKind.GLOBAL_VARIABLE
                : SymbolKind.LOCAL_VARIABLE;


        Symbol instance = buildSymbol(
                node.getIdentifier(),
                kind,
                node.getStructType(),
                node
        );

        if (!table.declare(instance)) {
            reportDuplicate(node.getIdentifier(), "instancia de struct", node);
        }
        return null;
    }

    // ============================================================
    // CODE SECTION AND BLOCKS
    // ============================================================

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

    @Override
    public Void visit(IfStatementNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        if (node.getThenBody() != null) {

            for (PigLatinAstNode thenBody : node.getThenBody()) {
                if (thenBody != null) {
                    thenBody.accept(this);
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

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ElseIfNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        if (node.getBody() != null) {

            for (PigLatinAstNode body : node.getBody()) {
                if (body != null) {
                    body.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ElseBlockNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

        if (node.getBody() != null) {
            for (PigLatinAstNode body : node.getBody()) {
                if (body != null) {
                    body.accept(this);
                }
            }
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(WhileStatementNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ForStatementNodePigLatin node) {
        table.enterScope(SymbolScopeKind.BLOCK, context.getFilePath());

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

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodePigLatin node) {
        String typeName = resolveTypeName(node.getType());

        Symbol variable = buildSymbol(
                node.getId(),
                SymbolKind.LOCAL_VARIABLE,
                typeName,
                node
        );

        if (!table.declare(variable)) {
            reportDuplicate(node.getId(), "variable de for", node);
        }
        return null;
    }


    // ============================================================
    // NON-DECLARING NODES
    // ============================================================

    @Override
    public Void visit(VariableAssignmentNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(TypeNodePigLatin node) {
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
    public Void visit(ExpressionNodePigLatin node) {
        return null;
    }

    @Override
    public Void visit(AccessorNodePigLatin node) {
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

    // ============================================================
    // HELPERS
    // ============================================================

    /**
     * Build symbol helper
     *
     */
    private Symbol buildSymbol(String name, SymbolKind kind, String type, PigLatinAstNode node) {
        Symbol symbol = new Symbol();
        symbol.setName(name);
        symbol.setKind(kind);
        symbol.setType(type);
        symbol.setFilePath(context.getFilePath());
        symbol.setFileName(context.getFileName());
        symbol.setLine(node.getLine());
        symbol.setColumn(node.getColumn());
        return symbol;
    }

    /**
     * Report duplicate helper
     *
     */
    private void reportDuplicate(String name, String kindLabel, PigLatinAstNode node) {
        CompilerError error = new CompilerError();
        error.setLexeme(name);
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("Ya existe un " + kindLabel + " con el nombre '" + name + "' en este ambito");
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }

    /**
     * Resolve type name helper method
     *
     */
    private String resolveTypeName(TypeNodePigLatin typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) {
            return typeNode.getCustomTypeName();
        }
        if (typeNode.getDataType() != null) {
            return typeNode.getDataType().getValue();
        }
        return null;
    }
}