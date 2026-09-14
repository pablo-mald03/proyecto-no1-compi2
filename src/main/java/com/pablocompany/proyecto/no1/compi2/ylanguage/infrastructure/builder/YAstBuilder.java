package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParser;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParserBaseVisitor;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructBodyNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.enums.YDataType;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.ArgumentsNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.FunctionCallExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.IdentifierExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.LiteralExpressionNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.VariableDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ParameterListNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ParameterNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
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
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

/**
 * AST builder for the Y language
 */
public class YAstBuilder extends YParserBaseVisitor<YAstNode> implements AstBuilder {

    @Override
    public YAstNode build(EditorContext context) {
        if (context.getParseTree() == null) {
            return null;
        }
        YParser.ProgramContext program = (YParser.ProgramContext) context.getParseTree();
        return visitProgram(program);
    }

    @Override
    public String getSupportedExtension() {
        return ".y";
    }

    //========================
    // PROGRAM NODE
    //========================

    @Override
    public YAstNode visitProgram(YParser.ProgramContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        StructuresRegionNodeY structures = null;
        if (ctx.structures_region() != null) {
            structures = (StructuresRegionNodeY) ctx.structures_region().accept(this);
        }

        FunctionsRegionNodeY functions = null;
        if (ctx.functions_region() != null) {
            functions = (FunctionsRegionNodeY) ctx.functions_region().accept(this);
        }

        return new ProgramNodeY(line, column, structures, functions);
    }

    //========================
    // STRUCTS REGION
    //========================

    @Override
    public YAstNode visitStructRegionDeclaration(YParser.StructRegionDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StructDeclarationNodeY> structs = new ArrayList<>();
        for (YParser.Struct_declarationContext sCtx : ctx.struct_declaration()) {
            structs.add((StructDeclarationNodeY) sCtx.accept(this));
        }
        return new StructuresRegionNodeY(line, column, structs);
    }

    @Override
    public YAstNode visitStructDeclaration(YParser.StructDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<StructAttributeNodeY> fields = new ArrayList<>();
        for (YParser.Struct_fieldContext fCtx : ctx.struct_field()) {
            fields.add((StructAttributeNodeY) fCtx.accept(this));
        }
        return new StructDeclarationNodeY(
                line, column,
                new StructBodyNodeY(line, column, fields),
                name);
    }

    @Override
    public YAstNode visitStructNormalProperty(YParser.StructNormalPropertyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();

        return new StructAttributeNodeY(line, column, name, type, false, null);
    }

    @Override
    public YAstNode visitStructArrayProperty(YParser.StructArrayPropertyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        ExpressionNodeY size = (ExpressionNodeY) ctx.expression().accept(this);

        return new StructAttributeNodeY(line, column, name, type, true, size);
    }

    //========================
    // FUNCTIONS REGION
    //========================

    @Override
    public YAstNode visitFunctionSection(YParser.FunctionSectionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<FunctionDeclarationNodeY> functions = new ArrayList<>();
        for (YParser.Function_declarationContext fCtx : ctx.function_declaration()) {
            functions.add((FunctionDeclarationNodeY) fCtx.accept(this));
        }
        return new FunctionsRegionNodeY(line, column, functions);
    }

    @Override
    public YAstNode visitFunctionDeclaration(YParser.FunctionDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<ParameterNodeY> params = new ArrayList<>();
        if (ctx.parameter_list() != null) {
            ParameterListNodeY paramList = (ParameterListNodeY) ctx.parameter_list().accept(this);
            params = paramList.getParameters();
        }

        TypeNodeY returnType = null;
        if (ctx.type() != null) {
            returnType = (TypeNodeY) ctx.type().accept(this);
        }

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }

        return new FunctionDeclarationNodeY(line, column, body, name, returnType, params);
    }

    @Override
    public YAstNode visitParameterList(YParser.ParameterListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ParameterNodeY> params = new ArrayList<>();
        for (YParser.ParameterContext pCtx : ctx.parameter()) {
            params.add((ParameterNodeY) pCtx.accept(this));
        }
        return new ParameterListNodeY(line, column, params);
    }

    @Override
    public YAstNode visitPrimitiveParameter(YParser.PrimitiveParameterContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        return new ParameterNodeY(line, column, name, type, false, ParameterKind.PRIMITIVE);
    }

    @Override
    public YAstNode visitArrayParameter(YParser.ArrayParameterContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        return new ParameterNodeY(line, column, name, type, true, ParameterKind.ARRAY);
    }

    @Override
    public YAstNode visitStructParameter(YParser.StructParameterContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String structName = ctx.ID(0).getText();
        String varName = ctx.ID(1).getText();

        return new ParameterNodeY(line, column, varName,
                new TypeNodeY(line, column, YDataType.CUSTOM, structName),
                false, ParameterKind.STRUCT);
    }

    //========================
    // STATEMENT DISPATCH
    //========================

    @Override
    public YAstNode visitStatementBlock(YParser.StatementBlockContext ctx) {
        return ctx.block_statement().accept(this);
    }

    @Override
    public YAstNode visitStatementConsoleAction(YParser.StatementConsoleActionContext ctx) {
        return ctx.console_actions().accept(this);
    }

    @Override
    public YAstNode visitStatementLoopControl(YParser.StatementLoopControlContext ctx) {
        return ctx.loop_control().accept(this);
    }

    @Override
    public YAstNode visitStatementAbbreviatedOperation(YParser.StatementAbbreviatedOperationContext ctx) {
        return ctx.abbreviated_operation().accept(this);
    }

    @Override
    public YAstNode visitStatementCompoundAssignment(YParser.StatementCompoundAssignmentContext ctx) {
        return ctx.compound_assignment().accept(this);
    }

    @Override
    public YAstNode visitStatementStructDeclaration(YParser.StatementStructDeclarationContext ctx) {
        return ctx.struct_declaration().accept(this);
    }

    @Override
    public YAstNode visitVariableDeclarationStatement(YParser.VariableDeclarationStatementContext ctx) {
        return ctx.variable_declaration().accept(this);
    }

    @Override
    public YAstNode visitAssignmentVariableStatement(YParser.AssignmentVariableStatementContext ctx) {
        return ctx.assignment().accept(this);
    }

    @Override
    public YAstNode visitReturnStatement(YParser.ReturnStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY expr = null;
        if (ctx.expression() != null) {
            expr = (ExpressionNodeY) ctx.expression().accept(this);
        }
        return new ReturnStatementNodeY(line, column, expr);
    }

    //========================
    // BLOCK DISPATCH
    //========================

    @Override
    public YAstNode visitBlockIf(YParser.BlockIfContext ctx) {
        return ctx.if_statement().accept(this);
    }

    @Override
    public YAstNode visitBlockSwitch(YParser.BlockSwitchContext ctx) {
        return ctx.switch_statement().accept(this);
    }

    @Override
    public YAstNode visitBlockWhile(YParser.BlockWhileContext ctx) {
        return ctx.while_statement().accept(this);
    }

    @Override
    public YAstNode visitBlockDoWhile(YParser.BlockDoWhileContext ctx) {
        return ctx.do_while_statement().accept(this);
    }

    @Override
    public YAstNode visitBlockFor(YParser.BlockForContext ctx) {
        return ctx.for_statement().accept(this);
    }

    //========================
    // IF / ELSE IF / ELSE
    //========================

    @Override
    public YAstNode visitIfStatement(YParser.IfStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY condition = (ExpressionNodeY) ctx.expression().accept(this);

        List<StatementNodeY> thenBody = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            thenBody.add((StatementNodeY) sCtx.accept(this));
        }

        List<ElseIfNodeY> elseIfs = new ArrayList<>();
        if (ctx.else_if_list() != null) {
            ElseIfListNodeY listNode = (ElseIfListNodeY) ctx.else_if_list().accept(this);
            elseIfs = listNode.getClauses();
        }

        ElseBlockNodeY elseBlock = null;
        if (ctx.else_block() != null) {
            elseBlock = (ElseBlockNodeY) ctx.else_block().accept(this);
        }

        return new IfStatementNodeY(line, column, condition, thenBody, elseIfs, elseBlock);
    }

    @Override
    public YAstNode visitElseIfList(YParser.ElseIfListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ElseIfNodeY> clauses = new ArrayList<>();
        for (YParser.Else_if_clauseContext cCtx : ctx.else_if_clause()) {
            clauses.add((ElseIfNodeY) cCtx.accept(this));
        }
        return new ElseIfListNodeY(line, column, clauses);
    }

    @Override
    public YAstNode visitElseIfClause(YParser.ElseIfClauseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY condition = (ExpressionNodeY) ctx.expression().accept(this);

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }
        return new ElseIfNodeY(line, column, condition, body);
    }

    @Override
    public YAstNode visitElseBlock(YParser.ElseBlockContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }
        return new ElseBlockNodeY(line, column, body);
    }

    //========================
    // SWITCH
    //========================

    @Override
    public YAstNode visitSwitchStatement(YParser.SwitchStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY selector = (ExpressionNodeY) ctx.expression().accept(this);

        List<SwitchCaseNodeY> cases = new ArrayList<>();
        for (YParser.Switch_caseContext cCtx : ctx.switch_case()) {
            cases.add((SwitchCaseNodeY) cCtx.accept(this));
        }

        DefaultCaseNodeY defaultCase = null;
        if (ctx.always_case() != null) {
            defaultCase = (DefaultCaseNodeY) ctx.always_case().accept(this);
        }

        return new SwitchStatementNodeY(line, column, selector, cases, defaultCase);
    }

    @Override
    public YAstNode visitSwitchCase(YParser.SwitchCaseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }
        return new SwitchCaseNodeY(line, column, value, body);
    }

    @Override
    public YAstNode visitAlwaysCase(YParser.AlwaysCaseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }
        return new DefaultCaseNodeY(line, column, body);
    }

    //========================
    // LOOPS
    //========================

    @Override
    public YAstNode visitWhileStatement(YParser.WhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY condition = (ExpressionNodeY) ctx.expression().accept(this);

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }
        return new WhileStatementNodeY(line, column, condition, body);
    }

    @Override
    public YAstNode visitDoWhileStatement(YParser.DoWhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }

        ExpressionNodeY condition = (ExpressionNodeY) ctx.expression().accept(this);
        return new DoWhileStatementNodeY(line, column, body, condition);
    }

    @Override
    public YAstNode visitForStatement(YParser.ForStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        YAstNode init = null;
        if (ctx.for_init() != null) {
            init = ctx.for_init().accept(this);
        }

        ExpressionNodeY condition = null;
        if (ctx.expression() != null) {
            condition = (ExpressionNodeY) ctx.expression().accept(this);
        }

        YAstNode update = null;
        if (ctx.for_update() != null) {
            update = ctx.for_update().accept(this);
        }

        List<StatementNodeY> body = new ArrayList<>();
        for (YParser.StatementContext sCtx : ctx.statement()) {
            body.add((StatementNodeY) sCtx.accept(this));
        }

        return new ForStatementNodeY(line, column, body, init, condition, update);
    }

    @Override
    public YAstNode visitForInitVarDecl(YParser.ForInitVarDeclContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);

        return new ForInitDeclarationNodeY(line, column, name, type, value);
    }

    @Override
    public YAstNode visitForInitAssign(YParser.ForInitAssignContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);

        return new ForInitAssignmentNodeY(line, column, target, value);
    }

    @Override
    public YAstNode visitForUpdateIncrement(YParser.ForUpdateIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new ForUpdateNodeY(line, column, target, null, ForUpdateOperator.INCREMENT);
    }

    @Override
    public YAstNode visitForUpdateDecrement(YParser.ForUpdateDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new ForUpdateNodeY(line, column, target, null, ForUpdateOperator.DECREMENT);
    }

    @Override
    public YAstNode visitForUpdatePrefixIncrement(YParser.ForUpdatePrefixIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new ForUpdateNodeY(line, column, target, null, ForUpdateOperator.PREFIX_INCREMENT);
    }

    @Override
    public YAstNode visitForUpdatePrefixDecrement(YParser.ForUpdatePrefixDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new ForUpdateNodeY(line, column, target, null, ForUpdateOperator.PREFIX_DECREMENT);
    }

    @Override
    public YAstNode visitForUpdateAssign(YParser.ForUpdateAssignContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ForUpdateNodeY(line, column, target, value, ForUpdateOperator.ASSIGN);
    }

    @Override
    public YAstNode visitComPoundAssingment(YParser.ComPoundAssingmentContext ctx) {
        return ctx.compound_assignment().accept(this);
    }

    //========================
    // LOOP CONTROL
    //========================

    @Override
    public YAstNode visitLoopContinue(YParser.LoopContinueContext ctx) {
        return new ContinueStatementNodeY(
                ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public YAstNode visitLoopBreak(YParser.LoopBreakContext ctx) {
        return new BreakStatementNodeY(
                ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    //========================
    // CONSOLE ACTIONS
    //========================

    @Override
    public YAstNode visitPrintAction(YParser.PrintActionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY expr = (ExpressionNodeY) ctx.expression().accept(this);
        return new PrintStatementNodeY(line, column, expr);
    }

    @Override
    public YAstNode visitReadAction(YParser.ReadActionContext ctx) {
        return ctx.read_call().accept(this);
    }

    @Override
    public YAstNode visitReadCall(YParser.ReadCallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new ReadStatementNodeY(line, column);
    }

    //========================
    // ABBREVIATED OPERATIONS
    //========================

    @Override
    public YAstNode visitIncSufixOperation(YParser.IncSufixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new IncrementStatementNodeY(line, column, AbreviationOperator.ABREV_PLUS, target);
    }

    @Override
    public YAstNode visitDecSufixOperation(YParser.DecSufixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new DecrementStatementNodeY(line, column, AbreviationOperator.ABREV_MINUS, target);
    }

    @Override
    public YAstNode visitIncPrefixOperation(YParser.IncPrefixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new IncrementPrevStatementNodeY(line, column, AbreviationOperator.ABREV_PREV_PLUS, target);
    }

    @Override
    public YAstNode visitDecPrefixOperation(YParser.DecPrefixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        return new DecrementPrevStatementNodeY(line, column, AbreviationOperator.ABREV_PREV_MINUS, target);
    }

    //========================
    // COMPOUND ASSIGNMENTS
    //========================

    @Override
    public YAstNode visitCompoundAddAssignment(YParser.CompoundAddAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ShortlyOperationNodeY(line, column, target, value, ShortlyOperator.PLUS_ASSIGN);
    }

    @Override
    public YAstNode visitCompoundSubAssignment(YParser.CompoundSubAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ShortlyOperationNodeY(line, column, target, value, ShortlyOperator.MINUS_ASSIGN);
    }

    @Override
    public YAstNode visitCompoundMulAssignment(YParser.CompoundMulAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ShortlyOperationNodeY(line, column, target, value, ShortlyOperator.MULTIPLY_ASSIGN);
    }

    @Override
    public YAstNode visitCompoundDivAssignment(YParser.CompoundDivAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ShortlyOperationNodeY(line, column, target, value, ShortlyOperator.DIVIDE_ASSIGN);
    }

    @Override
    public YAstNode visitCompoundModAssignment(YParser.CompoundModAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new ShortlyOperationNodeY(line, column, target, value, ShortlyOperator.MODULO_ASSIGN);
    }

    //========================
    // ASSIGNMENT
    //========================

    @Override
    public YAstNode visitAssingmentStatement(YParser.AssingmentStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY target = (ExpressionNodeY) ctx.nest_variable().accept(this);
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);

        return new VariableAssignmentNodeY(line, column, target, value);
    }

    //========================
    // NESTED VARIABLE
    //========================

    @Override
    public YAstNode visitNestedVariable(YParser.NestedVariableContext ctx) {
        return ctx.object_values().accept(this);
    }

    //========================
    // OBJECT VALUES
    //========================

    @Override
    public YAstNode visitBaseIdentifier(YParser.BaseIdentifierContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new IdentifierExpressionNodeY(line, column, ctx.ID().getText());
    }

    @Override
    public YAstNode visitBaseFunctionCall(YParser.BaseFunctionCallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<ExpressionNodeY> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodeY argsNode = (ArgumentsNodeY) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }
        return new FunctionCallExpressionNodeY(line, column, null, name, args);
    }

    @Override
    public YAstNode visitObjectPropertyChain(YParser.ObjectPropertyChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY target = (ExpressionNodeY) ctx.object_values().accept(this);
        String propertyName = ctx.ID().getText();
        return new PropertyAccessExpressionNodeY(line, column, target, propertyName);
    }

    @Override
    public YAstNode visitObjectArrayAccessChain(YParser.ObjectArrayAccessChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY target = (ExpressionNodeY) ctx.object_values().accept(this);
        ExpressionNodeY index = (ExpressionNodeY) ctx.expression().accept(this);
        return new MemberArrayAccessExpressionNodeY(line, column, index, target);
    }

    @Override
    public YAstNode visitArgumentsList(YParser.ArgumentsListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeY> args = new ArrayList<>();
        for (YParser.ExpressionContext eCtx : ctx.expression()) {
            args.add((ExpressionNodeY) eCtx.accept(this));
        }
        return new ArgumentsNodeY(line, column, args);
    }

    //========================
    // ARRAY LITERAL
    //========================

    @Override
    public YAstNode visitArrayLiteralValue(YParser.ArrayLiteralValueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeY> values = new ArrayList<>();
        if (ctx.array_values() != null) {
            ArrayValuesNodeY valuesNode = (ArrayValuesNodeY) ctx.array_values().accept(this);
            values = valuesNode.getValues();
        }
        return new ArrayInitExpressionNodeY(line, column, values);
    }

    @Override
    public YAstNode visitArrayValuesList(YParser.ArrayValuesListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeY> values = new ArrayList<>();
        for (YParser.ExpressionContext eCtx : ctx.expression()) {
            values.add((ExpressionNodeY) eCtx.accept(this));
        }
        return new ArrayValuesNodeY(line, column, values);
    }

    //========================
    // VARIABLE DECLARATIONS
    //========================

    @Override
    public YAstNode visitNotDefiniedVariable(YParser.NotDefiniedVariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        return new VariableDeclarationNodeY(line, column, name, type, null, false);
    }

    @Override
    public YAstNode visitDefiniedVariable(YParser.DefiniedVariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();
        ExpressionNodeY value = (ExpressionNodeY) ctx.expression().accept(this);
        return new VariableDeclarationNodeY(line, column, name, type, value, false);
    }

    @Override
    public YAstNode visitNotDefiniedArrayVariable(YParser.NotDefiniedArrayVariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();

        List<YParser.ExpressionContext> exprCtxs = ctx.expression();
        int last = exprCtxs.size() - 1;

        List<ExpressionNodeY> dimensions = new ArrayList<>();
        for (int i = 0; i < last; i++) {
            dimensions.add((ExpressionNodeY) exprCtxs.get(i).accept(this));
        }

        ExpressionNodeY initializer = (ExpressionNodeY) exprCtxs.get(last).accept(this);

        return new ArrayDeclarationNodeY(line, column, name, type, dimensions, initializer);
    }

    @Override
    public YAstNode visitDefiniedArrayVariable(YParser.DefiniedArrayVariableContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeY type = (TypeNodeY) ctx.type().accept(this);
        String name = ctx.ID().getText();

        List<YParser.ExpressionContext> exprCtxs = ctx.expression();
        int last = exprCtxs.size() - 1;

        List<ExpressionNodeY> dimensions = new ArrayList<>();
        for (int i = 0; i < last; i++) {
            dimensions.add((ExpressionNodeY) exprCtxs.get(i).accept(this));
        }

        ExpressionNodeY initializer = (ExpressionNodeY) exprCtxs.get(last).accept(this);

        return new ArrayDeclarationNodeY(line, column, name, type, dimensions, initializer);
    }

    //========================
    // TYPES
    //========================

    @Override
    public YAstNode visitIntValue(YParser.IntValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), YDataType.INT);
    }

    @Override
    public YAstNode visitStringValue(YParser.StringValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), YDataType.STRING);
    }

    @Override
    public YAstNode visitFloatValue(YParser.FloatValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), YDataType.FLOAT);
    }

    @Override
    public YAstNode visitCharValue(YParser.CharValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), YDataType.CHAR);
    }

    @Override
    public YAstNode visitBooleanValue(YParser.BooleanValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), YDataType.BOOLEAN);
    }

    @Override
    public YAstNode visitCustomTypeValue(YParser.CustomTypeValueContext ctx) {
        return new TypeNodeY(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                YDataType.CUSTOM, ctx.ID().getText());
    }

    //========================
    // EXPRESSIONS
    //========================

    @Override
    public YAstNode visitExpressionParents(YParser.ExpressionParentsContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public YAstNode visitExpressionUnary(YParser.ExpressionUnaryContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY expr = (ExpressionNodeY) ctx.expression().accept(this);
        UnaryOperator op = mapUnaryOperator(ctx.op.getType());
        return new UnaryExpressionNodeY(line, column, expr, op);
    }

    @Override
    public YAstNode visitExpressionMultDiv(YParser.ExpressionMultDivContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public YAstNode visitExpressionAddSub(YParser.ExpressionAddSubContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public YAstNode visitExpressionRelational(YParser.ExpressionRelationalContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public YAstNode visitExpressionEquality(YParser.ExpressionEqualityContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public YAstNode visitExpressionAnd(YParser.ExpressionAndContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), YLexer.AND, ctx);
    }

    @Override
    public YAstNode visitExpressionOr(YParser.ExpressionOrContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), YLexer.OR, ctx);
    }

    @Override
    public YAstNode visitExpressionValue(YParser.ExpressionValueContext ctx) {
        return ctx.normal_values().accept(this);
    }

    private BinaryExpressionNodeY buildBinary(YParser.ExpressionContext l,
                                              YParser.ExpressionContext r,
                                              int tokenType,
                                              ParserRuleContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeY left = (ExpressionNodeY) l.accept(this);
        ExpressionNodeY right = (ExpressionNodeY) r.accept(this);
        BinaryOperator op = mapBinaryOperator(tokenType);
        return new BinaryExpressionNodeY(line, column, left, right, op);
    }

    private BinaryOperator mapBinaryOperator(int tokenType) {
        return switch (tokenType) {
            case YLexer.PLUS -> BinaryOperator.PLUS;
            case YLexer.MINUS -> BinaryOperator.MINUS;
            case YLexer.MULTIPLICATION -> BinaryOperator.MULTIPLICATION;
            case YLexer.DIVIDE -> BinaryOperator.DIVIDE;
            case YLexer.PERCENT -> BinaryOperator.MODULE;
            case YLexer.EQUALS -> BinaryOperator.EQUALS;
            case YLexer.DIFERENCE -> BinaryOperator.DIFFERENT;
            case YLexer.LESS -> BinaryOperator.LESS;
            case YLexer.GREATER -> BinaryOperator.GREATER;
            case YLexer.LESS_EQUALS -> BinaryOperator.LESS_EQUALS;
            case YLexer.GREATER_EQUALS -> BinaryOperator.GREATER_EQUALS;
            case YLexer.AND -> BinaryOperator.AND;
            case YLexer.OR -> BinaryOperator.OR;
            default -> throw new IllegalArgumentException("Unknown binary op: " + tokenType);
        };
    }

    private UnaryOperator mapUnaryOperator(int tokenType) {
        return switch (tokenType) {
            case YLexer.MINUS -> UnaryOperator.NEGATE;
            case YLexer.NOT -> UnaryOperator.NOT;
            default -> throw new IllegalArgumentException("Unknown unary op: " + tokenType);
        };
    }

    //========================
    // NORMAL VALUES
    //========================

    @Override
    public YAstNode visitValArrayLiteral(YParser.ValArrayLiteralContext ctx) {
        return ctx.array_literal().accept(this);
    }

    @Override
    public YAstNode visitValReadCall(YParser.ValReadCallContext ctx) {
        return ctx.read_call().accept(this);
    }

    @Override
    public YAstNode visitValueString(YParser.ValueStringContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.STRING, ctx.TEXT().getText());
    }

    @Override
    public YAstNode visitValueChar(YParser.ValueCharContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.CHAR, ctx.CHAR().getText().charAt(0));
    }

    @Override
    public YAstNode visitValueDecimal(YParser.ValueDecimalContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.FLOAT, Float.parseFloat(ctx.DECIMAL().getText()));
    }

    @Override
    public YAstNode visitValueInt(YParser.ValueIntContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.INT, Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public YAstNode visitValBool(YParser.ValBoolContext ctx) {
        return ctx.boolean_values().accept(this);
    }

    @Override
    public YAstNode visitValObjectAccess(YParser.ValObjectAccessContext ctx) {
        return ctx.object_values().accept(this);
    }

    @Override
    public YAstNode visitBoolTrue(YParser.BoolTrueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.BOOLEAN, true);
    }

    @Override
    public YAstNode visitBoolFalse(YParser.BoolFalseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeY(line, column, YDataType.BOOLEAN, false);
    }
}