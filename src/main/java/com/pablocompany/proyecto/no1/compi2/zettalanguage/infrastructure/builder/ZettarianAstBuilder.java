package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.builder;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AbreviationOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ForUpdateOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.ShortlyOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.BinaryOperator;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.enums.UnaryOperator;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZParser;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZParserBaseVisitor;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.MemberArrayAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.PropertyAccessExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.access.ShortlyOperationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayInitExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.arrays.ArrayValuesNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.assignation.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.instances.ExpressionStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.ZDataType;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.values.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.VariableDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.BreakStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ContinueStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.breakpoints.ReturnStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseBlockNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfListNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.ElseIfNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.conditionals.IfStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterListNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.PrintStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.iostreams.ReadStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.loops.*;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.ConstructorDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.DefaultCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchCaseNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.switches.SwitchStatementNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.CodeBodyNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.parents.ExpressionNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.principals.ClassDeclarationNodeZ;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

/**
 * AST builder for the Z language (Zettaradian)
 */
public class ZettarianAstBuilder extends ZParserBaseVisitor<ZAstNode> implements AstBuilder {

    @Override
    public ZAstNode build(EditorContext context) {
        if (context.getParseTree() == null) {
            return null;
        }
        ZParser.ProgramContext program = (ZParser.ProgramContext) context.getParseTree();
        return visitProgram(program);
    }

    @Override
    public String getSupportedExtension() {
        return ".z";
    }

    //========================
    // PROGRAM NODE
    //========================

    @Override
    public ZAstNode visitProgram(ZParser.ProgramContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ClassDeclarationNodeZ classDecl =
                (ClassDeclarationNodeZ) ctx.class_declaration().accept(this);
        return new ProgramNodeZ(line, column, classDecl);
    }

    @Override
    public ZAstNode visitClassDeclaration(ZParser.ClassDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String className = ctx.ID().getText();

        List<ZAstNode> members = new ArrayList<>();
        for (ZParser.Class_memberContext mCtx : ctx.class_member()) {
            members.add(mCtx.accept(this));
        }

        return new ClassDeclarationNodeZ(line, column, className, members);
    }

    //========================
    // MEMBER NODES
    //========================

    @Override
    public ZAstNode visitClassFieldMember(ZParser.ClassFieldMemberContext ctx) {
        return ctx.variable_declaration().accept(this);
    }

    @Override
    public ZAstNode visitClassConstructorMember(ZParser.ClassConstructorMemberContext ctx) {
        return ctx.constructor_declaration().accept(this);
    }

    @Override
    public ZAstNode visitClassMethodMember(ZParser.ClassMethodMemberContext ctx) {
        return ctx.method_declaration().accept(this);
    }

    //========================
    // CONSTRUCTOR AND METHOD NODES
    //========================

    @Override
    public ZAstNode visitConstructorDeclaration(ZParser.ConstructorDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<ParameterNodeZ> params = new ArrayList<>();
        if (ctx.parameter_list() != null) {
            ParameterListNodeZ list = (ParameterListNodeZ) ctx.parameter_list().accept(this);
            params = list.getParameters();
        }

        List<ZAstNode> body = new ArrayList<>();
        for (ZParser.StatementContext sCtx : ctx.statement()) {
            body.add(sCtx.accept(this));
        }

        return new ConstructorDeclarationNodeZ(line, column, name, params, body);
    }

    @Override
    public ZAstNode visitMethodDeclaration(ZParser.MethodDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ returnType = (TypeNodeZ) ctx.type().accept(this);
        int returnDimensions = ctx.INIT_BRACKET().size();
        String name = ctx.ID().getText();

        List<ParameterNodeZ> params = new ArrayList<>();
        if (ctx.parameter_list() != null) {
            ParameterListNodeZ list = (ParameterListNodeZ) ctx.parameter_list().accept(this);
            params = list.getParameters();
        }

        List<ZAstNode> body = new ArrayList<>();
        for (ZParser.StatementContext sCtx : ctx.statement()) {
            body.add(sCtx.accept(this));
        }

        return new MethodDeclarationNodeZ(line, column, name, returnType, params, body, returnDimensions);
    }

    //========================
    // PARAMETER NODES
    //========================

    @Override
    public ZAstNode visitParameterList(ZParser.ParameterListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ParameterNodeZ> params = new ArrayList<>();
        for (ZParser.ParameterContext pCtx : ctx.parameter()) {
            params.add((ParameterNodeZ) pCtx.accept(this));
        }
        return new ParameterListNodeZ(line, column, params);
    }

    @Override
    public ZAstNode visitParameterStatement(ZParser.ParameterStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ type = (TypeNodeZ) ctx.type().accept(this);
        String name = ctx.ID().getText();

        int dimensions = ctx.INIT_BRACKET().size();
        boolean isArray = dimensions > 0;
        ParameterKind kind = (isArray) ? ParameterKind.ARRAY : ParameterKind.NORMAL;

        return new ParameterNodeZ(line, column, name, type, isArray, dimensions, kind);
    }

    //========================
    // STATEMENT DISPATCH
    //========================

    @Override
    public ZAstNode visitStatementBlock(ZParser.StatementBlockContext ctx) {
        return ctx.block_statement().accept(this);
    }

    @Override
    public ZAstNode visitStatementConsoleAction(ZParser.StatementConsoleActionContext ctx) {
        return ctx.console_actions().accept(this);
    }

    @Override
    public ZAstNode visitStatementLoopControl(ZParser.StatementLoopControlContext ctx) {
        return ctx.loop_control().accept(this);
    }

    @Override
    public ZAstNode visitStatementReturn(ZParser.StatementReturnContext ctx) {
        return ctx.return_statement().accept(this);
    }

    @Override
    public ZAstNode visitStatementAbbreviatedOperation(ZParser.StatementAbbreviatedOperationContext ctx) {
        return ctx.abbreviated_operation().accept(this);
    }

    @Override
    public ZAstNode visitStatementCompoundAssignment(ZParser.StatementCompoundAssignmentContext ctx) {
        return ctx.compound_assignment().accept(this);
    }

    @Override
    public ZAstNode visitStatementNestedAssignment(ZParser.StatementNestedAssignmentContext ctx) {
        return ctx.nested_variables_usage().accept(this);
    }

    @Override
    public ZAstNode visitStatementVariableDeclaration(ZParser.StatementVariableDeclarationContext ctx) {
        return ctx.variable_declaration().accept(this);
    }

    @Override
    public ZAstNode visitStatementObjectPropertyCalling(ZParser.StatementObjectPropertyCallingContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ obj = (ExpressionNodeZ) ctx.object_values().accept(this);
        return new ExpressionStatementNodeZ(line, column, obj);
    }

    //========================
    // RETURN AND LOOP CONTROL
    //========================

    @Override
    public ZAstNode visitReturnStatement(ZParser.ReturnStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ expr = null;
        if (ctx.expression() != null) {
            expr = (ExpressionNodeZ) ctx.expression().accept(this);
        }
        return new ReturnStatementNodeZ(line, column, expr);
    }

    @Override
    public ZAstNode visitLoopContinue(ZParser.LoopContinueContext ctx) {
        return new ContinueStatementNodeZ(
                ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public ZAstNode visitLoopBreak(ZParser.LoopBreakContext ctx) {
        return new BreakStatementNodeZ(
                ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    //========================
    // CONSOLE ACTIONS
    //========================

    @Override
    public ZAstNode visitPrintlnAction(ZParser.PrintlnActionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ expr = (ExpressionNodeZ) ctx.expression().accept(this);
        return new PrintStatementNodeZ(line, column, expr, true);
    }

    @Override
    public ZAstNode visitPrintAction(ZParser.PrintActionContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ expr = (ExpressionNodeZ) ctx.expression().accept(this);
        return new PrintStatementNodeZ(line, column, expr, false);
    }

    @Override
    public ZAstNode visitReadAction(ZParser.ReadActionContext ctx) {
        return ctx.read_call().accept(this);
    }

    @Override
    public ZAstNode visitReadCall(ZParser.ReadCallContext ctx) {
        return new ReadStatementNodeZ(
                ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    //========================
    // BLOCK DISPATCH
    //========================

    @Override
    public ZAstNode visitBlockIf(ZParser.BlockIfContext ctx) {
        return ctx.if_statement().accept(this);
    }

    @Override
    public ZAstNode visitBlockSwitch(ZParser.BlockSwitchContext ctx) {
        return ctx.switch_statement().accept(this);
    }

    @Override
    public ZAstNode visitBlockWhile(ZParser.BlockWhileContext ctx) {
        return ctx.while_statement().accept(this);
    }

    @Override
    public ZAstNode visitBlockDoWhile(ZParser.BlockDoWhileContext ctx) {
        return ctx.do_while_statement().accept(this);
    }

    @Override
    public ZAstNode visitBlockFor(ZParser.BlockForContext ctx) {
        return ctx.for_statement().accept(this);
    }

    //========================
    // STATEMENT BODIES (WRAPPER)
    //========================

    @Override
    public ZAstNode visitBracedStatementBody(ZParser.BracedStatementBodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ZAstNode> body = new ArrayList<>();
        for (ZParser.StatementContext sCtx : ctx.statement()) {
            body.add(sCtx.accept(this));
        }
        return new CodeBodyNodeZ(line, column, body);
    }

    @Override
    public ZAstNode visitSingleStatementBody(ZParser.SingleStatementBodyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ZAstNode stmt = ctx.statement().accept(this);
        List<ZAstNode> body = new ArrayList<>();
        body.add(stmt);
        return new CodeBodyNodeZ(line, column, body);
    }

    //========================
    // IF / ELSE IF / ELSE
    //========================

    @Override
    public ZAstNode visitIfStatement(ZParser.IfStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ condition = (ExpressionNodeZ) ctx.expression().accept(this);
        CodeBodyNodeZ thenBody = (CodeBodyNodeZ) ctx.statement_body().accept(this);

        List<ElseIfNodeZ> elseIfs = new ArrayList<>();
        if (ctx.else_if_list() != null) {
            ElseIfListNodeZ listNode = (ElseIfListNodeZ) ctx.else_if_list().accept(this);
            elseIfs = listNode.getClauses();
        }

        ElseBlockNodeZ elseBlock = null;
        if (ctx.else_block() != null) {
            elseBlock = (ElseBlockNodeZ) ctx.else_block().accept(this);
        }

        return new IfStatementNodeZ(
                line, column, condition, thenBody.getStatements(), elseIfs, elseBlock);
    }

    @Override
    public ZAstNode visitElseIfList(ZParser.ElseIfListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ElseIfNodeZ> clauses = new ArrayList<>();
        for (ZParser.Else_if_clauseContext cCtx : ctx.else_if_clause()) {
            clauses.add((ElseIfNodeZ) cCtx.accept(this));
        }
        return new ElseIfListNodeZ(line, column, clauses);
    }

    @Override
    public ZAstNode visitElseIfClause(ZParser.ElseIfClauseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ condition = (ExpressionNodeZ) ctx.expression().accept(this);
        CodeBodyNodeZ body = (CodeBodyNodeZ) ctx.statement_body().accept(this);

        return new ElseIfNodeZ(line, column, condition, body.getStatements());
    }

    @Override
    public ZAstNode visitElseBlock(ZParser.ElseBlockContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        CodeBodyNodeZ body = (CodeBodyNodeZ) ctx.statement_body().accept(this);
        return new ElseBlockNodeZ(line, column, body.getStatements());
    }

    //========================
    // SWITCH
    //========================

    @Override
    public ZAstNode visitSwitchStatement(ZParser.SwitchStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ selector = (ExpressionNodeZ) ctx.expression().accept(this);

        List<SwitchCaseNodeZ> cases = new ArrayList<>();
        for (ZParser.Switch_caseContext cCtx : ctx.switch_case()) {
            cases.add((SwitchCaseNodeZ) cCtx.accept(this));
        }

        DefaultCaseNodeZ defaultCase = null;
        if (ctx.default_case() != null) {
            defaultCase = (DefaultCaseNodeZ) ctx.default_case().accept(this);
        }

        return new SwitchStatementNodeZ(line, column, selector, cases, defaultCase);
    }

    @Override
    public ZAstNode visitSwitchCase(ZParser.SwitchCaseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);

        List<ZAstNode> body = new ArrayList<>();
        for (ZParser.StatementContext sCtx : ctx.statement()) {
            body.add(sCtx.accept(this));
        }
        return new SwitchCaseNodeZ(line, column, value, body);
    }

    @Override
    public ZAstNode visitDefaultCase(ZParser.DefaultCaseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ZAstNode> body = new ArrayList<>();
        for (ZParser.StatementContext sCtx : ctx.statement()) {
            body.add(sCtx.accept(this));
        }
        return new DefaultCaseNodeZ(line, column, body);
    }

    //========================
    // LOOPS
    //========================

    @Override
    public ZAstNode visitWhileStatement(ZParser.WhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ condition = (ExpressionNodeZ) ctx.expression().accept(this);
        CodeBodyNodeZ body = (CodeBodyNodeZ) ctx.statement_body().accept(this);

        return new WhileStatementNodeZ(line, column, condition, body.getStatements());
    }

    @Override
    public ZAstNode visitDoWhileStatement(ZParser.DoWhileStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        CodeBodyNodeZ body = (CodeBodyNodeZ) ctx.statement_body().accept(this);
        ExpressionNodeZ condition = (ExpressionNodeZ) ctx.expression().accept(this);

        return new DoWhileStatementNodeZ(line, column, condition, body.getStatements());
    }

    @Override
    public ZAstNode visitForStatement(ZParser.ForStatementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ZAstNode init = null;
        if (ctx.for_init() != null) {
            init = ctx.for_init().accept(this);
        }

        ExpressionNodeZ condition = null;
        if (ctx.expression() != null) {
            condition = (ExpressionNodeZ) ctx.expression().accept(this);
        }

        ZAstNode update = null;
        if (ctx.for_update() != null) {
            update = ctx.for_update().accept(this);
        }

        CodeBodyNodeZ body = (CodeBodyNodeZ) ctx.statement_body().accept(this);

        return new ForStatementNodeZ(line, column, init, condition, update, body.getStatements());
    }

    //========================
    // FOR INIT / UPDATE
    //========================

    @Override
    public ZAstNode visitForInitVarDecl(ZParser.ForInitVarDeclContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ type = (TypeNodeZ) ctx.type().accept(this);
        String name = ctx.ID().getText();
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);

        int dimensions = ctx.INIT_BRACKET().size();

        return new ForInitDeclarationNodeZ(line, column, name, type, value, dimensions);
    }

    @Override
    public ZAstNode visitForInitAssign(ZParser.ForInitAssignContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);

        return new ForInitAssignmentNodeZ(line, column, target, value);
    }

    @Override
    public ZAstNode visitForUpdateIncrement(ZParser.ForUpdateIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new ForUpdateNodeZ(line, column, target, null, ForUpdateOperator.INCREMENT);
    }

    @Override
    public ZAstNode visitForUpdateDecrement(ZParser.ForUpdateDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new ForUpdateNodeZ(line, column, target, null, ForUpdateOperator.DECREMENT);
    }

    @Override
    public ZAstNode visitForUpdatePrefixIncrement(ZParser.ForUpdatePrefixIncrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new ForUpdateNodeZ(line, column, target, null, ForUpdateOperator.PREFIX_INCREMENT);
    }

    @Override
    public ZAstNode visitForUpdatePrefixDecrement(ZParser.ForUpdatePrefixDecrementContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new ForUpdateNodeZ(line, column, target, null, ForUpdateOperator.PREFIX_DECREMENT);
    }

    @Override
    public ZAstNode visitForUpdateAssign(ZParser.ForUpdateAssignContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ForUpdateNodeZ(line, column, target, value, ForUpdateOperator.ASSIGN);
    }

    @Override
    public ZAstNode visitComPoundAssingment(ZParser.ComPoundAssingmentContext ctx) {
        return ctx.compound_assignment().accept(this);
    }

    //========================
    // VARIABLE DECLARATION AND ASSIGNMENT
    //========================

    @Override
    public ZAstNode visitVariableDeclaration(ZParser.VariableDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ type = (TypeNodeZ) ctx.type().accept(this);
        String name = ctx.ID().getText();

        ExpressionNodeZ value = null;
        if (ctx.expression() != null) {
            value = (ExpressionNodeZ) ctx.expression().accept(this);
        }

        int dimensions = ctx.INIT_BRACKET().size();

        return new VariableDeclarationNodeZ(line, column, name, type, value, dimensions);
    }

    @Override
    public ZAstNode visitNestedObjectAssignment(ZParser.NestedObjectAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ target = (ExpressionNodeZ) ctx.object_values().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);

        return new VariableAssignmentNodeZ(line, column, target, value);
    }

    //========================
    // COMPOUND ASSIGNMENTS
    //========================

    @Override
    public ZAstNode visitCompoundAddAssignment(ZParser.CompoundAddAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ShortlyOperationNodeZ(line, column, target, value, ShortlyOperator.PLUS_ASSIGN);
    }

    @Override
    public ZAstNode visitCompoundSubAssignment(ZParser.CompoundSubAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ShortlyOperationNodeZ(line, column, target, value, ShortlyOperator.MINUS_ASSIGN);
    }

    @Override
    public ZAstNode visitCompoundMulAssignment(ZParser.CompoundMulAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ShortlyOperationNodeZ(line, column, target, value, ShortlyOperator.MULTIPLY_ASSIGN);
    }

    @Override
    public ZAstNode visitCompoundDivAssignment(ZParser.CompoundDivAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ShortlyOperationNodeZ(line, column, target, value, ShortlyOperator.DIVIDE_ASSIGN);
    }

    @Override
    public ZAstNode visitCompoundModAssignment(ZParser.CompoundModAssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        ExpressionNodeZ value = (ExpressionNodeZ) ctx.expression().accept(this);
        return new ShortlyOperationNodeZ(line, column, target, value, ShortlyOperator.MODULO_ASSIGN);
    }

    //========================
    // ABBREVIATED OPERATIONS
    //========================

    @Override
    public ZAstNode visitIncSufixOperation(ZParser.IncSufixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new IncrementStatementNodeZ(line, column, AbreviationOperator.ABREV_PLUS, target);
    }

    @Override
    public ZAstNode visitDecSufixOperation(ZParser.DecSufixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new DecrementStatementNodeZ(line, column, AbreviationOperator.ABREV_MINUS, target);
    }

    @Override
    public ZAstNode visitIncPrefixOperation(ZParser.IncPrefixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new IncrementPrevStatementNodeZ(line, column, AbreviationOperator.ABREV_PREV_PLUS, target);
    }

    @Override
    public ZAstNode visitDecPrefixOperation(ZParser.DecPrefixOperationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExpressionNodeZ target = (ExpressionNodeZ) ctx.nest_variable().accept(this);
        return new DecrementPrevStatementNodeZ(line, column, AbreviationOperator.ABREV_PREV_MINUS, target);
    }

    //========================
    // NESTED VARIABLE WRAPPER
    //========================

    @Override
    public ZAstNode visitNestedVariable(ZParser.NestedVariableContext ctx) {
        return ctx.object_values().accept(this);
    }

    //========================
    // OBJECT VALUES
    //========================

    @Override
    public ZAstNode visitBaseIdentifier(ZParser.BaseIdentifierContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new IdentifierExpressionNodeZ(line, column, ctx.ID().getText());
    }

    @Override
    public ZAstNode visitBaseFunctionCall(ZParser.BaseFunctionCallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        String name = ctx.ID().getText();

        List<ExpressionNodeZ> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodeZ argsNode = (ArgumentsNodeZ) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }
        return new FunctionCallExpressionNodeZ(line, column, null, name, args);
    }

    @Override
    public ZAstNode visitObjectPropertyChain(ZParser.ObjectPropertyChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ target = (ExpressionNodeZ) ctx.object_values().accept(this);
        String propertyName = ctx.ID().getText();
        return new PropertyAccessExpressionNodeZ(line, column, target, propertyName);
    }

    @Override
    public ZAstNode visitObjectMethodChain(ZParser.ObjectMethodChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ target = (ExpressionNodeZ) ctx.object_values().accept(this);
        String name = ctx.ID().getText();

        List<ExpressionNodeZ> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodeZ argsNode = (ArgumentsNodeZ) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }
        return new FunctionCallExpressionNodeZ(line, column, target, name, args);
    }

    @Override
    public ZAstNode visitObjectArrayAccessChain(ZParser.ObjectArrayAccessChainContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ target = (ExpressionNodeZ) ctx.object_values().accept(this);
        ExpressionNodeZ index = (ExpressionNodeZ) ctx.expression().accept(this);
        return new MemberArrayAccessExpressionNodeZ(line, column, index, target);
    }

    @Override
    public ZAstNode visitArgumentsList(ZParser.ArgumentsListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeZ> args = new ArrayList<>();
        for (ZParser.ExpressionContext eCtx : ctx.expression()) {
            args.add((ExpressionNodeZ) eCtx.accept(this));
        }
        return new ArgumentsNodeZ(line, column, args);
    }

    //========================
    // INSTANTIATION
    //========================

    @Override
    public ZAstNode visitObjectInstantiation(ZParser.ObjectInstantiationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ type = (TypeNodeZ) ctx.type().accept(this);

        List<ExpressionNodeZ> args = new ArrayList<>();
        if (ctx.arguments_list() != null) {
            ArgumentsNodeZ argsNode = (ArgumentsNodeZ) ctx.arguments_list().accept(this);
            args = argsNode.getArguments();
        }
        return new ObjectInstantiationNodeZ(line, column, type, args);
    }

    @Override
    public ZAstNode visitArrayInstantiation(ZParser.ArrayInstantiationContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        TypeNodeZ type = (TypeNodeZ) ctx.type().accept(this);

        List<ExpressionNodeZ> dimensions = new ArrayList<>();
        for (ZParser.ExpressionContext eCtx : ctx.expression()) {
            dimensions.add((ExpressionNodeZ) eCtx.accept(this));
        }
        return new ArrayInstantiationNodeZ(line, column, type, dimensions);
    }

    //========================
    // ARRAY LITERAL
    //========================

    @Override
    public ZAstNode visitArrayLiteralValue(ZParser.ArrayLiteralValueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeZ> values = new ArrayList<>();
        if (ctx.array_values() != null) {
            ArrayValuesNodeZ valuesNode = (ArrayValuesNodeZ) ctx.array_values().accept(this);
            values = valuesNode.getValues();
        }
        return new ArrayInitExpressionNodeZ(line, column, values);
    }

    @Override
    public ZAstNode visitArrayValuesList(ZParser.ArrayValuesListContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        List<ExpressionNodeZ> values = new ArrayList<>();
        for (ZParser.ExpressionContext eCtx : ctx.expression()) {
            values.add((ExpressionNodeZ) eCtx.accept(this));
        }
        return new ArrayValuesNodeZ(line, column, values);
    }

    //========================
    // EXPRESSIONS
    //========================

    @Override
    public ZAstNode visitExpressionParents(ZParser.ExpressionParentsContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public ZAstNode visitExpressionUnary(ZParser.ExpressionUnaryContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ expr = (ExpressionNodeZ) ctx.expression().accept(this);
        UnaryOperator op = mapUnaryOperator(ctx.op.getType());
        return new UnaryExpressionNodeZ(line, column, expr, op);
    }

    @Override
    public ZAstNode visitExpressionMultDiv(ZParser.ExpressionMultDivContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public ZAstNode visitExpressionAddSub(ZParser.ExpressionAddSubContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public ZAstNode visitExpressionRelational(ZParser.ExpressionRelationalContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public ZAstNode visitExpressionEquality(ZParser.ExpressionEqualityContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ctx.op.getType(), ctx);
    }

    @Override
    public ZAstNode visitExpressionAnd(ZParser.ExpressionAndContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ZLexer.AND, ctx);
    }

    @Override
    public ZAstNode visitExpressionOr(ZParser.ExpressionOrContext ctx) {
        return buildBinary(ctx.expression(0), ctx.expression(1), ZLexer.OR, ctx);
    }

    @Override
    public ZAstNode visitExpressionTernary(ZParser.ExpressionTernaryContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ condition = (ExpressionNodeZ) ctx.expression(0).accept(this);
        ExpressionNodeZ thenExpr = (ExpressionNodeZ) ctx.expression(1).accept(this);
        ExpressionNodeZ elseExpr = (ExpressionNodeZ) ctx.expression(2).accept(this);

        return new TernaryExpressionNodeZ(line, column, condition, thenExpr, elseExpr);
    }

    @Override
    public ZAstNode visitExpressionValue(ZParser.ExpressionValueContext ctx) {
        return ctx.normal_values().accept(this);
    }

    private BinaryExpressionNodeZ buildBinary(ZParser.ExpressionContext l,
                                              ZParser.ExpressionContext r,
                                              int tokenType,
                                              ParserRuleContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        ExpressionNodeZ left = (ExpressionNodeZ) l.accept(this);
        ExpressionNodeZ right = (ExpressionNodeZ) r.accept(this);
        BinaryOperator op = mapBinaryOperator(tokenType);
        return new BinaryExpressionNodeZ(line, column, left, right, op);
    }

    private BinaryOperator mapBinaryOperator(int tokenType) {
        return switch (tokenType) {
            case ZLexer.PLUS -> BinaryOperator.PLUS;
            case ZLexer.MINUS -> BinaryOperator.MINUS;
            case ZLexer.MULTIPLICATION -> BinaryOperator.MULTIPLICATION;
            case ZLexer.DIVIDE -> BinaryOperator.DIVIDE;
            case ZLexer.PERCENT -> BinaryOperator.MODULE;
            case ZLexer.EQUALS -> BinaryOperator.EQUALS;
            case ZLexer.DIFERENCE -> BinaryOperator.DIFFERENT;
            case ZLexer.LESS -> BinaryOperator.LESS;
            case ZLexer.GREATER -> BinaryOperator.GREATER;
            case ZLexer.LESS_EQUALS -> BinaryOperator.LESS_EQUALS;
            case ZLexer.GREATER_EQUALS -> BinaryOperator.GREATER_EQUALS;
            case ZLexer.AND -> BinaryOperator.AND;
            case ZLexer.OR -> BinaryOperator.OR;
            default -> throw new IllegalArgumentException("Unknown binary op: " + tokenType);
        };
    }

    private UnaryOperator mapUnaryOperator(int tokenType) {
        return switch (tokenType) {
            case ZLexer.MINUS -> UnaryOperator.NEGATE;
            case ZLexer.NOT -> UnaryOperator.NOT;
            default -> throw new IllegalArgumentException("Unknown unary op: " + tokenType);
        };
    }

    //========================
    // TYPES
    //========================

    @Override
    public ZAstNode visitTypePrimitive(ZParser.TypePrimitiveContext ctx) {
        return ctx.primitive_type().accept(this);
    }

    @Override
    public ZAstNode visitTypeClassName(ZParser.TypeClassNameContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new TypeNodeZ(line, column, ZDataType.CLASS, ctx.ID().getText());
    }

    @Override
    public ZAstNode visitTypeInt(ZParser.TypeIntContext ctx) {
        return new TypeNodeZ(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ZDataType.INT);
    }

    @Override
    public ZAstNode visitTypeDouble(ZParser.TypeDoubleContext ctx) {
        return new TypeNodeZ(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ZDataType.DOUBLE);
    }

    @Override
    public ZAstNode visitTypeChar(ZParser.TypeCharContext ctx) {
        return new TypeNodeZ(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ZDataType.CHAR);
    }

    @Override
    public ZAstNode visitTypeBoolean(ZParser.TypeBooleanContext ctx) {
        return new TypeNodeZ(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ZDataType.BOOLEAN);
    }

    @Override
    public ZAstNode visitTypeVoid(ZParser.TypeVoidContext ctx) {
        return new TypeNodeZ(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ZDataType.VOID);
    }

    //========================
    // NORMAL VALUES
    //========================

    @Override
    public ZAstNode visitValText(ZParser.ValTextContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.STRING, ctx.TEXT().getText());
    }

    @Override
    public ZAstNode visitValChar(ZParser.ValCharContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.CHAR, ctx.CHAR().getText().charAt(0));
    }

    @Override
    public ZAstNode visitValDecimal(ZParser.ValDecimalContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.DOUBLE, Double.parseDouble(ctx.DECIMAL().getText()));
    }

    @Override
    public ZAstNode visitValInt(ZParser.ValIntContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.INT, Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public ZAstNode visitValBool(ZParser.ValBoolContext ctx) {
        return ctx.boolean_values().accept(this);
    }

    @Override
    public ZAstNode visitValNull(ZParser.ValNullContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.NULL, null);
    }

    @Override
    public ZAstNode visitValInstantiation(ZParser.ValInstantiationContext ctx) {
        return ctx.instantiation().accept(this);
    }

    @Override
    public ZAstNode visitValObjectAccess(ZParser.ValObjectAccessContext ctx) {
        return ctx.object_values().accept(this);
    }

    @Override
    public ZAstNode visitValArrayLiteral(ZParser.ValArrayLiteralContext ctx) {
        return ctx.array_literal().accept(this);
    }

    @Override
    public ZAstNode visitValReadCall(ZParser.ValReadCallContext ctx) {
        return ctx.read_call().accept(this);
    }

    @Override
    public ZAstNode visitBoolTrue(ZParser.BoolTrueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.BOOLEAN, true);
    }

    @Override
    public ZAstNode visitBoolFalse(ZParser.BoolFalseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new LiteralExpressionNodeZ(line, column, ZDataType.BOOLEAN, false);
    }
}