package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParser;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParserBaseVisitor;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.AccessorNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.instances.ExpressionStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseBlockNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfListNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.ElseIfNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.conditionals.IfStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.MaiorSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.VariablesSectionNodePigLatin;

import java.util.ArrayList;
import java.util.List;

/**
 * AST builder for the Pig Latin language (orchestrator)
 */
public class PigAstBuilder extends PigLatinParserBaseVisitor<PigLatinAstNode> implements AstBuilder {

    private EditorContext context;

    @Override
    public PigLatinAstNode build(EditorContext context) {
        this.context = context;

        if (context.getParseTree() == null) {
            return null;
        }

        PigLatinParser.ProgramContext program = (PigLatinParser.ProgramContext) context.getParseTree();
        return visitProgram(program);
    }

    @Override
    public String getSupportedExtension() {
        return ".pig";
    }

    @Override
    public PigLatinAstNode visitProgram(PigLatinParser.ProgramContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        BodyNodePigLatin body = (BodyNodePigLatin) ctx.body().accept(this);

        return new ProgramNodePigLatin(line, column, body);
    }

    //========================
    // BODY FOR THE PROGRAM
    //========================

    @Override
    public PigLatinAstNode visitBody(PigLatinParser.BodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ImportNodePigLatin> imports = new ArrayList<>();
        for (PigLatinParser.Import_listContext importCtx : ctx.import_list()) {
            AstNode imp = importCtx.accept(this);
            imports.add((ImportNodePigLatin) imp);
        }

        VariablesSectionNodePigLatin variableSection = null;
        if (ctx.variable_section() != null) {
            variableSection = (VariablesSectionNodePigLatin) ctx.variable_section().accept(this);
        }

        MaiorSectionNodePigLatin maior = (MaiorSectionNodePigLatin) ctx.maior_section().accept(this);

        return new BodyNodePigLatin(line, column, imports, variableSection, maior);

    }

    //========================
    // INSTRUCTIONS SECTION
    //========================

    @Override
    public PigLatinAstNode visitAccessorInstruction(PigLatinParser.AccessorInstructionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.ID().size(); i++) {
            if (i > 0) sb.append(".");
            sb.append(ctx.ID(i).getText());
        }
        return new AccessorNodePigLatin(line, column, sb.toString());
    }

    //========================
    // IMPORTS SECTION
    //========================

    @Override
    public PigLatinAstNode visitImportLists(PigLatinParser.ImportListsContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        AccessorNodePigLatin accessor = (AccessorNodePigLatin) ctx.accessor().accept(this);
        String rawPath = accessor.getPath();
        String extension = extractExtension(rawPath);
        ImportType type = ImportType.fromExtension(extension);

        return new ImportNodePigLatin(line, column, rawPath, type);
    }

    private String extractExtension(String path) {
        int lastDot = path.lastIndexOf('.');
        if (lastDot < 0) return "";
        return path.substring(lastDot);
    }

    //========================
    // SECTIONS
    //========================

    @Override
    public PigLatinAstNode visitMaiorSection(PigLatinParser.MaiorSectionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        CodeBodyNodePigLatin codeBody = (CodeBodyNodePigLatin) ctx.code_body().accept(this);
        return new MaiorSectionNodePigLatin(line, column, codeBody);
    }


    @Override
    public PigLatinAstNode visitCodeBodyStatement(PigLatinParser.CodeBodyStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<PigLatinAstNode> statements = new ArrayList<>();
        for (PigLatinParser.StatementContext stmtCtx : ctx.statement()) {
            AstNode stmt = stmtCtx.accept(this);
            statements.add((StatementNodePigLatin) stmt);
        }
        return new CodeBodyNodePigLatin(line, column, statements);
    }

    //========================
    // BLOCK CODE ACTIONS
    //========================

    @Override
    public PigLatinAstNode visitBlockCode(PigLatinParser.BlockCodeContext ctx) {
        return ctx.block_code().accept(this);
    }

    @Override
    public PigLatinAstNode visitConsoleActions(PigLatinParser.ConsoleActionsContext ctx) {
        return ctx.console_actions().accept(this);
    }

    @Override
    public PigLatinAstNode visitLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx) {
        return ctx.abbreviated_operation().accept(this);
    }

    @Override
    public PigLatinAstNode visitLocalAssignment(PigLatinParser.LocalAssignmentContext ctx) {
        return ctx.assignment().accept(this);
    }

    @Override
    public PigLatinAstNode visitStatementObjectPropertyCalling(PigLatinParser.StatementObjectPropertyCallingContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin obj = (ExpressionNodePigLatin) ctx.object_values().accept(this);
        return new ExpressionStatementNodePigLatin(line, column, obj);
    }

    @Override
    public PigLatinAstNode visitCodeBlockIf(PigLatinParser.CodeBlockIfContext ctx) {
        return ctx.if_statement().accept(this);
    }

    //========================
    //LOOPS
    //========================
    @Override
    public PigLatinAstNode visitCodeBlockWhile(PigLatinParser.CodeBlockWhileContext ctx) {
        return ctx.while_statement().accept(this);
    }

    @Override
    public PigLatinAstNode visitCodeBlockDoWhile(PigLatinParser.CodeBlockDoWhileContext ctx) {
        return ctx.do_while_statement().accept(this);
    }

    @Override
    public PigLatinAstNode visitCodeBlockFor(PigLatinParser.CodeBlockForContext ctx) {
        return ctx.for_statement().accept(this);
    }

    @Override
    public PigLatinAstNode visitIfStatement(PigLatinParser.IfStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin condition =
                (ExpressionNodePigLatin) ctx.expression().accept(this);

        CodeBodyNodePigLatin thenBodyNode =
                (CodeBodyNodePigLatin) ctx.code_body().accept(this);

        List<ElseIfNodePigLatin> elseIfs = new ArrayList<>();
        if (ctx.else_if_list() != null) {
            ElseIfListNodePigLatin elseIfListNode =
                    (ElseIfListNodePigLatin) ctx.else_if_list().accept(this);
            elseIfs = elseIfListNode.getClauses();
        }

        ElseBlockNodePigLatin elseBlock = null;
        if (ctx.else_statement() != null) {
            PigLatinAstNode result = ctx.else_statement().accept(this);
            if (result != null) {
                elseBlock = (ElseBlockNodePigLatin) result;
            }
        }

        return new IfStatementNodePigLatin(
                line, column, condition, thenBodyNode.getStatements(), elseIfs, elseBlock
        );
    }

    @Override
    public PigLatinAstNode visitElseIfList(PigLatinParser.ElseIfListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ElseIfNodePigLatin> clauses = new ArrayList<>();
        for (PigLatinParser.Else_if_clauseContext clauseCtx : ctx.else_if_clause()) {
            clauses.add((ElseIfNodePigLatin) clauseCtx.accept(this));
        }
        return new ElseIfListNodePigLatin(line, column, clauses);
    }


    @Override
    public PigLatinAstNode visitElseStatement(PigLatinParser.ElseStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        if (ctx.code_body() == null) {
            return null;
        }

        CodeBodyNodePigLatin body = (CodeBodyNodePigLatin) ctx.code_body().accept(this);

        return new ElseBlockNodePigLatin(line, column, body.getStatements());
    }

    @Override
    public PigLatinAstNode visitElseIfClause(PigLatinParser.ElseIfClauseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin cond = (ExpressionNodePigLatin) ctx.expression().accept(this);
        CodeBodyNodePigLatin bodyNode = (CodeBodyNodePigLatin) ctx.code_body().accept(this);

        return new ElseIfNodePigLatin(line, column, bodyNode.getStatements(), cond);
    }


}
