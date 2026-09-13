package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParser;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParserBaseVisitor;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.InstanceCreationExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.ShortlyOperationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.access.enums.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.assignation.enums.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.AccessorNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports.ImportType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.instances.ExpressionStatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.operators.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.operators.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.StructInstanceNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructLiteralExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.properties.StructPropertyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.ArgumentsNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.FunctionCallExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.IdentifierExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.values.LiteralExpressionNodePigLatin;
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
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.statements.loops.enums.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.BodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.CodeBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.ExpressionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.parents.StatementNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.MaiorSectionNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesBodyNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.principals.variables.VariablesSectionNodePigLatin;
import org.antlr.v4.runtime.ParserRuleContext;

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

    //========================
    // CONDITIONAL
    //========================

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

    //========================
    //ELSE - IF STATEMENTS
    //========================

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

    @Override
    public PigLatinAstNode visitWhileStatement(PigLatinParser.WhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin cond = (ExpressionNodePigLatin) ctx.expression().accept(this);
        CodeBodyNodePigLatin body = (CodeBodyNodePigLatin) ctx.code_body().accept(this);

        return new WhileStatementNodePigLatin(line, column, body, cond);
    }

    @Override
    public PigLatinAstNode visitDoWhileStatement(PigLatinParser.DoWhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        CodeBodyNodePigLatin body = (CodeBodyNodePigLatin) ctx.code_body().accept(this);
        ExpressionNodePigLatin cond = (ExpressionNodePigLatin) ctx.expression().accept(this);

        return new DoWhileStatementNodePigLatin(line, column, body, cond);
    }

    @Override
    public PigLatinAstNode visitForStatement(PigLatinParser.ForStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        PigLatinAstNode init = ctx.for_init().accept(this);
        ExpressionNodePigLatin cond = (ExpressionNodePigLatin) ctx.expression().accept(this);
        PigLatinAstNode update = ctx.for_update().accept(this);
        CodeBodyNodePigLatin body = (CodeBodyNodePigLatin) ctx.code_body().accept(this);

        return new ForStatementNodePigLatin(line, column, body, init, cond, update);
    }

    @Override
    public PigLatinAstNode visitForInitVarDecl(PigLatinParser.ForInitVarDeclContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        TypeNodePigLatin type = (TypeNodePigLatin) ctx.variable_type().accept(this);
        ExpressionNodePigLatin expr = (ExpressionNodePigLatin) ctx.expression().accept(this);

        return new ForInitDeclarationNodePigLatin(line, column, id, type, expr);
    }

    @Override
    public PigLatinAstNode visitForInitAssign(PigLatinParser.ForInitAssignContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        ExpressionNodePigLatin expr = (ExpressionNodePigLatin) ctx.expression().accept(this);

        return new ForInitAssignmentNodePigLatin(line, column, id, expr);
    }

    @Override
    public PigLatinAstNode visitForUpdateIncrement(PigLatinParser.ForUpdateIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new ForUpdateNodePigLatin(line, column, target, null, ForUpdateOperator.INCREMENT);
    }

    @Override
    public PigLatinAstNode visitForUpdateDecrement(PigLatinParser.ForUpdateDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new ForUpdateNodePigLatin(line, column, target, null, ForUpdateOperator.DECREMENT);
    }

    @Override
    public PigLatinAstNode visitForUpdatePrefixIncrement(PigLatinParser.ForUpdatePrefixIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new ForUpdateNodePigLatin(line, column, target, null, ForUpdateOperator.PREFIX_INCREMENT);
    }

    @Override
    public PigLatinAstNode visitForUpdatePrefixDecrement(PigLatinParser.ForUpdatePrefixDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new ForUpdateNodePigLatin(line, column, target, null, ForUpdateOperator.PREFIX_DECREMENT);
    }


    //========================
    // LOOP CONTROL STATEMENTS
    //========================

    @Override
    public PigLatinAstNode visitReturnStatement(PigLatinParser.ReturnStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin expr = null;
        if (ctx.expression() != null) {
            expr = (ExpressionNodePigLatin) ctx.expression().accept(this);
        }
        return new ReturnStatementNodePigLatin(line, column, expr);
    }

    @Override
    public PigLatinAstNode visitLoopContinue(PigLatinParser.LoopContinueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new ContinueStatementNodePigLatin(line, column);
    }

    @Override
    public PigLatinAstNode visitLoopBreak(PigLatinParser.LoopBreakContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new BreakStatementNodePigLatin(line, column);
    }

    @Override
    public PigLatinAstNode visitLoopControlAction(PigLatinParser.LoopControlActionContext ctx) {
        return ctx.loop_control().accept(this);
    }

    @Override
    public PigLatinAstNode visitReturnControlAction(PigLatinParser.ReturnControlActionContext ctx) {
        return ctx.return_control().accept(this);
    }

    //========================
    // READ VARIABLES INPUT
    //========================

    @Override
    public PigLatinAstNode visitReadVariableInput(PigLatinParser.ReadVariableInputContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new ReadStatementNodePigLatin(line, column, target);
    }

    @Override
    public PigLatinAstNode visitReadInput(PigLatinParser.ReadInputContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new ReadStatementNodePigLatin(line, column, null);
    }

    //========================
    // PRINT ACTIONS OUTPUT
    //========================
    @Override
    public PigLatinAstNode visitPrintAction(PigLatinParser.PrintActionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        PrintStatementNodePigLatin printFn =
                (PrintStatementNodePigLatin) ctx.print_function().accept(this);
        return new PrintStatementNodePigLatin(line, column, printFn.getExpressionList());
    }

    @Override
    public PigLatinAstNode visitPrintSingleExpr(PigLatinParser.PrintSingleExprContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin expr = (ExpressionNodePigLatin) ctx.expression().accept(this);
        List<ExpressionNodePigLatin> list = new ArrayList<>();
        list.add(expr);
        return new PrintStatementNodePigLatin(line, column, list);
    }

    @Override
    public PigLatinAstNode visitPrintMultipleExpr(PigLatinParser.PrintMultipleExprContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        PrintStatementNodePigLatin left =
                (PrintStatementNodePigLatin) ctx.print_function().accept(this);
        ExpressionNodePigLatin right = (ExpressionNodePigLatin) ctx.expression().accept(this);

        List<ExpressionNodePigLatin> list = new ArrayList<>(left.getExpressionList());
        list.add(right);
        return new PrintStatementNodePigLatin(line, column, list);
    }

    //========================
    // VARIABLES SECTION
    //========================

    @Override
    public PigLatinAstNode visitVariablesSection(PigLatinParser.VariablesSectionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        VariablesBodyNodePigLatin body = (VariablesBodyNodePigLatin) ctx.variabiles_body().accept(this);
        return new VariablesSectionNodePigLatin(line, column, body);
    }

    @Override
    public PigLatinAstNode visitVariabilesBody(PigLatinParser.VariabilesBodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<AstNode> decls = new ArrayList<>();
        for (PigLatinParser.DeclarationContext dCtx : ctx.declaration()) {
            decls.add(dCtx.accept(this));
        }
        return new VariablesBodyNodePigLatin(line, column, decls);
    }

    //========================
    // VARIABLES DEFINITION DELEGATIONS
    //========================
    @Override
    public PigLatinAstNode visitVariableInstance(PigLatinParser.VariableInstanceContext ctx) {
        return ctx.variable_declaration().accept(this);
    }

    @Override
    public PigLatinAstNode visitVariableAssignment(PigLatinParser.VariableAssignmentContext ctx) {
        return ctx.assignment().accept(this);
    }

    @Override
    public PigLatinAstNode visitNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx) {
        return ctx.array_declaration().accept(this);
    }

    @Override
    public PigLatinAstNode visitStructDefinition(PigLatinParser.StructDefinitionContext ctx) {
        return ctx.struct_declaration().accept(this);
    }

    @Override
    public PigLatinAstNode visitStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx) {
        return ctx.struct_instance().accept(this);
    }

    @Override
    public PigLatinAstNode visitGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx) {
        return ctx.abbreviated_operation().accept(this);
    }

    @Override
    public PigLatinAstNode visitCompoundAssignment(PigLatinParser.CompoundAssignmentContext ctx) {
        return ctx.compound_assignment().accept(this);
    }


    //========================
    // ASSIGNATION VARIABLES
    //========================
    @Override
    public PigLatinAstNode visitVariableDeclaration(PigLatinParser.VariableDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();

        TypeNodePigLatin type = null;
        if (ctx.variable_type() != null) {
            type = (TypeNodePigLatin) ctx.variable_type().accept(this);
        }

        ExpressionNodePigLatin expr = (ExpressionNodePigLatin) ctx.expression().accept(this);

        return new VariableDeclarationNodePigLatin(line, column, type, id, expr);
    }

    @Override
    public PigLatinAstNode visitStructAssignment(PigLatinParser.StructAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);

        return new VariableAssignmentNodePigLatin(line, column, target, value);
    }

    //========================
    // ABBREVIATED OPERATIONS
    //========================
    @Override
    public PigLatinAstNode visitCompoundAddAssignment(PigLatinParser.CompoundAddAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return buildShortly(line, column, target, value, ShortlyOperator.PLUS_ASSIGN);
    }

    @Override
    public PigLatinAstNode visitCompoundSubAssignment(PigLatinParser.CompoundSubAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return buildShortly(line, column, target, value, ShortlyOperator.MINUS_ASSIGN);
    }

    @Override
    public PigLatinAstNode visitCompoundMulAssignment(PigLatinParser.CompoundMulAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return buildShortly(line, column, target, value, ShortlyOperator.MULTIPLY_ASSIGN);
    }

    @Override
    public PigLatinAstNode visitCompoundDivAssignment(PigLatinParser.CompoundDivAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return buildShortly(line, column, target, value, ShortlyOperator.DIVIDE_ASSIGN);
    }

    @Override
    public PigLatinAstNode visitCompoundModAssignment(PigLatinParser.CompoundModAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        ExpressionNodePigLatin value = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return buildShortly(line, column, target, value, ShortlyOperator.MODULO_ASSIGN);
    }

    /**
     * Auxiliary method
     *
     */
    private ShortlyOperationNodePigLatin buildShortly(
            int line, int column,
            ExpressionNodePigLatin target,
            ExpressionNodePigLatin value,
            ShortlyOperator op) {
        return new ShortlyOperationNodePigLatin(line, column, target, value, op);
    }

    //========================
    // ARRAY ASSIGNMENT OPERATIONS
    //========================

    @Override
    public PigLatinAstNode visitNormalArrayDeclaration(PigLatinParser.NormalArrayDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        ExpressionNodePigLatin size = (ExpressionNodePigLatin) ctx.expression().accept(this);
        TypeNodePigLatin type = (TypeNodePigLatin) ctx.variable_type().accept(this);

        ArrayInitExpressionNodePigLatin init = null;
        if (ctx.array_initialization() != null) {
            init = (ArrayInitExpressionNodePigLatin) ctx.array_initialization().accept(this);
        }

        return new ArrayDeclarationNodePigLatin(line, column, type, id, size, init);
    }

    @Override
    public PigLatinAstNode visitArrayInitWithValues(PigLatinParser.ArrayInitWithValuesContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodePigLatin> values = new ArrayList<>();
        for (PigLatinParser.ExpressionContext eCtx : ctx.values_array_list().expression()) {
            values.add((ExpressionNodePigLatin) eCtx.accept(this));
        }
        return new ArrayInitExpressionNodePigLatin(line, column, values);
    }

    //========================
    // STRUCT OPERATIONS
    //========================

    @Override
    public PigLatinAstNode visitStructDeclaration(PigLatinParser.StructDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        StructBodyNodePigLatin body = (StructBodyNodePigLatin) ctx.struct_body().accept(this);
        return new StructDeclarationNodePigLatin(line, column, body, id);
    }

    @Override
    public PigLatinAstNode visitStructSeparatedBody(PigLatinParser.StructSeparatedBodyContext ctx) {
        return ctx.struct_normal_body().accept(this);
    }

    @Override
    public PigLatinAstNode visitStructCommaBody(PigLatinParser.StructCommaBodyContext ctx) {
        return ctx.struct_comma_body().accept(this);
    }

    @Override
    public PigLatinAstNode visitStructNormalBody(PigLatinParser.StructNormalBodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StructAttributeNodePigLatin> attrs = new ArrayList<>();
        for (PigLatinParser.Struct_attributeContext aCtx : ctx.struct_attribute()) {
            attrs.add((StructAttributeNodePigLatin) aCtx.accept(this));
        }
        return new StructBodyNodePigLatin(line, column, attrs);
    }

    @Override
    public PigLatinAstNode visitStructCommaStatementBody(PigLatinParser.StructCommaStatementBodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StructAttributeNodePigLatin> attrs = new ArrayList<>();
        for (PigLatinParser.Struct_attributeContext aCtx : ctx.struct_attribute()) {
            attrs.add((StructAttributeNodePigLatin) aCtx.accept(this));
        }
        return new StructBodyNodePigLatin(line, column, attrs);
    }

    @Override
    public PigLatinAstNode visitNormalVariableStruct(PigLatinParser.NormalVariableStructContext ctx) {
        return ctx.variable_without_value().accept(this);
    }

    @Override
    public PigLatinAstNode visitArrayVariableStruct(PigLatinParser.ArrayVariableStructContext ctx) {
        return ctx.array_variable_struct().accept(this);
    }

    @Override
    public PigLatinAstNode visitInternalStructNormalVariable(PigLatinParser.InternalStructNormalVariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        TypeNodePigLatin type = (TypeNodePigLatin) ctx.variable_type().accept(this);
        return new StructAttributeNodePigLatin(line, column, id, type, false);
    }

    @Override
    public PigLatinAstNode visitInternalStructArray(PigLatinParser.InternalStructArrayContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        TypeNodePigLatin type = (TypeNodePigLatin) ctx.variable_type().accept(this);
        return new StructAttributeNodePigLatin(line, column, id, type, true);
    }

    @Override
    public PigLatinAstNode visitStructInstance(PigLatinParser.StructInstanceContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String varName = ctx.ID(0).getText();
        String structName = ctx.ID(1).getText();
        StructLiteralExpressionNodePigLatin literal = (StructLiteralExpressionNodePigLatin) ctx.struct_literal().accept(this);

        return new StructInstanceNodePigLatin(line, column, varName, structName, literal);
    }

    @Override
    public PigLatinAstNode visitStructLiteralValue(PigLatinParser.StructLiteralValueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        PigLatinParser.StructDataListContext dataList =
                (PigLatinParser.StructDataListContext) ctx.struct_data_list();

        List<StructPropertyNodePigLatin> values = new ArrayList<>();
        for (PigLatinParser.Struct_data_valueContext vCtx : dataList.struct_data_value()) {
            values.add((StructPropertyNodePigLatin) vCtx.accept(this));
        }
        return new StructLiteralExpressionNodePigLatin(line, column, values);
    }

    @Override
    public PigLatinAstNode visitStructDataNormal(PigLatinParser.StructDataNormalContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String key = ctx.ID().getText();
        ExpressionNodePigLatin val = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return new StructPropertyNodePigLatin(line, column, key, val);
    }


    //========================
    // NESTED VARIABLES
    //========================
    @Override
    public PigLatinAstNode visitNestedVariable(PigLatinParser.NestedVariableContext ctx) {
        return ctx.object_values().accept(this);
    }

    @Override
    public PigLatinAstNode visitBaseIdentifier(PigLatinParser.BaseIdentifierContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new IdentifierExpressionNodePigLatin(line, column, ctx.ID().getText());
    }

    @Override
    public PigLatinAstNode visitBaseFunctionCall(PigLatinParser.BaseFunctionCallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<ExpressionNodePigLatin> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodePigLatin argsNode = (ArgumentsNodePigLatin) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }

        return new FunctionCallExpressionNodePigLatin(line, column, null, name, args);
    }

    @Override
    public PigLatinAstNode visitObjectPropertyChain(PigLatinParser.ObjectPropertyChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.object_values().accept(this);
        String propertyName = ctx.ID().getText();
        return new PropertyAccessExpressionNodePigLatin(line, column, target, propertyName);
    }

    @Override
    public PigLatinAstNode visitObjectMethodChain(PigLatinParser.ObjectMethodChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.object_values().accept(this);
        String name = ctx.ID().getText();

        List<ExpressionNodePigLatin> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodePigLatin argsNode = (ArgumentsNodePigLatin) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }

        return new FunctionCallExpressionNodePigLatin(line, column, target, name, args);
    }

    @Override
    public PigLatinAstNode visitObjectArrayAccessChain(PigLatinParser.ObjectArrayAccessChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.object_values().accept(this);
        ExpressionNodePigLatin index = (ExpressionNodePigLatin) ctx.expression().accept(this);
        return new MemberArrayAccessExpressionNodePigLatin(line, column, index, target);
    }

    @Override
    public PigLatinAstNode visitArgumentsList(PigLatinParser.ArgumentsListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodePigLatin> args = new ArrayList<>();
        for (PigLatinParser.ExpressionContext eCtx : ctx.expression()) {
            args.add((ExpressionNodePigLatin) eCtx.accept(this));
        }
        return new ArgumentsNodePigLatin(line, column, args);
    }

    //========================
    // EXPRESSSIONS AND TYPE VARIABLES
    //========================
    @Override
    public PigLatinAstNode visitExpressionParents(PigLatinParser.ExpressionParentsContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public PigLatinAstNode visitExpressionUnary(PigLatinParser.ExpressionUnaryContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin expr = (ExpressionNodePigLatin) ctx.expression().accept(this);
        UnaryOperator op = mapUnaryOperator(ctx.op.getType());

        return new UnaryExpressionNodePigLatin(line, column, expr, op);
    }

    @Override
    public PigLatinAstNode visitExpressionMultDiv(PigLatinParser.ExpressionMultDivContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionAddSub(PigLatinParser.ExpressionAddSubContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionRelational(PigLatinParser.ExpressionRelationalContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionEquality(PigLatinParser.ExpressionEqualityContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionAnd(PigLatinParser.ExpressionAndContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.AND().getSymbol().getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionOr(PigLatinParser.ExpressionOrContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.OR().getSymbol().getType(), ctx);
    }

    @Override
    public PigLatinAstNode visitExpressionValue(PigLatinParser.ExpressionValueContext ctx) {
        return ctx.normal_values().accept(this);
    }

    /**
     * Auxiliary method
     *
     */

    private BinaryExpressionNodePigLatin buildBinary(
            PigLatinParser.ExpressionContext leftCtx,
            PigLatinParser.ExpressionContext rightCtx,
            int tokenType,
            ParserRuleContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodePigLatin left = (ExpressionNodePigLatin) leftCtx.accept(this);
        ExpressionNodePigLatin right = (ExpressionNodePigLatin) rightCtx.accept(this);
        BinaryOperator op = mapBinaryOperator(tokenType);

        return new BinaryExpressionNodePigLatin(line, column, left, right, op);
    }

    private BinaryOperator mapBinaryOperator(int tokenType) {
        return switch (tokenType) {
            case PigLatinLexer.PLUS -> BinaryOperator.PLUS;
            case PigLatinLexer.MINUS -> BinaryOperator.MINUS;
            case PigLatinLexer.MULTIPLICATION -> BinaryOperator.MULTIPLICATION;
            case PigLatinLexer.DIVIDE -> BinaryOperator.DIVIDE;
            case PigLatinLexer.PERCENT -> BinaryOperator.MODULE;
            case PigLatinLexer.EQUALS -> BinaryOperator.EQUALS;
            case PigLatinLexer.DIFERENCE -> BinaryOperator.DIFFERENT;
            case PigLatinLexer.LESS -> BinaryOperator.LESS;
            case PigLatinLexer.GREATER -> BinaryOperator.GREATER;
            case PigLatinLexer.LESS_EQUALS -> BinaryOperator.LESS_EQUALS;
            case PigLatinLexer.GREATER_EQUALS -> BinaryOperator.GREATER_EQUALS;
            case PigLatinLexer.AND -> BinaryOperator.AND;
            case PigLatinLexer.OR -> BinaryOperator.OR;
            default -> throw new IllegalArgumentException("Unknown binary operator token: " + tokenType);
        };
    }

    private UnaryOperator mapUnaryOperator(int tokenType) {
        return switch (tokenType) {
            case PigLatinLexer.MINUS -> UnaryOperator.NEGATE;
            case PigLatinLexer.NOT -> UnaryOperator.NOT;
            default -> throw new IllegalArgumentException("Unknown unary operator token: " + tokenType);
        };
    }

    //========================
    // NORMAL VALUES
    //========================
    @Override
    public PigLatinAstNode visitValString(PigLatinParser.ValStringContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.STRING, ctx.STRING().getText());
    }

    @Override
    public PigLatinAstNode visitValChar(PigLatinParser.ValCharContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.CHAR, ctx.CHAR().getText().charAt(0));
    }

    @Override
    public PigLatinAstNode visitValDecimal(PigLatinParser.ValDecimalContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.DECIMAL, Double.parseDouble(ctx.DECIMAL().getText()));
    }

    @Override
    public PigLatinAstNode visitValInt(PigLatinParser.ValIntContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.INT, Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public PigLatinAstNode visitValBool(PigLatinParser.ValBoolContext ctx) {
        return ctx.boolean_values().accept(this);
    }

    @Override
    public PigLatinAstNode visitValStructNestValue(PigLatinParser.ValStructNestValueContext ctx) {
        return ctx.object_values().accept(this);
    }

    @Override
    public PigLatinAstNode visitValStructPropertyLiteral(PigLatinParser.ValStructPropertyLiteralContext ctx) {
        return ctx.struct_literal().accept(this);
    }

    @Override
    public PigLatinAstNode visitValArrayInitialLiteral(PigLatinParser.ValArrayInitialLiteralContext ctx) {
        return ctx.array_initialization().accept(this);
    }

    @Override
    public PigLatinAstNode visitValNewInstance(PigLatinParser.ValNewInstanceContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String className = ctx.ID().getText();

        List<ExpressionNodePigLatin> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodePigLatin argsNode = (ArgumentsNodePigLatin) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }

        return new InstanceCreationExpressionNodePigLatin(line, column, className, args);
    }

    @Override
    public PigLatinAstNode visitBoolTrue(PigLatinParser.BoolTrueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.BOOLEAN, true);
    }

    @Override
    public PigLatinAstNode visitBoolFalse(PigLatinParser.BoolFalseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodePigLatin(line, column, DataType.BOOLEAN, false);
    }

    //========================
    // ABREVIATED OPERATIONS VALUES
    //========================

    @Override
    public PigLatinAstNode visitTypeText(PigLatinParser.TypeTextContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.STRING);
    }

    @Override
    public PigLatinAstNode visitTypeInt(PigLatinParser.TypeIntContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.INT);
    }

    @Override
    public PigLatinAstNode visitTypeDecimal(PigLatinParser.TypeDecimalContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.DECIMAL);
    }

    @Override
    public PigLatinAstNode visitTypeChar(PigLatinParser.TypeCharContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.CHAR);
    }

    @Override
    public PigLatinAstNode visitTypeBoolean(PigLatinParser.TypeBooleanContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.BOOLEAN);
    }

    @Override
    public PigLatinAstNode visitTypeCustomId(PigLatinParser.TypeCustomIdContext ctx) {
        return new TypeNodePigLatin(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), DataType.CUSTOM, ctx.ID().getText());
    }

    @Override
    public PigLatinAstNode visitIncOperation(PigLatinParser.IncOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new IncrementStatementNodePigLatin(line, column, AbreviationOperator.ABREV_PLUS, target);
    }

    @Override
    public PigLatinAstNode visitDecOperation(PigLatinParser.DecOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new DecrementStatementNodePigLatin(line, column, AbreviationOperator.ABREV_MINUS, target);
    }

    @Override
    public PigLatinAstNode visitIncPrevOperation(PigLatinParser.IncPrevOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new IncrementPrevStatementNodePigLatin(line, column, AbreviationOperator.ABREV_PREV_PLUS, target);
    }

    @Override
    public PigLatinAstNode visitDecPrevOperation(PigLatinParser.DecPrevOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodePigLatin target = (ExpressionNodePigLatin) ctx.nest_variable().accept(this);
        return new DecrementPrevStatementNodePigLatin(line, column, AbreviationOperator.ABREV_PREV_MINUS, target);
    }
}
