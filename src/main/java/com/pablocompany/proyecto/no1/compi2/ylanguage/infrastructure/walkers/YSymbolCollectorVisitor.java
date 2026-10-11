package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolScopeKind;
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
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal symbol collector visitor
 *
 */
@Getter
public class YSymbolCollectorVisitor implements YAstVisitor<Void> {

    private final GlobalSymbolTable table;
    private final EditorContext context;

    private final YSemanticErrorReporter reporter;
    private final YScopeService scopes;
    private final YMemberCollectorService members;
    private final YSymbolDeclarationService declarations;

    public YSymbolCollectorVisitor(GlobalSymbolTable table, EditorContext context) {
        this.table = table;
        this.context = context;

        YTypeMapperService mapper = new YTypeMapperService();
        this.reporter = new YSemanticErrorReporter(context);
        this.scopes = new YScopeService(table, context);
        this.members = new YMemberCollectorService(context, mapper);
        this.declarations = new YSymbolDeclarationService(table, context, reporter);
    }

    // -------- TOP LEVEL --------

    @Override
    public Void visit(ProgramNodeY node) {
        if (node.getStructures() != null) node.getStructures().accept(this);
        if (node.getFunctions() != null) node.getFunctions().accept(this);
        return null;
    }

    @Override
    public Void visit(StructuresRegionNodeY node) {
        if (node.getStructs() != null) {
            for (StructDeclarationNodeY s : node.getStructs()) if (s != null) s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionsRegionNodeY node) {
        if (node.getFunctions() != null) {
            for (YAstNode f : node.getFunctions()) if (f != null) f.accept(this);
        }
        return null;
    }

    // -------- STRUCTS --------

    @Override
    public Void visit(StructDeclarationNodeY node) {
        StructBodyNodeY body = node.getBody();
        List<Symbol> memberSymbols = (body != null)
                ? members.collectAttributes(body.getAttributes())
                : new ArrayList<>();

        declarations.declareStruct(node.getStructName(), node, memberSymbols);

        scopes.registerScope(node, SymbolScopeKind.STRUCT);      // <-- FIX
        try {
            if (body != null) body.accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(StructBodyNodeY node) {
        if (node.getAttributes() != null) {
            for (StructAttributeNodeY a : node.getAttributes()) if (a != null) a.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructAttributeNodeY node) {
        Symbol attr = new Symbol();
        attr.setName(node.getIdentifier());
        attr.setKind(SymbolKind.ATTRIBUTE);
        attr.setType(resolveTypeName(node.getType()));
        attr.setFilePath(context.getFilePath());
        attr.setFileName(context.getFileName());
        attr.setLine(node.getLine());
        attr.setColumn(node.getColumn());
        if (node.isArray()) {
            attr.setDimensions(node.getDimensions() != null ? node.getDimensions().size() : 1);
            attr.setArray(true);
        }
        table.declare(attr);
        return null;
    }

    @Override
    public Void visit(StructPropertyNodeY node) {
        return null;
    }

    // -------- FUNCTIONS / PROCEDURES --------

    @Override
    public Void visit(FunctionDeclarationNodeY node) {
        List<String> paramTypes = new ArrayList<>();
        if (node.getParameters() != null) {
            for (ParameterNodeY p : node.getParameters()) {
                if (p == null) continue;
                String t = resolveParameterType(p);
                if (p.isArray()) t = t + "[]".repeat(p.getDimensions());
                paramTypes.add(t);
            }
        }

        String returnType = node.getReturnType() != null
                ? resolveTypeName(node.getReturnType())
                : "void";

        declarations.declareFunction(node.getName(), node, paramTypes, returnType,
                SymbolKind.FUNCTION, "funcion");

        scopes.registerScope(node, SymbolScopeKind.FUNCTION);     // <-- FIX
        try {
            if (node.getParameters() != null) {
                for (ParameterNodeY p : node.getParameters()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ProcedureDeclarationNodeY node) {
        List<String> paramTypes = new ArrayList<>();
        if (node.getParameters() != null) {
            for (ParameterNodeY p : node.getParameters()) {
                if (p == null) continue;
                String t = resolveParameterType(p);
                if (p.isArray()) t = t + "[]".repeat(p.getDimensions());
                paramTypes.add(t);
            }
        }
        declarations.declareFunction(node.getName(), node, paramTypes, "void",
                SymbolKind.FUNCTION, "procedimiento");

        scopes.registerScope(node, SymbolScopeKind.FUNCTION);     // <-- FIX
        try {
            if (node.getParameters() != null) {
                for (ParameterNodeY p : node.getParameters()) if (p != null) p.accept(this);
            }
            if (node.getBody() != null) {
                for (YAstNode s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(StructParameterNodeY node) {
        declarations.declareParameter(node, node);
        return null;
    }

    @Override
    public Void visit(PrimitiveParameterNodeY node) {
        declarations.declareParameter(node, node);
        return null;
    }

    @Override
    public Void visit(ArrayParameterNodeY node) {
        declarations.declareParameter(node, node);
        return null;
    }

    // -------- VARIABLES --------

    @Override
    public Void visit(VariableDeclarationNodeY node) {
        declarations.declareVariable(node.getIdentifier(), node.getDataType(), node);
        return null;
    }

    @Override
    public Void visit(ArrayDeclarationNodeY node) {
        int dims = node.getDimensions() != null ? node.getDimensions().size() : 0;
        declarations.declareArray(node.getIdentifier(), node.getDataType(), dims, node);
        return null;
    }

    @Override
    public Void visit(StructInstanceNodeY node) {
        declarations.declareStructInstance(node.getIdentifier(), node.getStructType(), node);
        return null;
    }

    @Override
    public Void visit(ForInitDeclarationNodeY node) {
        declarations.declareForVariable(node.getId(), node.getType(), node);
        return null;
    }

    // -------- CONTROL FLOW --------

    @Override
    public Void visit(IfStatementNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getThenBody() != null) {
                for (StatementNodeY s : node.getThenBody()) if (s != null) s.accept(this);
            }
            if (node.getElseIfs() != null) {
                for (ElseIfNodeY e : node.getElseIfs()) if (e != null) e.accept(this);
            }
            if (node.getElseBlockNode() != null) node.getElseBlockNode().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseIfNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ElseBlockNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(WhileStatementNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(DoWhileStatementNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
            if (node.getCondition() != null) node.getCondition().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ForStatementNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCondition() != null) node.getCondition().accept(this);
            if (node.getUpdate() != null) node.getUpdate().accept(this);
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(SwitchStatementNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getSelector() != null) node.getSelector().accept(this);
            if (node.getCases() != null) {
                for (SwitchCaseNodeY c : node.getCases()) if (c != null) c.accept(this);
            }
            if (node.getDefaultCase() != null) node.getDefaultCase().accept(this);
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(SwitchCaseNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(DefaultCaseNodeY node) {
        scopes.registerScope(node, SymbolScopeKind.BLOCK);        // <-- FIX
        try {
            if (node.getBody() != null) {
                for (StatementNodeY s : node.getBody()) if (s != null) s.accept(this);
            }
        } finally {
            table.exitScope();
        }
        return null;
    }

    // -------- NO-OP --------

    @Override
    public Void visit(VariableAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ShortlyOperationNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ElseIfListNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(IncrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(DecrementPrevStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(StructLiteralExpressionNodeY node) {
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
    public Void visit(PrintStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReadStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ReturnStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(BreakStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ContinueStatementNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArgumentsNodeY node) {
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(TypeNodeY node) {
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNodeY node) {
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
    public Void visit(ArrayCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(FunctionCallExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayValuesNodeY node) {
        return null;
    }

    @Override
    public Void visit(ArrayInitExpressionNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForInitAssignmentNodeY node) {
        return null;
    }

    @Override
    public Void visit(ForUpdateNodeY node) {
        return null;
    }

    // -------- HELPERS --------

    private String resolveTypeName(TypeNodeY typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    private String resolveParameterType(ParameterNodeY node) {
        if (node instanceof StructParameterNodeY s) return resolveTypeName(s.getDataType());
        if (node instanceof ArrayParameterNodeY a) return resolveTypeName(a.getElementType());
        if (node instanceof PrimitiveParameterNodeY p) return resolveTypeName(p.getType());
        return resolveTypeName(node.getType());
    }
}